package modelo;

import java.util.Date;

public class Filmes {
	
	private String titulo;
	private String autor;
	private int id;
	private float preco;
	private int ano;
	private String genero;
	private boolean alugado;
	private Date dataCadastro;
	

	public Filmes(){
		
		
		
	}
	
	public Filmes(int _id, String _titulo, String _autor,float _preco, int _ano, String _genero, boolean _alugado){
		
		this.id = _id;
		this.titulo = _titulo;
		this.autor = _autor;
		this.preco = _preco;
		this.ano = _ano;
		this.genero = _genero;
		this.alugado = _alugado;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	
	
	
}
