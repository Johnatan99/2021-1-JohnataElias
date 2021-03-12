package telefonia.model.vo;

public class TelefoneVO {
	
	private String ddd;
	private String numero;
	private String codigoInternacional;
	private boolean ativo;
	private boolean movel;
	
	public TelefoneVO(String codigoInternacional, String ddd, String numero, boolean ativo, boolean movel) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.codigoInternacional = codigoInternacional;
		this.ativo = ativo;
		this.movel = movel;
		
		boolean resultado = Boolean.parseBoolean("true");
	}
	
	public TelefoneVO() {
		super();
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoInternacional() {
		return codigoInternacional;
	}
	public void setCodigoInternacional(String codigoInternacional) {
		this.codigoInternacional = codigoInternacional;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isMovel() {
		return ativo;
	}
	public void setMovel(boolean movel) {
		this.movel = movel;
	}
	
	@Override
	public String toString() {
		return "\nTelefone: +"+this.getCodigoInternacional()+" ("+this.getDdd()+") "+this.getNumero()
				+ "\nSituação: "+(this.isAtivo() ? "Ativo" : "Inativo")
				+ "\nTipo de telefone:      "+(this.isMovel() ? "Móvel" : "Fixo")
				+ "\n";	
	}
	
	
	
}
