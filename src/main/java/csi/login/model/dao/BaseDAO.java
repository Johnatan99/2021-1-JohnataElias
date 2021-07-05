package csi.login.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface BaseDAO <L>{
	
	public L cadastrar(L novoRegistro);
	
	public boolean alterar(L registroAlterado);
	
	public boolean excluir(Integer idUsuario);
	
	public L buscarPorId(Integer idUsuario);
	
	public ArrayList<L> buscarTodos();
}
