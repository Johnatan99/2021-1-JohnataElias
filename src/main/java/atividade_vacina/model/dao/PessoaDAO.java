  package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;

import atividade_vacina.model.dao.PessoaDAO;
import atividade_vacina.model.entity.Aplicacao;
import atividade_vacina.model.entity.Pessoa;
import atividade_vacina.model.entity.Vacina;

public class PessoaDAO implements BaseDAO<Pessoa> {
	
	public Pessoa cadastrar(Pessoa novaPessoa) {
		Connection conn = Banco.getConnection();
		String sql="insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, fkIdAplicacao) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, novaPessoa.getNome());
			ps.setString(2, novaPessoa.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(novaPessoa.getDtNascimento()));
			ps.setString(4, String.valueOf(novaPessoa.getSexo()));
			ps.setString(5, novaPessoa.getCpf());
			ps.setString(6, novaPessoa.getTipoPessoa());
			ps.setInt(7, novaPessoa.getAplicacao().getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novaPessoa.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar Pessoa.\nErro: "+e.getMessage());
		} finally{
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaPessoa;
	}
	public boolean alterar(Pessoa pessoaAlterada) {
		Connection conn = Banco.getConnection();
		String sql="update pessoa set nome=?, sobrenome=?, dtNascimento=?, sexo=?, cpf=?, fkidAplicacao"
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
			ps.setInt(6, pessoaAlterada.getAplicacao().getId());
			ps.setInt(6, pessoaAlterada.getId());
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registros de Pessoa.\nErro: "+e.getMessage());
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
			System.out.println("Erro ao excluir registros de Pessoa.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	
	public Pessoa construirDoResultSet(ResultSet rs) {
		Pessoa pessoaEncontrada = new Pessoa();
		try {
			pessoaEncontrada.setId(rs.getInt("idPessoa"));
			pessoaEncontrada.setNome(rs.getString("nome"));
			pessoaEncontrada.setSobrenome(rs.getString("sobrenome"));
			pessoaEncontrada.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			pessoaEncontrada.setSexo(rs.getString("sexo").charAt(0));
			pessoaEncontrada.setCpf(rs.getString("cpf"));
			
			AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
			Aplicacao aplicacaoVO = aplicacaoDAO.buscarPorId(rs.getInt("idAplicacao"));
			pessoaEncontrada.setAplicacao(aplicacaoVO);
		} catch(SQLException e) {
			System.out.println("Erro ao buscar Registro de Pessoa solicitada do ResultSet.\nErro: "+e.getMessage());
		}
		return pessoaEncontrada;
	}
	
	public Pessoa buscarPorId(int id) {
		Pessoa pessoaEncontrada = new Pessoa();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa where idPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pessoaEncontrada = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar registros de Pessoa solicitada.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pessoaEncontrada;
	}
	public ArrayList<Pessoa> buscarTodos(){
		ArrayList<Pessoa> pessoasEncontradas = new ArrayList<Pessoa>();
		Connection conn = Banco.getConnection();
		String sql="select * from pessoa";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				pessoasEncontradas.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos registros de Pessoas.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return pessoasEncontradas;
	}	
}
