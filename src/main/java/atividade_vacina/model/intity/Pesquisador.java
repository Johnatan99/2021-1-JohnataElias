package atividade_vacina.model.intity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pesquisador extends Pessoa{
	private int id;
	private String instituicao;
	public Pesquisador() {
		super();
	}
	public Pesquisador(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			Aplicacao aplicacao, String instituicao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, aplicacao);
		this.instituicao=instituicao;
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
	@Override
	public String toString() {
		return "(ID do pesquisador: "+id+", Instituição :"+instituicao+")";
	}
}
