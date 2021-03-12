package atividade_vacina.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class VoluntarioVO extends PessoaVO{
	
	public VoluntarioVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAplicacao,
			ArrayList<AplicacaoVacinaVO> aplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao, aplicacao);
	}
	public VoluntarioVO() {
		super();
	}
}
