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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;

import atividade_vacina.model.dao.PublicoGeralDAO;
import atividade_vacina.model.intity.PublicoGeral;

public class MenuPrincipal extends JFrame{
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Throwable t) {
			t.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	private Dimension buscarResolucao() {
		Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((dimensao.width+5), (dimensao.height));
		
		return dimensao;
	}
	
	public MenuPrincipal() {
		setTitle("Menu principal");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, buscarResolucao().width, buscarResolucao().height); //Acompanha de acordo com as dimensões da tela;
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza;
		getContentPane().setLayout(null);
		 
		
		Container panel = getContentPane();
		
		//BoxLayout:
		//panel.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		//JButton bt1 = new JButton("Botão 1");
		//bt1.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panel.add(bt1);
		//JButton bt2 = new JButton("Botão 2");
		//bt2.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panel.add(bt2);
		//JButton bt3 = new JButton("Botão longooooooooooooooooooooo");
		//bt3.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panel.add(bt3);
		
		//BorderLayout: 
		//JButton b = new JButton("Botão 1");
		//panel.add(b, BorderLayout.PAGE_START);
		
		//b = new JButton("Button 2 (CENTER)");
		//b.setPreferredSize(new Dimension(200, 100));
		//panel.add(b, BorderLayout.CENTER);
		
		//b = new JButton("Botão 3");
		//panel.add(b, BorderLayout.LINE_START);
		
		//b = new JButton("Botão 4");
		//panel.add(b, BorderLayout.LINE_END);
		
		//b = new JButton("Botão 5");
		//panel.add(b, BorderLayout.PAGE_END);
		
		//FlowLayout:
		//panel.setLayout(new FlowLayout());
		
		//JButton b = new JButton("Botão 1");;
		//panel.add(b);
		
		//b = new JButton("Botão 2");
		//panel.add(b);
		
		//b = new JButton("Botão 3");
		//panel.add(b);
		
		//b = new JButton("Botão longooooooooo");
		//panel.add(b);
		
		//b = new JButton("1");
		//panel.add(b);
		
		JButton b1, b2, b3, b4; Dimension size;
		b1 = new JButton("Vacina"); panel.add(b1);
		b2 = new JButton("Pesquisador"); panel.add(b2);
		b3 = new JButton("Voluntário"); panel.add(b3);
		b4 = new JButton("Publico em geral"); panel.add(b4);
		
		Insets insets = panel.getInsets();
		
		double centroD = buscarResolucao().getSize().getWidth()/2;
		int centro = (int) centroD;
		
		size = b1.getPreferredSize();
		b1.setLocation((centro+(size.height/2)), 100+insets.top);
		b1.setSize(size.width, size.height);
		
		size = b2.getPreferredSize();
		b2.setLocation((centro+(size.height/2)), 200+insets.top);
		b2.setSize(size.width, size.height);
		
		size = b3.getPreferredSize();
		b3.setLocation((centro+(size.height/2)), 300+insets.top);
		b3.setSize(size.width, size.height);
		
		Insets insets2 = getInsets();
	}
	
}































