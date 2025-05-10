package br.com.alura.Api;

public class Conversao {
	private String result;
	private String base_code;
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getBase_code() {
		return base_code;
	}
	
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}
	
	public String getTarget_code() {
		return target_code;
	}
	
	public void setTarget_code(String target_code) {
		this.target_code = target_code;
	}
	
	public String getConversion_rate() {
		return conversion_rate;
	}
	
	public void setConversion_rate(String conversion_rate) {
		this.conversion_rate = conversion_rate;
	}
	
	private String target_code;
	private String conversion_rate;
}
