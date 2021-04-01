package atividade_vacina.executavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.dao.PessoaDAO;
import atividade_vacina.model.dao.AplicacaoDAO;
import atividade_vacina.model.dao.PesquisadorDAO;
import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.dao.PublicoGeralDAO;
import atividade_vacina.model.dao.VoluntarioDAO;
import atividade_vacina.model.intity.Aplicacao;
import atividade_vacina.model.intity.Pesquisador;
import atividade_vacina.model.intity.Pessoa;
import atividade_vacina.model.intity.PublicoGeral;
import atividade_vacina.model.intity.Vacina;
import atividade_vacina.model.intity.Voluntario;
import atividade_vacina.model.dao.VoluntarioDAO;
import atividade_vacina.model.dao.PublicoGeralDAO;


public class executavel {	
	public static void main(String args[]) {
		
		Pesquisador pesquisador = new Pesquisador();
		Voluntario voluntario = new Voluntario();
		PublicoGeral pg = new PublicoGeral();
		
		PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
		VoluntarioDAO voluntarioDAO = new VoluntarioDAO();
		PublicoGeralDAO pgDAO = new PublicoGeralDAO();
		
		//Criando Vacinas:
		VacinaDAO vacinaDAO = new VacinaDAO();
		Vacina vacina1 = new Vacina("Sputinic", "Desconhecido", "Final", LocalDate.of(2019, 8, 9), LocalDate.of(2021, 8, 9), 100);
		Vacina vacina2 = new Vacina("Coca", "China", "Finaç", LocalDate.of(2019, 8, 9), LocalDate.of(2021, 2, 5), 100);
		//vacinaDAO.cadastrar(vacina1);
		//vacinaDAO.cadastrar(vacina2);
		//Criando Aplicações:
		AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
		Aplicacao aplicacao1 = new Aplicacao(vacina1, LocalDate.of(2021, 3, 4), "Bom");
		Aplicacao aplicacao2 = new Aplicacao(vacina1, LocalDate.of(2021, 3, 4), "Ruim");
		Aplicacao aplicacao3 = new Aplicacao(vacina2, LocalDate.of(2021, 3, 10), "Ótimo");
		Aplicacao aplicacao4 = new Aplicacao(vacina2, LocalDate.of(2021, 3, 10), "Ruim");
		//aplicacaoDAO.cadastrar(aplicacao1);
		//aplicacaoDAO.cadastrar(aplicacao2);
		//aplicacaoDAO.cadastrar(aplicacao3);
		//aplicacaoDAO.cadastrar(aplicacao4);
		//Criando Pessoas: 
		//Criando Pesquisador:
		Pesquisador pesquisador1 = new Pesquisador("Tio", "do Corre", LocalDate.of(1975, 4, 3), 'M', "000.000.000-00", "Pesquisador", aplicacao1 ,"Naum sei", vacina1);
		//pesquisadorDAO.cadastrar(pesquisador1);
		// Criando Voluntario:
		
		//Criando Publico geral:

		//pesquisador1.setNome("Mano");
		//pesquisador1.setSobrenome("do Furto");
		//pesquisador1.setInstituicao("Butatan");
		//pesquisadorDAO.alterar(pesquisador1);
	}
}
