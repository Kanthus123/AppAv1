package dao;

import java.sql.SQLException;
import java.util.List;
import modelo.Filmes;

public interface InterfaceFilmesDAO {

	public void Inserir(Filmes _filmes) throws SQLException;
	
	public List<Filmes> listarTodos() throws SQLException;
	
	public void Deletar(Filmes _filmes) throws SQLException;
	
	public void Update(Filmes _filmes) throws SQLException;
	
	public void Devolver(Filmes _filmes) throws SQLException;
	
	
}
