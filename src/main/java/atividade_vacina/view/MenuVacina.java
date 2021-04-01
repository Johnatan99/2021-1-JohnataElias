package atividade_vacina.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.util.StringUtil;

public class MenuVacina {
	
	public static final int OPCAO_CADASTRAR_VACINA = 1;
	public static final int OPCAO_EXCLUIR_VACINA = 2;
	public static final int OPCAO_BUSCAR_VACINA_POR_ID = 3;
	public static final int OPCAO_LISTAR_TODAS_VACINAS = 4;
	public static final int OPCAO_MENU_VACINA_VOLTAR = 5;
	
	public int apresentarOpcoesMenuVacina() {
		String titulo = "Menu Vacina";
		String mensagem = "Selecione uma opção:";
		mensagem += "1 - Dacastrar Vacina";
		mensagem += "2 - Excluir Vacina";
		mensagem += "3 - Buscar Vacina";
		mensagem += "4 - Listar todas Vacinas";
		mensagem += "5 - Voltar";
		String valorInformado = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
		int opcaoSelecionada = Integer.parseInt(valorInformado);
		try {
			opcaoSelecionada = Integer.parseInt(valorInformado);
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "ERRO", "O valor deve ser numérico", JOptionPane.ERROR_MESSAGE);
			this.apresentarOpcoesMenuVacina();
		}
		return opcaoSelecionada;
	}
	
	private void MenuVacina() {
		int opcao =  this.apresentarOpcoesMenuVacina();
		while(opcao != OPCAO_MENU_VACINA_VOLTAR) {
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
				default: {
					
					JOptionPane.showMessageDialog(null, "Opção inválida");
				}
			}
		}
	}
	private void cadastrarVacina() {
		
	}
	private void excluirVacina() {
		
	}
	private void buscarVacinaPorId() {
		
	}
	private void listarTodasVacinas() {
		
	}
	
	

}
