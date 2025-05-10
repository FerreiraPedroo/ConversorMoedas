package br.com.alura.Log;

import com.google.gson.Gson;

import java.io.File;
import java.util.Scanner;

public class Logger {
	public void carregarLog() {
		Gson gson = new Gson();
		
		File arquivo = new File("log.txt");
		String arquivoCarregado = "";
		
		try {
			Scanner leitorDoArquivo = new Scanner(arquivo);
			while (leitorDoArquivo.hasNextLine()) {
				arquivoCarregado += leitorDoArquivo.hasNextLine();
			}
			
			//Log log = gson.toJson(arquivoCarregado, Log.class);
			System.out.println(arquivoCarregado);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	static String registrarLog() {
		return "";
	}
}
