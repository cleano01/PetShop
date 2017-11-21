package dao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Animal;
import model.Cliente;


public class AnimalDAO {
	private DataSource dataSource;
	
	public AnimalDAO(DataSource dataSource) {
		
		this.dataSource=dataSource;
	}
	
	public ArrayList<Animal> redAll() {
		
		try {
			String SQL="SELECT * FROM Animal";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			
			ArrayList<Animal> lista= new ArrayList<Animal>();
			
			while(rs.next()){//recupera os valores das colunas que esta apontado
				
				Animal ani= new Animal();
				
				ani.setId(rs.getInt("id"));
				ani.setNome(rs.getString("nome"));
				ani.setTipo(rs.getString("tipo"));
				ani.setIdade(rs.getInt("idade"));
				ani.setEntregue(rs.getString("entregue"));
				ani.setCpf(rs.getInt("cpf"));
				
				lista.add(ani);
				
				
			}
			ps.close();
			return lista;
			
		} 
		catch (SQLException e) {
			System.err.println("Erro ao recuperar Animal "+e.getMessage());
			
		}
		catch (Exception e) {
			System.out.println("Erro geral "+e.getMessage());
		}
		return null;

	}//Listar animais

	
	public void cadastrarAnimal( Animal animal) throws SQLException{
		
		String SQL= "INSERT INTO Animal (nome, tipo, idade, entregue, cpf) VALUES(?,?,?,?,?)";
		PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
		
		ps.setString(1, animal.getNome());
		ps.setString(2, animal.getTipo());
		ps.setInt(3, animal.getIdade());
		ps.setString(4, animal.getEntregue());
		ps.setInt(5, animal.getCpf());
		
		ps.executeUpdate();
		ps.close();
			
		
	}// Cadastrar animal
	
	public void atualizarEntrega(Animal animal) throws SQLException{
		
		String SQL= "UPDATE Animal SET entregue= ? WHERE id= ? and cpf = ?";
		PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
		
		ps.setString(1, animal.getEntregue());
		ps.setInt(2, animal.getId());
		ps.setInt(3, animal.getCpf());
		
		ps.executeUpdate();
		ps.close();		
		
		
	}//Atualizar Entrega
	
	public ArrayList<Animal> pesquisaAnimalDono(int cpf) throws SQLException{
		
		try {
			String SQL="SELECT * FROM Animal WHERE cpf = ?";
			PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
			ps.setInt(1, cpf);
			
			ResultSet rs= ps.executeQuery();
			
			ArrayList<Animal> lista= new ArrayList<Animal>();
			
			while(rs.next()){//recupera os valores das colunas que esta apontado
				
				Animal ani= new Animal();
				
				ani.setId(rs.getInt("id"));
				ani.setNome(rs.getString("nome"));
				ani.setTipo(rs.getString("tipo"));
				ani.setIdade(rs.getInt("idade"));
				ani.setEntregue(rs.getString("entregue"));
				ani.setCpf(rs.getInt("cpf"));
				
				lista.add(ani);
				
				
			}
			ps.close();
			
			if(lista.isEmpty()){
				return null;
			}
			
			return lista;
			
			
		} 
		catch (SQLException e) {
			System.err.println("Erro ao recuperar Animal "+e.getMessage());
			
		}
		catch (Exception e) {
			System.out.println("Erro geral "+e.getMessage());
		}
		return null;
		
		
	}//  Pesquisa Animal Dono
	
	public void deletarAnimal(Animal animal) throws SQLException{
		
		String SQL= "DELETE FROM Animal WHERE cpf = ?";
		PreparedStatement ps= (PreparedStatement) dataSource.getConnection().prepareStatement(SQL);
		
		ps.setInt(1,animal.getCpf());
		
		ps.executeUpdate();
		ps.close();
		
	}//Deletar Animal
	

}
