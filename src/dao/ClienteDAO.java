package dao;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cliente;

public class ClienteDAO implements InterfaceClienteDAO{

	Connection conexao;
	
	public ClienteDAO(Connection _conexao){
		
		this.conexao = _conexao;
		
	}
	
	@Override
	public void Inserir(Cliente _cliente) {	
		
		try{
			
			String comando = "insert into cliente(cpf, name, endereco, tel, \"dtcadastro\")" + "values (?, ?, ?, ?, ?)";
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setInt(1, _cliente.getCpf());
			ps.setString(2, _cliente.getName());
			ps.setString(3, _cliente.getEndereco());
			ps.setString(4, _cliente.getTel());
			ps.setDate(5, new Date(_cliente.getDataCadastro().getTime()));
			
			ps.execute();
		}
			catch(Exception e){
				
				
				
			}
		
		
	}

	@Override
	public List<Cliente> listarTodos() {
		
		ResultSet rs = null;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
	
		try {
			
			String comando = "select * from cliente";
					
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				int cpf = rs.getInt(1);
				String name = rs.getString(2);
				String endereco = rs.getString(3);
				int idade = rs.getInt(4);
				String tel = rs.getString(5);
				
				listaClientes.add(new Cliente(cpf, name, endereco, idade, tel));
			}
		}
		
			catch (Exception e){
				
				
			}
		
		return listaClientes;
	}
	
	public void Deletar(Cliente _cliente){
		try {	
			String comando = "delete from cliente where Cpf = ? ";
		
			PreparedStatement ps= this.conexao.prepareStatement(comando);
		
			ps.setInt(1,_cliente.getCpf());
			
			ps.execute();
			
			ps.close();
			
		
		} catch (Exception e) {
			
			
		}
	}
		
	public void Update(Cliente _cliente){
		
		try {
			String comando = "update cliente set Name = ?, Endereco = ?, Tel = ?, Date = ?  where Id =?";
			
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setString(1, _cliente.getName());
			ps.setString(2, _cliente.getEndereco());
			ps.setString(3, _cliente.getTel());
			ps.setDate(4, new Date(_cliente.getDataCadastro().getTime()));
			
			ps.execute();
			
			ps.close();
			
		}
		 catch (Exception e){
			 
			 
		 }
		
		 
	}
		
	
}
