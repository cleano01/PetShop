package model;

import java.util.ArrayList;

public class Animal {
	
	private int id;
	private String nome;
	private String tipo; //cachorro ou gato ?
	private int idade;
	private String entregue;
	private int cpf; // chave estrangeira
	private ArrayList<Cliente> clientes= new ArrayList<Cliente>();
	
	public Animal() {
		// TODO Auto-generated constructor stub
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEntregue() {
		return entregue;
	}

	public void setEntregue(String entregue) {
		this.entregue = entregue;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
	@Override
	public String toString() {
		
		return "ID: "+this.id+" - Nome: "+this.nome+" - Tipo:"+this.tipo+
				" - Idade: "+this.idade+" - Entregue: "+this.entregue+ " - "+ "CPF_DONO:" +this.cpf;
	}
	

}
