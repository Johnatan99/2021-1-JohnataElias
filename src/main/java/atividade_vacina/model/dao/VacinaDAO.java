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
		String sql = "insert into(nomeVacina, paisOrigem, estagioPesquisa, dtInicioPesquisa, dtTerminoPesquisa, pesquisador) values(?, ?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection(sql);
		PreparedStatement ps = Banco.getPreparedStatement();
		ResultSet rs = Banco.getResultSet();
		VacinaVO vacina = new VacinaVO();
		PesquisadorVO pesquisador = new PesquisadorVO();
		try {
			ps.setString(1, vacina.getNomeVacina());
			ps.setString(2, vacina.getPaisOrigem());
			ps.setString(3, vacina.getEstagioPesquisa());
			ps.setDate(4,  vacina.getDtInicioPesquisa());
			ps.setDate(5,  vacina.getDtTerminoPesquisa());
			
			ps.execute();
		} catch(SQLException e){
			System.out.println("Erro ao cadastrar nova vacina"+e.getMessage());
		}
		return novaVacina;
	}
	
	public boolean excluir(Integer id) {
		String sql = "delete from vacina where id = ?";
		boolean resposta = true;
		Connection conn = new Banco.getConnection(sql);
		PreparedStatement ps = Banco.getPreparedStatement(  );
		try {
			ps.setInt(1, id);
		} catch(SQLException e) {
			System.out.println("Erro ao excluir vacina "+e.getMessage());
		}
		
		return resposta;
	}
}
