package atividade_vacina.model.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import atividade_vacina.model.entity.Pesquisador;
import atividade_vacina.model.entity.Vacina;
import atividade_vacina.seletor.VacinaSeletor;

public class VacinaDAO implements BaseDAO<Vacina>{	
	
	public Vacina cadastrar(Vacina novaVacina) {
		Connection conn = Banco.getConnection();
		String sql = "insert into vacina(nome, paisOrigem, estagioPesquisa, dtInicioPesquisa, dtTerminoPesquisa, quantidadeDoses, IdCriador) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);	
		ResultSet rs = null;
		try {
			ps.setString(1, novaVacina.getNomeVacina());
			ps.setString(2, novaVacina.getPaisOrigem());
			ps.setString(3, novaVacina.getEstagioPesquisa());
			ps.setDate(4, java.sql.Date.valueOf(novaVacina.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(novaVacina.getDtTerminoPesquisa()));
			ps.setInt(6, novaVacina.getQuantidadeDoses());
			ps.setInt(7, novaVacina.getIdCriador());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novaVacina.setId(rs.getInt(1));
			}
		} catch(SQLException e){
			System.out.println("Erro ao cadastrar Vacina.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novaVacina;
	}
	public boolean excluir(int id) {
		String sql = "delete from vacina where idVacina=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		int numLinhasAfetadas = 0;
		boolean excluiu = false;
		try {
			ps.setInt(1, id);
			excluiu = ps.executeUpdate()>0; // tirar dúvida
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro da Vacina.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return excluiu;
	}
	public boolean alterar(Vacina vacinaAlterada) {
		String sql = "update vacina set nome=? , paisOrigem=?, estagioPesquisa=?, dtInicioPesquisa=?, dtTerminoPesquisa=?, quantidadeDoses=?"
				+ "where idVacina=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		boolean alterou = false;
		try {
			ps.setString(1, vacinaAlterada.getNomeVacina());
			ps.setString(2, vacinaAlterada.getPaisOrigem());
			ps.setString(3, vacinaAlterada.getEstagioPesquisa());
			ps.setDate(4, java.sql.Date.valueOf(vacinaAlterada.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(vacinaAlterada.getDtTerminoPesquisa()));
			ps.setInt(6, vacinaAlterada.getQuantidadeDoses());
			alterou = ps.executeUpdate()>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Vacina.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return alterou;
	}
	public Vacina construirDoResultSet(ResultSet rs) {
		Vacina vacinaEncontrada = new Vacina();
		try {
		vacinaEncontrada.setId(rs.getInt("idVacina"));
		vacinaEncontrada.setNomeVacina(rs.getString("nome"));
		vacinaEncontrada.setPaisOrigem(rs.getString("paisOrigem"));
		vacinaEncontrada.setEstagioPesquisa(rs.getString("estagioPesquisa"));
		vacinaEncontrada.setDtInicioPesquisa(rs.getDate("dtInicioPesquisa").toLocalDate());
		vacinaEncontrada.setDtTerminoPesquisa(rs.getDate("dtTerminoPesquisa").toLocalDate());
		vacinaEncontrada.setQuantidadeDoses(rs.getInt("quantidadeDoses"));
		vacinaEncontrada.setIdCriador(rs.getInt("idCriador"));
		} catch(SQLException e) {
			System.out.println("Erro ao construir registro vacina do ResultSet.\nErro: "+e.getMessage());
		}
		return vacinaEncontrada;
	}
	public Vacina buscarVacinaPorNome(String nomeVacina) {
		String sql = "select * from vacina where nome=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		Vacina vacinaEncontrada = new Vacina();
		ResultSet rs = null;
		try {
			ps.setString(1, nomeVacina);
			rs = ps.executeQuery();
			if(rs.next()) {
				vacinaEncontrada = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registro de Vacina. \nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return vacinaEncontrada;
	}
	public Vacina buscarPorId(int id) {
		String sql = "select * from vacina where idVacina=?";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		Vacina vacinaEncontrada = new Vacina();
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vacinaEncontrada = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros da Vacina solicitada.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return vacinaEncontrada;
	}
	
	public ArrayList<Vacina> buscarTodos() {
		String sql = "select * from vacina";
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ArrayList<Vacina> vacinaEncontradas = new ArrayList<Vacina>();
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				vacinaEncontradas.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros de Vacinas. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return vacinaEncontradas;
	}
	
	public ArrayList<Vacina> listarComSeletor(VacinaSeletor seletor){
		String sql="select*from vacina v";
		if(seletor.temFiltro()) {
			sql=seletor.criarFiltros(seletor, sql);
		}
		Connection conn = Banco.getConnection();
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);	
		ArrayList<Vacina> resultados = new ArrayList<Vacina>();
		if(seletor.temPaginacao()) {
			
		}
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vacina v = construirDoResultSet(rs);
				resultados.add(v);
			}
		}catch(SQLException e) {
			System.out.println("Erroao consultar com filtro.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resultados;
		
	}
}



























