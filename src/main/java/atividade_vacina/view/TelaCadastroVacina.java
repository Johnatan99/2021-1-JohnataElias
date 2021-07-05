package atividade_vacina.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import atividade_vacina.model.dao.VacinaDAO;
import atividade_vacina.model.entity.PublicoGeral;
import atividade_vacina.model.entity.Vacina;
import atividade_vacina.util.Listas;
import java.awt.Panel;
import net.miginfocom.swing.MigLayout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroVacina {
	
	
	
	MaskFormatter formater = new MaskFormatter();
	private VacinaDAO vDAO = new VacinaDAO();
	private JPanel contentPane;
	private JFrame frame = new JFrame();
	private JTextField txtNome;
	private JComboBox cbPaisOrigem;
	private JComboBox cbEstagioPesquisa;
	
	private JFormattedTextField txtDtInicioPesquisa;
	private JFormattedTextField txtDtTerminoPesquisa;
	private MaskFormatter formatoData;
	
	private JTextField txtDoses;
	private JTextField txtIdCriador;
	
	private Listas listaDePaises = new Listas();
	private JTextField txtIdPesquisador;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					TelaCadastroVacina window = new TelaCadastroVacina();
					window.frame.setVisible(true);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	public TelaCadastroVacina() {
		initialize();
	}
	
	public void initialize() {
		
		Toolkit tk =  Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		frame.setTitle("Menu principal");
		
		frame.setBounds(100, 100, (int)d.getWidth(), (int)d.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBounds(5, 5, 15, 15);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg) {
				txtNome.requestFocus();
			}
		});
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setColumns(10);
		
		JLabel jlPaisOrigem = new JLabel("País de Origem");
		jlPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cbPaisOrigem = new JComboBox(listaDePaises.ListarPaises());
		cbPaisOrigem.setModel(new DefaultComboBoxModel(new String[] {" --- Selecione --- ", "Alb\u00E2nia", "Alemanha", "Andorra", "Angola", "Anguilla", "Ant\u00E1rtida", "Ant\u00EDgua e Barbuda", "Antilhas Holandesas", "Ar\u00E1bia Saudita", "Arg\u00E9lia", "Argentina", "Arm\u00EAnia", "Aruba", "Austr\u00E1lia", "\u00C1ustria", "Azerbaij\u00E3o", "Bahamas", "Bahrein", "Bangladesh", "Barbados", "Belarus", "B\u00E9lgica", "Belize", "Benin", "Bermudas", "Bol\u00EDvia", "B\u00F3snia-Herzeg\u00F3vina", "Botsuana", "Brasil", "Brunei", "Bulg\u00E1ria", "Burkina Fasso", "Burundi", "But\u00E3o", "Cabo Verde", "Camar\u00F5es", "Camboja", "Canad\u00E1", "Cazaquist\u00E3o", "Chade", "Chile", "China", "Chipre", "Cingapura", "Col\u00F4mbia", "Congo", "Cor\u00E9ia do Norte", "Cor\u00E9ia do Sul", "Costa do Marfim", "Costa Rica", "Cro\u00E1cia (Hrvatska)", "Cuba", "Dinamarca", "Djibuti", "Dominica", "Egito", "El Salvador", "Emirados \u00C1rabes Unidos", "Equador", "Eritr\u00E9ia", "Eslov\u00E1quia", "Eslov\u00EAnia", "Espanha", "Estados Unidos", "Est\u00F4nia", "Eti\u00F3pia", "Fiji", "Filipinas", "Finl\u00E2ndia", "Fran\u00E7a", "Gab\u00E3o", "G\u00E2mbia", "Gana", "Ge\u00F3rgia", "Gibraltar", "Gr\u00E3-Bretanha (Reino Unido, UK)", "Granada", "Gr\u00E9cia", "Groel\u00E2ndia", "Guadalupe", "Guam (Territ\u00F3rio dos Estados Unidos)", "Guatemala", "Guernsey", "Guiana", "Guiana Francesa", "Guin\u00E9", "Guin\u00E9 Equatorial", "Guin\u00E9-Bissau", "Haiti", "Holanda", "Honduras", "Hong Kong", "Hungria", "I\u00EAmen", "Ilha Bouvet (Territ\u00F3rio da Noruega)", "Ilha do Homem", "Ilha Natal", "Ilha Pitcairn", "Ilha Reuni\u00E3o", "Ilhas Aland", "Ilhas Cayman", "Ilhas Cocos", "Ilhas Comores", "Ilhas Cook", "Ilhas Faroes", "Ilhas Falkland (Malvinas)", "Ilhas Ge\u00F3rgia do Sul e Sandwich do Sul", "Ilhas Heard e McDonald (Territ\u00F3rio da Austr\u00E1lia)", "Ilhas Marianas do Norte", "Ilhas Marshall", "Ilhas Menores dos Estados Unidos", "Ilhas Norfolk", "Ilhas Seychelles", "Ilhas Solom\u00E3o", "Ilhas Svalbard e Jan Mayen", "Ilhas Tokelau", "Ilhas Turks e Caicos", "Ilhas Virgens (Estados Unidos)", "Ilhas Virgens (Inglaterra)", "Ilhas Wallis e Futuna", "\u00EDndia", "Indon\u00E9sia", "Iraque", "Irlanda", "Isl\u00E2ndia", "Israel", "It\u00E1lia", "Jamaica", "Jap\u00E3o", "Jersey", "Jord\u00E2nia", "K\u00EAnia", "Kiribati", "Kuait", "Laos", "L\u00E1tvia", "Lesoto", "L\u00EDbano", "Lib\u00E9ria", "L\u00EDbia", "Liechtenstein", "Litu\u00E2nia", "Luxemburgo", "Macau", "Maced\u00F4nia (Rep\u00FAblica Yugoslava)", "Madagascar", "Mal\u00E1sia", "Malaui", "Maldivas", "Mali", "Malta", "Marrocos", "Martinica", "Maur\u00EDcio", "Maurit\u00E2nia", "Mayotte", "M\u00E9xico", "Micron\u00E9sia", "Mo\u00E7ambique", "Moldova", "M\u00F4naco", "Mong\u00F3lia", "Montenegro", "Montserrat", "Myanma", "Nam\u00EDbia", "Nauru", "Nepal", "Nicar\u00E1gua", "N\u00EDger", "Nig\u00E9ria", "Niue", "Noruega", "Nova Caled\u00F4nia", "Nova Zel\u00E2ndia", "Om\u00E3", "Palau", "Panam\u00E1", "Papua-Nova Guin\u00E9", "Paquist\u00E3o", "Paraguai", "Peru", "Polin\u00E9sia Francesa", "Pol\u00F4nia", "Porto Rico", "Portugal", "Qatar", "Quirguist\u00E3o", "Rep\u00FAblica Centro-Africana", "Rep\u00FAblica Democr\u00E1tica do Congo", "Rep\u00FAblica Dominicana", "Rep\u00FAblica Tcheca", "Rom\u00EAnia", "Ruanda", "R\u00FAssia (antiga URSS) - Federa\u00E7\u00E3o Russa", "Saara Ocidental", "Saint Vincente e Granadinas", "Samoa Americana", "Samoa Ocidental", "San Marino", "Santa Helena", "Santa L\u00FAcia", "S\u00E3o Bartolomeu", "S\u00E3o Crist\u00F3v\u00E3o e N\u00E9vis", "S\u00E3o Martim", "S\u00E3o Tom\u00E9 e Pr\u00EDncipe", "Senegal", "Serra Leoa", "S\u00E9rvia", "S\u00EDria", "Som\u00E1lia", "Sri Lanka", "St. Pierre and Miquelon", "Suazil\u00E2ndia", "Sud\u00E3o", "Su\u00E9cia", "Su\u00ED\u00E7a", "Suriname", "Tadjiquist\u00E3o", "Tail\u00E2ndia", "Taiwan", "Tanz\u00E2nia", "Territ\u00F3rios do Sul da Fran\u00E7a", "Territ\u00F3rios Palestinos Ocupados", "Timor Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tun\u00EDsia", "Turcomenist\u00E3o", "Turquia", "Tuvalu", "Ucr\u00E2nia", "Uganda", "Uzbequist\u00E3o", "Vanuatu", "Vaticano", "Venezuela", "Vietn\u00E3", "Z\u00E2mbia", "Zimb\u00E1bue"}));
		cbPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel jlEstagioPesquisa = new JLabel("Estágio da Pesquisa");
		jlEstagioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlEstagioPesquisa.setVerticalAlignment(SwingConstants.TOP);
		cbEstagioPesquisa = new JComboBox(new String[] {"---Selecione---", "Inicio", "Testes", "Aplicação em Massa"});
		cbEstagioPesquisa.setModel(new DefaultComboBoxModel(new String[] {" --- Selecione --- ", "In\u00EDcio", "Teste", "Aplica\u00E7\u00E3o em Massa"}));
		cbEstagioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel jlDtInicioPesquisa = new JLabel("Data de início da Pesquisa");
		jlDtInicioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel jlDtTerminoPesquisa = new JLabel("Data de término da Pesquisa");
		jlDtTerminoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel jlDoses = new JLabel("Doses");
		jlDoses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel jlPesquisador = new JLabel("ID do Pesquisador");
		jlPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		try {
		formatoData = new MaskFormatter("##/##/####");
		txtDtInicioPesquisa = new JFormattedTextField(formatoData);
		txtDtInicioPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDtTerminoPesquisa = new JFormattedTextField(formatoData);
		txtDtTerminoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formatoData.setValidCharacters("0123456789");
		}
		catch (ParseException pe) {
		pe.printStackTrace();
		}
		txtDtInicioPesquisa.setColumns(8);
		txtDtTerminoPesquisa.setColumns(8);
		

		txtIdPesquisador = new JTextField();
		txtIdPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdPesquisador.setColumns(10);
		txtDoses = new JTextField();
		txtDoses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDoses.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				salvarVacina();
			}
			private void salvarVacina() {						
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formater.getMask());
				LocalDate dtInicioFormatada =  LocalDate.parse(txtDtInicioPesquisa.getText(), formatter);
				LocalDate dtTerminoFormatada = LocalDate.parse(txtDtTerminoPesquisa.getText(), formatter);
				Vacina novaVacina = new Vacina(txtNome.getText(), cbPaisOrigem.getSelectedItem().toString(), cbEstagioPesquisa.getSelectedItem().toString(), dtInicioFormatada, dtTerminoFormatada, Integer.parseInt(txtDoses.getText()), Integer.parseInt(txtIdPesquisador.getText()));
				vDAO.cadastrar(novaVacina);
			}
		});	
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jlDoses)
					.addGap(18)
					.addComponent(txtDoses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1134, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
					.addGap(533))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jlDtTerminoPesquisa, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDtTerminoPesquisa, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(jlEstagioPesquisa, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(cbEstagioPesquisa, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(jlPesquisador, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtIdPesquisador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNome)
								.addGap(17)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(jlPaisOrigem)
									.addGap(18)
									.addComponent(cbPaisOrigem, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(jlDtInicioPesquisa)
									.addGap(18)
									.addComponent(txtDtInicioPesquisa, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(954, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPaisOrigem, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbPaisOrigem, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDtInicioPesquisa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDtInicioPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDtTerminoPesquisa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDtTerminoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPesquisador, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdPesquisador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlDoses, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDoses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEstagioPesquisa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbEstagioPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(83))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}






























