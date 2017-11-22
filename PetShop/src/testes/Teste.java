package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AnimalDAO;
import dao.ClienteDAO;
import dao.DataSource;
import model.Animal;
import model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;


public class Teste {
	private static DataSource dataSource;
	
	@BeforeClass
	public static void inicializarCone(){
		dataSource = new DataSource();
	}
	
	
	@Test
	public void testCarregarSql()throws ClassNotFoundException {
		//TESTE DE CONECTIVIDADE E CARREGAMENTO DO DRIVER DO SQL, CALSSE DATASOURCE
		Connection connection = dataSource.getConnection();
		
		
	}
	

	@Test
	public void testClienteDAO() {
		
		ClienteDAO cd= new ClienteDAO(dataSource);
	}
	
	@Test
	public void testReadAll() throws SQLException {
		
		ClienteDAO cd = new ClienteDAO(dataSource);
		cd.readAll();
		
	}
	
	
	@Test
	public void testConsultarCliente() throws SQLException {
		
		ClienteDAO cd= new ClienteDAO(dataSource);
		int cpf=123;
		cd.consultarCliente(cpf);
		
	}
	
	
	@Test
	public void testCadastrarCliente() throws SQLException {
	//CPF: 127 - Nome: Rebeca - Idade: 21 - EMAIL: rebeca@rebeca.com - TEL: 32321414
		
		Cliente cliente = new Cliente();
		
		ClienteDAO cd= new ClienteDAO(dataSource);
		
		cliente.setCpf(127);
		cliente.setIdade(21); 
		cliente.setNome("Rebeca");
		cliente.setEmail("rebeca@rebeca.com"); 
		cliente.setTelefone("32321414");
		
		
		
		cd.cadastrarCliente(cliente);
		
	
		
		
	}
	

	@Test
	public void testEditarCliente() throws SQLException {
		//Opção para teste 3, com essa opção podemos alterar o email do cliente
		
		Cliente cliente = new Cliente();
		ClienteDAO cd = new ClienteDAO(dataSource);
		
		int cpf=127;
		cliente.setCpf(cpf);
		cliente.setEmail("rebeca@hotmail.com");
		
		cd.editarCliente(cliente, 3);
	}
	
	
	
	@Test
	public void testAnimalReadAll() throws SQLException {
		
		AnimalDAO aniDao = new AnimalDAO(dataSource);
		aniDao.redAll();
		
				
	}
	
	
	public void testCadastrarAnimal() throws SQLException {
		
		Animal animal =  new Animal();
		AnimalDAO aniDao = new AnimalDAO(dataSource);
		
		animal.setNome("Dengosa"); animal.setTipo("gata");
		animal.setIdade(1); animal.setEntregue("não");
		animal.setCpf(127);
		
		aniDao.cadastrarAnimal(animal);
		
	}
	
	
	

	@Test
	public void testAtualizarEntrega() throws SQLException {
		
		Animal animal =  new Animal();
		AnimalDAO aniDao = new AnimalDAO(dataSource);
		
		animal.setEntregue("NÃO");
		animal.setId(16);
		animal.setCpf(127);
		
		aniDao.atualizarEntrega(animal);
		
		
	}

	@Test
	public void testPesquisaAnimalDono() throws SQLException {
		
		AnimalDAO aniDao = new AnimalDAO(dataSource);
		
		int cpf=127;
		aniDao.pesquisaAnimalDono(cpf);
		
	}
	
	
	
	
	@Test
	public void testDeletarCliente() throws SQLException {
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO(dataSource);
		
		cliente.setCpf(125);
		clienteDAO.deletarCliente(cliente);
	}
	
	@Test
	public void testDeletarAnimal() throws SQLException {
		
		Animal animal = new Animal();
		AnimalDAO aniDao = new AnimalDAO(dataSource);
		
		animal.setCpf(127);
		aniDao.deletarAnimal(animal);
	}

	
		
	}
	


