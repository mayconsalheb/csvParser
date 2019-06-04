package br.com.csvparser.exception;

public class CsvFormatException extends Exception{

	private static final long serialVersionUID = 5648304157636962239L;

	public CsvFormatException(String message) {
		super(message);
	}
}
