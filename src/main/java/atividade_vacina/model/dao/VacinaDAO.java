package atividade_vacina.model.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import atividade_vacina.model.vo.VacinaVO;
import atividade_vacina.model.vo.PesquisadorVO;

public class VacinaDAO {
	
	public VacinaVO cadastrar(VacinaVO novaVacina) {
		Connection conn = Banco.getConnection();
		String sql = "insert into vacina(nome, paisOrigem, estagioPesquisa, dtInicioPesquisa, dtTerminoPesquisa, quantidadeDoses) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);	
		ResultSet rs = null;
		try {
			ps.setString(1, novaVacina.getNomeVacina());
			ps.setString(2, novaVacina.getPaisOrigem());
			ps.setString(3, novaVacina.getEstagioPesquisa());
			ps.setDate(4, java.sql.Date.valueOf(novaVacina.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(novaVacina.getDtTerminoPesquisa()));
			ps.setInt(6, novaVacina.getQuantidadeDoses());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novaVacina.setId(rs.getInt(1));
			}
		} catch(SQLException e){
			System.out.println("Erro ao cadastrar vacina.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaVacina;
	}
	
	public boolean excluir(Integer id) {
		String sql = "delete from vacina where id = ?";
		boolean resposta = true;
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		int numLinhasAfetadas = 0;
		try {
			ps.setInt(1, id);
			numLinhasAfetadas = ps.executeUpdate(sql);
		} catch(SQLException e) {
			System.out.println("Erro ao excluir vacina "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		boolean excluiu = numLinhasAfetadas > 0;
		return excluiu;
	}
	
	public boolean alterar(int id) {
		String sql = "update vacina set nome=? , paisOrigem=?, estagioPesquisa=?, dtInicioPesquisa=?, dtTerminoPesquisa=?, quantidadeDoses=?"
				+ "where id=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		boolean alterado = false;
		int linhasAfetadas = 0;
		VacinaVO vacinaAlterada = new VacinaVO();
		try {
			ps.setString(1, vacinaAlterada.getNomeVacina());
			ps.setString(2, vacinaAlterada.getPaisOrigem());
			ps.setString(3, vacinaAlterada.getEstagioPesquisa());
			ps.setDate(4, java.sql.Date.valueOf(vacinaAlterada.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(vacinaAlterada.getDtTerminoPesquisa()));
			ps.setInt(6, vacinaAlterada.getQuantidadeDoses());
			linhasAfetadas = ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erro ao alterar vacina.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		boolean alterou = linhasAfetadas > 0;
		return alterou;
	}
	
	private VacinaVO construirVacinaDoRs(ResultSet rs) {
		VacinaVO vacinaEncontrada = new VacinaVO();
		try {
		vacinaEncontrada.setId(rs.getInt("idVacina"));
		vacinaEncontrada.setNomeVacina(rs.getString("nome"));
		vacinaEncontrada.setPaisOrigem(rs.getString("paisOrigem"));
		vacinaEncontrada.setEstagioPesquisa(rs.getString("estagioPesquisa"));
		vacinaEncontrada.setDtInicioPesquisa(rs.getDate("dtInicioPesquisa").toLocalDate());
		vacinaEncontrada.setDtTerminoPesquisa(rs.getDate("dtTerminoPesquisa").toLocalDate());
		vacinaEncontrada.setQuantidadeDoses(rs.getInt("quantidadeDoses"));
		} catch(SQLException e) {
			System.out.println("Erro ao construir vacina do ResultSet.\nErro: "+e.getMessage());
		}
		return vacinaEncontrada;
	}
	public VacinaVO buscarVacinaPorNome(String nomeVacina) {
		String sql = "select * from vacina where nome = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		VacinaVO vacinaEncontrada = new VacinaVO();
		ResultSet rs = null;
		try {
			ps.setString(1, nomeVacina);
			rs = ps.executeQuery();
			if(rs.next()) {
				vacinaEncontrada = construirVacinaDoRs(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar por vacina. \nErro: "+e.getMessage());
		}
		return vacinaEncontrada;
	}
	public VacinaVO buscarPorId(int id) {
		String sql = "select * from vacina where idVacina=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		VacinaVO vacinaEncontrada = new VacinaVO();
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vacinaEncontrada = construirVacinaDoRs(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros da vacina solicitada. \nErro: "+e.getMessage());
		}
		return vacinaEncontrada;
	}
	
	public ArrayList<VacinaVO> buscarTodasVacinas() {
		String sql = "select * from vacina";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ArrayList<VacinaVO> vacinaEncontradas = new ArrayList<VacinaVO>();
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				vacinaEncontradas.add(construirVacinaDoRs(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros de vacinas. \nErro: "+e.getMessage());
		}
		return vacinaEncontradas;
	}
}
