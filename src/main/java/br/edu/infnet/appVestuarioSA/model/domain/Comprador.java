package br.edu.infnet.appVestuarioSA.model.domain;

public class Comprador {

	private int id;
	private String nome;
	private String Cpf;
	private String email;
	private String telefone;
	
	public Comprador() {
		
	}
	
	public Comprador(int id, String nome, String Cpf, String email, String telefone ) {
		this.id = id;
		this.nome = nome;
		this.Cpf = Cpf;
		this.email = email;
		this.telefone = telefone;
	}	
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.id);
		sb.append(";");
		
		sb.append(this.nome);
		sb.append(";");
		
		sb.append(this.Cpf);
		sb.append(";");
		
		sb.append(this.email);
		sb.append(";");
		
		sb.append(this.telefone);
		
		
		return sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	
	
}
