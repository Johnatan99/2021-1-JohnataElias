package atividade_vacina.executavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.vo.Vacina; 
import atividade_vacina.model.vo.Pessoa;
import atividade_vacina.model.vo.Aplicacao;
import atividade_vacina.model.vo.Pesquisador;

//import atividade_vacina.model.dao.PesquisadorDAO;
import atividade_vacina.model.dao.VacinaDAO;
//import atividade_vacina.model.dao.PublicoGeralDAO;
//import atividade_vacina.model.dao.VoluntarioDAO;
import atividade_vacina.model.dao.PessoaDAO;

public class executavel {	
	public static void main(String args[]) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		ArrayList<Aplicacao> aplicacaoP1 = new ArrayList<Aplicacao>();
		ArrayList<Aplicacao> aplicacaoP2 = new ArrayList<Aplicacao>();
	
		Pessoa pessoa1 = new Pessoa("Mano", "do Corre da Silva" , LocalDate.of(1980, 8, 06) , 'M', "111.111.111-11", null);
		Pessoa pessoa2 = new Pessoa("Mano", "do Corre da Silva" , LocalDate.of(1980, 8, 06) , 'M', "111.111.111-11", null);
		
		Pesquisador pesquisador1 = new Pesquisador("Mano", "do Corre da Silva" , LocalDate.of(1980, 8, 06) , 'M', "111.111.111-11", null);

		//VacinaVO novaVacina = new VacinaVO("CoronaVac", "China", "aplicação em massa", null, null, 200, null);
		
		VacinaDAO vdao = new VacinaDAO();
		//vdao.cadastrar(novaVacina);
		//PessoaDAO pdao = new PessoaDAO();
		//pdao.cadastrar(pessoa1);
		//pdao.cadastrar(pessoa2);
		//pessoa2.setNome("ManoB");
		//pdao.alterar(pessoa2, 1);
		//pdao.excluir(l);
		//System.out.println(pdao.buscarPorId(3));
		//for(PessoaVO p : pdao.buscarTodos()) {
		//	System.out.println(pdao.buscarTodos());
		//     }
	}
}
