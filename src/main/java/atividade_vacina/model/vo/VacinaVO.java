package atividade_vacina.model.vo;

import java.time.LocalDate;

public class VacinaVO {
	
	private int id;
	private String nome;
	private String paisOrigem;
	private String estagioPesquisa;
	private LocalDate dtInicioPesquisa;
	private LocalDate dtTerminoPesquisa;
	private int quantidadeDoses;
	private PesquisadorVO responsavel;
	
	public VacinaVO(String nome, String paisOrigem, String estagioPesquisa, LocalDate dtInicioPesquisa, LocalDate dtTerminoPesquisa, int quantidadeDoses, PesquisadorVO responsavel) {
		super();
		this.nome = nome;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.dtTerminoPesquisa = dtTerminoPesquisa;
		this.quantidadeDoses = quantidadeDoses;
		this.responsavel = responsavel;
	}
	public VacinaVO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeVacina() {
		return nome;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nome = nomeVacina;
	}
	
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	
	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	
	public LocalDate getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(LocalDate dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	
	public LocalDate getDtTerminoPesquisa() {
		return dtTerminoPesquisa;
	}
	public void setDtTerminoPesquisa(LocalDate dtTerminoPesquisa) {
		this.dtTerminoPesquisa = dtTerminoPesquisa;
	}
	public void setQuantidadeDoses(int quantidadeDoses) {
		this.quantidadeDoses = quantidadeDoses;
	}
	
	public int getQuantidadeDoses() {
		return quantidadeDoses;
	}
	public PesquisadorVO getPesquisador() {
		return responsavel;
	}
	public void setPesquisador(PesquisadorVO pesquisador) {
		this.responsavel = pesquisador;
	}
	
	@Override
	public String toString() {
		return "VacinaVO [id=" + id + ", nomeVacina=" + nome + ", paisOrigem=" + paisOrigem + ", estagioPesquisa="
				+ estagioPesquisa + ", dtInicioPesquisa=" + dtInicioPesquisa + ", dtTerminoPesquisa="
				+ dtTerminoPesquisa + ", quantidadeDoses=" + quantidadeDoses + ", pesquisador=" + responsavel + "]";
	}	
}
