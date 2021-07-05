package csi.login.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import csi.login.controller.LoginController;
import csi.login.exceptions.login_exception.ValidarCamposLogin;
import csi.login.model.vo.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class TelaLogin extends JFrame{
	
	//Variáveis globais:
	private JTextField txtUsuario;
	private JPasswordField txtSenhaAntiga;
	private JPasswordField txtSenhaAtual;
	private JPasswordField txtRepetirSenha;
	private JPasswordField txtNovaSenha;
	private JTextPane txtRecuperacaoSenha;
	private static String opcoes[] = {"Sim", "Não"};
	private int resposta;
	
	private LoginController lController = new LoginController();
	
	//Inicia a aplicação:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch(Exception ex) {
					System.out.println("Erro ao iniciar a aplicação.\nErro: "+ex.getMessage());
				}
			}
		});
	}
	
	public TelaLogin() {
		setBackground(Color.BLACK);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(26, 0, 0, 0));
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		contentPane.setPreferredSize(new Dimension(400, 300));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(130, 0, 217, 361);
		
		contentPane.add(panel);
		txtUsuario = new JTextField();
		
		JLabel jlUsuario = new JLabel("Usuário");
		txtSenhaAtual = new JPasswordField();
		txtRepetirSenha = new JPasswordField();
		txtRepetirSenha.setVisible(true);
		
		JLabel jlRepetirSenha = new JLabel("Repita a senha");
		jlRepetirSenha.setVisible(true);
		
		JLabel lblSenhaAtual = new JLabel("Senha");
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				try {
					cadastrar();
				} catch(ValidarCamposLogin e1) {
					resposta = JOptionPane.showOptionDialog(null, e1+"Deseja editar as informações?", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				}
			}
		});
		
		JLabel lblEsqueceuSuaSenha = new JLabel("Esqueceu sua senha?");
		
		txtRecuperacaoSenha = new JTextPane();
		
		JLabel lblPalavraChavePara = new JLabel("Palavra chave para recupera\u00E7\u00E3o de senha");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRecuperacaoSenha, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(jlRepetirSenha, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblSenhaAtual, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addComponent(jlUsuario, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtSenhaAtual, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtRepetirSenha, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
							.addComponent(btnCadastrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEsqueceuSuaSenha)
						.addComponent(btnAcessar, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
						.addComponent(lblPalavraChavePara, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(jlUsuario, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSenhaAtual, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSenhaAtual, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlRepetirSenha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRepetirSenha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblPalavraChavePara)
					.addGap(13)
					.addComponent(txtRecuperacaoSenha, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAcessar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEsqueceuSuaSenha)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
	
	public boolean verificarSeSenhasCoincidem() {
		boolean resposta = false;
		char getPass1[]; 
		char getPass2[];
		getPass1 = txtSenhaAtual.getPassword(); 
		getPass2 = txtSenhaAtual.getPassword();
		String senha1 = String.copyValueOf(getPass1);
		String senha2 = String.copyValueOf(getPass2);
		if(senha1==senha2) {
			resposta = true;
		}
		return resposta;
	}
	public void cadastrar() throws ValidarCamposLogin {
		Login login = new Login();
		login.setUsuario(txtUsuario.getText().toString());
		
		login.setSenhaAtual(txtSenhaAtual.getPassword().toString());
		login.setSenhaAntiga("");
		login.setRecuperacaoSenha(txtRecuperacaoSenha.getText().toString());
		lController.cadastrar(login);
	}
}































