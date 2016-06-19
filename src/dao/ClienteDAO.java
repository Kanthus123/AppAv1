package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClienteDAO implements InterfaceClienteDAO {

	Connection conexao;
	
	public ClienteDAO(Connection _conexao){
		
		this.conexao = _conexao;
		
	}
	
	@Override
	public void Inserir(Cliente _cliente) throws SQLException {	
		
			String comando = "insert into cliente(cpf, name, endereco, idade, tel, \"dtcadastro\")" + "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setInt(1, _cliente.getCpf());
			ps.setString(2, _cliente.getName());
			ps.setString(3, _cliente.getEndereco());
			ps.setInt(4, _cliente.getIdade());
			ps.setString(5, _cliente.getTel());
			ps.setDate(6, new Date(_cliente.getDataCadastro().getTime()));
			
			ps.execute();
		
	}

	@Override
	public List<Cliente> listarTodos() throws SQLException {
		
		ResultSet rs = null;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
	
			String comando = "select * from cliente order by cpf";
					
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				int cpf = rs.getInt(1);
				String name = rs.getString(2);
				String endereco = rs.getString(3);
				int idade = rs.getInt(4);
				String tel = rs.getString(5);
				Date data = rs.getDate(6);
				
				listaClientes.add(new Cliente(cpf, name, endereco, idade, tel, data));
		
			}
		
		return listaClientes;
	}
	
	public void Deletar(Cliente _cliente) throws SQLException {
			
			String comando = "delete from cliente where cpf = ?";
		
			PreparedStatement ps= this.conexao.prepareStatement(comando);
		
			ps.setInt(1,_cliente.getCpf());
			
			ps.execute();
			
	}
		
	public void Update(Cliente _cliente) throws SQLException {
		
			String comando = "update cliente set name = ?, endereco = ?, tel = ?, idade = ?, where cpf = ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setString(1, _cliente.getName());
			ps.setString(2, _cliente.getEndereco());
			ps.setInt(3, _cliente.getIdade());
			ps.setString(4, _cliente.getTel());
			
			ps.execute();
		 
	}
		
	
}
