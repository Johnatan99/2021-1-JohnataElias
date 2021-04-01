package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.dao.PessoaDAO;
import atividade_vacina.model.intity.Pessoa;
import atividade_vacina.model.intity.Voluntario;

public class VoluntarioDAO {
	
	public Voluntario cadastrar(Voluntario novoVoluntario) {
		Connection conn = Banco.getConnection();
		String sql="insert into voluntario(fkIdPessoa) values(?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		Pessoa pessoa = new Pessoa();
		ResultSet rs = null;
		try {
			ps.setInt(1, pessoa.getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoVoluntario.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Voluntário.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novoVoluntario;
	}
	public boolean alterar(Voluntario voluntarioAlterado) {
		Connection conn = Banco.getConnection();
		String sql="update voluntario set fkIdPessoa=? where idVoluntario=?";
		PreparedStatement ps =Banco.getPreparedStatementWithPk(conn, sql);
	    Pessoa pessoa = new Pessoa();
		boolean resposta = false;
		try {
			ps.setInt(1, pessoa.getId());
			ps.setInt(2, voluntarioAlterado.getId());
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Voluntário.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from voluntario where idVoluntario=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro de Voluntário.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public Voluntario construirDoResultSet(ResultSet rs) {
		Voluntario pgEncontrado = new Voluntario();
		try {
			pgEncontrado.setId(rs.getInt("idVoluntario"));
		} catch(SQLException e) {
			System.out.println("Erro ao construir registro de Voluntário solicitado do resultSet.\nErro: "+e.getMessage());
		}
		return pgEncontrado;
	}
	public Voluntario buscarPorId(int id) {
		Voluntario voluntarioEncontrado = new Voluntario();
		Connection conn = Banco.getConnection();
		String sql="select * from voluntario where idVoluntario=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				voluntarioEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registro de Voluntário solicitado .\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return voluntarioEncontrado;
	}
	public ArrayList<Voluntario> buscarTodos(){
		ArrayList<Voluntario> voluntariosEncontrados = new ArrayList<Voluntario>();
		Connection conn = Banco.getConnection();
		String sql="select * from voluntario";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			if(rs.next()) {
				voluntariosEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos regstros de Voluntário.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return voluntariosEncontrados;
	}	
}
