package br.com.csvparser.dto;

import br.com.csvparser.bean.CsvBindByName;

public class BalanceRecord {
	
	@CsvBindByName(columnName="MO")
	private String modelo;
	
	@CsvBindByName(columnName="AG")
	private String idade;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
}
