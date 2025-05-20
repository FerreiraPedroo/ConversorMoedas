package br.com.alura;

import br.com.alura.Api.Api;
import br.com.alura.Api.Conversor;
import br.com.alura.Log.Log;
import br.com.alura.Log.Logger;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int moedaDeDestinoSelecionada;
	
	public static void main(String[] args) {
		Api consultaAPI = new Api();
		Scanner leitor = new Scanner(System.in);
		
		Gson gson = new Gson();
		Logger logger = new Logger();
		
		List<String> listaDeMoedas = new ArrayList<String>(List.of("ARS - Peso argentino", "BOB - Boliviano bolivian", "BRL - Real brasileiro", "CLP - Peso chileno", "COP - Peso colombiano", "USD - Dólar americano"));
		
		int moedaDeOrigemSelecionada = -1;
		int moedaDeDestinoSelecionada = -1;
		double valorParaConverter = 0;
		
		int ponteiroConverteMoeda = 1;
		int ponteiro = 0;
		
		System.out.println("╔════════════════════════════════════════════════╗");
		System.out.println("‖                                                ‖");
		System.out.println("‖    C O N V E R S O R    D E    M O E D A S     ‖");
		System.out.println("‖                                                ‖");
		System.out.println("‖      Oracle One by Alura / Pedro Henrique      ‖");
		System.out.println("‖                                                ‖");
		System.out.println("╚════════════════════════════════════════════════╝");
		
		while (ponteiro >= 0) {
			
			switch (ponteiro) {
				// MENU PRINCIPAL
				case 0:
					System.out.println("╔════════════════════════════════════════════════╗");
					System.out.println("‖                 MENU PRINCIPAL                 ‖");
					System.out.println("‖════════════════════════════════════════════════‖");
					System.out.println("‖   SELECIONE UMA OPÇÃO                          ‖");
					System.out.println("‖                                                ‖");
					System.out.println("‖    1: Moedas disponíveis                       ‖");
					System.out.println("‖    2: Converter moeda                          ‖");
					System.out.println("‖    3: Registro                                 ‖");
					System.out.println("‖                                                ‖");
					System.out.println("‖    0: Sair                                     ‖");
					System.out.println("‖                                                ‖");
					System.out.println("╚════════════════════════════════════════════════╝");
					
					ponteiro = leitor.nextInt();
					
					switch (ponteiro) {
						case 0:
							System.out.println("╔════════════════════════════════════════════════╗");
							System.out.println("‖                                                ‖");
							System.out.println("‖   VOLTE SEMPRE !!!                             ‖");
							System.out.println("‖                                                ‖");
							System.out.println("╚════════════════════════════════════════════════╝");
							ponteiro = -1;
							break;
						case 1:
						case 2:
						case 3:
							break;
						default:
							System.out.println("╔════════════════════════════════════════════════╗");
							System.out.println("‖                                                ‖");
							System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
							System.out.println("‖                                                ‖");
							System.out.println("╚════════════════════════════════════════════════╝");
							ponteiro = 0;
							break;
					}
					
					break;
				
				case 1:
					System.out.println("╔════════════════════════════════════════════════╗");
					System.out.println("‖   MOEDAS DISPONÍVEIS                           ‖");
					System.out.println("‖                                                ‖");
					System.out.println("‖   ARS - Peso argentino                         ‖");
					System.out.println("‖   BOB - Boliviano bolivian                     ‖");
					System.out.println("‖   BRL - Real brasileiro                        ‖");
					System.out.println("‖   CLP - Peso chileno                           ‖");
					System.out.println("‖   COP - Peso colombiano                        ‖");
					System.out.println("‖   USD - Dólar americano                        ‖");
					System.out.println("‖                                                ‖");
					System.out.println("‖    0: Menu principal                           ‖");
					System.out.println("‖                                                ‖");
					System.out.println("╚════════════════════════════════════════════════╝");
					ponteiro = leitor.nextInt();
					
					switch (ponteiro) {
						case 0:
							ponteiro = 0;
							break;
						default:
							System.out.println("╔════════════════════════════════════════════════╗");
							System.out.println("‖                                                ‖");
							System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
							System.out.println("‖                                                ‖");
							System.out.println("╚════════════════════════════════════════════════╝");
							ponteiro = 1;
							break;
					}
					
					break;
				
				// MENU CONVERTER MOEDAS
				case 2:
					
					// SELECIONAR A MOEDA DE ORIGEM PARA CONVERSÃO
					while (ponteiroConverteMoeda == 1) {
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖   SELECIONE A MOEDA DE ORIGEM                  ‖");
						System.out.println("‖                                                ‖");
						System.out.println("‖    1: ARS - Peso argentino                     ‖");
						System.out.println("‖    2: BOB - Boliviano bolivian                 ‖");
						System.out.println("‖    3: BRL - Real brasileiro                    ‖");
						System.out.println("‖    4: CLP - Peso chileno                       ‖");
						System.out.println("‖    5: COP - Peso colombiano                    ‖");
						System.out.println("‖    6: USD - Dólar americano                    ‖");
						System.out.println("‖                                                ‖");
						System.out.println("‖    0: Menu principal                           ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						
						int opcaoSelecionada = leitor.nextInt();
						
						switch (opcaoSelecionada) {
							case 0:
								ponteiro = 0;
								break;
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
							case 6:
								moedaDeOrigemSelecionada = opcaoSelecionada - 1;
								ponteiroConverteMoeda = 2;
								break;
							default:
								System.out.println("╔════════════════════════════════════════════════╗");
								System.out.println("‖                                                ‖");
								System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
								System.out.println("‖                                                ‖");
								System.out.println("╚════════════════════════════════════════════════╝");
								break;
						}
						
					}
					
					// SELECIONAR A MOEDA DE DESTINO PARA CONVERSÃO
					while (ponteiroConverteMoeda == 2) {
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖   SELECIONE A MOEDA DE DESTINO                 ‖");
						System.out.println("‖                                                ‖");
						
						for (int i = 0; i < listaDeMoedas.size(); i++) {
							if (moedaDeOrigemSelecionada == i) {
								String texto = "‖    : " + listaDeMoedas.get(i) + " (ORIGEM)";
								String complete = caracteresParaCompletar(1, texto.length());
								System.out.println(texto + complete + "‖");
							} else {
								String texto = "‖   " + (i + 1) + ": " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								System.out.println(texto + complete + "‖");
							}
						}
						
						System.out.println("‖                                                ‖");
						System.out.println("‖    0: Voltar                                   ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						
						int opcaoSelecionada = leitor.nextInt();
						
						// VOLTA PARA SELECIONAR A MOEDA DE ORIGEM.
						if (opcaoSelecionada == 0) {
							ponteiroConverteMoeda = 1;
						} else if ((opcaoSelecionada - 1) == moedaDeOrigemSelecionada || opcaoSelecionada < 0 || opcaoSelecionada > listaDeMoedas.size()) {
							System.out.println("╔════════════════════════════════════════════════╗");
							System.out.println("‖                                                ‖");
							System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
							System.out.println("‖                                                ‖");
							System.out.println("╚════════════════════════════════════════════════╝");
						} else {
							moedaDeDestinoSelecionada = opcaoSelecionada - 1;
							ponteiroConverteMoeda = 3;
						}
						
					}
					
					// SELECIONAR A QUANTIDADE PARA SER CONVERTIDO
					while (ponteiroConverteMoeda == 3) {
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖   SELECIONE O VALOR A SER CONVERTIDO           ‖");
						System.out.println("‖                                                ‖");
						
						String textoMoedaOrigem = "";
						String textoMoedaDestino = "";
						for (int i = 0; i < listaDeMoedas.size(); i++) {
							if (moedaDeOrigemSelecionada == i) {
								String texto = "‖    [ORIGEM ] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaOrigem = texto + complete + "‖";
							} else if (moedaDeDestinoSelecionada == i) {
								String texto = "‖    [DESTINO] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaDestino = texto + complete + "‖";
							}
						}
						
						System.out.println(textoMoedaOrigem);
						System.out.println(textoMoedaDestino);
						
						System.out.println("‖                                                ‖");
						System.out.println("‖   Quanto deseja converter ?                    ‖");
						System.out.println("‖                                                ‖");
						System.out.println("‖    0: Voltar                                   ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						
						double opcaoSelecionada = leitor.nextDouble();
						
						if (opcaoSelecionada == 0) {
							System.out.println("opcaoSelecionada");
							ponteiroConverteMoeda = 2;
						} else {
							valorParaConverter = opcaoSelecionada;
							ponteiroConverteMoeda = 4;
						}
						
					}
					
					// EXIBE AS MOEDAS SELECIONADAS
					while (ponteiroConverteMoeda == 4) {
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖   MOEDAS SELECIONADAS                          ‖");
						System.out.println("‖                                                ‖");
						
						String textoMoedaOrigem = "";
						String textoMoedaDestino = "";
						for (int i = 0; i < listaDeMoedas.size(); i++) {
							if (moedaDeOrigemSelecionada == i) {
								String texto = "‖    [ORIGEM ] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaOrigem = texto + complete + "‖";
							} else if (moedaDeDestinoSelecionada == i) {
								String texto = "‖    [DESTINO] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaDestino = texto + complete + "‖";
							}
						}
						System.out.println(textoMoedaOrigem);
						System.out.println(textoMoedaDestino);
						
						String textoValor = "‖    [VALOR  ] => " + valorParaConverter;
						String completeValor = caracteresParaCompletar(1, textoValor.length());
						System.out.println(textoValor + completeValor + "‖");
						
						System.out.println("‖                                                ‖");
						System.out.println("‖    1: Consultar                                ‖");
						System.out.println("‖    0: Voltar                                   ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						
						int opcaoSelecionada = leitor.nextInt();
						
						switch (opcaoSelecionada) {
							case 0:
								ponteiroConverteMoeda = 3;
								break;
							case 1:
								ponteiroConverteMoeda = 5;
								break;
							default:
								System.out.println("╔════════════════════════════════════════════════╗");
								System.out.println("‖                                                ‖");
								System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
								System.out.println("‖                                                ‖");
								System.out.println("╚════════════════════════════════════════════════╝");
								break;
						}
						
					}
					
					// EFETUAR A CONSULTA NA API
					while (ponteiroConverteMoeda == 5) {
						String moedaDeOrigemSigla = listaDeMoedas.get(moedaDeOrigemSelecionada).substring(0, 3);
						String moedaDeDestinoSigla = listaDeMoedas.get(moedaDeDestinoSelecionada).substring(0, 3);
						
						String resultado = consultaAPI.consultaMoeda(moedaDeOrigemSigla, moedaDeDestinoSigla);
						Conversor conversor = gson.fromJson(resultado, Conversor.class);
						
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖   CONVERSÃO CONSULTADA                         ‖");
						
						// EXIBE NA ORIGEM A MOEDA DE ORIGEM E DESTINO SELEIONADAS
						String textoMoedaOrigem = "";
						String textoMoedaDestino = "";
						for (int i = 0; i < listaDeMoedas.size(); i++) {
							if (moedaDeOrigemSelecionada == i) {
								String texto = "‖    [ORIGEM ] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaOrigem = texto + complete + "‖";
							} else if (moedaDeDestinoSelecionada == i) {
								String texto = "‖    [DESTINO] => " + listaDeMoedas.get(i);
								String complete = caracteresParaCompletar(1, texto.length());
								textoMoedaDestino = texto + complete + "‖";
							}
						}
						
						System.out.println(textoMoedaOrigem);
						System.out.println(textoMoedaDestino);
						
						System.out.println("‖                                                ‖");
						System.out.println("‖   TAXA DE CONVERSÃO                            ‖");
						
						// EXIBE A CONVERSÃO DA MOEDA DE ORIGEM PARA A MOEDA DE DESTINO SELECIONADAS
						String textoConversao = "‖    1 " + moedaDeOrigemSigla + " = " +
						Double.parseDouble(conversor.getConversion_rate()) + " " + moedaDeDestinoSigla;
						String complete = caracteresParaCompletar(1, textoConversao.length());
						System.out.println(textoConversao + complete + "‖");
						
						System.out.println("‖                                                ‖");
						System.out.println("‖   VALOR CONVERTIDO                             ‖");
						
						// EXIBE A CONVERSÃO DO VALOR SELECIONADO
						String valorConversao = "‖    " + valorParaConverter + " " + moedaDeOrigemSigla + " = " +
						String.format("%.6f", Double.parseDouble(conversor.getConversion_rate()) * valorParaConverter) + " " + moedaDeDestinoSigla;
						String valorComplete = caracteresParaCompletar(1, valorConversao.length());
						
						System.out.println(valorConversao + valorComplete + "‖");
						
						System.out.println("‖                                                ‖");
						System.out.println("‖    1: Nova consulta                            ‖");
						System.out.println("‖    0: Menu principal                           ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						
						// SALVAR A CONSULTA NO LOG
						LocalDateTime dataAgora = LocalDateTime.now();
						DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
						
						String dataFormatada = dataAgora.format(formatoDataHora);
						String registro = "[" + dataFormatada + "] " + valorParaConverter + " " + moedaDeOrigemSigla + " = " + String.format("%.6f", Double.parseDouble(conversor.getConversion_rate()) * valorParaConverter) + " " + moedaDeDestinoSigla;

						logger.registrarLog(registro);
						
						int opcaoSelecionada = leitor.nextInt();
						
						switch (opcaoSelecionada) {
							case 0:
								ponteiro = 0;
								ponteiroConverteMoeda = 0;
								break;
							case 1:
								ponteiroConverteMoeda = 1;
								break;
							default:
								System.out.println("╔════════════════════════════════════════════════╗");
								System.out.println("‖                                                ‖");
								System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
								System.out.println("‖                                                ‖");
								System.out.println("╚════════════════════════════════════════════════╝");
								break;
						}
						
					}
					
					break;
				
				// EXIBIR REGISTROS DE CONVERSÃO
				case 3:
					String log = logger.carregarLog();
					
					System.out.println("╔════════════════════════════════════════════════╗");
					System.out.println("‖   REGISTRO DE CONSULTAS                        ‖");
					System.out.println("‖                                                ‖");
					if (!log.isEmpty()) {
						Log[] registros = gson.fromJson(log, Log[].class);
						for (Log registro : registros) {
							String registroData = "‖    " + registro.getRegistroData();
							String registroDataComplete = caracteresParaCompletar(1, registroData.length());
							System.out.println(registroData + registroDataComplete + "‖");
							
							String registroInfo = "‖    " + registro.getRegistroInfo();
							String registroInfoComplete = caracteresParaCompletar(1, registroInfo.length());
							System.out.println(registroInfo + registroInfoComplete + "‖");
							System.out.println("‖                                                ‖");
						}
					} else {
						System.out.println("‖               [SEM REGISTROS]                  ‖");
					}
					System.out.println("‖                                                ‖");
					System.out.println("‖    0: Menu principal                           ‖");
					System.out.println("‖                                                ‖");
					System.out.println("╚════════════════════════════════════════════════╝");
					ponteiro = leitor.nextInt();
					
					if (ponteiro != 0) {
						System.out.println("╔════════════════════════════════════════════════╗");
						System.out.println("‖                                                ‖");
						System.out.println("‖   OPÇÃO INVÁLIDA                               ‖");
						System.out.println("‖                                                ‖");
						System.out.println("╚════════════════════════════════════════════════╝");
						ponteiro = 3;
					}
					
					break;
			}
			
		}
		
	}
	
	static String caracteresParaCompletar(int caracteresFinais, int caractereTotal) {
		// CALCULA A QUANTIDADE DE CARACTERES DEPOIS DO TEXTO E ANTES DO FINAL
		// 50 = TOTAL DE CARACTERES NA LINHA
		int numeroDeCaractereRestante = 50 - (caracteresFinais + caractereTotal);
		
		if (numeroDeCaractereRestante <= 0) {
			numeroDeCaractereRestante = 1;
		}
		
		char[] caracteresParaCompletar = new char[numeroDeCaractereRestante];
		Arrays.fill(caracteresParaCompletar, ' ');
		return new String(caracteresParaCompletar);
	}
	
}