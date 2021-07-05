package csi.login.model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;

import csi.login.model.dao.BaseDAO;
import csi.login.model.dao.LoginDAO;
import csi.login.model.vo.Login;

public class LoginBO implements BaseDAO<Login>{
	private LoginDAO dao = new LoginDAO();
	
	public Login cadastrar(Login novoRegistro) {
		
		return dao.cadastrar(novoRegistro);
	}
	public boolean alterar(Login registroAlterado) {
		return dao.alterar(registroAlterado);
	}
	public boolean excluir(Integer idUsuario) {
		return dao.excluir(idUsuario);
	}
	public Login buscarPorId(Integer idUsuario) {
		return dao.buscarPorId(idUsuario);
	}
	public ArrayList<Login> buscarTodos() {
		return dao.buscarTodos();
	}
	public boolean usuarioJaExiste(String usuario) {
		return dao.verificarSeUsuarioJaExiste(usuario);
	}
}
