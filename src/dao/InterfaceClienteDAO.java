package dao;

import java.util.List;
import modelo.Cliente;

public interface InterfaceClienteDAO {
	
	public void Inserir(Cliente _cliente);
	
	public List<Cliente> listarTodos();
	

}