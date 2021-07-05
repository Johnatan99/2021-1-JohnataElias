package telefonia.model.vo;

public class EnderecoVO {
	
	private Integer id;
	private String logradouro;
	private String cep;
	private String uf;
	private String cidade;
	private String numero;
	private String estado;
	
	public EnderecoVO() {
		super();
	}
	public EnderecoVO(String logradouro, String cep, String uf, String cidade, String numero, String estado) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.numero = numero;
		this.estado = estado;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "\nLogradouro: "+this.getLogradouro()
				+ "\nCEP: "+this.getCep()
				+ "\nUF: "+this.getUf()
				+ "\nCidade: "+this.getCidade()
				+ "\nEstado: "+this.getEstado()
				+ "\n";
	}
	
}
