package atividade_vacina.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public abstract class PessoaVO {
	
	private int id;
	private String nome;
	private Date dtNascimento;
	private char sexo;
	private String cpf;
	private ArrayList<AplicacaoVacinaVO> aplicacao;
	
	public PessoaVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAplicacao, ArrayList<AplicacaoVacinaVO> aplicacao) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.aplicacao = aplicacao;
	}
	public PessoaVO() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public ArrayList<AplicacaoVacinaVO> getAplicacao() {
		return aplicacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNotaAplicacao(ArrayList<AplicacaoVacinaVO> aplicacao) {
		this.aplicacao = aplicacao;
	}
	@Override
	public String toString() {
		return "PessoaVO [nome=" + nome + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", cpf=" + cpf
				+ ", notaAplicacao=" + aplicacao + "]";
	}
	
	
}
