package br.edu.infnet.appVestuarioSA.model.domain;

import br.edu.infnet.appVestuarioSA.model.exceptions.MaterialSapatoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TecidoNaoPreenchidoException;
import br.edu.infnet.appVestuarioSA.model.exceptions.TipoDeAtividadeNaoPreenchidaException;

public abstract class Produto {
	
	
	protected int id;
	protected String descricao;
	protected float valor;
	
	public Produto(int id, String descricao, float valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public abstract float calcularValorPromocional() throws TecidoNaoPreenchidoException, MaterialSapatoNaoPreenchidoException, TipoDeAtividadeNaoPreenchidaException;
	
	
	public String informarProduto() throws TecidoNaoPreenchidoException, TipoDeAtividadeNaoPreenchidaException, MaterialSapatoNaoPreenchidoException {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calcularValorPromocional());
		
		return sb.toString();
		
	}
	
	@Override
	public String toString() {
		
		return String.format("%d;%s;%f", this.id, this.descricao, this.valor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}


	
}
