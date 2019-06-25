package br.com.csvparser.parser.impl;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.csvparser.bean.CsvBindByName;
import br.com.csvparser.exception.CsvFormatException;
import br.com.csvparser.parser.Parser;
import br.com.csvparser.reader.ReaderCsv;

@Component
public class CsvParser implements Parser{

	private static final long serialVersionUID = 2014880055377483504L;
	
	@Autowired
	private ReaderCsv reader;

	public <T> T parseCsv(String filePath, Class<T> clazz) throws 
		IOException, CsvFormatException, Exception{
		
		List<Map<String, String>> datas = reader.getCsvData(filePath);
		List<Object> result = new ArrayList<>();
		for (Map<String, String> data : datas) {
			data.forEach((k,v)->System.out.println("Key : " + k + " value : " + v));
			result.add(populateClass(data, clazz));
		}
		return (T) result;
	}
	
	private <T> T populateClass(Map<String,String> data, Class<T> clazz) throws 
		InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, 
		NoSuchFieldException, SecurityException {
		
		T newObject = clazz.newInstance();
		
		for(Field field: clazz.getDeclaredFields()) {
			
			System.out.println(field.getName());
			for (Annotation annotation : field.getAnnotations()) {
				
				if( annotation.annotationType().equals(CsvBindByName.class)) {
					
					CsvBindByName bindAnnotation = (CsvBindByName) annotation;
					
					Field objectField= newObject.getClass().getDeclaredField(field.getName());
					objectField.setAccessible(true);
					objectField.set(newObject, data.get(bindAnnotation.columnName()));
					
					System.out.println(data.get(bindAnnotation.columnName()));
				}
			}
		}
		
		
		return newObject;
	}
}
