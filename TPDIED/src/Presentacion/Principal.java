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

import Datos.Avenida;
import Datos.Mapa;
import Datos.Peaje;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Principal extends JFrame implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmSentiers;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnEjecutar, btnDibujar;
	private JRadioButton rdbtnSubmapa, rdbtnDestinosPosibles,rdbtnMenorCantidadDe,rdbtnDistanciaMasCorta,rdbtnFlujoMximoDe, rdbtnCambiarEstadoDe;
	private Grafo panel_1;
	private JMenuItem mntmNuevoMapa,mntmAgregarAvenida,mntmCargar,mntmSalir,mntmAgregarPeaje, mntmAyuda, mntmAcercaDe;
	private JButton btnLimpiar;
	private CargarMapa cmp;
	private Grafo gf;
	private TextArea textArea;
	private  AgregarNodo aN;
	private AgregarAvenida aA;
	String st;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal window = new Principal();
					
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
		frmSentiers.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		 mntmNuevoMapa = new JMenuItem("Nuevo Mapa");
		 mntmNuevoMapa.addActionListener(this);
		mnArchivo.add(mntmNuevoMapa);
		
		 mntmCargar = new JMenuItem("Cargar Mapa");
		 mntmCargar.addActionListener(this);
		 mnArchivo.add(mntmCargar);
		
		 mntmSalir = new JMenuItem("Salir");
		 mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		 mntmAgregarPeaje = new JMenuItem("Agregar Peaje");
		mnEditar.add(mntmAgregarPeaje);
		mntmAgregarPeaje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel_1.getMapa().getInicioMapa()==null){
					PEmEr error=new PEmEr("No existe Mapa, cree uno primero");
					error.setVisible(true);
				}else{
					aN = new AgregarNodo();
					aN.setBounds(100, 100, 309, 128);
					
					aN.getAgregar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg1) {
							panel_1.getMapa().agregarPeaje(new Peaje(aN.getId().getText(),Float.parseFloat(aN.getCosto().getText())));
						}
					});
					aN.getSalir().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg1) {
							aN.dispose();
							
						}
					});
				}
				aN.setVisible(true);
				
			}
		});
		
		
		 mntmAgregarAvenida = new JMenuItem("Agregar Avenida");
		mnEditar.add(mntmAgregarAvenida);
		mntmAgregarAvenida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(panel_1.getMapa().getInicioMapa()==null){
					PEmEr error=new PEmEr("No existe Mapa, cree uno primero");
					error.setVisible(true);
				}else{
					aA=new AgregarAvenida();
					aA.getAgregar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							panel_1.getMapa().agregarAvenida(new Avenida("",Integer.parseInt(aA.getFlujo().getText())
									,Integer.parseInt(aA.getLongitud().getText())
									,panel_1.getMapa().getPeaje(aA.getDesde().getText()),
									panel_1.getMapa().getPeaje(aA.getHasta().getText()),
									true));
									
							}
							
						});
					aA.getSalir().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							aA.destruir();//cierra la ventana
							
						}
					});
					aA.setVisible(true);
				}
				
				
			}
		});
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		 mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		mntmAyuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		 mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 280, 417);
		frmSentiers.getContentPane().add(panel);
		panel.setLayout(null);
		
		 rdbtnMenorCantidadDe = new JRadioButton("Menor cantidad de peajes.");
		buttonGroup.add(rdbtnMenorCantidadDe);
		rdbtnMenorCantidadDe.setBounds(0, 47, 184, 23);
		panel.add(rdbtnMenorCantidadDe);
		rdbtnMenorCantidadDe.addFocusListener(this);
		
		 rdbtnDestinosPosibles = new JRadioButton("Destinos posíbles.");
		buttonGroup.add(rdbtnDestinosPosibles);
		rdbtnDestinosPosibles.setBounds(0, 73, 156, 23);
		panel.add(rdbtnDestinosPosibles);
		rdbtnDestinosPosibles.addFocusListener(this);
		
		 rdbtnDistanciaMasCorta = new JRadioButton("Distancia mas corta.");
		buttonGroup.add(rdbtnDistanciaMasCorta);
		rdbtnDistanciaMasCorta.setBounds(0, 24, 229, 23);
		panel.add(rdbtnDistanciaMasCorta);
		rdbtnDistanciaMasCorta.addFocusListener(this);
		
		 rdbtnFlujoMximoDe = new JRadioButton("Flujo m\u00E1ximo de vehículos.");
		buttonGroup.add(rdbtnFlujoMximoDe);
		rdbtnFlujoMximoDe.setBounds(0, 99, 196, 23);
		panel.add(rdbtnFlujoMximoDe);
		rdbtnFlujoMximoDe.addFocusListener(this);
		
		 rdbtnSubmapa = new JRadioButton("Submapa.");
		buttonGroup.add(rdbtnSubmapa);
		rdbtnSubmapa.setBounds(0, 125, 109, 23);
		panel.add(rdbtnSubmapa);
		rdbtnSubmapa.addFocusListener(this);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesde.setBounds(0, 157, 46, 14);
		panel.add(lblDesde);
		
		textField = new JTextField();
		textField.setBounds(45, 155, 46, 20);
		panel.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Hasta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(101, 158, 46, 14);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 155, 46, 20);
		textField_1.setEditable(false);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("Distancia máxima del submapa:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(0, 182, 196, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 180, 46, 20);
		textField_2.setEditable(false);
		panel.add(textField_2);
		
		 rdbtnCambiarEstadoDe = new JRadioButton("Cambiar estado de avenida.");
		buttonGroup.add(rdbtnCambiarEstadoDe);
		rdbtnCambiarEstadoDe.setBounds(0, 0, 184, 23);
		panel.add(rdbtnCambiarEstadoDe);
		
		 btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(95, 207, 89, 23);
		panel.add(btnEjecutar);
		btnEjecutar.addActionListener(this);
		
		 btnDibujar = new JButton("Dibujar");
		btnDibujar.setBounds(186, 207, 89, 23);
		panel.add(btnDibujar);
		btnDibujar.addActionListener(this);
		
		 textArea = new TextArea();
		textArea.setSelectionEnd(10);
		textArea.setBounds(0, 235, 280, 160);
		panel.add(textArea);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(2, 207, 89, 23);
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		
		panel_1 = new Grafo(new Mapa());
		panel_1.setBounds(300, 10, 490, 430);
		frmSentiers.getContentPane().add(panel_1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mntmNuevoMapa){
			
		}
		if(e.getSource()==mntmCargar){
			cmp= new CargarMapa();
			cmp.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e1) {
					if(e1.getSource()==cmp.btnNewButton){
						st= cmp.textField.getText();

							try {
								panel_1= new Grafo(new Mapa(st));
								panel_1.setBounds(300, 10, 490, 430);
								panel_1.setVisible(true);
								frmSentiers.getContentPane().add(panel_1);
								panel_1.repaint();
								
							} catch (FileNotFoundException ex) {
								PEmEr error=new PEmEr("Problema Al cargar el archivo");
								error.setVisible(true);
							} catch (IOException ex) {
								PEmEr error=new PEmEr("Problema Al cargar el archivo");
								error.setVisible(true);
							}
				   
					cmp.dispose();
					}
					
				}
			});
			cmp.setVisible(true);
		}
		if(e.getSource()==mntmSalir){
			this.dispose();
		}
		
		if(e.getSource()==mntmAgregarAvenida){
			
		}
		if(e.getSource()==mntmAcercaDe){
			
		}
		if(e.getSource()==mntmAyuda){
			
		}
		
		if(e.getSource()==btnEjecutar){
			if(rdbtnDestinosPosibles.isSelected()){
				
				panel_1.getMapa().destinosPosibles(panel_1.getPeaje(textField.getText()));
				textArea.append("Destinos posibles: "+panel_1.getMapa().getPeajesposibles()+"\n");
				
				panel_1.repaint();
			}else if(rdbtnDistanciaMasCorta.isSelected()){
				panel_1.getMapa().masCortos(panel_1.getPeaje(textField.getText()), panel_1.getPeaje(textField_1.getText()));
				textArea.append("El camino mas corto es de: "+panel_1.getMapa().getCaminosCortos()+"\n");
				panel_1.repaint();
			}else if(rdbtnFlujoMximoDe.isSelected()){
				textArea.append("Flujo Máximo: "+panel_1.getMapa().flujoMaximo()+" vehiculos por hora\n");
				panel_1.repaint();
			}else if(rdbtnMenorCantidadDe.isSelected()){
				panel_1.getMapa().menosPeajes(panel_1.getPeaje(textField.getText()), panel_1.getPeaje(textField_1.getText()));
				textArea.append("Camino con menos peajes: "+panel_1.getMapa().getCaminosMenosPeajes()+"\n");
				panel_1.repaint();
			}else if(rdbtnSubmapa.isSelected()){
				panel_1.getMapa().subGrafo(panel_1.getPeaje(textField.getText()), Integer.parseInt(textField_2.getText()));
				textArea.append("El subgrafo contiene a los peajes: "+panel_1.getMapa().getSubMap().getListaPeajes()+"\n");
				Grafo panel_2 = new Grafo(panel_1.getMapa().getSubMap());
				panel_2.setBounds(300, 10, 490, 430);
				frmSentiers.getContentPane().add(panel_2);
				panel_2.repaint();
				
			}//C:\Users\Usuario\Desktop\TPDIED\Prueba1.csv
			
		}else if(e.getSource()==btnDibujar){
			panel_1.repaint();
		}else if(e.getSource()==btnLimpiar){
			panel_1= new Grafo(null);
			panel_1.setVisible(false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==rdbtnDestinosPosibles){
			textField.setEditable(true);
			textField_1.setEditable(false);
			textField_2.setEditable(false);
		}else if(e.getSource()==rdbtnDistanciaMasCorta){
			textField.setEditable(true);
			textField_1.setEditable(true);
			textField_2.setEditable(false);
		}else if(e.getSource()==rdbtnFlujoMximoDe){
			textField.setEditable(false);
			textField_1.setEditable(false);
			textField_2.setEditable(false);
		}else if(e.getSource()==rdbtnMenorCantidadDe){
			textField.setEditable(true);
			textField_1.setEditable(true);
			textField_2.setEditable(false);
		}else if(e.getSource()==rdbtnSubmapa){
			textField.setEditable(true);
			textField_1.setEditable(false);
			textField_2.setEditable(true);
		}else if(e.getSource()==rdbtnCambiarEstadoDe){
			textField.setEditable(true);
			textField_1.setEditable(true);
			textField_2.setEditable(false);
		}
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


