package telefonia.model.vo;

import java.util.List;

public class ClienteVO {
	
	private Integer id;
	private String nome;
	private String cpf;
	private List<TelefoneVO> telefones;
	private EnderecoVO  enderecoCliente;
	private boolean ativo;
	
	public ClienteVO(String nome, String cpf, List<TelefoneVO> telefones, EnderecoVO enderecoCliente,
			boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.enderecoCliente = enderecoCliente;
		this.ativo = ativo;
	}
	public ClienteVO() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<TelefoneVO> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneVO> telefones) {
		this.telefones = telefones;
	}
	public EnderecoVO getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(EnderecoVO enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Override
	public String toString(){
		String textoTelefones = this.getTelefones().toString();
		if(this.getTelefones().isEmpty()) {
			textoTelefones = "Sem telefones";
		}
		return "\nNome: "+this.getNome()
			 + "\nCPF: "+this.getCpf()
			 + "\nSituação : "+(this.isAtivo() ? "Ativo" : "Inativo")
		     + "\nEndereco: "+this.getEnderecoCliente()
		     + "\nTelefones: "+textoTelefones;
	}
}
