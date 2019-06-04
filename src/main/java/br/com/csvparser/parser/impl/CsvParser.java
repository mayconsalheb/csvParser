package br.com.csvparser.parser.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.csvparser.exception.CsvFormatException;
import br.com.csvparser.parser.Parser;
import br.com.csvparser.reader.ReaderCsv;

@Component
public class CsvParser implements Parser{

	private static final long serialVersionUID = 2014880055377483504L;
	
	@Autowired
	private ReaderCsv reader;

	public <T> T parseCsv(String filePath, Class<T> clazz) throws IOException, CsvFormatException {
		Map<String, String> data = reader.getCsvData(filePath);
		
		
		data.forEach((k,v)->System.out.println("Key : " + k + " value : " + v));
		return null;
	}
}
