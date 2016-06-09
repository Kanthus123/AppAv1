package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Cliente;

public interface InterfaceClienteDAO {

	public void Inserir(Cliente _cliente) throws SQLException;
	
	public List<Cliente> listarTodos() throws SQLException;
	
	public void Deletar(Cliente _cliente) throws SQLException;
	
	public void Update(Cliente _cliente) throws SQLException;
}
