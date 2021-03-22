package atividade_vacina.model.vo;

import java.util.Date;

public class VacinaVO {
	
	private int id;
	private String nome;
	private String paisOrigem;
	private String estagioPesquisa;
	private Date dtInicioPesquisa;
	private Date dtTerminoPesquisa;
	private int quantidadeDoses;
	private PesquisadorVO responsavel;
	
	public VacinaVO(String nome, String paisOrigem, String estagioPesquisa, Date dtInicioPesquisa, Date dtTerminoPesquisa, int quantidadeDoses, PesquisadorVO responsavel) {
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
	
	public Date getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(Date dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	
	public Date getDtTerminoPesquisa() {
		return dtTerminoPesquisa;
	}
	public void setDtTerminoPesquisa(Date dtTerminoPesquisa) {
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
