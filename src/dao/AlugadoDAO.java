package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Alugar;
import modelo.Filmes;

public class AlugadoDAO implements InterfaceAlugarDAO {
	
	Connection conexao;
	
	public AlugadoDAO(Connection _conexao){
		
		this.conexao = _conexao;
		
	}
	
	@Override
	public List<Alugar> listarTodos() throws SQLException{
		
		ResultSet rs = null;
		List<Alugar> listaAlugar = new ArrayList<Alugar>();
	
			String comando = "select * from alugar order by id";
					
			PreparedStatement ps = this.conexao.prepareStatement(comando);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				
				int id = rs.getInt(1);
				Date data = rs.getDate(2);
				Date data2 = rs.getDate(3);
				
				listaAlugar.add(new Alugar(id, data, data2));
			}
		
		return listaAlugar;
	}
	
	@Override
	public void Alugar(Filmes _filmes, Alugar _alugado) throws SQLException{
		 
		
		 
 		java.util.Date data = new java.util.Date();
 		String comando1 = "update filmes set alugado = true, where id = ?";
 		String comando2 = "update alugar set dataAlugado = ? , DataDevolucao = ?, where id = ?";
 		
 		PreparedStatement ps = this.conexao.prepareStatement(comando1);
 		ps.setBoolean(1, _filmes.isAlugado());
 		
 		PreparedStatement ps1 = this.conexao.prepareStatement(comando2);
 		ps1.setDate(1, new Date(_alugado.getDataAlugado().getTime()));
 		ps1.setDate(2, new Date((data.getDay() + 7 )));
 		
 		ps.execute();
 		ps1.execute();
 		
 		ps1.close();
 		ps.close();

	}

		
}
