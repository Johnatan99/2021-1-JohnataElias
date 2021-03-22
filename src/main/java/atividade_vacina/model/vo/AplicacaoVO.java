package atividade_vacina.model.vo;

import java.time.LocalDate;

public class AplicacaoVO {
	
	private int id;
	private VacinaVO vacina;
	private LocalDate dtAplicacao;
	private String nota;
	
	public AplicacaoVO() {
		super();
	}
	public AplicacaoVO(VacinaVO vacina, LocalDate dtAplicacao) {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public VacinaVO getVacina() {
		return vacina;
	}
	public void setVacina(VacinaVO vacina) {
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
