package atividade_vacina.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PublicoEmGeral extends PessoaVO{
	
	public PublicoEmGeral(String nome, String sobrenome, LocalDate dtNascimento, char sexo, String cpf,
			ArrayList<AplicacaoVacinaVO> aplicacao) {
		super(nome, sobrenome, dtNascimento, sexo, cpf, aplicacao);
	}
	public PublicoEmGeral() {
		super();
	}
}
