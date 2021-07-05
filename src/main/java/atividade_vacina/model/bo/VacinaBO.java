package atividade_vacina.model.bo;

import java.util.ArrayList;

import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.entity.Vacina;

public class VacinaBO{
	
	VacinaDAO vDAO = new VacinaDAO();
	
	public Vacina cadastrar(Vacina novaVacina) {
		
		return vDAO.cadastrar(novaVacina);
	}
	
	public boolean alterar(Vacina vacinaAlterada) {
		
		return vDAO.alterar(vacinaAlterada);
	}
	public boolean excluir(int id) {
		
		return vDAO.excluir(id);
	}
	
	public Vacina buscarPorId(int id) {
		
		return vDAO.buscarPorId(id);
	}
	
	
	public ArrayList<Vacina> buscarTodos(){
		
		return vDAO.buscarTodos();
	}
	
}
