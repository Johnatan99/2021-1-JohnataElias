package telefonia.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import telefonia.controller.EnderecoController;
import telefonia.model.vo.EnderecoVO;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroEndereco extends JFrame{
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textCep;
	private JTextField textNumero;
	private JTextField textLogradouro;
	private JTextField textCidade;
	
	private JComboBox cbEstado;
	private JComboBox cbUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco frame = new TelaCadastroEndereco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		
		initialize();
		addWindowListener(new WindowAdapter() {
			public void windowActvated(WindowEvent arg) {
			}
		});
		setTitle("Cadastro de Endereço");
		getContentPane().setLayout(null);
		setBounds(100, 100, 650, 650);
		
		//CEP:
		JLabel jlCep = new JLabel("CEP");
		jlCep.setBounds(124, 21, 50, 15);
		getContentPane().add(jlCep);
		textCep = new JTextField();
		textCep.setBounds(184, 20, 70, 15);
		getContentPane().add(textCep);
		textCep.setColumns(10);
		JButton btnNewButton = new JButton("Botão");
		btnNewButton.setBounds(270, 18, 100, 20);
		getContentPane().add(btnNewButton);
		
		//Cidade:
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 50, 100, 15);
		getContentPane().add(lblCidade);
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(95, 49, 70, 15);
		getContentPane().add(textCidade);
		
		//Estado:
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 80, 100, 15);
		getContentPane().add(lblEstado);
		final JComboBox cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
				                                                 "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                                                                 "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO"}));
		cbEstado.setBounds(95, 80, 70, 22);
		getContentPane().add(cbEstado);
		
		//Número: 
		JLabel label_1 = new JLabel("Número:");
		label_1.setBounds(10, 110, 100, 15);
		getContentPane().add(label_1);
		textNumero = new JTextField();
		textNumero.setBounds(95, 114, 70, 15);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		//Logradouro:
		JLabel jlLogradouro = new JLabel("Logradouro");
		jlLogradouro.setBounds(10, 140, 100, 15);
		getContentPane().add(jlLogradouro);
		textLogradouro = new JTextField();
		textLogradouro.setColumns(10);
		textLogradouro.setBounds(95, 139, 70, 15);
		getContentPane().add(textLogradouro);
		
		//UF:
		JLabel jlUf = new JLabel("UF");
		jlUf.setBounds(10, 166, 100, 15);
		getContentPane().add(jlUf);
		
		final JComboBox cbUf = new JComboBox(new String[]{"A", "B"}) ;
		cbUf.setBounds(95, 166, 70, 22);
		getContentPane().add(cbUf);
		
		//Botom:
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(237, 198, 100, 20);
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoVO novoEndereco = new EnderecoVO();
				novoEndereco.setCep(textCep.getText());
				novoEndereco.setCidade(textNumero.getText());
				novoEndereco.setEstado(cbEstado.getSelectedItem().toString());
				novoEndereco.setNumero(textNumero.getText());
				novoEndereco.setUf(cbUf.getSelectedItem().toString());
				novoEndereco.setLogradouro(textLogradouro.getText());
				
				EnderecoController enderecoController = new EnderecoController();
				enderecoController.cadastrar(novoEndereco);
				
			}
		});
		getContentPane().add(btCadastrar);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
