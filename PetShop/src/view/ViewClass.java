package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSpinnerUI;

import dao.AnimalDAO;
import dao.ClienteDAO;
import dao.DataSource;
import model.Animal;
import model.Cliente;

public class ViewClass {

	public static void main(String[] args) throws SQLException {

		
		DataSource dataSource = new DataSource();
	
						
		
		String opcoes= JOptionPane.showInputDialog("1.Exibir Clientes\n"+"2.Exibir Animais\n"+
				"3.Cadastrar Cliente\n"+"4.Excluir Cliente\n"+"5.Editar Cliente\n"+"6.Consultar Cliente\n"
				+"7.Cadastrar Animal\n"+"8.Status da Entrega\n"+"9.Pesquisar Animal Pelo Dono");
		
		
		if(opcoes.equals("1")){
						
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			ArrayList<Cliente>listaCliente= cliDao.readAll();
			
			if(listaCliente != null ){
				
				for(Cliente c : listaCliente){
					System.out.println(c.toString());
				}
				
			}
			else{
				System.err.println("Não há clientes cadastrados !");
			}
			
		}//Exibir cliente
		
		if(opcoes.equals("2")){

			AnimalDAO aniDao = new AnimalDAO(dataSource);
			ArrayList<Animal>listaAnimal= aniDao.redAll();
			
			if(listaAnimal != null){
				
				for (Animal a : listaAnimal){
					System.out.println(a.toString());
				}
			}
			else{
				System.err.println("Não há animais cadastrados !");
			}
			
			
		}
		
		if(opcoes.equals("3")){
			
			Cliente cliente = new Cliente();
			ClienteDAO cliDAO = new ClienteDAO(dataSource);			
				
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Infome seu CPF"));
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Infome sua Idade"));
			String nome= JOptionPane.showInputDialog("Informe seu Nome");
			String email= JOptionPane.showInputDialog("Informe seu email");
			String tel= JOptionPane.showInputDialog("Informe seu Telefone");
			
			cliente.setCpf(cpf); cliente.setIdade(idade); cliente.setNome(nome);
			cliente.setEmail(email); cliente.setTelefone(tel);
			
			cliDAO.cadastrarCliente(cliente);
			
						
		}//Cadastrar Cliente
		
		if(opcoes.equals("4")){
			Cliente cliente = new Cliente();
			Animal animal= new Animal();
			
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			AnimalDAO aniDao= new AnimalDAO(dataSource);
			
			
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF para VERIFICAR se a pessoa já possui cadastro!"));
				
				
				if(cliDao.consultarCliente(cpf) !=  null){
					/* Todos os dados do cliente em animal também serão excluidos*/
					
					cliente.setCpf(cpf);	
					animal.setCpf(cpf);
					
					aniDao.deletarAnimal(animal);
					cliDao.deletarCliente(cliente);
			
				}
				
				else{
					System.err.println("Esse CPF: "+cpf+" não possui cadastro");
				}					
			
		}//Deletar Cliente
		
		if(opcoes.equals("5")){
			
			Cliente cliente = new Cliente();
			ClienteDAO cliDAO = new ClienteDAO(dataSource);
			
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Antes de editar informe seu CPF"));
			
			int opc = Integer.parseInt(JOptionPane.showInputDialog("Esolha os campos que quer EDITAR:\n"+
			"1.Idade\n"+"2.Nome\n"+"3.Email\n"+"4.Telefone"));
			
			if(opc == 1){
			
				
				int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade"));
				cliente.setCpf(cpf);
				cliente.setIdade(idade);	
				
				cliDAO.editarCliente(cliente, opc);
			}
			
			
			if(opc == 2){
			
				
				String nome = JOptionPane.showInputDialog("Informe o Nome");
				cliente.setCpf(cpf);
				cliente.setNome(nome);
				
				cliDAO.editarCliente(cliente, opc);
			}
			

			if(opc == 3){
			
				
				String email = JOptionPane.showInputDialog("Informe o E-mail");
				cliente.setCpf(cpf);
				cliente.setEmail(email);
				
				cliDAO.editarCliente(cliente, opc);
			}
			

			if(opc == 4){
			
				
				String tel = (JOptionPane.showInputDialog("Informe o nome"));
				cliente.setCpf(cpf);
				cliente.setEmail(tel);	
				
				cliDAO.editarCliente(cliente, opc);
			}
			
			
			
		}//Editar cliente
		
		
		
	/*     PARTE DO ANIMAL         */
		
		
		
		if(opcoes.equals("6")){
			
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o CPF do Cliente para Consulta"));
			
			
			
				cliDao.consultarCliente(cpf);
				if(cliDao.consultarCliente(cpf) !=  null){
				
					for(Cliente c: cliDao.consultarCliente(cpf)){
					
					System.out.println(c.toString());
					
				}
				}else{
					System.out.println("Cliente não esta cadastrado");
				}
			
			
			
			
			
		}//Consultar Cliente
		
		
		if(opcoes.equals("7")){
			
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF para VERIFICAR se a pessoa já possui cadastro!"));
				
				
				if(cliDao.consultarCliente(cpf) !=  null){
					System.out.println("Cliente OK !");
					
					Animal animal = new Animal();
					AnimalDAO animalDAO = new AnimalDAO(dataSource);
					
					String nome= JOptionPane.showInputDialog("Informe o Nome do Animal");
					String tipo= JOptionPane.showInputDialog("Informe o tipo do Animal, Cachorro ou Gato ?");
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Infome a Idade do Animal"));
					String entregue="não";
					
					animal.setNome(nome); animal.setTipo(tipo);
					animal.setIdade(idade); animal.setEntregue(entregue);
					animal.setCpf(cpf);
					
					animalDAO.cadastrarAnimal(animal);
					
				}
				
				else{
					System.err.println("Esta pessoa não tem cadastrado com CPF: "+cpf);
				}
		
		}//Cadastrar Animal
		
		
		if(opcoes.equals("8")){
			
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF para VERIFICAR se a pessoa já possui cadastro!"));
				
				
				if(cliDao.consultarCliente(cpf) !=  null){
					Animal animal = new Animal();
					
					AnimalDAO animalDAO = new AnimalDAO(dataSource);
					
					System.out.println("Cliente OK !");
					
					
					
					String alterar= JOptionPane.showInputDialog("Aletar ENTREGA para sim/não");					
					int id = Integer.parseInt(JOptionPane.showInputDialog("Infome o ID do animal"));
					
					animal.setId(id);
					animal.setCpf(cpf);
					animal.setEntregue(alterar);
					
					animalDAO.atualizarEntrega(animal);						
					
					
				}
				else{
					System.err.println("Esta pessoa não tem cadastrado com CPF: "+cpf);
				}
			
		}//Alterar entrega
		
		
		if(opcoes.equals("9")){
			
			ClienteDAO cliDao = new ClienteDAO(dataSource);
			
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe CPF para VERIFICAR se a pessoa já possui cadastro!"));
				
				
				if(cliDao.consultarCliente(cpf) !=  null){
					System.out.println("Cliente OK !");
					AnimalDAO animalDAO = new AnimalDAO(dataSource);
					
					if(animalDAO.pesquisaAnimalDono(cpf) == null ){
						System.out.println("Esse Cliente com CPF: "+cpf+" não possui animal cadastrado !");
					}
					else{
						
						for(Animal a : animalDAO.pesquisaAnimalDono(cpf)){
							System.out.println(a.toString());
						}
						
					}
										
										
				}
				else{
					System.err.println("Esta pessoa não tem cadastrado com CPF: "+cpf);
				}
			
			
		}//Pesquisar Animal Pelo Dono
		
		
		
		
		
		
		
			
		}//MAIN		

	

}//Classe
