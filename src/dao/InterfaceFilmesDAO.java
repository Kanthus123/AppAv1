package dao;

import java.util.List;
import modelo.Filmes;

public interface InterfaceFilmesDAO {
	
	public void Inserir(Filmes _filmes);
	
	public List<Filmes> listarTodos();
	

}