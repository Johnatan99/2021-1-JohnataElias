package atividade_vacina.model.vo;

import java.sql.Date;

public class PesquisadorVO extends PessoaVO{
	
	public PesquisadorVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAlicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAlicacao);
	}
	public PesquisadorVO() {
		super();
	}
}
