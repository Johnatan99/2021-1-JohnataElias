package atividade_vacina.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class PesquisadorVO extends PessoaVO{
	
	
	public PesquisadorVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAplicacao,
			ArrayList<AplicacaoVacinaVO> aplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao, aplicacao);
	}

	public PesquisadorVO() {
		super();
	}
}
