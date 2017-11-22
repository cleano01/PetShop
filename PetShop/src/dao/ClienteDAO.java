package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import model.Cliente;

public class ClienteDAO {
	private DataSource dataSource;
	
	
	public ClienteDAO(){
		
	}
	
	
	public ClienteDAO(DataSource dataSource) {
		this.dataSource= dataSource;
		
	}
	
	
	
	
	public ArrayList<Cliente> readAll(){
		
		try {
			
			String SQL="SELECT * FROM Cliente";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			
			while(rs.next()){ //recupera os valores das colunas que esta apontado
				
				Cliente cli = new Cliente();
				
				cli.setCpf(rs.getInt("cpf"));
				cli.setIdade(rs.getInt("idade"));
				cli.setNome(rs.getString("nome"));
				cli.setEmail(rs.getString("email"));
				cli.setTelefone(rs.getString("telefone"));
				
				lista.add(cli);
				
			}
			ps.close();
			return lista;
			
			
		} 
		
		catch (SQLException e) {
			System.err.println("Erro ao recuperar Cliente "+e.getMessage());
		}
		
		catch (Exception e) {
			System.err.println("Erro geral "+e.getMessage());
			// TODO: handle exception
		}
		return null;
		
	}//Listar clientes 
	
	
	
	public ArrayList<Cliente> consultarCliente(int cpf) throws SQLException{
		
		String SQL="SELECT * FROM Cliente WHERE cpf = ?";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			
			ps.setInt(1, cpf);
			
			ResultSet rs= ps.executeQuery();
			
			
			if (rs.next()) {
				
				Cliente cli = new Cliente();
				
				cli.setCpf(rs.getInt("cpf"));
				cli.setIdade(rs.getInt("idade"));
				cli.setNome(rs.getString("nome"));
				cli.setEmail(rs.getString("email"));
				cli.setTelefone(rs.getString("telefone"));
				
				lista.add(cli);
				return lista;	
				
				
			}else{
			
			}
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		catch (Exception e){
			System.err.println(e.getMessage());
		}
		
		
		
		
		return null;			
	
		
	}//Consultar Cliente
	
	public void cadastrarCliente(Cliente cliente) throws SQLException{
		
		String SQL="INSERT INTO Cliente (cpf,idade,nome,email,telefone) VALUES(?,?,?,?,?)";
		PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
		
		ps.setInt(1, cliente.getCpf());
		ps.setInt(2, cliente.getIdade());
		ps.setString(3, cliente.getNome());
		ps.setString(4, cliente.getEmail());
		ps.setString(5,  cliente.getTelefone());
		
		ps.executeUpdate();
		ps.close();
		
	
	}// Cadastrar cliente
	
	
	
	public void deletarCliente(Cliente cliente) throws SQLException{
		
		String SQL= "DELETE FROM Cliente WHERE cpf = ?";
		PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
		
		ps.setInt(1,cliente.getCpf());
		
		ps.executeUpdate();
		ps.close();
		
	}//Deletar cliente
	
	
	
	
	
	public void editarCliente(Cliente cliente, int opc) throws SQLException{
		//1= idade ; 2= nome ; 3= email ; 4= telfone
		
			
		if(opc == 1){
			
			
			String SQL= "UPDATE Cliente SET idade=? WHERE cpf = ?";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			
				ps.setInt(1, cliente.getIdade());
				ps.setInt(2, cliente.getCpf());
				
				ps.executeUpdate();
				
				if(ps.executeUpdate() >0){
					
					System.out.println("Edição feita com sucesso !");
					
				}
				else{
					System.err.println("Edição não foi concluída !!");
					
				}
				ps.close();
				
						
		}
		
		if(opc == 2 ){
			
			String SQL= "UPDATE FROM Cliente SET nome= ? WHERE cpf = ?";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			
						
				ps.setString(1, cliente.getNome());
				ps.setInt(2, cliente.getCpf());
				
				ps.executeUpdate();

				if(ps.executeUpdate() >0){
					
					System.out.println("Edição feita com sucesso !");
					
				}
				else{
					System.err.println("Edição não foi concluída !!");
					
				}
				ps.close();
				
				
			
		}
		
		if(opc == 3 ){
			
			String SQL= "UPDATE Cliente SET email= ? WHERE cpf = ?";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			
			
				
				ps.setString(1, cliente.getEmail());
				ps.setInt(2, cliente.getCpf());
			
				ps.executeUpdate();

				if(ps.executeUpdate() >0){
					
					System.out.println("Edição feita com sucesso !");
					
				}
				else{
					System.err.println("Edição não foi concluída !!");
					
				}
				
				ps.close();	
					
			
			
			
		}
		
		if(opc == 4){
			
			String SQL= "UPDATE Cliente SET telefone= ? WHERE cpf = ?";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			
			
				
				ps.setString(1, cliente.getTelefone());
				ps.setString(2, cliente.getTelefone());
				
				ps.executeUpdate();
				
				if(ps.executeUpdate() >0){
					
					System.out.println("Edição feita com sucesso !");
					
				}
				else{
					System.err.println("Edição não foi concluída !!");
					
				}
				ps.close();
						
			
		}
		
		
	}//Editar Cliente
	
	
	

}
