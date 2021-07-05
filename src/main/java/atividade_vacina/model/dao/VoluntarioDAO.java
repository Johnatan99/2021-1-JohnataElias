package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.dao.PessoaDAO;
import atividade_vacina.model.entity.Pessoa;
import atividade_vacina.model.entity.Voluntario;

public class VoluntarioDAO {
	
	public Voluntario cadastrar(Voluntario novoVoluntario) {
		Connection conn = Banco.getConnection();
		String sql1 = "insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, fkidAplicacao";
		String sql2="update voluntario set fkIdPessoa where idVoluntario=?;";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql1);
		PreparedStatement ps2 = Banco.getPreparedStatementWithPk(conn, sql2);
		Pessoa pessoa = new Pessoa();
		ResultSet rs = null;
		
		try {
			ps.setString(1, novoVoluntario.getNome());
			ps.setString(2, novoVoluntario.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(novoVoluntario.getDtNascimento()));
			ps.setString(4, String.valueOf(novoVoluntario.getSexo()));
			ps.setString(5, novoVoluntario.getCpf());
			ps.setString(6, novoVoluntario.getTipoPessoa());
			ps.setInt(7, novoVoluntario.getAplicacao().getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoVoluntario.setId(rs.getInt(1));
			}
			if(rs.next()) {
				novoVoluntario.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Pessoa Voluntário.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		try {
			ps2.setInt(1, pessoa.getId());
			ps2.execute();
			rs = ps2.getGeneratedKeys();
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
		String sql="update pessoa set nome=?, sobrenome=?, dtNascimento=?, sexo=?, cpf=?, tipoPessoa=?, fkIdAplicacao=? where idPessoa=?;";
		String sql2="update voluntario set fkIdPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		PreparedStatement ps2 = Banco.getPreparedStatementWithPk(conn, sql2);
		boolean resposta = false;
		Pessoa pessoa = new Pessoa();
		try {
			ps.setString(1, voluntarioAlterado.getNome());
			ps.setString(2, voluntarioAlterado.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(voluntarioAlterado.getDtNascimento()));
			ps.setString(4, String.valueOf(voluntarioAlterado.getSexo()));
			ps.setString(5, voluntarioAlterado.getCpf());
			ps.setString(6, voluntarioAlterado.getTipoPessoa());
			ps.setInt(7, voluntarioAlterado.getAplicacao().getId()); 
			ps.setInt(8, voluntarioAlterado.getId());
			resposta = ps.executeUpdate()>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar Pessoa Voluntário.\nErro: "+e.getMessage());
	
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		try{
			ps2.setInt(1, voluntarioAlterado.getId());
			ps2.executeUpdate();
			ps2.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Voluntário.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public Voluntario construirDoResultSet(ResultSet rs) {
		Voluntario voluntarioEncontrado = new Voluntario();
		try {
			voluntarioEncontrado.setId(rs.getInt("idPessoa"));
			voluntarioEncontrado.setNome(rs.getString("nome"));
			voluntarioEncontrado.setSobrenome(rs.getString("sobrenome"));
			voluntarioEncontrado.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			voluntarioEncontrado.setSexo(rs.getString("sexo").charAt(0));
			voluntarioEncontrado.setCpf(rs.getString("cpf"));	
			voluntarioEncontrado.setId(rs.getInt("idVoluntario"));			
		} catch(SQLException e) {
			System.out.println("Erro ao construir registro de Pesquisador do ResultSet.\nErro: "+e.getMessage());
		}
		return voluntarioEncontrado;
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
