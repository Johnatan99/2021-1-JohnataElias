package atividade_vacina.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Voluntario extends Pessoa{
	private int id;
	public Voluntario(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,  String tipoPessoa,
			Aplicacao aplicacao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, aplicacao);
	}
	public Voluntario() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
