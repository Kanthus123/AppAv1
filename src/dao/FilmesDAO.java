package dao;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Filmes;

public class FilmesDAO implements InterfaceFilmesDAO {

	Connection conexao;
	
	public FilmesDAO(Connection _conexao){
		
		this.conexao = _conexao;
		
	}
	
	@Override
	public void Inserir(Filmes _filmes) {	
		
		try{
			
			String comando = "insert into cliente(id, titulo, autor, preco, ano, genero, \"dtcadastro\")" + "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setInt(1, _filmes.getId());
			ps.setString(2, _filmes.getTitulo());
			ps.setString(3, _filmes.getAutor());
			ps.setFloat(4, _filmes.getPreco());
			ps.setInt(5, _filmes.getAno());
			ps.setString(6, _filmes.getGenero());
			ps.setDate(7, new Date(_filmes.getDataCadastro().getTime()));
			
			ps.execute();
		}
			catch(Exception e){
				
				
				
			}
		
		
	}

	@Override
	public List<Filmes> listarTodos() {
		
		ResultSet rs = null;
		List<Filmes> listaFilmes = new ArrayList<Filmes>();
	
		try {
			
			String comando = "select * from filmes";
					
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				int id = rs.getInt(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				float preco = rs.getFloat(4);
				int ano = rs.getInt(5);
				String genero = rs.getString(6);
				
				listaFilmes.add(new Filmes(id, titulo, autor, preco, ano, genero));
			}
		}
		
			catch (Exception e){
				
				
			}
		
		return listaFilmes;
	}
	
	public void Deletar(Filmes _filmes){
		try {	
			String comando = "delete from filmes where Id = ? ";
		
			PreparedStatement ps= this.conexao.prepareStatement(comando);
		
			ps.setInt(1,_filmes.getId());
			
			ps.execute();
			
			ps.close();
			
		
		} catch (Exception e) {
			
			
		}
	}
		
	public void Update(Filmes _filmes){
		
		try {
			String comando = "update filmes set Titulo = ?, Autor = ?, Preco = ?, Ano = ? , Genero = ?  where Id =?";
			
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setString(1, _filmes.getTitulo());
			ps.setString(2, _filmes.getAutor());
			ps.setFloat(3, _filmes.getPreco());
			ps.setInt(4, _filmes.getAno());
			ps.setString(5, _filmes.getGenero());
			ps.setDate(6, new Date(_filmes.getDataCadastro().getTime()));
			
			ps.execute();
			
			ps.close();
			
		}
		 catch (Exception e){
			 
			 
		 }
	}
		 public void Alugar(Filmes _filmes){
			 
			 try {
				 		String comando = "update filmes set Alugado = true, DataAlugado = ?, DataDevolucao = ?, where Id = ?";
				 		
				 		PreparedStatement ps = this.conexao.prepareStatement(comando);
				 		ps.isAlugado(1, _filmes.getAlugado());
				 		
				 		
			 
		 }
			 
			 
	}
	
	
}
