package br.edu.infnet.appVestuarioSA.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SacolaDeCompras {

	private String descricao;
	private LocalDateTime data;
	private Comprador comprador;
	
	public SacolaDeCompras() {
		data = LocalDateTime.now();
	}

	public SacolaDeCompras(String descricao, Comprador comprador) {
		this();
		this.descricao = descricao;
		this.comprador = comprador;
	}
	
	
	public String obterSacola() {
		
		return String.format("Sacola de compras do %s realizada em %s",this.comprador.getNome(), this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		
	}
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.data.format(formato));
		sb.append(";");
		sb.append(this.comprador);

		
		return sb.toString(); 
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	
	
	
}
