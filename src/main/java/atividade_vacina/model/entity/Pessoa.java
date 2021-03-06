package atividade_vacina.model.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pessoa {
	private int id;
	private String nome;
	private String sobrenome;
	private LocalDate dtNascimento;
	private String sexo;
	private String cpf;
	private Aplicacao aplicacao;
	public Pessoa(String nome, String sobrenome, LocalDate dtNascimento, String sexo, String cpf, Aplicacao aplicacao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.aplicacao = aplicacao;
	}
	public Pessoa() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNomeSobrenome() {
		return this.nome+this.sobrenome;
	}
	public LocalDate getDtNascimento() {
		
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}
	@Override
	public String toString() {
		return "PessoaVO (id: " + id+", nome: "+nome+", sobrenome: "+sobrenome+", dtNascimento: "+dtNascimento+", sexo: "+sexo+", cpf: "+cpf+")" ;
	}
}
