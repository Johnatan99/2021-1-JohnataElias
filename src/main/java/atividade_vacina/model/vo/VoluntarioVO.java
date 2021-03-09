package atividade_vacina.model.vo;

import java.sql.Date;

public class VoluntarioVO extends PessoaVO{
	
	public VoluntarioVO(String nome, Date dtNascimento, char sexo, String cpf, String notaAlicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAlicacao);
	}
	public VoluntarioVO() {
		super();
	}
}
