package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Filmes;
import modelo.Alugar;

public class AlugadoDAO {
	
Connection conexao;
	
	public AlugadoDAO(Connection _conexao){
		
		this.conexao = _conexao;

}

	public void Alugar(Filmes _filmes , Alugar _alugado){
		 
		 try {
			 
			 		java.util.Date data = new java.util.Date();
			 		String comando1 = "update filmes set Alugado = true, where Id = ?";
			 		String comando2 = "update alugar set DataAlugado = ? , DataDevolucao = ?, where Id = ?";
			 		
			 		PreparedStatement ps = this.conexao.prepareStatement(comando1);
			 		ps.setBoolean(1, _filmes.isAlugado());
			 		
			 		PreparedStatement ps1 = this.conexao.prepareStatement(comando2);
			 		ps1.setDate(1, new Date(_alugado.getDataAlugado().getTime()));
			 		ps1.setDate(2, new Date((data.getDay() + 7 )));
			 		
			 		ps1.execute();
			 		
			 		ps1.close();
		 
	 }
		catch(Exception e){
			
		}
	
	}
}