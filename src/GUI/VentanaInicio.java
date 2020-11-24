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
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 519, 400);
		
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
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel P1 = new JPanel();
		P1.setBounds(5, 5, 251, 324);
		contentPane.add(P1);
		P1.setLayout(null);
		
		JPanel P3 = new JPanel();
		P3.setBounds(0, 0, 251, 125);
		P1.add(P3);
		P3.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 0, 251, 125);
		textArea.setRows(5);
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setColumns(30);
		textArea.setText("Bienvenido al programa");
		textArea.setEditable(false);
		P3.add(textArea);
		
		JPanel P4 = new JPanel();
		P4.setBounds(0, 124, 251, 200);
		P1.add(P4);
		P4.setLayout(null);
		
		JButton VentanaPrincipal = new JButton("INICIO");
		VentanaPrincipal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
//--				//BOTON DE INICIO
				
			}
		});
		VentanaPrincipal.setBounds(0, 0, 251, 200);
		VentanaPrincipal.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		VentanaPrincipal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		P4.add(VentanaPrincipal);
		
		JPanel P2 = new JPanel();
		P2.setBounds(266, 5, 237, 324);
		contentPane.add(P2);
		P2.setLayout(null);
		
		JPanel P5 = new JPanel();
		P5.setBounds(0, 0, 237, 128);
		P2.add(P5);
		P5.setLayout(null);
		
		Label label = new Label("Mauricio");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				DARLE CLICK AL NOMBRE
			}
		});
		label.setBounds(79, 35, 62, 22);
		P5.add(label);
		
		Label label_1 = new Label("Daniel");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				DARLE CLICK AL NOMBRE
			}
		});
		label_1.setBounds(79, 85, 62, 22);
		P5.add(label_1);
		
		Label label_2 = new Label("Juan Pablo");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				DARLE CLICK AL NOMBRE
			}
		});
		label_2.setBounds(79, 60, 62, 22);
		P5.add(label_2);
		
		Label label_3 = new Label("Faiber");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
/*--		AL DARLE CLICK AL NOMBRE*/
			}
		});
		label_3.setBounds(79, 10, 62, 22);
		P5.add(label_3);
		
		JPanel P6 = new JPanel();
		P6.setBounds(0, 126, 237, 198);
		P2.add(P6);
		P6.setLayout(null);
		
		JTextPane txtpnMostrarFotosDe = new JTextPane();
		txtpnMostrarFotosDe.setEditable(false);
		txtpnMostrarFotosDe.setBounds(36, 89, 164, 20);
		txtpnMostrarFotosDe.setText("Mostrar Fotos");
		P6.add(txtpnMostrarFotosDe);
	}
}
