package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


import java.awt.Color;
import java.awt.Graphics;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmSentiers;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal window = new Principal();
					Nodo n1=new Nodo();
					window.frmSentiers.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSentiers = new JFrame();
		frmSentiers.setTitle("Sentiers");
		frmSentiers.setBounds(100, 100, 800, 500);
		frmSentiers.setResizable(false);
		frmSentiers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSentiers.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		frmSentiers.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoMapa = new JMenuItem("Nuevo Mapa");
		mnArchivo.add(mntmNuevoMapa);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar Mapa");
		mnArchivo.add(mntmCargar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmAgregarPeaje = new JMenuItem("Agregar Peaje");
		mnEditar.add(mntmAgregarPeaje);
		
		JMenuItem mntmAgregarAvenida = new JMenuItem("Agregar Avenida");
		mnEditar.add(mntmAgregarAvenida);
		
		JMenuItem mntmCambiarEstadoDe = new JMenuItem("Cambiar estado de avenida");
		mnEditar.add(mntmCambiarEstadoDe);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 280, 417);
		frmSentiers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnMenorCantidadDe = new JRadioButton("Menor cantidad de peajes.");
		buttonGroup.add(rdbtnMenorCantidadDe);
		rdbtnMenorCantidadDe.setBounds(0, 23, 184, 23);
		panel.add(rdbtnMenorCantidadDe);
		
		JRadioButton rdbtnDestinosPosibles = new JRadioButton("Destinos posíbles.");
		buttonGroup.add(rdbtnDestinosPosibles);
		rdbtnDestinosPosibles.setBounds(0, 49, 156, 23);
		panel.add(rdbtnDestinosPosibles);
		
		JRadioButton rdbtnDistanciaMasCorta = new JRadioButton("Distancia mas corta.");
		buttonGroup.add(rdbtnDistanciaMasCorta);
		rdbtnDistanciaMasCorta.setBounds(0, 0, 229, 23);
		panel.add(rdbtnDistanciaMasCorta);
		
		JRadioButton rdbtnFlujoMximoDe = new JRadioButton("Flujo m\u00E1ximo de vehículos.");
		buttonGroup.add(rdbtnFlujoMximoDe);
		rdbtnFlujoMximoDe.setBounds(0, 75, 196, 23);
		panel.add(rdbtnFlujoMximoDe);
		
		JRadioButton rdbtnSubmapa = new JRadioButton("Submapa.");
		buttonGroup.add(rdbtnSubmapa);
		rdbtnSubmapa.setBounds(0, 101, 109, 23);
		panel.add(rdbtnSubmapa);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesde.setBounds(10, 131, 46, 14);
		panel.add(lblDesde);
		
		textField = new JTextField();
		textField.setBounds(55, 129, 46, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Hasta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(111, 132, 46, 14);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 129, 46, 20);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("Distancia máxima del submapa:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(10, 156, 196, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 154, 46, 20);
		panel.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 260, 220);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		Nodo panel_1 = new Nodo();
		panel_1.setBounds(300, 32, 490, 430);
		frmSentiers.getContentPane().add(panel_1);
		
		
	}
	
	
}


