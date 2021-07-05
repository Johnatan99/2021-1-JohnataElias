package atividade_vacina.model.entity;

import java.time.LocalDate;

public class Aplicacao {
	private int id;
	private Vacina vacina;
	private LocalDate dtAplicacao;
	private String nota;
	public Aplicacao() {
		super();
	}
	public Aplicacao(Vacina vacina, LocalDate dtAplicacao, String nota) {
		super();
		this.vacina=vacina;
		this.dtAplicacao=dtAplicacao;
		this.nota=nota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public LocalDate getDtAplicacao() {
		return dtAplicacao;
	}
	public void setDtAplicacao(LocalDate dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "AplicacaoVO [id=" + id + ", vacina=" + vacina + ", dtAplicacao=" + dtAplicacao + ", nota=" + nota + "]";
	}
}
