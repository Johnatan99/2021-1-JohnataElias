package atividade_vacina.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class PublicoEmGeral extends PessoaVO{
	
	public PublicoEmGeral(String nome, Date dtNascimento, char sexo, String cpf, String notaAplicacao,
			ArrayList<AplicacaoVacinaVO> aplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao, aplicacao);
	}
	public PublicoEmGeral() {
		super();
	}
}
