package controle;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

import dao.FilmesDAO;
import dao.fabricaConexao;
import modelo.Filmes;

@ManagedBean
public class FilmesBean {
	
	Filmes filme;
	ListDataModel<Filmes> filmes;
	List<Filmes> listaFilmes;
	
	public List<Filmes> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaPessoas(List<Filmes> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public Filmes getFilmes() {
		return filme;
	}

	public void setCliente(Filmes filme) {
		this.filme = filme;
	}

	public FilmesBean(){
		this.filme = new Filmes();
	}
	
	public void CadastrarCliente(){
		try{
			
			this.filme.setDataCadastro(new Date());
			
		fabricaConexao fabrica = new fabricaConexao();
		Connection conexao = fabrica.fazerConexao();
		
		FilmesDAO dao = new FilmesDAO(conexao);
		dao.Inserir(this.filme);
		
		fabrica.fecharConexao();
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			
		}
	}
		
		public void Atulizar(){
			
			try {
				
				this.filme.setDataCadastro(new Date());
					
				fabricaConexao fabrica = new fabricaConexao();
				Connection conexao = fabrica.fazerConexao();
				
				FilmesDAO dao = new FilmesDAO(conexao);
				dao.Update(this.filme);
				
				fabrica.fecharConexao();
				
				}
			
				catch(Exception ex){
					
					ex.printStackTrace();
					
				}
					 
		}

		public ListDataModel<Filmes> getFilmes1() {
			return filmes;
		}

		public void setPessoas(ListDataModel<Filmes> filmes) {
			this.filmes = filmes;
		}	

		@PostConstruct
		public void PreencherList(){
			
			if (listaFilmes == null){
				
				try{
					
				fabricaConexao fabrica = new fabricaConexao();
				Connection conexao = fabrica.fazerConexao();
				
				FilmesDAO dao = new FilmesDAO(conexao);
				this.listaFilmes = dao.listarTodos();
				
				fabrica.fecharConexao();
					
				this.filmes = new ListDataModel <> (this.listaFilmes);
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
				
				FilmesDAO dao = new FilmesDAO(conexao);
				dao.Deletar(this.filme);
				
				fabrica.fecharConexao();
				
				}
			
				catch(Exception ex){
					
					ex.printStackTrace();
					
				}
					 
		}
		
}
