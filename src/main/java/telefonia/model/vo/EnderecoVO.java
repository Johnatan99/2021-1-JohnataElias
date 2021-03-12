package telefonia.model.vo;

public class EnderecoVO {
	
	private String logradouro;
	private String cep;
	private String uf;
	private String cidade;
	
	public EnderecoVO() {
		super();
	}
	public EnderecoVO(String logradouro, String cep, String uf, String cidade) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
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
	
	@Override
	public String toString() {
		return "\nLogradouro: "+this.getLogradouro()
				+ "\nCEP: "+this.getCep()
				+ "\nUF: "+this.getUf()
				+ "\nCidade: "+this.getCidade()
				+ "\n";
	}
	
}
