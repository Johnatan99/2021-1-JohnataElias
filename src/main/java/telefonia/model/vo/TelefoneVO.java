package telefonia.model.vo;

public class TelefoneVO {
	
	private Integer id;
	private String codigoInternacional;
	private String ddd;
	private String numero;
	private Integer idCliente;
	private boolean movel;
	private boolean ativo;
	
	public TelefoneVO(String codigoInternacional, String ddd, String numero, Integer idCliente, boolean movel, boolean ativo) {
		super();
		this.codigoInternacional = codigoInternacional;
		this.ddd = ddd;
		this.numero = numero;
		this.idCliente = idCliente;
		this.movel = movel;
		this.ativo = ativo;
		
		boolean resultado = Boolean.parseBoolean("true");
	}
	public TelefoneVO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoInternacional() {
		return codigoInternacional;
	}
	public void setCodigoInternacional(String codigoInternacional) {
		this.codigoInternacional = codigoInternacional;
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
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public boolean isMovel() {
		return movel;
	}
	public void setMovel(boolean movel) {
		this.movel = movel;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString() {
		return (this.movel ? "Móvel": "Fixo")+" +"+codigoInternacional+"("+ddd+") "+numero+(ativo ? "Ativo":"Inativo")+ this.idCliente != null ? "Id do dono: "+this.idCliente :   "Sem dono" ;
	}	
}
