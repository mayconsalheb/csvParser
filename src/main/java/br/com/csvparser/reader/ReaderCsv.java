package br.com.csvparser.reader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import br.com.csvparser.exception.CsvFormatException;

@Component
public class ReaderCsv {
	
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
		Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
		csvReader.close();
		
		if( records.isEmpty() ) {
			throw new CsvFormatException("Empty CSV file!");
		}
		
		return convertToMap(Arrays.asList(records.get(0)));
	}
	
	private Map<String, String> convertToMap(List<String> records) throws CsvFormatException{
		Map<String,String> recordsMap = new HashMap<String, String>();
		
		try {
			
			for (Integer ind=0;ind<records.size()-1;ind+=2) {
				
				recordsMap.put(records.get(ind), records.get(ind+1));
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new CsvFormatException(e.getMessage());
		}
		
		return recordsMap;
	}

}
