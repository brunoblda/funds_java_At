package br.edu.infnet.appVestuarioSA.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.appVestuarioSA.model.domain.Comprador;
import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.SacolaDeCompras;
import br.edu.infnet.appVestuarioSA.model.domain.Sapato;
import br.edu.infnet.appVestuarioSA.model.exceptions.MaterialSapatoNaoPreenchido;
import br.edu.infnet.appVestuarioSA.model.exceptions.TecidoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TipoDeAtividadeNaoPreenchidaException;


public class AppTest {

	public static void main(String[] args) {
		
		
		String dir = System.getProperty("user.dir");
		String arq = "sacaolasDeCompras.txt";
		
		// String dir = "c:/dev/"
		// String arq = "pedidos.txt"

		try {		
			try {
				InputStream resource = new ClassPathResource("static/pedidos.txt").getInputStream();

				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));
				
				// FileWriter filew = new FileWriter(dir+"out_"+arq);
				//BufferedWriter escrita = new BufferedWriter(fileW);
				
				//FileReader file = new FileReader(dir+arq);
				//BUfferedReader leitura = new BufferedReader(file);
				

				String linha = leitura.readLine();

				while (linha != null) {

					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "C":
						Comprador compradorC1 = new Comprador(Integer.valueOf(campos[1]), campos[2], campos[3], campos[4], campos[5], campos[6]);

						SacolaDeCompras s1 = new SacolaDeCompras();

						escrita.write(s1.obterPedido()+"\r\n");
						
						break;

					case "R":
						Roupa r1 = new Roupa(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], campos[6], campos[7],"S".equalsIgnoreCase(campos[8]));

						escrita.write(r1.obterProduto());

						break;

					case "M":
						Mochila m1 = new Mochila(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]), campos[7]);

						escrita.write(c1.obterProduto());

						break;

					case "S":
						Sapato sa1 = new Sapato(Integer.valueOf(campos[1]), campos[2], Float.valueOf(campos[3]), campos[4], campos[5], Integer.valueOf(campos[6]),"S".equalsIgnoreCase(campos[7]));


						escrita.write(sa1.obterProduto());

						break;

					default:
						System.out.println("Entrada inválida!!!");
						break;
					}

					linha = leitura.readLine();
				}

				leitura.close();
				escrita.close();
				fileW.close();
				
			} catch (MaterialSapatoNaoPreenchido| TecidoNaoPreenchidoException| TipoDeAtividadeNaoPreenchidaException | IOException e) {
				
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento finalizado: "+(dir + arq)+"!!!");
		}

	}

}
