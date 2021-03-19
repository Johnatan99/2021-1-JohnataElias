  package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import atividade_vacina.model.vo.PessoaVO;

public class PessoaDAO {
	
	public PessoaVO cadastrar(PessoaVO novaPessoa) {
		Connection conn = Banco.getConnection();
		String sql="insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf) values(?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, novaPessoa.getNome());
			ps.setString(2, novaPessoa.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(novaPessoa.getDtNascimento()));
			ps.setString(4, String.valueOf(novaPessoa.getSexo()));
			ps.setString(5, novaPessoa.getCpf());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novaPessoa.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar nova pessoa.\nErro: "+e.getMessage());
		} finally{
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaPessoa;
	}
	public boolean alterar(PessoaVO pessoaAlterada, Integer id) {
		Connection conn = Banco.getConnection();
		String sql="update pessoa set nome=?, sobrenome=?, dtNascimento=?, sexo=?, cpf=?"
				+ "where idPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		boolean resposta = false;
		try {
			ps.setString(1, pessoaAlterada.getNome());
			ps.setString(2, pessoaAlterada.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(pessoaAlterada.getDtNascimento()));
			ps.setString(4, String.valueOf(pessoaAlterada.getSexo()));
			ps.setString(5, pessoaAlterada.getCpf());
			ps.setInt(6, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar pessoa.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from pessoa where idPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1,  id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta=numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir pessoa.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	
	public PessoaVO construirPessoDoResultSet(ResultSet rs) {
		PessoaVO pessoaEncontrada = new PessoaVO();
		try {
			pessoaEncontrada.setId(rs.getInt("idPessoa"));
			pessoaEncontrada.setNome(rs.getString("nome"));
			pessoaEncontrada.setSobrenome(rs.getString("sobrenome"));
			pessoaEncontrada.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			pessoaEncontrada.setSexo(rs.getString("sexo").charAt(0));
			pessoaEncontrada.setCpf(rs.getString("cpf"));
		} catch(SQLException e) {
			System.out.println("Erro ao buscar pessoa.\nErro: "+e.getMessage());
		}
		return pessoaEncontrada;
	}
	
	public PessoaVO buscarPorId(int id) {
		PessoaVO pessoaEncontrada = new PessoaVO();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa where idPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pessoaEncontrada = construirPessoDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar pessoa.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pessoaEncontrada;
	}
	public ArrayList<PessoaVO> buscarTodos(){
		ArrayList<PessoaVO> pessoasEncontradas = new ArrayList<PessoaVO>();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				pessoasEncontradas.add(construirPessoDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pessoasEncontradas;
	} 
	
}
