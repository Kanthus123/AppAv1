package controle;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.fabricaConexao;
import dao.ClienteDAO;
import modelo.Cliente;
import Util.JSFUtil;

@ManagedBean
public class ClienteBean {
	
	Cliente cliente;
	ListDataModel<Cliente> listaClienteParaPF;
	private List<Cliente> listaClientes;
	
	public List<Cliente> getListaCliente() {
		return listaClientes;
	}

	public void setListaCliente(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public ListDataModel<Cliente> getListaClienteParaPF() {
		return listaClienteParaPF;
	}

	public void setListaClienteParaPF(ListDataModel<Cliente> cliente) {
		this.listaClienteParaPF = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void PrepararNovo() {
		this.cliente = new Cliente();
	}
	
	public void CadastrarCliente()
	{
		try {
			this.cliente.setDataCadastro(new Date());

			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			ClienteDAO dao = new ClienteDAO(conexao);
			dao.Inserir(this.cliente);

			this.listaClientes = dao.listarTodos();

			this.listaClienteParaPF = new ListDataModel<Cliente>(listaClientes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Cliente salvo com sucesso!");
			
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void PreparaUpdate()	{
		this.cliente = listaClienteParaPF.getRowData();
	}
	
	public void UpdateCliente() {
		try {
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			ClienteDAO dao = new ClienteDAO(conexao);
			dao.Update(this.cliente);

			this.listaClientes = dao.listarTodos();

			this.listaClienteParaPF = new ListDataModel<Cliente>(listaClientes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Cliente atualizado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void PreparaDeletar() {
		this.cliente = listaClienteParaPF.getRowData();
	}
	
	public void DeletarCliente() {
		try {
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			ClienteDAO dao = new ClienteDAO(conexao);
			dao.Deletar(this.cliente);

			this.listaClientes = dao.listarTodos();

			this.listaClienteParaPF = new ListDataModel<Cliente>(listaClientes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Cliente deletada com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	@PostConstruct
	public void PreecherLista() 
	{
		try {
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			this.listaClientes = dao.listarTodos();
			
			fabrica.fecharConexao();
			
			this.listaClienteParaPF = new ListDataModel<Cliente>(this.listaClientes);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
