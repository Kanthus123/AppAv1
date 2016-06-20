package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Filmes;

public class FilmesDAO implements InterfaceFilmesDAO {
	
	Connection conexao;
	
	public FilmesDAO(Connection _conexao){
		
		this.conexao = _conexao;
		
	}
	
	@Override
	public void Inserir(Filmes _filmes) throws SQLException {	
		
			String comando = "insert into filmes(id, titulo, autor, preco, ano, genero, \"dtcadastro\")" + "values (?, ?, ?, ?, ?, ?, ?)";
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

	@Override
	public List<Filmes> listarTodos() throws SQLException{
		
		ResultSet rs = null;
		List<Filmes> listaFilmes = new ArrayList<Filmes>();
	
			String comando = "select * from filmes order by id";
					
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				int id = rs.getInt(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				float preco = rs.getFloat(4);
				int ano = rs.getInt(5);
				String genero = rs.getString(6);
				Date data = rs.getDate(7);
				boolean alugado = rs.getBoolean(8);
				
				listaFilmes.add(new Filmes(id, titulo, autor, preco, ano, genero, data, alugado));
			}
		
		return listaFilmes;
	}
	
	public void Deletar(Filmes _filmes) throws SQLException{
		
			String comando = "delete from filmes where id = ? ";
		
			PreparedStatement ps= this.conexao.prepareStatement(comando);
		
			ps.setInt(1,_filmes.getId());
			
			ps.execute();
			
	
	
	}
		
	public void Update(Filmes _filmes) throws SQLException {
		
		
			String comando = "update filmes set titulo = ?, autor = ?, preco = ?, ano = ? , genero = ?  where id = ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			ps.setString(1, _filmes.getTitulo());
			ps.setString(2, _filmes.getAutor());
			ps.setFloat(3, _filmes.getPreco());
			ps.setInt(4, _filmes.getAno());
			ps.setString(5, _filmes.getGenero());
			ps.setInt(6, _filmes.getId());
			
			ps.execute();
			
	}
	
	public void Devolver(Filmes _filmes) throws SQLException{
		
 		String comando1 = "update filmes set alugado = false, where id = ?";
 		
 		PreparedStatement ps = this.conexao.prepareStatement(comando1);
 		ps.setBoolean(1, _filmes.isAlugado());

 		ps.execute();
 		
 		ps.close();
	
	}
		
		
}
