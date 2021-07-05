package atividade_vacina.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.util.StringUtil;

import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.entity.Vacina;

public class MenuVacina {
	
	public static final int OPCAO_CADASTRAR_VACINA = 1;
	public static final int OPCAO_EXCLUIR_VACINA = 2;
	public static final int OPCAO_BUSCAR_VACINA_POR_ID = 3;
	public static final int OPCAO_LISTAR_TODAS_VACINAS = 4;
	public static final int OPCAO_MENU_VACINA_SAIR = 5;
	
	public int apresentarOpcoesMenuVacina() {
		String titulo = "Menu Vacina";
		String mensagem = "Selecione uma opção:\n";
		mensagem += "1 - Cacastrar Vacina\n";
		mensagem += "2 - Excluir Vacina\n";
		mensagem += "3 - Buscar Vacina\n";
		mensagem += "4 - Listar todas Vacinas\n";
		mensagem += "5 - Sair\n";
		int opcaoSelecionada = 0;
		try {
			 opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE));
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Erro", "O valor deve ser numérico", JOptionPane.ERROR_MESSAGE);
			this.apresentarOpcoesMenuVacina();
		}
		if(opcaoSelecionada == 5) {
			 System.exit(1);
		 }
		return opcaoSelecionada;
	}
	
	public void MenuVacina() {
		int opcao =  this.apresentarOpcoesMenuVacina();
			switch(opcao) {
				case OPCAO_CADASTRAR_VACINA:{
					this.cadastrarVacina();
					break;
				} 
				case OPCAO_EXCLUIR_VACINA:{
					this.excluirVacina();
					break;
				}
				case OPCAO_BUSCAR_VACINA_POR_ID:{
					this.buscarVacinaPorId();
					break;
				}
				case OPCAO_LISTAR_TODAS_VACINAS:{
					this.listarTodasVacinas();
					break;
				}
				case OPCAO_MENU_VACINA_SAIR:{
					System.exit(1);
					break;
				}
				default: {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}
			}
	}
	public void cadastrarVacina() {
		Vacina vacina = new Vacina();
		String nomeInformado = JOptionPane.showInputDialog(null, "Informe o nome da vacina: ", JOptionPane.QUESTION_MESSAGE);
		vacina.setNomeVacina(nomeInformado);
		String paisInformado = JOptionPane.showInputDialog(null, "Informe o país de origem da vacina:");
		vacina.setPaisOrigem(paisInformado);	
		String estagioPesquisaInformado = JOptionPane.showInputDialog(null, "Informe o estágio da pesquisa:");
		vacina.setEstagioPesquisa(estagioPesquisaInformado);
		LocalDate dtInicioInformado = LocalDate.parse(JOptionPane.showInputDialog(null, "Informe a Data de início da pesquisa:"));
		vacina.setDtInicioPesquisa(dtInicioInformado);
		LocalDate dtTerminoInformado = LocalDate.parse(JOptionPane.showInputDialog(null, "Informe a Data de término da pesquisa:"));
		vacina.setDtTerminoPesquisa(dtTerminoInformado);
		int quantidadeDosesinformadas = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de doses da vacina:"));
		vacina.setQuantidadeDoses(quantidadeDosesinformadas);
		VacinaDAO vacinaDAO =  new VacinaDAO();
		vacinaDAO.cadastrar(vacina);
		
		int resposta = JOptionPane.showConfirmDialog(null, "Desenja cadastrar mais alguma vacina?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
		if(resposta == JOptionPane.YES_OPTION) {
			this.cadastrarVacina();
			JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			int resposta2 = JOptionPane.showConfirmDialog(null, "Deseja voltar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
			if(resposta2 == JOptionPane.YES_OPTION) {
				this.apresentarOpcoesMenuVacina();
			} else {
				System.exit(1);
			}
		}
	}
	private void excluirVacina() {
		Vacina vacina = new Vacina();
		VacinaDAO vDAO = new VacinaDAO();
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código da vacina que deseja excluir:", "Excluir vacina", JOptionPane.QUESTION_MESSAGE));
		if(vDAO.excluir(id) == true) {
			JOptionPane.showMessageDialog(null, "Vacina excluída com sucesso.", "Aviso sobre ação",JOptionPane.INFORMATION_MESSAGE);
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir mais alguma vacina?", "Pergunta", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				this.excluirVacina();
			} else {
				this.apresentarOpcoesMenuVacina();
			}
		} else {
			int resposta = JOptionPane.showConfirmDialog(null, "Erro ao excluir vacina.\nDeseja tentar novamente?", "Erro", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				this.excluirVacina();
			} else {
				System.exit(1);
			}
		}
	}
	private void buscarVacinaPorId() {
		Vacina vacina = new Vacina();
		VacinaDAO vDAO = new VacinaDAO();
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o codigo da vacina:", "Buscar vacina", JOptionPane.QUESTION_MESSAGE));
		if(id <= 0) {
			int resposta = JOptionPane.showConfirmDialog(null, "Erro ao buscar vacina", "Erro", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				this.buscarVacinaPorId();
			} else {
				System.exit(1);
			}
		} else {
			JOptionPane.showMessageDialog(null, vDAO.buscarPorId(id), "Vacina encontrada", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void listarTodasVacinas() {
		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
		VacinaDAO vDAO = new VacinaDAO();
		vacinas = vDAO.buscarTodos();
		//String[] listaVacinas = vacinas.toArray(new String[0]);
		String[] lista = {"Essa", "Merda", "Não", "Vai", "Com", "Array"};
		JComboBox jcv = new JComboBox(lista);
		JOptionPane.showMessageDialog(null, jcv, "Lista de Vacinas", JOptionPane.INFORMATION_MESSAGE);
		

	}
}
