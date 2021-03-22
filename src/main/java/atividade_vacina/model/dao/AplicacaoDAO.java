package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_vacina.model.vo.VacinaVO;
import atividade_vacina.model.vo.AplicacaoVO;

import java.util.ArrayList;

public class AplicacaoDAO {
	
	public AplicacaoVO cadastrarAplicacao(AplicacaoVO novaAplicacao) {
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
			System.out.println("Erro ao registrar aplica��o.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaAplicacao;
	}
	public boolean alterar(AplicacaoVO aplicacaoAlterada) {
		Connection conn = Banco.getConnection();
		String sql="update from aplicacao set fkIdAplicacao=?, dtAplicacao=?, nota=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		boolean resposta = false;
		try {
			ps.setInt(1, aplicacaoAlterada.getVacina().getId());
			ps.setDate(2, java.sql.Date.valueOf(aplicacaoAlterada.getDtAplicacao()));
			ps.setString(3, aplicacaoAlterada.getNota());
			ps.executeUpdate();
		} catch(SQLException e){
			System.out.println("Erro ao alterar registro de aplica��o");
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
			System.out.println("Erro ao excluir registro da aplica��o.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public AplicacaoVO buscarPorId(int id) {
		AplicacaoVO aplicacaoEncontrada = new AplicacaoVO();
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
			System.out.println("Erro ao buscar registro da aplica��o.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return aplicacaoEncontrada;
	}
	
	public AplicacaoVO construirDoResultSet(ResultSet rs) {
		AplicacaoVO aplicacaoEncontrada = new AplicacaoVO();
		try {
			VacinaDAO vacinaDAO = new VacinaDAO();
			VacinaVO vacinaVO = vacinaDAO.buscarPorId(rs.getInt("idVacina"));
			aplicacaoEncontrada.setVacina(vacinaVO);
			aplicacaoEncontrada.setDtAplicacao(rs.getDate("dtAplicacao").toLocalDate());
		aplicacaoEncontrada.setNota(rs.getString("nota"));
		} catch(SQLException e) {
			System.out.println("Erro ao registro de aplicacao do construirDoResultSet");
		}
		return aplicacaoEncontrada;
	}
	public ArrayList<AplicacaoVO> buscarTodasAplicacoes(){
		ArrayList<AplicacaoVO> aplicacoesEncontradas = new ArrayList<AplicacaoVO>();
		Connection conn = Banco.getConnection();
		String sql = "select * from aplicacao";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aplicacoesEncontradas.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todo registro de aplica��es.\nErro: "+e.getMessage());
		}
		return aplicacoesEncontradas;
	}
}