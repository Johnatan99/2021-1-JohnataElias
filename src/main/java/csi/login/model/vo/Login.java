package csi.login.model.vo;

public class Login {
	
	private int idUsuario;
	private String usuario;
	private String senhaAntiga;
	private String senhaAtual;
	private String recuperacaoSenha;
	
	public Login() {
		super();
	}
	public Login(int idUsuario, String usuario, String senhaAntiga, String senhaAtual, String recuperacaoSenha) {
		super();
		this.idUsuario=idUsuario;
		this.usuario=usuario;
		this.senhaAntiga=senhaAntiga;
		this.senhaAtual=senhaAtual;
		this.recuperacaoSenha=recuperacaoSenha;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario=idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenhaAntiga() {
		return senhaAntiga;
	}
	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga=senhaAntiga;
	}
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual=senhaAtual;
	}
	public String getRecuperacaoSenha() {
		return recuperacaoSenha;
	}
	public void setRecuperacaoSenha(String recuperacaoSenha) {
		this.recuperacaoSenha = recuperacaoSenha;
	}	
	public boolean recuperarSenha(String recuperacaoSenha) {
		boolean podeAlterarSenha = false;
		if(this.recuperacaoSenha==recuperacaoSenha) {
			podeAlterarSenha = true;
		}
		return podeAlterarSenha;
	}
	@Override
	public String toString() {
		return "Login [idUsuario=" + idUsuario + ", usuario=" + usuario + ", senhaAntiga=" + senhaAntiga
				+ ", senhaAtual=" + senhaAtual + ", recuperacaoSenha=" + recuperacaoSenha + "]";
	}
	
}
