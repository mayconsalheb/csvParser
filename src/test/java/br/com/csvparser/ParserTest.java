package br.com.csvparser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.csvparser.dto.BalanceRecord;
import br.com.csvparser.parser.Parser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserTest{
	
	public static final String FILE_NAME = "DATA1.CSV";
	
	@Autowired
	private Parser parser;

	@SuppressWarnings("unchecked")
	@Test
	public void parserCsvFile() {
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(FILE_NAME).getFile());
			System.out.println(file.getAbsolutePath());
			
			List<BalanceRecord> objs;
				objs = (List<BalanceRecord>) parser.parseCsv(file.getAbsolutePath(), BalanceRecord.class);
				assertEquals(true, objs.get(0).getModelo().equals("BC-601"));
				assertEquals(true, objs.get(0).getIdade().equals("42"));
				
				assertEquals(true, objs.get(1).getModelo().equals("BC-6033"));
				assertEquals(true, objs.get(1).getIdade().equals("42"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
