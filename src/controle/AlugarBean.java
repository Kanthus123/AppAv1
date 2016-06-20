package controle;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.ListDataModel;

import dao.fabricaConexao;
import dao.AlugadoDAO;
import dao.FilmesDAO;
import modelo.Alugar;
import modelo.Filmes;

import Util.JSFUtil;

@ManagedBean
public class AlugarBean {
	
	Filmes filmes;
	Alugar alugar;
	ListDataModel<Alugar> listaAlugarParaPF;
	private List<Alugar> listaAlugar;
	
	public Alugar getAlugar() {
		return alugar;
	}
	public void setAlugar(Alugar alugar) {
		this.alugar = alugar;
	}
	public ListDataModel<Alugar> getListaAlugarParaPF() {
		return listaAlugarParaPF;
	}
	public void setListaAlugarParaPF(ListDataModel<Alugar> listaAlugarParaPF) {
		this.listaAlugarParaPF = listaAlugarParaPF;
	}
	public List<Alugar> getListaAlugar() {
		return listaAlugar;
	}
	public void setListaAlugar(List<Alugar> listaAlugar) {
		this.listaAlugar = listaAlugar;
	}
	public Filmes getFilmes() {
		return filmes;
	}
	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}

	
	public void PreparaAlugar(){
		this.alugar = listaAlugarParaPF.getRowData();
	}
	
	public void AlugarFilmes (){
		try{
			
			this.filmes.setDataCadastro(new Date());
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			AlugadoDAO dao = new AlugadoDAO(conexao);
			dao.Alugar(this.filmes, this.alugar);;
			
			this.listaAlugarParaPF = new ListDataModel<Alugar>(listaAlugar);
			
			fabrica.fecharConexao();

			JSFUtil.adicionarMensagemSucesso("Filme alugado com sucesso!");
			
		}
			catch (Exception e){
				
				e.printStackTrace();
				JSFUtil.adicionarMensagemErro(e.getMessage());
			}
		
	}
	
	
	

}
