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
		String sql1 = "insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, fkidAplicacao";
		String sql2="update publicoGeral set fkIdPessoa where idPublicGeral=?;";
		PreparedStatement ps1 = Banco.getPreparedStatementWithPk(conn, sql1);
		PreparedStatement ps2 = Banco.getPreparedStatement(conn, sql2);
		ResultSet rs = null;
		try {
			ps1.setString(1, novoPublicoGeral.getNome());
			ps1.setString(2,novoPublicoGeral.getSobrenome());
			ps1.setDate(3, java.sql.Date.valueOf(novoPublicoGeral.getDtNascimento()));
			ps1.setString(4,String.valueOf(novoPublicoGeral.getSexo()));
			ps1.setString(5, novoPublicoGeral.getCpf());
			ps1.setString(6, novoPublicoGeral.getTipoPessoa());
			ps1.setInt(7, novoPublicoGeral.getAplicacao().getId());
			ps1.execute();
			rs = ps1.getGeneratedKeys();
			if(rs.next()) {	
				int idGerado = rs.getInt(1);
				novoPublicoGeral.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar Pessoa Publico Geral.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps1);
			Banco.closeResultSet(rs);
		}
		try {
			ps2.setInt(1, novoPublicoGeral.getId());
			ps2.execute();
			rs = ps2.getGeneratedKeys();
			if(rs.next()) {
				novoPublicoGeral.setId(rs.getInt(1));
			}
			System.out.print(rs.getString(2)+"\n"+rs.getInt(8));
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Público Geral.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps1);
			Banco.closePreparedStatement(ps2);
			Banco.closeResultSet(rs);
		}
		return novoPublicoGeral;
	}
	public boolean alterar(PublicoGeral publicoGeralAlterado) {
		Connection conn = Banco.getConnection();
		String sql="update pessoa set nome=?, sobrenome=?, dtNascimento=?, sexo=?, cpf=?, tipoPessoa=?, fkIdAplicacao=? where idPessoa=?;";
		String sql2="update publicoGeral set fkIdPessoa=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		PreparedStatement ps2 = Banco.getPreparedStatementWithPk(conn, sql2);
		boolean resposta = false;
		Pessoa pessoa = new Pessoa();
		try {
			ps.setString(1, publicoGeralAlterado.getNome());
			ps.setString(2, publicoGeralAlterado.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(publicoGeralAlterado.getDtNascimento()));
			ps.setString(4, String.valueOf(publicoGeralAlterado.getSexo()));
			ps.setString(5, publicoGeralAlterado.getCpf());
			ps.setString(6, publicoGeralAlterado.getTipoPessoa());
			ps.setInt(7, publicoGeralAlterado.getAplicacao().getId()); 
			ps.setInt(8, publicoGeralAlterado.getId());
			resposta = ps.executeUpdate()>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar Pessoa Publico Geral.\nErro: "+e.getMessage());
	
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		try{
			ps2.setInt(1, publicoGeralAlterado.getId());
			ps2.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de PublicoGeral.\nErro: "+e.getMessage());
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
