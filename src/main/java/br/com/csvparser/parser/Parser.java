package br.com.csvparser.parser;

import java.io.IOException;
import java.io.Serializable;

import br.com.csvparser.exception.CsvFormatException;

public interface Parser extends Serializable{
	
	public <T> T parseCsv(String filePath, Class<T> clazz) throws IOException, CsvFormatException, InstantiationException, 
		IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchFieldException;

}
