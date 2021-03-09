package atividade_vacina.model.vo;

import java.sql.Date;

public class PessoaVO {
	
	private String nome;
	private Date dtNascimento;
	private char sexo;
	private String cpf;
	private String notaAplicacao;
	
	public PessoaVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAplicacao) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.notaAplicacao = notaAplicacao;
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
	public String getNotaAplicacao() {
		return notaAplicacao;
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
	public void setNotaAplicacao(String notaAplicacao) {
		this.notaAplicacao = notaAplicacao;
	}
	@Override
	public String toString() {
		return "PessoaVO [nome=" + nome + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", cpf=" + cpf
				+ ", notaAplicacao=" + notaAplicacao + "]";
	}
	
	
}
