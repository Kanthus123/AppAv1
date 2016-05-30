package modelo;

import java.util.Date;


public class Cliente {

	
	private int cpf;
	private String name;
	private String endereco;
	private int idade;
	private String tel;
	private Date dataCadastro;

	
	
	public Cliente(){
		
		
	}
	
	public Cliente(int _cpf, String _name,String _endereco, int _idade, String _tel){
		
			this.cpf = _cpf;
			this.name = _name;
			this.endereco = _endereco;
			this.idade = _idade;
			this.tel = _tel;
		
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}

