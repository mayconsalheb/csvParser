package br.com.csvparser.parser.impl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;

import br.com.csvparser.exception.CsvFormatException;
import br.com.csvparser.parser.Parser;


public class CsvParser implements Parser{

	private static final long serialVersionUID = 2014880055377483504L;

	public <T> T parseCsv(String filePath, Class<T> clazz) throws IOException {
		List<String> data = getCsvData(filePath);
		
		return null;
	}

	/**
	 * Returning columns of the CSV separated by comma
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	private List<String> getCsvData(String filePath) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
		csvReader.close();
		
		if( records.isEmpty() ) {
			throw new CsvFormatException();
		}
		
		return Arrays.asList(records.get(0));
	}

}
