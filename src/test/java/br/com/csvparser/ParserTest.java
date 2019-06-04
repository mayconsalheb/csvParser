package br.com.csvparser;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.csvparser.dto.BalanceRecord;
import br.com.csvparser.exception.CsvFormatException;
import br.com.csvparser.parser.impl.CsvParser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserTest{
	
	public static final String FILE_NAME = "DATA1.CSV";
	
	@Autowired
	private CsvParser parser;

	@Test
	public void parserCsvFile() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(FILE_NAME).getFile());
			System.out.println(file.getAbsolutePath());
			
			parser.parseCsv(file.getAbsolutePath(), BalanceRecord.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvFormatException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
