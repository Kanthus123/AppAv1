package modelo;

import java.util.Date;

public class Alugar {
	
	private Filmes id;
	private Date dataAlugado;
	private Date dataDevolucao;
	
	public Alugar(){
				
	}
	
	public Alugar(Filmes _id){
		
		this.id = _id;
		
	}

	public Filmes getId() {
		return id;
	}

	public void setId(Filmes id) {
		this.id = id;
	}

	public Date getDataAlugado() {
		return dataAlugado;
	}

	public void setDataAlugado(Date dataAlugado) {
		this.dataAlugado = dataAlugado;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	
	
}
