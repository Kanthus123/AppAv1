package controle;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.fabricaConexao;
import dao.FilmesDAO;
import dao.AlugadoDAO;
import modelo.Alugar;
import modelo.Filmes;
import Util.JSFUtil;

@ManagedBean
public class FilmesBean {
	
	Filmes filmes;
	Alugar alugar;
	ListDataModel<Filmes> listaFilmesParaPF;
	private List<Filmes> listaFilmes;
	
	public List<Filmes> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(List<Filmes> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}
	
	public ListDataModel<Filmes> getListaFilmesParaPF() {
		return listaFilmesParaPF;
	}

	public void setListaClienteParaPF(ListDataModel<Filmes> filmes) {
		this.listaFilmesParaPF = filmes;
	}

	public Filmes getFilmes() {
		return filmes;
	}

	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}
	
	public Alugar getAlugar() {
		return alugar;
	}

	public void setAlugar(Alugar alugar) {
		this.alugar = alugar;
	}
	
	public void PrepararNovo() {
		this.filmes = new Filmes();
	}
	
	public void CadastrarFilmes()
	{
		try {
			this.filmes.setDataCadastro(new Date());

			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			FilmesDAO dao = new FilmesDAO(conexao);
			dao.Inserir(this.filmes);

			this.listaFilmes = dao.listarTodos();

			this.listaFilmesParaPF = new ListDataModel<Filmes>(listaFilmes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Filme salvo com sucesso!");
			
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void PreparaUpdate()	{
		this.filmes = listaFilmesParaPF.getRowData();
	}
	
	public void UpdateFilmes() {
		try {
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			FilmesDAO dao = new FilmesDAO(conexao);
			dao.Update(this.filmes);

			this.listaFilmes = dao.listarTodos();

			this.listaFilmesParaPF = new ListDataModel<Filmes>(listaFilmes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Filme atualizado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void PreparaDeletar() {
		this.filmes = listaFilmesParaPF.getRowData();
	}
	
	public void DeletarFilmes() {
		try {
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();

			FilmesDAO dao = new FilmesDAO(conexao);
			dao.Deletar(this.filmes);

			this.listaFilmes = dao.listarTodos();

			this.listaFilmesParaPF = new ListDataModel<Filmes>(listaFilmes);

			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Filme deletado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void PreparaAlugar(){
		this.filmes = listaFilmesParaPF.getRowData();
	}
	
	public void AlugarFilmes(){
		try{
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FilmesDAO dao2 = new FilmesDAO(conexao);
			AlugadoDAO dao = new AlugadoDAO(conexao);
			dao.Alugar(this.filmes, this.alugar);;
			
			this.listaFilmes = dao2.listarTodos();
			
			this.listaFilmesParaPF = new ListDataModel<Filmes>(listaFilmes);
			
			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Filme alugado com sucesso!");
			
		}
			catch (Exception e){
				
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
			
			FilmesDAO dao = new FilmesDAO(conexao);
			this.listaFilmes = dao.listarTodos();
			
			fabrica.fecharConexao();
			
			this.listaFilmesParaPF = new ListDataModel<Filmes>(this.listaFilmes);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
