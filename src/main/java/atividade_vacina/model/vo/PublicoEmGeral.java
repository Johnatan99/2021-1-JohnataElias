package atividade_vacina.model.vo;

import java.sql.Date;

public class PublicoEmGeral extends PessoaVO{
	
	public PublicoEmGeral(String nome, Date dtNascimento, char sexo, String cpf, String notaAlicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAlicacao);
	}
	public PublicoEmGeral() {
		super();
	}
}
