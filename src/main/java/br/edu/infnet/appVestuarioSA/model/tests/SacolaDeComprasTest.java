package br.edu.infnet.appVestuarioSA.model.tests;

import br.edu.infnet.appVestuarioSA.model.domain.Comprador;
import br.edu.infnet.appVestuarioSA.model.domain.SacolaDeCompras;

public class SacolaDeComprasTest {

	public static void main(String[] args) {
		
		
		Comprador compradorC1 = new Comprador(1, "bruno Luiz", "11122233355", "email@email.com", "61998845522", "456654456b");
		
		SacolaDeCompras p1 = new SacolaDeCompras("pedido do bruno", compradorC1);
		
		System.out.println("Sacola de Compras: " + p1);

	}

}
