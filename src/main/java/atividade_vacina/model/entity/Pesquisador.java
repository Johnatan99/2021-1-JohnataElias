package atividade_vacina.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pesquisador extends Pessoa{
	private int id;
	private String instituicao;
	private int idVacinaCriada;
	public Pesquisador() {
		super();
	}
	public Pesquisador(String nome, String sobrenome, LocalDate dtNascimento, String sexo, String cpf,
			Aplicacao aplicacao, String instituicao, int idVacinaCriada) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, aplicacao);
		this.instituicao=instituicao;
		this.idVacinaCriada=idVacinaCriada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getInstituicao() {
		return instituicao;
	}
	
	public int getIdVacinaCriada() {
		return idVacinaCriada;
	}
	public void setIdVacinaCriada(int idVacinaCriada) {
		this.idVacinaCriada=idVacinaCriada;
	}
	@Override
	public String toString() {
		return "(ID do pesquisador: "+id+", Instituição :"+instituicao+")";
	}
}
