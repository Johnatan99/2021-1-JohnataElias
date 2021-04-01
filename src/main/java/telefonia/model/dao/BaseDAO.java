package telefonia.model.dao;
//java.sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//java.util
import java.util.ArrayList;
import java.util.List;
//Banco
import atividade_vacina.model.dao.Banco;

public interface BaseDAO <T>{
	
	public T cadastrar(T novoRegistro);
	
	public boolean alterar(T registroAlterado);
	
	public boolean excluir(int id);
	
	public T construirDoResultSet(ResultSet rs);
	
	public T buscarPorId(int id);
	
	public ArrayList<T> buscarTodos();
}
