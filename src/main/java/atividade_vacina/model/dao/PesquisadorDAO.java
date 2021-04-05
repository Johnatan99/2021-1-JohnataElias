package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import atividade_vacina.model.intity.Pesquisador;
import atividade_vacina.model.intity.Pessoa;
import atividade_vacina.model.intity.Vacina;

public class PesquisadorDAO implements BaseDAO<Pesquisador>{
	public Pesquisador cadastrar(Pesquisador novoPesquisador) {
		Connection conn = Banco.getConnection();
		String sql="insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, tipoPessoa, fkidAplicacao) values(?, ?, ?, ?, ?, ?, ?)";
		String sql2="insert into pesquisador(instituicao, fkIdPessoa) values(?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		PreparedStatement ps2 = Banco.getPreparedStatementWithPk(conn, sql2);
		ResultSet rs = null;
		try {
			ps.setString(1, novoPesquisador.getNome());
			ps.setString(2, novoPesquisador.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(novoPesquisador.getDtNascimento()));
			ps.setString(4, String.valueOf(novoPesquisador.getSexo()));
			ps.setString(5, novoPesquisador.getCpf());
			ps.setString(6, novoPesquisador.getTipoPessoa());
			ps.setInt(7, novoPesquisador.getAplicacao().getId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoPesquisador.setId(rs.getInt(1));
			} 
		}catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Pessoa Pesquisador.\nErro: )"+e.getMessage());
		}
		try {
			ps2.setString(1, novoPesquisador.getInstituicao());
			ps2.setInt(2, novoPesquisador.getId());
			ps2.execute();
			rs = ps2.getGeneratedKeys();
			if(rs.next()) {
				novoPesquisador.setId(rs.getInt(8));
			}
			
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar Pesquisador.\nErro: "+e.getMessage());
		} finally{
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novoPesquisador;
	}
	public boolean alterar(Pesquisador pesquisadorAlterado) {
		Connection conn = Banco.getConnection();
		String sql="update pessoa set nome=?, sobrenome=?, dtNascimento=?, sexo=?, cpf=?, tipoPessoa=?, fkIdAplicacao=? where idPessoa=?;";
		String sql2="update pesquisador set instituicao=?, fkIdVacinaCriada=?, fkIdPessoa=? where idPesquisador=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		PreparedStatement ps2 = Banco.getPreparedStatementWithPk(conn, sql2);
		boolean resposta = false;
		boolean bool = false;
		Pessoa pessoa = new Pessoa();
		try {
			ps.setString(1, pesquisadorAlterado.getNome());
			ps.setString(2, pesquisadorAlterado.getSobrenome());
			ps.setDate(3, java.sql.Date.valueOf(pesquisadorAlterado.getDtNascimento()));
			ps.setString(4, String.valueOf(pesquisadorAlterado.getSexo()));
			ps.setString(5, pesquisadorAlterado.getCpf());
			ps.setString(6, pesquisadorAlterado.getTipoPessoa());
			ps.setInt(7, pesquisadorAlterado.getAplicacao().getId()); 
			ps.setInt(8, pesquisadorAlterado.getId());
			
			ps2.setString(1, pesquisadorAlterado.getInstituicao());
			ps2.setInt(2, pesquisadorAlterado.getId());
			ps2.setInt(3, pesquisadorAlterado.getId());
			ps.executeUpdate();
			ps2.executeUpdate();	
			resposta = ps.executeUpdate()>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Pesquisador.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		try{
			ps2.setString(1, pesquisadorAlterado.getInstituicao());
			ps2.setInt(2, pesquisadorAlterado.getId());
			ps2.setInt(3, pesquisadorAlterado.getId());
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro de Pesquisador.\nErro: "+e.getMessage());
		}
		return resposta;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from pessoa where idPessoa=?";
		String sql2="delete from pesquisador where idPesquisador=?";
		PreparedStatement ps1 = Banco.getPreparedStatement(conn, sql);
		PreparedStatement ps2 = Banco.getPreparedStatement(conn, sql2);
		boolean resposta = false;
		try {
			ps1.setInt(1,  id);
			ps2.setInt(1, id);
			int numLinhasAlteradas = ps1.executeUpdate();
			resposta=numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro de Pesquisador.\nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps1);
			Banco.closePreparedStatement(ps2);
		}
		return resposta;
	}
	public Pesquisador construirDoResultSet(ResultSet rs) {
		Pesquisador pesquisadorEncontrado = new Pesquisador();
		try {
			pesquisadorEncontrado.setId(rs.getInt("idPessoa"));
			pesquisadorEncontrado.setNome(rs.getString("nome"));
			pesquisadorEncontrado.setSobrenome(rs.getString("sobrenome"));
			pesquisadorEncontrado.setDtNascimento(rs.getDate("dtNascimento").toLocalDate());
			pesquisadorEncontrado.setSexo(rs.getString("sexo").charAt(0));
			pesquisadorEncontrado.setCpf(rs.getString("cpf"));	
			pesquisadorEncontrado.setId(rs.getInt("idPesquisador"));
			pesquisadorEncontrado.setInstituicao(rs.getString("instituicao"));			
		} catch(SQLException e) {
			System.out.println("Erro ao construir registro de Pesquisador do ResultSet.\nErro: "+e.getMessage());
		}
		return pesquisadorEncontrado;
	}
	public Pesquisador buscarPorId(int id) {
		Pesquisador pesquisadorEncontrado = new Pesquisador();
		Connection conn = Banco.getConnection();
		String sql="select * "
				+ "from pessoa inner join pesquisador on pessoa.idPessoa=pesquisador.IdPesquisador "
				+ "where id=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pesquisadorEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao encontrar registro do Pesquiador solicitado.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return pesquisadorEncontrado;
	}
	public ArrayList<Pesquisador> buscarTodos(){
		ArrayList<Pesquisador> pesquisadoresEncontrados = new ArrayList<Pesquisador>();
		Connection conn = Banco.getConnection();
		String sql="select * "
				+ "from pessoa inner join pesquisador on pessoa.IdPessoa=pesquisador.IdPesquisador";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				pesquisadoresEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros de todos Pesquisadores.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return pesquisadoresEncontrados;
	} 
}
