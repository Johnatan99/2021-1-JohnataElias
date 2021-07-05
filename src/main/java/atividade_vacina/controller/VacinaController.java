package atividade_vacina.controller;

import java.util.ArrayList;

import atividade_vacina.model.bo.VacinaBO;
import atividade_vacina.model.entity.Vacina;

public class VacinaController {
	private VacinaBO vBO = new VacinaBO();
	
	public Vacina cadastrar(Vacina novaVacina) {
		
		return vBO.cadastrar(novaVacina);
	}
	
	public boolean alterar(Vacina vacinaAlterada) {
		
		return vBO.alterar(vacinaAlterada);
	}
	
	public boolean excluir(int id) {
		
		return vBO.excluir(id);
	}
	
	public Vacina buscarPorId(int id) {
		
		return vBO.buscarPorId(id);
	}
	
	public ArrayList<Vacina> buscarTodos(){
		
		return vBO.buscarTodos();
	}
}
