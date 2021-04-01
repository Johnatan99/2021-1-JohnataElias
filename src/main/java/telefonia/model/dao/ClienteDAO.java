package telefonia.model.dao;
// java.sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// java.uti
import java.util.ArrayList;
import java.util.List;
// Banco
import atividade_vacina.model.dao.Banco;

// java.time
import java.time.LocalDate;
// classes
import telefonia.model.vo.ClienteVO;
import telefonia.model.vo.TelefoneVO;
import telefonia.model.vo.EnderecoVO;
import telefonia.model.dao.TelefoneDAO;

public class ClienteDAO implements BaseDAO<ClienteVO>{
	private TelefoneVO telefones = new TelefoneVO();
	private EnderecoVO endereco = new EnderecoVO();
	public ClienteVO cadastrar(ClienteVO novoCliente) {
		Connection conn = Banco.getConnection();
		String sql = "insert into cliente(nome, cpf, fkIdTelefone, fkIdEndereco, ativo) values(?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, novoCliente.getNome());
			ps.setString(2, novoCliente.getCpf());
			ps.setInt(3, novoCliente.getEndereco().getId());
			ps.setBoolean(4, true);
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				novoCliente.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao cadastrar novo Cliente.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoCliente;
	}
	public boolean alterar(ClienteVO clienteAlterado) {
		Connection conn = Banco.getConnection();
		String sql = "update cliente set nome=?, cpf=?, fkidEndereco=?, ativo=?"
				+ "where idCliente=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setString(1, clienteAlterado.getNome());
			ps.setString(2, clienteAlterado.getCpf());
			ps.setInt(4, clienteAlterado.getEndereco().getId());
			ps.setBoolean(5, clienteAlterado.isAtivo());
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao alterar registro do Cliente.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from cliente where idCliente=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean resposta = false;
		try {
			ps.setInt(1, id);
			int numLinhasAlteradas = ps.executeUpdate();
			resposta = numLinhasAlteradas>0;
		} catch(SQLException e) {
			System.out.println("Erro ao excluir registro do Cliente de id = "+id+".\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return resposta;
	}
	public ClienteVO construirDoResultSet(ResultSet rs) {
		ClienteVO cliente = new  ClienteVO(); 
		try {
			cliente.setNome(rs.getString("nome"));
			cliente.setCpf(rs.getString("cpf"));	
			TelefoneDAO tDAO = new TelefoneDAO();
			ArrayList<TelefoneVO> telefones =  tDAO.buscarPorIdCliente(cliente.getId());
			cliente.setTelefones(telefones);
			EnderecoDAO eDAO = new EnderecoDAO();
			EnderecoVO enderecoC =  eDAO.buscarPorId(endereco.getId());
			cliente.setEndereco(enderecoC);		
			cliente.setAtivo(rs.getBoolean("ativo"));
			
		} catch(SQLException e) {
			System.out.println("Erro ao construir Cliente do ResultSet.\nErro: "+e.getMessage());
		}
		return cliente;
	}
	public ClienteVO buscarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = "select * from cliente where idCliente=?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		ClienteVO clienteEncontrado = new ClienteVO();
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				clienteEncontrado = construirDoResultSet(rs);
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar registro de Cliente de id = "+id+".\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return clienteEncontrado;
	}
	public ArrayList<ClienteVO> buscarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "select * from cliente";
		PreparedStatement ps = Banco.getPreparedStatementWithPk(conn, sql);
		ArrayList<ClienteVO> clientesEncontrados = new ArrayList<ClienteVO>();
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				clientesEncontrados.add(construirDoResultSet(rs));
			}
		} catch(SQLException e) {
			System.out.println("Erro ao buscar todos registros de Clientes.\nErro: "+e.getMessage());
		} finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return clientesEncontrados;
	}
}
