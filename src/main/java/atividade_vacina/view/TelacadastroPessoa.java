package atividade_vacina.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import atividade_vacina.model.dao.AplicacaoDAO;
import atividade_vacina.model.dao.PesquisadorDAO;
import atividade_vacina.model.entity.Pesquisador;
import atividade_vacina.model.entity.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class TelacadastroPessoa {
	
	private AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
	private PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtAplicacao;
	private JTextField txtInstituicao;
	private JTextField txtIdVacinaCriada;
	private MaskFormatter formatoCpf;
	
	private MaskFormatter formatoData;
	JFormattedTextField txtDtNascimento;
	JFormattedTextField txtCpf;
	JComboBox cbSexo = new JComboBox(new String[] {" --- Selecione ---", "Feminino", "Masculindo"});
	JComboBox cbTipoPessoa = new JComboBox(new String[]{"          --- Selecine ---", "Pesquisador", "Voluntário", "Publico em Geral"});
	private JLabel lblInstituicao;
	private JLabel lblVacinaCriada;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelacadastroPessoa window = new TelacadastroPessoa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelacadastroPessoa() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cadastro Pessoa");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		frame.setBounds(100, 100, (int)d.getWidth(), (int)d.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
			public void windowActived(WindowEvent arg0) {
				txtNome.requestFocus();
			}
		});
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(184, 11, 61, 14);
		frame.getContentPane().add(lblSobrenome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(240, 73, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(10, 73, 116, 14);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblTxtcpf = new JLabel("CPF");
		lblTxtcpf.setBounds(10, 135, 46, 14);
		frame.getContentPane().add(lblTxtcpf);
		
		JLabel lblAplicao = new JLabel("Aplica\u00E7\u00E3o");
		lblAplicao.setBounds(240, 135, 46, 14);
		frame.getContentPane().add(lblAplicao);
		
		JLabel lblPessoa = new JLabel("Pessoa");
		lblPessoa.setBounds(10, 202, 46, 14);
		frame.getContentPane().add(lblPessoa);
		
		lblInstituicao = new JLabel("Intitui\u00E7\u00E3o");
		lblInstituicao.setBounds(10, 267, 61, 14);
		lblInstituicao.setVisible(false);
		frame.getContentPane().add(lblInstituicao);
		
		lblVacinaCriada = new JLabel("Vacina criada");
		lblVacinaCriada.setBounds(194, 267, 92, 14);
		lblVacinaCriada.setVisible(false);
		
		frame.getContentPane().add(lblVacinaCriada);
		
		
		//JTextField:
		
		
		cbSexo.setBounds(275, 69, 108, 22);
		frame.getContentPane().add(cbSexo);
	
		try {
			formatoData = new MaskFormatter("##/##/####");
			formatoCpf = new MaskFormatter("###.###.###-##");
			txtDtNascimento = new JFormattedTextField(formatoData);
			txtDtNascimento.setBounds(140, 70, 90, 20);
			frame.getContentPane().add(txtDtNascimento);
			txtCpf = new JFormattedTextField(formatoCpf);
			txtCpf.setBounds(58, 132, 154, 20);
			frame.getContentPane().add(txtCpf);
			formatoData.setValidCharacters("0123456789");
			formatoCpf.setValidCharacters("0123456789");
			}
			catch (ParseException pe) {
			pe.printStackTrace();
			}
		txtDtNascimento.setColumns(8);
		txtCpf.setColumns(8);
		cbTipoPessoa.setBounds(60, 198, 152, 22);
		frame.getContentPane().add(cbTipoPessoa);
		
		
		txtNome = new JTextField();
		txtNome.setBounds(58, 8, 116, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(252, 8, 131, 20);
		frame.getContentPane().add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		txtAplicacao = new JTextField();
		txtAplicacao.setBounds(297, 132, 86, 20);
		frame.getContentPane().add(txtAplicacao);
		txtAplicacao.setColumns(10);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setBounds(72, 264, 86, 20);
		txtInstituicao.setVisible(false);
		frame.getContentPane().add(txtInstituicao);
		txtInstituicao.setColumns(10);
		
		txtIdVacinaCriada = new JTextField();
		txtIdVacinaCriada.setBounds(297, 264, 86, 20);
		txtIdVacinaCriada.setVisible(false);
		frame.getContentPane().add(txtIdVacinaCriada);
		txtIdVacinaCriada.setColumns(10);
		
		cbTipoPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTipoPessoa.getSelectedItem().toString() == "Pesquisador") {
					lblInstituicao.setVisible(true);
					lblVacinaCriada.setVisible(true);
					txtInstituicao.setVisible(true);
					txtIdVacinaCriada.setVisible(true);
				} else {
					lblInstituicao.setVisible(false);
					lblVacinaCriada.setVisible(false);
					txtInstituicao.setVisible(false);
					txtIdVacinaCriada.setVisible(false);
				}
			}
		});
		JButton btnSalvar = new JButton("Salvar");	
		btnSalvar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoData.getMask());
					LocalDate dtNascimento = LocalDate.parse(txtDtNascimento.getText(), formatter);
					Pesquisador pesquisador = new Pesquisador(txtNome.getText(), txtSobrenome.getText(), dtNascimento, cbSexo.getSelectedItem().toString(), txtCpf.getText(), aplicacaoDAO.buscarPorId(Integer.parseInt(txtAplicacao.getText())), txtInstituicao.getText(), Integer.parseInt(txtIdVacinaCriada.getText()));
					pesquisadorDAO.cadastrar(pesquisador);
					JOptionPane.showMessageDialog(null, null);
				
			}
		});
		btnSalvar.setBounds(58, 323, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
	}
	
	
}
