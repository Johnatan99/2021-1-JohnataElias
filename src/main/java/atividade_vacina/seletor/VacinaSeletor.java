package atividade_vacina.seletor;

import java.time.LocalDate;

public class VacinaSeletor {
	//Atributos para filtro
	private int id;
	private String nome;
	private String paisOrigem;
	private String estagioPesquisa;
	private LocalDate dtInicioPesquisa;
	private LocalDate dtTerminoPesquisa;
	private int quantidadeDoses;
	private int idCriador;
	//Filtragem de datas por período(Início, fim)
	private LocalDate dtInicioCadastro;
	private LocalDate dtFimCadastro;
	//Atributos para possível pagição dos resultados;
	private int limite;
	private int pagina;
	
	public VacinaSeletor() {
		this.limite=0;
		this.pagina=-1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public int getQuantidadeDoses() {
		return quantidadeDoses;
	}
	public void setQuantidadeDoses(int quantidadeDoses) {
		this.quantidadeDoses = quantidadeDoses;
	}
	public int getIdCriador() {
		return idCriador;
	}
	public void setIdCriador(int idCriador) {
		this.idCriador = idCriador;
	}
	public LocalDate getDtInicioCadastro() {
		return dtInicioCadastro;
	}

	public void setDtInicioCadastro(LocalDate dtInicioCadastro) {
		this.dtInicioCadastro = dtInicioCadastro;
	}
	public LocalDate getDtFimCadastro() {
		return dtFimCadastro;
	}
	public void setDtFimCadastro(LocalDate dtFimCadastro) {
		this.dtFimCadastro = dtFimCadastro;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public boolean temFiltro() {
		if(this.id>0) {
			return true;
		}
		if((this.nome!=null)&&(this.nome.trim().length()>0)) {
		return true;
		}
		if((this.paisOrigem!=null)&&(this.paisOrigem.trim().length()>0)){		
			return true;
		}
		if((this.estagioPesquisa!=null&&(this.estagioPesquisa.trim().length()>0))) {
			return true;
		}
		if(this.dtInicioPesquisa!=null) {
			return true;
		}
		if(this.dtTerminoPesquisa!=null) {
			return true;
		}
		if(this.idCriador>0) {
			return true;
		}
		if(this.dtInicioCadastro!=null) {
			return true;
		}
		if(this.dtFimCadastro!=null) {
			return true;
		}
		return false;
	}
	public boolean temPaginacao() {		
		return ((this.limite>0)&&(this.pagina>-1));
	}
	public int getOffset() {
		return (this.limite)*(this.pagina-1);
	}
	
	public String criarFiltros(VacinaSeletor seletor, String sql) {
		//Tem pelo menos um filtro
		sql+=" where ";
		boolean primeiro = true;
		if(seletor.getId()>0) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.id= "+seletor.getId();
			primeiro=false;
		}
		if((seletor.getNome()!=null)&&(seletor.getNome().trim().length()>0)){
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.nome LIKE '% "+seletor.getNome()+" %'";
			primeiro=false;
		}
		if((seletor.getPaisOrigem()!=null)&&(seletor.getPaisOrigem().trim().length()>0)){
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.paisOrigem= "+seletor.getPaisOrigem();
			primeiro=false;
		}
		if((seletor.getEstagioPesquisa()!=null)&&(seletor.getEstagioPesquisa().trim().length())>0) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.estagioPesquisa";
			primeiro=false;
		}
		if(seletor.getDtInicioPesquisa()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dtInicioPesquisa= "+seletor.getDtInicioPesquisa();
			primeiro=false;
		}
		if(seletor.getDtTerminoPesquisa()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dtTerminoPesquisa= "+seletor.getDtTerminoPesquisa();
			primeiro=false;
		}
		if(seletor.quantidadeDoses>0) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.quantidadeDoses= "+seletor.getQuantidadeDoses();
			primeiro=false;
		}
		if(seletor.getId()>0) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.idCriador= "+seletor.getIdCriador();
			primeiro=false;
		}
		if((seletor.getDtInicioCadastro()!=null)&&(seletor.getDtFimCadastro()!=null)) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dtCadastro BETWEEN "+seletor.getDtInicioCadastro()+" and "+seletor.getDtFimCadastro();
			primeiro=false;
		}else if(seletor.getDtInicioCadastro()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dtCadastro>= "+seletor.getDtInicioCadastro();
			primeiro=false;
		} else if(seletor.getDtFimCadastro()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dtCadastro <= "+seletor.getDtFimCadastro();
		}
		return sql;
	}
}


