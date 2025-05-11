package br.com.alura.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Logger {
	
	public void registrarLog(String texto) {
		Gson gson = new Gson();
		
		try {
			String log = this.carregarLog();
			Log[] registrosJson = gson.fromJson(log, Log[].class);
			
			List<Log> registrosLista = new ArrayList<>();
			
			if (!log.isEmpty()) {
				for (Log registro : registrosJson) {
					System.out.println("AKI OK 0");
					registrosLista.add(registro);
				}
			}

			Log novoRegistro = new Log();
			novoRegistro.setRegistro(texto);

			registrosLista.add(novoRegistro);

			FileWriter arquivo = new FileWriter("log.txt");
			arquivo.write(gson.toJson(registrosLista));
			arquivo.close();

			
		} catch (Exception e) {
			System.out.println("╔════════════════════════════════════════════════╗");
			System.out.println("‖   ERRO AO SALVAR O LOG                         ‖");
			System.out.println("╚════════════════════════════════════════════════╝");
			System.out.println(e);
		}
	}
	
	
	public String carregarLog() {
		
		File arquivo = new File("log.txt");
		StringBuilder registro = new StringBuilder();
		
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			Scanner leitorDoArquivo = new Scanner(arquivo);
			
			while (leitorDoArquivo.hasNextLine()) {
				registro.append(leitorDoArquivo.nextLine());
			}
			leitorDoArquivo.close();
			
		} catch (Exception e) {
			System.out.println("╔════════════════════════════════════════════════╗");
			System.out.println("‖   ERRO AO CARREGAR O LOG                       ‖");
			System.out.println("╚════════════════════════════════════════════════╝");
		}
		
		return registro.toString();
	}
	
	
}
