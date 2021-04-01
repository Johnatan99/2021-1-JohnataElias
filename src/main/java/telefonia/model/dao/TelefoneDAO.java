package telefonia.model.dao;
//java.sql:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//java.util:
import java.util.ArrayList;
import java.util.List;
//Banco:
import atividade_vacina.model.dao.Banco;
import telefonia.model.vo.ClienteVO;
import telefonia.model.vo.EnderecoVO;
//Classes:
import telefonia.model.vo.TelefoneVO;

public class TelefoneDAO implements BaseDAO<TelefoneVO> {

	public static final int CODIGO_TELEFONE_SEM_CLIENTE = 0;
	
	public TelefoneVO cadastrar(TelefoneVO novoTelefone) {
		Connection conn = Banco.getConnection();
		String sql="insert into telefone (codigoInternacional, ddd, numero, idCliente, movel, ativo) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		try {
			ps.setString(1, novoTelefone.getCodigoInternacional());
			ps.setString(2, novoTelefone.getDdd());
			ps.setString(3, novoTelefone.getNumero());
			if(novoTelefone.getIdCliente() == null) {
				ps.setInt(4, CODIGO_TELEFONE_SEM_CLIENTE);
				ps.setBoolean(6, true);
			}else {
				ps.setInt(4,  novoTelefone.getIdCliente());
				ps.setBoolean(6, false);
			}
			ps.setBoolean(5, novoTelefone.isMovel());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoTelefone.setId(rs.getInt(1));
			}	
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Telefone.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoTelefone;
	}
	public boolean alterar(TelefoneVO telefoneAlterado) {
		Connection conn = Banco.getConnection();
		String sql="update telefone set codigoInternacional=, ddd=?, numero=?, idCliente=?, movel=?, ativo=? where idTelefone=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		boolean resposta = false;
		try {
			ps.setString(1, telefoneAlterado.getCodigoInternacional());
			ps.setString(2, telefoneAlterado.getDdd());
			ps.setString(3, telefoneAlterado.getNumero());
			ps.setInt(4, telefoneAlterado.getIdCliente());
			ps.setBoolean(5, telefoneAlterado.isMovel());
			ps.setBoolean(6, telefoneAlterado.isAtivo());
			ps.setInt(7, telefoneAlterado.getId());
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro do Telefone.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql="delete from telefone where idTelefone=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			ps.executeUpdate();
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro do Telefone.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public TelefoneVO construirDoResultSet(ResultSet rs) {
		TelefoneVO telefone = new  TelefoneVO();
		try {
			telefone.setId(rs.getInt("idTelefone"));
			telefone.setCodigoInternacional(rs.getString("codigoInternacional"));
			telefone.setDdd(rs.getString("ddd"));
			telefone.setNumero(rs.getString("numero"));
			telefone.setIdCliente(rs.getInt("idCliente"));
			telefone.setAtivo(rs.getBoolean("ativo"));
			telefone.setMovel(rs.getBoolean("movel"));
		} catch(SQLException e) {
			System.out.println("Erro ao construir Telefone do ResultSet.\nErro: "+e.getMessage());
		}
		return telefone;
	}

	public TelefoneVO buscarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql="select * from telefone where idTelefone=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		TelefoneVO telefoneEncontrado = new TelefoneVO();
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				telefoneEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar por registro do Telefone de id = "+id+".\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return telefoneEncontrado;
	}
	public ArrayList<TelefoneVO> buscarTodos() {
		Connection conn = Banco.getConnection();
		String sql="select * from telefone where idTelefone=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ArrayList<TelefoneVO> telefonesEncontrados = new ArrayList<TelefoneVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				telefonesEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros dos Telefones.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return telefonesEncontrados;
	}
	public ArrayList<TelefoneVO> buscarPorIdCliente(int id) {
		Connection conn = Banco.getConnection();
		String sql="select * from telefone where idCliente=?";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ArrayList<TelefoneVO> telefonesEncontrados = new ArrayList<TelefoneVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				telefonesEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registros de Telefones do Cliente de id = "+id+".\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return telefonesEncontrados;
	}	
	
	public boolean numeroEstaDisponivel(TelefoneVO novoTelefone) {
		Connection conn = Banco.getConnection();
		String sql= "select count(idTelefone) from telefone"
				+ "where ddd = ? \n"
				+ "and numero = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean numeroDisponivel = false;
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				numeroDisponivel = rs.getInt(0) == 0;
			}
			ps.setString(1, novoTelefone.getDdd());
			ps.setString(2, novoTelefone.getNumero());
		} catch(SQLException e) {
			System.out.println("Erro ao verificar disponibilidade de ddd e número.\nErro: "+e.getMessage());
		} finally {
			
				Banco.closeConnection(conn);
				Banco.closePreparedStatement(ps);
		}
		return numeroDisponivel;
	}
}
