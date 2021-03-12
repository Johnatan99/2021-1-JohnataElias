package atividade_vacina.model.vo;

import java.sql.Date;

public class VacinaVO {
	
	private int id;
	private String nomeVacina;
	private String paisOrigem;
	private String estagioPesquisa;
	private Date dtInicioPesquisa;
	private Date dtTerminoPesquisa;
	private int quantidadeDoses;
	private PesquisadorVO pesquisador;
	
	public VacinaVO(String nomeVacina, String paisOrigem, String estagioPesquisa, Date dtInicioPesquisa, Date dtTerminoPesquisa, PesquisadorVO pesquisador, int quantidadeDoses) {
		super();
		this.nomeVacina = nomeVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.dtTerminoPesquisa = dtTerminoPesquisa;
		this.quantidadeDoses = quantidadeDoses;
		this.pesquisador = pesquisador;
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
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
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
		return pesquisador;
	}
	public void setPesquisador(PesquisadorVO pesquisador) {
		this.pesquisador = pesquisador;
	}
	
	@Override
	public String toString() {
		return "VacinaVO [id=" + id + ", nomeVacina=" + nomeVacina + ", paisOrigem=" + paisOrigem + ", estagioPesquisa="
				+ estagioPesquisa + ", dtInicioPesquisa=" + dtInicioPesquisa + ", dtTerminoPesquisa="
				+ dtTerminoPesquisa + ", quantidadeDoses=" + quantidadeDoses + ", pesquisador=" + pesquisador + "]";
	}	
}
