package dao;

import java.sql.SQLException;

import modelo.Filmes;
import modelo.Alugar;

public interface InterfaceAlugarDAO {
		
		public void Alugar(Filmes _filmes, Alugar _alugar) throws SQLException;
	
}
