package telefonia.model.vo;

import java.util.ArrayList;

public class ClienteVO {
	
	private Integer id;
	private String nome;
	private String cpf;
	private ArrayList<TelefoneVO> telefones;
	private EnderecoVO endereco;
	private boolean ativo;
	
	public ClienteVO(String nome, String cpf, ArrayList<TelefoneVO> telefones, EnderecoVO endereco,
			boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.endereco = endereco;
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
	public ArrayList<TelefoneVO> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<TelefoneVO> telefones) {
		this.telefones = telefones;
	}
	public EnderecoVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
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
		}else {
			textoTelefones = telefones.toString();
		}
		return "\nNome: "+this.getNome()
			 + "\nCPF: "+this.getCpf()
			 + "\nSituação : "+(this.isAtivo() ? "Ativo" : "Inativo")
		     + "\nEndereco: "+this.getEndereco()
		     + "\nTelefones: "+textoTelefones;
	}
}
