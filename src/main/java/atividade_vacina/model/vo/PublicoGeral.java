package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PublicoGeral extends Pessoa{
	
	private int id;
	
	public PublicoGeral(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			Aplicacao aplicacao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, aplicacao);
	}
	public PublicoGeral() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
