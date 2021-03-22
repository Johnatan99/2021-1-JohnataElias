package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PesquisadorVO extends PessoaVO{
	
	private int id;
	private String instituicao;
	private VacinaVO vacinaCriada;
	
	public PesquisadorVO() {
		super();
	}
	public PesquisadorVO(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			AplicacaoVO aplicacao, String instituicao, VacinaVO vacinaCriada) {
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
	public VacinaVO getVacinaCriada() {
		return vacinaCriada;
	}

	public void setVacinaCriada(VacinaVO vacinaCriada) {
		this.vacinaCriada = vacinaCriada;
	}
	@Override
	public String toString() {
		return "PesquisadorVO [id=" + id + ", instituicao=" + instituicao + ", vacinaCriada=" + vacinaCriada + "]";
	}
	
}
