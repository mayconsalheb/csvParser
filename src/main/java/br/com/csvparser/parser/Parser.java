package br.com.csvparser.parser;

import java.io.IOException;
import java.io.Serializable;

public interface Parser extends Serializable{
	
	public <T> T parseCsv(String filePath, Class<T> clazz) throws IOException;

}
