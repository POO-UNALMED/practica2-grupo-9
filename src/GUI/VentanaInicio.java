package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import java.awt.TextArea;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.TextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;

public class VentanaInicio extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setTitle("Tu Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setToolTipText("INICIO");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("INICIO");
		mnNewMenu.setVerticalAlignment(SwingConstants.TOP);
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("DESCRIPCION");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("SALIR");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(1, 1));
		
		JPanel P1 = new JPanel();
		contentPane.add(P1, BorderLayout.WEST);
		P1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel P3 = new JPanel();
		P1.add(P3);
		
		TextArea textArea = new TextArea();
		textArea.setRows(5);
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setColumns(30);
		textArea.setText("Bienvenido al programa");
		textArea.setEditable(false);
		P3.add(textArea);
		
		JPanel P4 = new JPanel();
		P1.add(P4);
		P4.setLayout(new CardLayout(0, 0));
		
		JButton VentanaPrincipal = new JButton("INICIO");
		VentanaPrincipal.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		VentanaPrincipal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		P4.add(VentanaPrincipal, "name_3823311636200");
		
		JPanel P2 = new JPanel();
		contentPane.add(P2, BorderLayout.EAST);
		P2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel P5 = new JPanel();
		P2.add(P5);
		
		JTextPane txtpnMostrarProgramadores = new JTextPane();
		txtpnMostrarProgramadores.setText("Mostrar Programadores");
		txtpnMostrarProgramadores.setEditable(false);
		P5.add(txtpnMostrarProgramadores);
		
		JPanel P6 = new JPanel();
		P2.add(P6);
		
		JTextPane txtpnMostrarFotosDe = new JTextPane();
		txtpnMostrarFotosDe.setText("Mostrar Fotos de Programadores");
		P6.add(txtpnMostrarFotosDe);
	}

}
