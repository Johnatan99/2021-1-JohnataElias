package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.intity.Aplicacao;
import atividade_vacina.model.intity.Vacina;

public class AplicacaoDAO {
	
	public Aplicacao cadastrar(Aplicacao novaAplicacao) {
		Connection conn = Banco.getConnection();
		String sql="insert into aplicacao(fkIdVacina, dtAplicacao, nota) values(?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, novaAplicacao.getVacina().getId());
			ps.setDate(2, java.sql.Date.valueOf(novaAplicacao.getDtAplicacao()));
			ps.setString(3, novaAplicacao.getNota());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novaAplicacao.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar Aplicação.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaAplicacao;
	}
	public boolean alterar(Aplicacao aplicacaoAlterada) {
		Connection conn = Banco.getConnection();
		String sql="update aplicacao set fkIdAplicacao=?, dtAplicacao=?, nota=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		boolean resposta = false;
		try {
			ps.setInt(1, aplicacaoAlterada.getVacina().getId());
			ps.setDate(2, java.sql.Date.valueOf(aplicacaoAlterada.getDtAplicacao()));
			ps.setString(3, aplicacaoAlterada.getNota());
			ps.executeUpdate();
		} catch(SQLException e){
			System.out.println("Erro ao alterar registro de Aplicação");
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		 
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from aplicacao where idAplicacao=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro da Aplicação.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public Aplicacao buscarPorId(int id) {
		Aplicacao aplicacaoEncontrada = new Aplicacao();
		Connection conn = Banco.getConnection();
		String sql="select * from aplicacao where idAplicacao=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aplicacaoEncontrada = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registro da Aplicação.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return aplicacaoEncontrada;
	}
	
	public Aplicacao construirDoResultSet(ResultSet rs) {
		Aplicacao aplicacaoEncontrada = new Aplicacao();
		try {
			VacinaDAO vacinaDAO = new VacinaDAO();
			Vacina vacinaVO = vacinaDAO.buscarPorId(rs.getInt("idVacina"));
			aplicacaoEncontrada.setVacina(vacinaVO);
			aplicacaoEncontrada.setDtAplicacao(rs.getDate("dtAplicacao").toLocalDate());
		aplicacaoEncontrada.setNota(rs.getString("nota"));
		} catch(SQLException e) {
			System.out.println("Erro ao constuir registro da Aplicação solcitada do ResultSet.\nErro: "+e.getMessage());
		}
		return aplicacaoEncontrada;
	}
	public ArrayList<Aplicacao> buscarTodasAplicacoes(){   
		ArrayList<Aplicacao> aplicacoesEncontradas = new ArrayList<Aplicacao>();
		Connection conn = Banco.getConnection();
		String sql = "select * from aplicacao";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aplicacoesEncontradas.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todo registro de Aplicações.\nErro: "+e.getMessage());
		}
		return aplicacoesEncontradas;
	}
}
