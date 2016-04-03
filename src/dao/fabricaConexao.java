package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class fabricaConexao {
	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "mitsu2000");
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return conexao;
		
	}
	
	public void fecharConexao(){
		
		try{
			
			this.conexao.close();
			
		}
		
		catch (Exception e){
			
			e.printStackTrace();
			
		}
		
	}
 	
}
