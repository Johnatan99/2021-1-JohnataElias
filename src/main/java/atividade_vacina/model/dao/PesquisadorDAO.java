package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.vo.PessoaVO;
import atividade_vacina.model.vo.PesquisadorVO;
import atividade_vacina.model.vo.VacinaVO;

public class PesquisadorDAO {
	
	private PessoaVO pessoa = new PessoaVO();
	public PesquisadorVO cadastrar(PesquisadorVO novoPesquisador) {
		Connection conn = Banco.getConnection();
		String sql="insert into pesquisador(fkIdPessoa) values(?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, pessoa.getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoPesquisador.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo pesquisador.\nErro: "+e.getMessage());
		} finally{
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novoPesquisador;
	}
	public boolean alterar(PesquisadorVO pesquisadorAlterado, Integer id) {
		Connection conn = Banco.getConnection();
		String sql="update pesquisador set fkIdPessoa=? where idPesquisador=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, pessoa.getId());
			ps.setInt(6, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar pesquisador.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from pesquisador where idPesquisador=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1,  id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta=numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir pesquisador.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	
	public PesquisadorVO construirDoResultSet(ResultSet rs) {
		PesquisadorVO pesquisadorEncontrado = new PesquisadorVO();
		try {
			pesquisadorEncontrado.setId(rs.getInt("idPesquisador"));
			pessoa.setId(rs.getInt("fkIdPessoa"));
		} catch(SQLException e) {
			System.out.println("Erro ao buscar pessoa.\nErro: "+e.getMessage());
		}
		return pesquisadorEncontrado;
	}
	
	public PesquisadorVO buscarPorId(int id) {
		PesquisadorVO pesquisadorEncontrado = new PesquisadorVO();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa where idPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pesquisadorEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar pessoa.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pesquisadorEncontrado;
	}
	public ArrayList<PesquisadorVO> buscarTodos(){
		ArrayList<PesquisadorVO> pesquisadoresEncontrados = new ArrayList<PesquisadorVO>();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				pesquisadoresEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pesquisadoresEncontrados;
	} 
}
