package br.com.csvparser.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.csvparser.exception.CsvFormatException;

@Component
public class ReaderCsv {
	
	private static final String DELIMITADOR = ",";
	
	/**
	 * Returning columns of the CSV separated by comma as a map
	 * 
	 * @param filePath
	 * @throws IOException
	 * 
	 * @return Map 
	 * @throws CsvFormatException 
	 */
	public Map<String, String> getCsvData(String filePath) throws IOException, CsvFormatException {
        String contents = new String(Files.readAllBytes(Paths.get(filePath)));
		List<String> records = Arrays.asList(contents.split(DELIMITADOR));
		
		if( records.isEmpty() ) {
			throw new CsvFormatException("Empty CSV file!");
		}
		
		return convertToMap(records);
	}
	
	private Map<String, String> convertToMap(List<String> records) throws CsvFormatException{
		Map<String,String> map = new HashMap<String, String>();
		for (int key = 0, value = 1; key < records.size() - 1; key += 2, value += 2) {
			String keyStr = records.get(key), valueStr = records.get(value);
			map.put(keyStr, valueStr);
		}
		return map;
	}
}
