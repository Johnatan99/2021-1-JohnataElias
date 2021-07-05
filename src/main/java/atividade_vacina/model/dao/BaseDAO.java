package atividade_vacina.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface BaseDAO <T> {
	

	

	
	public boolean excluir(int id);
	
	
	public T buscarPorId(int id);
	
	public ArrayList<T> buscarTodos();
	
}
