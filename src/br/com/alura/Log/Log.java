package br.com.alura.Log;

public class Log {
	private String registro;
	
	public String getRegistro() {
		return registro;
	}
	public String getRegistroData() {
		return registro.substring(0,21);
	}
	public String getRegistroInfo() {
		return registro.substring(21);
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	/*
	@Override
	public String toString(){
		return "";
	}
	*/

}
