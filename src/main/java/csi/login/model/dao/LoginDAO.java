package csi.login.model.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.dao.Banco;
import csi.login.model.dao.BaseDAO;
import csi.login.model.vo.Login;

public class LoginDAO implements BaseDAO<Login>{

	public Login cadastrar(Login novoRegistro) {
		Connection conn = Banco.getConnection();
		String sql = " insert into login(usuario, senhaAntiga, senhaAtual, recuperacaoSenha)"  
				+ " values(?, ?, ?, ?) ";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		try {
			ps.setString(1, novoRegistro.getUsuario());
			ps.setString(2, novoRegistro.getSenhaAntiga());
			ps.setString(3, novoRegistro.getSenhaAtual());
			ps.setString(4, novoRegistro.getRecuperacaoSenha());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoRegistro.setIdUsuario(rs.getInt(1));
			}
		} catch(SQLException sqlE) {
			System.out.println("Erro ao cadastrar login.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoRegistro;
	}

	public boolean alterar(Login registroAlterado) {
		Connection conn = Banco.getConnection();
		String sql = " update login "
				+ " set usuario=?, senhaAntiga=?, senhaAtual=?, recuperacaoSenha=? "
				+ " where idUsuario=? ";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setString(1, registroAlterado.getUsuario());
			ps.setString(2, registroAlterado.getSenhaAntiga());
			ps.setString(3, registroAlterado.getSenhaAtual());
			ps.setString(4, registroAlterado.getRecuperacaoSenha());
			ps.setInt(5, registroAlterado.getIdUsuario());
			resposta = ps.executeUpdate()>0;
		} catch(SQLException sqlE) {
			System.out.println("Erro ao alterar login.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}

	public boolean excluir(Integer idUsuario) {
		Connection conn = Banco.getConnection();
		String sql = " delete from login where idUsuario=? ";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, idUsuario);
			resposta = ps.executeUpdate()>0;
		} catch(SQLException sqlE) {
			System.out.println("Erro ao excluir login.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}

	public Login buscarPorId(Integer idUsuario) {
		Connection conn = Banco.getConnection();
		String sql = " select * from pessoa where idUsuario=? ";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		Login loginEncontrado = new Login();
		try {
			ps.setInt(1, idUsuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				loginEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException sqlE) {
			System.out.println("Erro ao consultar login por ID.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return loginEncontrado;
	}

	public ArrayList<Login> buscarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " select * from pessoa where idUsuario=? ";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ArrayList<Login> loginsEncontrados = new ArrayList<Login>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Login loginEncontrado = new Login();
				loginEncontrado = construirDoResultSet(rs);
				loginsEncontrados.add(loginEncontrado);
			}
		} catch(SQLException sqlE) {
			System.out.println("Erro ao consultar todos logins.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return loginsEncontrados;
	}

	public Login construirDoResultSet(ResultSet rs) throws SQLException {
		Login loginEncontrado = new Login();
		loginEncontrado.setIdUsuario(rs.getInt("IdUsuario"));
		loginEncontrado.setUsuario(rs.getString("usuario"));
		loginEncontrado.setSenhaAntiga(rs.getString("senhaAntiga"));
		loginEncontrado.setSenhaAtual(rs.getString("senhaAtual"));
		loginEncontrado.setRecuperacaoSenha(rs.getString("recuperacaoSenha"));
		return loginEncontrado;
	}

	public boolean verificarSeUsuarioJaExiste(String usuario) {
		Connection conn = Banco.getConnection();
		String sql = " select * from pessoa where usuario=? ";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				resposta=true;
			}
		} catch(SQLException sqlE) {
			System.out.println("Erro ao consultar todos logins.\nErro: "+sqlE.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
}
