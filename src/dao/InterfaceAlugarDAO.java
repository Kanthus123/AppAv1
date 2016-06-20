package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Filmes;
import modelo.Alugar;

public interface InterfaceAlugarDAO {

		public List<Alugar> listarTodos() throws SQLException;
		
		public void Alugar(Filmes _filmes, Alugar _alugar) throws SQLException;
	
}
