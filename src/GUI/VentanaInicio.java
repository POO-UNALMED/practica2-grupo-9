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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel P1 = new JPanel();
		P1.setBorder(new LineBorder(Color.BLACK));
		P1.setBounds(5, 5, 251, 324);
		contentPane.add(P1);
		P1.setLayout(null);
		
		JPanel P3 = new JPanel();
		P3.setBorder(new LineBorder(Color.BLACK));
		P3.setBounds(0, 0, 251, 125);
		P1.add(P3);
		P3.setLayout(null);
		
		TextArea Bienvenida = new TextArea();
		Bienvenida.setBounds(0, 0, 251, 125);
		Bienvenida.setRows(5);
		Bienvenida.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Bienvenida.setColumns(30);
		Bienvenida.setText("Bienvenido al programa");
		Bienvenida.setEditable(false);
		P3.add(Bienvenida);
		
		JPanel P4 = new JPanel();
		P4.setBorder(new LineBorder(Color.BLACK));
		P4.setBounds(0, 124, 251, 200);
		P1.add(P4);
		P4.setLayout(null);
		
		JButton BotonINICIO = new JButton("INICIO");
		BotonINICIO.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
//--				//BOTON DE INICIO
				
			}
		});
		BotonINICIO.setBounds(0, 0, 251, 200);
		BotonINICIO.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		BotonINICIO.setAlignmentX(Component.RIGHT_ALIGNMENT);
		P4.add(BotonINICIO);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("DESCRIPCION");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bienvenida.setText("Descripcion breve del Sistema");
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("SALIR");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JPanel P2 = new JPanel();
		P2.setBorder(new LineBorder(Color.BLACK));
		P2.setBounds(266, 5, 227, 324);
		contentPane.add(P2);
		P2.setLayout(null);
		
		JPanel P5 = new JPanel();
		P5.setBorder(new LineBorder(Color.BLACK));
		P5.setBounds(0, 0, 227, 128);
		P2.add(P5);
		P5.setLayout(null);
		
		JPanel P6 = new JPanel();
		P6.setBorder(new LineBorder(Color.BLACK));
		P6.setBounds(0, 126, 227, 198);
		P2.add(P6);
		P6.setLayout(null);
		
		JTextPane txtpnMostrarFotosDe = new JTextPane();
		txtpnMostrarFotosDe.setEditable(false);
		txtpnMostrarFotosDe.setBounds(36, 89, 164, 20);
		txtpnMostrarFotosDe.setText("Mostrar Fotos");
		P6.add(txtpnMostrarFotosDe);
		
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
/*--			AL DARLE CLICK AL NOMBRE*/
				
			}
		});
		label_3.setBounds(79, 10, 62, 22);
		P5.add(label_3);
	}
}
