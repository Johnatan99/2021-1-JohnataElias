package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class VoluntarioVO extends PessoaVO{
	
	private int id;
	
	public VoluntarioVO(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			AplicacaoVO aplicacao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, aplicacao);
	}
	public VoluntarioVO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
