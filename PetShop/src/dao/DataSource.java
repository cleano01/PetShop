package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname;
	private int port;
	private String database;
	private String username;
	private String password;
	
	private Connection connection;
	
	
	public DataSource(){
		
		
	try {
		
		hostname= "localhost";
		port= 3306;
		database= "bancoPet";
		username= "root";
		password= "rootsql";
		
		String url= "jdbc:mysql://"+hostname+":"+port+"/"+database;
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		connection= DriverManager.getConnection(url,username,password);
		
		System.out.println("Conexão deu certo BD PetShop");
		
		
	}
	
	catch (SQLException e) {
		System.err.println("Erro na conexão "+ e.getMessage());
	}
	catch (Exception e) {
		System.err.println("Erro geral "+e.getMessage());
	}
	
		
	}
		
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void closeDataSource(){
		
		try {
			connection.close();
			
		} catch (Exception e) {
			System.err.println("Erro ao desconectar "+e.getMessage());
		}
	}
}
