package model;

public class Cliente {
	private int cpf; //Chave primaria
	private int idade;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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
	
	@Override
	public String toString() {
		
		return "CPF: "+this.cpf+" - Nome: "+this.nome+" - Idade: "+this.idade+" - EMAIL: "+this.email+" - TEL: "+this.telefone;
	}
	
	
}
