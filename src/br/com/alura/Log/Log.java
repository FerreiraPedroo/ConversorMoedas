package br.com.alura.Log;

public class Log {
	private String data;
	private String moedaOrigem;
	private String moedaDestino;
	
	public Double getConversao() {
		return conversao;
	}
	
	public void setConversao(Double conversao) {
		this.conversao = conversao;
	}
	
	public String getMoedaDestino() {
		return moedaDestino;
	}
	
	public void setMoedaDestino(String moedaDestino) {
		this.moedaDestino = moedaDestino;
	}
	
	public String getMoedaOrigem() {
		return moedaOrigem;
	}
	
	public void setMoedaOrigem(String moedaOrigem) {
		this.moedaOrigem = moedaOrigem;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	private Double conversao;
}
