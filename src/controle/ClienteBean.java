package controle;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.ClienteDAO;
import dao.fabricaConexao;
import modelo.Cliente;

@ManagedBean
public class ClienteBean {
	
	Cliente cliente;
	ListDataModel<Cliente> listaClienteParaPF;
	List<Cliente> listaClientes;
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaPessoas(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteBean(){
		this.cliente = new Cliente();
	}
	
	public void CadastrarCliente(){
		try{
			
			this.cliente.setDataCadastro(new Date());
			
		fabricaConexao fabrica = new fabricaConexao();
		Connection conexao = fabrica.fazerConexao();
		
		ClienteDAO dao = new ClienteDAO(conexao);
		dao.Inserir(this.cliente);
		
		fabrica.fecharConexao();
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			
		}
	}
		
		public void Atulizar(){
			
			try {
				
				this.cliente.setDataCadastro(new Date());
					
				fabricaConexao fabrica = new fabricaConexao();
				Connection conexao = fabrica.fazerConexao();
				
				ClienteDAO dao = new ClienteDAO(conexao);
				dao.Update(this.cliente);
				
				fabrica.fecharConexao();
				
				}
			
				catch(Exception ex){
					
					ex.printStackTrace();
					
				}
					 
		}

		public ListDataModel<Cliente> getlistaClienteParaPF() {
			return listaClienteParaPF;
		}

		public void setPessoas(ListDataModel<Cliente> clientes) {
			this.listaClienteParaPF = clientes;
		}	

		@PostConstruct
		public void PreencherList(){
			
			if (listaClientes == null){
				
				try{
					
				fabricaConexao fabrica = new fabricaConexao();
				Connection conexao = fabrica.fazerConexao();
				
				ClienteDAO dao = new ClienteDAO(conexao);
				this.listaClientes = dao.listarTodos();
				
				fabrica.fecharConexao();
					
				this.listaClienteParaPF = new ListDataModel <Cliente> (this.listaClientes);
				}
					catch(Exception ex){
						ex.printStackTrace();
						
					}
				
			}
			
		}
		
			public void Deletar(){
			
			try {
					
				fabricaConexao fabrica = new fabricaConexao();
				Connection conexao = fabrica.fazerConexao();
				
				ClienteDAO dao = new ClienteDAO(conexao);
				dao.Deletar(this.cliente);
				
				fabrica.fecharConexao();
				
				}
			
				catch(Exception ex){
					
					ex.printStackTrace();
					
				}
					 
		}
		
}
