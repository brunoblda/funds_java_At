package br.edu.infnet.appVestuarioSA.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.appVestuarioSA.model.domain.Comprador;
import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.SacolaDeCompras;
import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.exceptions.MaterialSapatoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TecidoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TipoDeAtividadeNaoPreenchidaException;


public class AppTest {

	public static void main(String[] args) {
		
		String dir = System.getProperty("user.dir");
		String arqOut = "\\src\\main\\resources\\static\\sacolasDeCompras_out.txt";
		String arqIn = "/src/main/resources/static/sacolasDeCompras.txt";

		try {		
			
			FileWriter fileW = new FileWriter(dir + arqOut);
			BufferedWriter escrita = new BufferedWriter(fileW);
				
			FileReader file = new FileReader(dir + arqIn);
			BufferedReader leitura = new BufferedReader(file);
			
			StringBuilder sbOut = new StringBuilder();
			
			try {
				
				// FileWriter filew = new FileWriter(dir+"out_"+arq);
				//BufferedWriter escrita = new BufferedWriter(fileW);
				
				//FileReader file = new FileReader(dir+arq);
				//BUfferedReader leitura = new BufferedReader(file);
				

				String linha = leitura.readLine();
				
				System.out.println(linha);

				while (linha != null) {

					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "C":
						Comprador compradorC1 = new Comprador(Integer.valueOf(campos[1]), campos[2], campos[3], campos[4], campos[5]);
						
						
						SacolaDeCompras s1 = new SacolaDeCompras("Sacola de Compras", compradorC1);

						//escrita.write(s1.obterSacola()+"\r\n");
						sbOut.append(s1.obterSacola()+"\r\n");
						
						break;

					case "R":
						Roupa r1 = new Roupa(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], campos[6], campos[7],"S".equalsIgnoreCase(campos[8]));

						//escrita.write(r1.informarProduto()+"\r\n");
						sbOut.append(r1.informarProduto()+"\r\n");

						break;

					case "M":
						Mochila m1 = new Mochila(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]), campos[7]);

						//escrita.write(m1.informarProduto()+"\r\n");
						sbOut.append(m1.informarProduto()+"\r\n");

						break;

					case "S":
						Sapato sa1 = new Sapato(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]),"S".equalsIgnoreCase(campos[7]));

						//escrita.write(sa1.informarProduto()+"\r\n");
						sbOut.append(sa1.informarProduto()+"\r\n");
						
						break;

					default:
						System.out.println("Entrada inválida!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(sbOut.toString());;
				

				
			} catch (MaterialSapatoNaoPreenchidoException| TecidoNaoPreenchidoException| TipoDeAtividadeNaoPreenchidaException | IOException e) {
				
				System.out.println(e.getMessage());

			}finally {
				
				leitura.close();
				if(escrita!= null) {
					escrita.close();
				}
				fileW.close();
			}
			
		}catch(IOException e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			System.out.println("Processamento finalizado: "+(dir + arqOut)+"!!!");
		}

	}

}
