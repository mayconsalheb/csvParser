package br.com.csvparser;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import br.com.csvparser.parser.impl.CsvParser;

public class ParserTest{
	
	public static final String FILE_NAME = "DATA1.CSV";

	@Test
	public void parserCsvFile() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(FILE_NAME).getFile());
			System.out.println(file.getAbsolutePath());
			
			CsvParser parser = new CsvParser();
		
			parser.parseCsv(file.getAbsolutePath(), ParserTest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
