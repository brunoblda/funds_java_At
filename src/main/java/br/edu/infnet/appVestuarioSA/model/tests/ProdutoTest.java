package br.edu.infnet.appVestuarioSA.model.tests;

import br.edu.infnet.appVestuarioSA.model.domain.Mochila;
import br.edu.infnet.appVestuarioSA.model.domain.Roupa;
import br.edu.infnet.appVestuarioSA.model.domain.Sapato;

public class ProdutoTest {

	public static void main(String[] args) {

		Roupa r1 = new Roupa(1, "Calça Jeans tracejada em cinza", 100, "Calça Jeans", "azul", "algodão", "M", true);
		System.out.println("Roupa: "+ r1);
		
		Sapato s1 = new Sapato(2, "Sapato social de couro", 100, "couro", "preto", 42, true);
		System.out.println("Sapato: "+ s1);
		
		Mochila m1 = new Mochila(3, "mochila escolar resistente", 100, "Algodão", "verde", 3, "EsTudante");
		System.out.println("Mochila: "+ m1);
		
	}

}
