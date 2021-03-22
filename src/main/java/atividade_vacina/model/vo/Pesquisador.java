package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pesquisador extends Pessoa{
	
	private int id;
	private String instituicao;
	private Vacina vacinaCriada;
	
	public Pesquisador() {
		super();
	}
	public Pesquisador(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			Aplicacao aplicacao, String instituicao, Vacina vacinaCriada) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, aplicacao);
		this.instituicao=instituicao;
		this.vacinaCriada=vacinaCriada;
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
	public Vacina getVacinaCriada() {
		return vacinaCriada;
	}

	public void setVacinaCriada(Vacina vacinaCriada) {
		this.vacinaCriada = vacinaCriada;
	}
	@Override
	public String toString() {
		return "PesquisadorVO [id=" + id + ", instituicao=" + instituicao + ", vacinaCriada=" + vacinaCriada + "]";
	}
	
}
