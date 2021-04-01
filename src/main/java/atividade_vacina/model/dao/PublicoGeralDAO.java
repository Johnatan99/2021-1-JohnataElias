package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import atividade_vacina.model.dao.PessoaDAO;
import atividade_vacina.model.intity.Pessoa;
import atividade_vacina.model.intity.PublicoGeral;

public class PublicoGeralDAO {
		
	public PublicoGeral cadastrar(PublicoGeral novoPublicoGeral) {
		Connection conn = Banco.getConnection();
		String sql="insert into publicoGeral(fkIdPessoa) values(?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		Pessoa pessoa = new Pessoa();
		ResultSet rs = null;
		try {
			ps.setInt(1, pessoa.getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoPublicoGeral.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Público Geral.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novoPublicoGeral;
	}
	public boolean alterar(PublicoGeral publicoGeralAlterado) {
		Connection conn = Banco.getConnection();
		String sql="update publicoGeral set fkIdPessoa=? where idPublicoGeral=?";
		PreparedStatement ps =Banco.getPreparedStatementWithPk(conn, sql);
	    Pessoa pessoa = new Pessoa();
		boolean resposta = false;
		try {
			ps.setInt(1, pessoa.getId());
			ps.setInt(2, publicoGeralAlterado.getId());
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Público Peral.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from publicoGeral where idPubicoGeral=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro de Público Peral.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public PublicoGeral construirDoResultSet(ResultSet rs) {
		PublicoGeral pgEncontrado = new PublicoGeral();
		try {
			pgEncontrado.setId(rs.getInt("idPublicoGeral"));
		} catch(SQLException e) {
			System.out.println("Erro ao construir registro de Público Geral solicitado do ResultSet.\nErro: "+e.getMessage());
		}
		return pgEncontrado;
	}
	public PublicoGeral buscarPorId(int id) {
		PublicoGeral pgEncnontrado = new PublicoGeral();
		Connection conn = Banco.getConnection();
		String sql="select * from publicoGeral where idPublicoGeral=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pgEncnontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registro de Público Geral solicitado.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return pgEncnontrado;
	}
	public ArrayList<PublicoGeral> buscarTodos(){
		ArrayList<PublicoGeral> pPublicoGeralEncontrados = new ArrayList<PublicoGeral>();
		Connection conn = Banco.getConnection();
		String sql="select * from publicogeral";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				pPublicoGeralEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos registros de Público Geral.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return pPublicoGeralEncontrados;
	}	
}
