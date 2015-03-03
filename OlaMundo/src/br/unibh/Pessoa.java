package br.unibh;

public abstract class Pessoa {
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + "]";
	}
	
	

	
	
	
	
}
