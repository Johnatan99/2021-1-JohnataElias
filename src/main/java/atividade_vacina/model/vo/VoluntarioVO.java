package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class VoluntarioVO extends PessoaVO{
	
	public VoluntarioVO(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,
			ArrayList<AplicacaoVacinaVO> aplicacao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, aplicacao);
	}
	public VoluntarioVO() {
		super();
	}
}
