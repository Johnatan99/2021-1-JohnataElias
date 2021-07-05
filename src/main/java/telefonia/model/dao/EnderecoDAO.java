package telefonia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import atividade_vacina.model.dao.Banco;

import java.util.ArrayList;

import telefonia.model.vo.ClienteVO;
import telefonia.model.vo.EnderecoVO;
import telefonia.model.vo.TelefoneVO;

public class EnderecoDAO implements BaseDAO<EnderecoVO> {
	
	public EnderecoVO cadastrar(EnderecoVO novoEndereco) {
		Connection conn = Banco.getConnection();
		String sql = "insert into atividade_telefonia.endereco(logradouro, cep, uf, cidade, estado, numero) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, novoEndereco.getLogradouro());
			ps.setString(2, novoEndereco.getCep());
			ps.setString(3, novoEndereco.getUf());
			ps.setString(4, novoEndereco.getCidade());
			ps.setString(5, novoEndereco.getNumero());
			ps.setString(6, novoEndereco.getEstado());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoEndereco.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo endereço.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return novoEndereco;
	}
	public boolean alterar(EnderecoVO endereco) {
		Connection conn = Banco.getConnection();
		String sql = "update endereco set logradouro=?, cep=?, uf=?, cidade=?, numero=?"
				+ "where idEndereco=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getUf());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getNumero());
			ps.setInt(6, endereco.getId());
			int linhasAfetadas = ps.executeUpdate(); //ps.executeUpdate() retorna a quantidade de linhas afetadas
			 resposta = linhasAfetadas > 0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar endereço.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from endereco where idEndereco=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			resposta = ps.executeUpdate()>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir endereço.\nErro: "+e.getMessage());
		}
		return resposta;
	}
	
	public EnderecoVO construirDoResultSet(ResultSet rs){
		EnderecoVO enderecoEncontrado = new EnderecoVO();
		
		return enderecoEncontrado;
	}
	
	public EnderecoVO buscarPorId(int id) {
		EnderecoVO enderecoEncontrado = new EnderecoVO();
		Connection conn = Banco.getConnection();
		String sql="select * from endereco where idEndereco=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				enderecoEncontrado.setId(rs.getInt("idEndereco"));
				enderecoEncontrado.setLogradouro(rs.getString("logradouro"));
				enderecoEncontrado.setCep(rs.getString("cep"));
				enderecoEncontrado.setUf(rs.getString("uf"));
				enderecoEncontrado.setCidade(rs.getString("cidade"));
				enderecoEncontrado.setNumero(rs.getString("numero"));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar endereço.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return enderecoEncontrado;
	}
	public ArrayList<EnderecoVO> buscarTodos(){
		Connection conn = Banco.getConnection();
		String sql = "select * from endereco";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		ArrayList<EnderecoVO> enderecosEnontrados = new ArrayList<EnderecoVO>();
		try {
			ps.executeQuery();
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos enderecos.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
			Banco.closeResultSet(rs);
		}
		return enderecosEnontrados;
	}
}
