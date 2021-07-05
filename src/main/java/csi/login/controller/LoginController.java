package csi.login.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import atividade_vacina.model.dao.BaseDAO;
import csi.login.exceptions.login_exception.ValidarCamposLogin;
import csi.login.model.bo.LoginBO;
import csi.login.model.vo.Login;

public class LoginController implements BaseDAO<Login> {
	LoginBO bo = new LoginBO();
	public String validarCampos(Login registro) {
		String resposta = null;
		// Validação usuario:
		if(registro.getUsuario().length()<8) {
			resposta += "O usuário deve possuir no mínimo 8 dígitos";
		} else if(registro.getUsuario().length()>20) {
			resposta += "O usuario deve possuir no máximo 20 dígitos";
		}
		//Validação senha:
		if(registro.getSenhaAtual().length()<8) {
			resposta += "A senha deve possuir no mínimo 8 dígitos";
		} else if(registro.getSenhaAtual().length()>20){
			resposta += "A senha deve possuir no máximo 20 dígitos";
		}
		
		if(registro.getRecuperacaoSenha().length()<3) {
			resposta += "A palavra chave deve possuir no mínimo 8 dígitos";
		} else if(registro.getRecuperacaoSenha().length()>100){
			resposta += "A palavra chave deve possuir no máximo 100 dígitos";
		}
		
		return resposta;
	}
	
	public Login cadastrar(Login novoRegistro) throws ValidarCamposLogin {
		String mensagem = validarCampos(novoRegistro);
		if(mensagem!=null) {
			throw new ValidarCamposLogin(mensagem);
		}
		return bo.cadastrar(novoRegistro);
	}

	public boolean alterar(Login reristroAlterado) {
		return bo.alterar(reristroAlterado);
	}

	public boolean excluir(int idUsuario) {
		return bo.excluir(idUsuario);
	}

	public Login buscarPorId(int idUsuario) {
		return bo.buscarPorId(idUsuario);
	}

	public ArrayList<Login> buscarTodos() {
		return bo.buscarTodos();
	}
	public boolean usuarioJaExiste(String usuario) {
		return bo.usuarioJaExiste   (usuario);
	}
}
