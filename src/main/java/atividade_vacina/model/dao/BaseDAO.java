package atividade_vacina.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface BaseDAO <T> {
	
	public T cadastrar(T novoRegistro);
	
	public boolean alterar(T geristroAlterado);
	
	public boolean excluir(int id);
	
	public T construirDoResultSet(ResultSet rs);
	
	public T buscarPorId(int id);
	
	public ArrayList<T> buscarTodos();
	
}
