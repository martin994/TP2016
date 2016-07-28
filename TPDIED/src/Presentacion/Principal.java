package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
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
	private JTextField desde,hasta,distanciaSubM;
	private JButton btnEjecutar, btnDibujar,btnLimpiar;
	private JRadioButton rdbtnSubmapa, rdbtnDestinosPosibles,rdbtnMenorCantidadDe,rdbtnDistanciaMasCorta,rdbtnFlujoMximoDe, rdbtnCambiarEstadoDe;
	private Grafo grafo;
	private JMenuItem mntmNuevoMapa,mntmAgregarAvenida,mntmCargar,mntmSalir,mntmAgregarPeaje, mntmAyuda, mntmAcercaDe;
	private CargarMapa cmp;
	private TextArea textArea;
	private  AgregarNodo aN;
	private AgregarAvenida aA;
	private Ayuda ayuda;
	private CrearMapa crearMapa;
	private JLabel lblSeleccioneSuOpcion;


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
		 mntmNuevoMapa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 crearMapa= new CrearMapa();
				crearMapa.getAgregar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try{
						grafo.setMapa(new Mapa(new Peaje(crearMapa.getId1().getText(),Float.parseFloat(crearMapa.getCosto1().getText())),
								new Peaje(crearMapa.getId2().getText(),Float.parseFloat(crearMapa.getCosto2().getText()))));
						crearMapa.dispose();
						}catch(NumberFormatException exception){
							PEmEr error = new PEmEr("Complete los campos correctamente");
							error.setVisible(true);
						}
					}
				});
				crearMapa.setVisible(true);
				
				
			}
		});
		 
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
				if(grafo.getMapa().getInicioMapa()==null){
					PEmEr error=new PEmEr("No existe Mapa, cree uno primero");
					error.setVisible(true);
				}else{
					aN = new AgregarNodo();
					
					
					aN.getAgregar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg1) {
							grafo.getMapa().agregarPeaje(new Peaje(aN.getId().getText(),Float.parseFloat(aN.getCosto().getText())));
						}
					});
					aN.getSalir().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg1) {
							aN.dispose();
							
						}
					});
					aN.setVisible(true);
				}
				
				
			}
		});
		
		
		 mntmAgregarAvenida = new JMenuItem("Agregar Avenida");
		mnEditar.add(mntmAgregarAvenida);
		mntmAgregarAvenida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(grafo.getMapa().getInicioMapa()==null){
					PEmEr error=new PEmEr("No existe Mapa, cree uno primero");
					error.setVisible(true);
				}else{
					aA=new AgregarAvenida();
					aA.getAgregar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							grafo.getMapa().agregarAvenida(new Avenida("",Integer.parseInt(aA.getFlujo().getText())
									,Integer.parseInt(aA.getLongitud().getText())
									,grafo.getMapa().getPeaje(aA.getDesde().getText()),
									grafo.getMapa().getPeaje(aA.getHasta().getText()),
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
				ayuda=new Ayuda();
				ayuda.getListo().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg1) {
						ayuda.dispose();
						
					}
				});
				ayuda.setVisible(true);
				
			}
		});
		
		 mntmAcercaDe = new JMenuItem("Acerca de...");
		mnAyuda.add(mntmAcercaDe);
		mntmAcercaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
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
		
		desde = new JTextField();
		desde.setBounds(45, 155, 46, 20);
		panel.add(desde);
		desde.setEditable(false);
		desde.setColumns(10);
		
		JLabel label = new JLabel("Hasta:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(101, 158, 46, 14);
		panel.add(label);
		
		hasta = new JTextField();
		hasta.setColumns(10);
		hasta.setBounds(140, 155, 46, 20);
		hasta.setEditable(false);
		panel.add(hasta);
		
		JLabel lblDistanciaMaxima = new JLabel("Distancia máxima del submapa:");
		lblDistanciaMaxima.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDistanciaMaxima.setBounds(0, 182, 196, 14);
		panel.add(lblDistanciaMaxima);
		
		distanciaSubM = new JTextField();
		distanciaSubM.setColumns(10);
		distanciaSubM.setBounds(186, 180, 46, 20);
		distanciaSubM.setEditable(false);
		panel.add(distanciaSubM);
		
		 rdbtnCambiarEstadoDe = new JRadioButton("Cambiar estado de avenida.");
		buttonGroup.add(rdbtnCambiarEstadoDe);
		rdbtnCambiarEstadoDe.addFocusListener(this);
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
		textArea.setBounds(0, 235, 280, 153);
		panel.add(textArea);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(2, 207, 89, 23);
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		JButton btnMostrarAvenidas = new JButton("Mostrar avenidas");
		btnMostrarAvenidas.setBounds(140, 394, 140, 23);
		panel.add(btnMostrarAvenidas);
		btnMostrarAvenidas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("Las avenidas del mapa son:\n");
				for(Avenida iterador:grafo.getMapa().getListaAvenidas()) {
					textArea.append(iterador.toString()+"\n");
				}
			}
		});
		
		JButton btnMostrarPeajes = new JButton("Mostrar Peajes");
		btnMostrarPeajes.setBounds(0, 394, 137, 23);
		panel.add(btnMostrarPeajes);
		btnMostrarPeajes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("Los peajes del mapa son:\n");
				for(Peaje iterador:grafo.getMapa().getListaPeajes()) {
					textArea.append(iterador.toString()+"\n");
				}
			}
		});
		
		grafo = new Grafo(new Mapa());
		grafo.setBounds(300, 10, 490, 430);
		frmSentiers.getContentPane().add(grafo);
		
		lblSeleccioneSuOpcion = new JLabel("Seleccione su opcion y ejecute.");
		lblSeleccioneSuOpcion.setBounds(10, 10, 260, 14);
		frmSentiers.getContentPane().add(lblSeleccioneSuOpcion);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==mntmCargar){
			
			 cmp = new CargarMapa();
			cmp.setVisible(true);
			cmp.getJf().addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e1) {
					
					
					
						

							try {
								grafo= new Grafo(new Mapa(cmp.getJf().getSelectedFile()));
								grafo.setBounds(300, 10, 490, 430);
								grafo.setVisible(true);
								frmSentiers.getContentPane().add(grafo);
								grafo.repaint();
								
							} catch (FileNotFoundException ex) {
								PEmEr error=new PEmEr("Problema Al cargar el archivo");
								error.setVisible(true);
							} catch (IOException ex) {
								PEmEr error=new PEmEr("Problema Al cargar el archivo");
								error.setVisible(true);
							}catch(NullPointerException n){
								n.printStackTrace();
							}
				   
					cmp.dispose();
										
				}
			});
			
		}
			
		
		if(e.getSource()==mntmSalir){
			this.dispose();
		}
		
		
		
		
		if(e.getSource()==btnEjecutar){
			try{
				if(rdbtnDestinosPosibles.isSelected()){
					
					grafo.getMapa().destinosPosibles(grafo.getPeaje(desde.getText()));
					textArea.append("Destinos posibles: "+grafo.getMapa().getPeajesposibles()+"\n");
					textArea.setForeground(Color.GREEN);
					grafo.repaint();
					
					
				}else if(rdbtnDistanciaMasCorta.isSelected() ){
					grafo.getMapa().masCortos(grafo.getPeaje(desde.getText()), grafo.getPeaje(hasta.getText()));
					textArea.append("El camino mas corto es de: "+grafo.getMapa().getMenosKms()+" kilómetros\n");
					textArea.append("El camino mas es por: "+grafo.getMapa().getCaminosCortos()+"\n");
					textArea.setForeground(Color.GREEN);
					grafo.repaint();
					grafo.getMapa().reSet();
				}else if(rdbtnFlujoMximoDe.isSelected()){
					textArea.append("Flujo Máximo: "+grafo.getMapa().flujoMaximo()+" vehículos por hora\n");
					textArea.setForeground(Color.GREEN);
					grafo.repaint();
					grafo.getMapa().reSet();
				}else if(rdbtnMenorCantidadDe.isSelected()){
					grafo.getMapa().menosPeajes(grafo.getPeaje(desde.getText()), grafo.getPeaje(hasta.getText()));
					textArea.append("Camino con menos peajes: "+grafo.getMapa().getCaminosMenosPeajes()+"\n");
					textArea.setForeground(Color.GREEN);
					grafo.repaint();
					grafo.getMapa().reSet();
				}else if(rdbtnSubmapa.isSelected()){
					grafo.getMapa().subGrafo(grafo.getPeaje(desde.getText()), Integer.parseInt(distanciaSubM.getText()));
					textArea.append("El subgrafo contiene a los peajes: "+grafo.getMapa().getSubMap().getListaPeajes()+"\n");
					Grafo panel_2 = new Grafo(grafo.getMapa().getSubMap());
					panel_2.setBounds(300, 10, 490, 430);
					textArea.setForeground(Color.GREEN);
					frmSentiers.getContentPane().add(panel_2);
					panel_2.repaint();
				}else if(rdbtnCambiarEstadoDe.isSelected()){
					grafo.getMapa().cambiarEstado(grafo.getPeaje(desde.getText()), grafo.getPeaje(hasta.getText()));
					textArea.append("El estado de la avenida "+desde.getText()+"->"+hasta.getText()+"ha sido cambiado.\n");
					textArea.setForeground(Color.GREEN);
					grafo.repaint();
				}//C:\Users\Usuario\Desktop\TPDIED\Prueba1.csv
			}catch(NullPointerException exception){
				textArea.setForeground(Color.RED);
				textArea.append("Cargue correctamente el mapa\n");
			}catch(NumberFormatException exception){
				textArea.setForeground(Color.RED);
				textArea.append("Cargue correctamente el mapa\n");
			}
			
		}else if(e.getSource()==btnDibujar){
			grafo.repaint();
		}else if(e.getSource()==btnLimpiar){
			
			grafo.setMapa(null);
			
			grafo.setBounds(300, 10, 490, 430);
			
			grafo.repaint();
			grafo.setVisible(false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==rdbtnDestinosPosibles){
			desde.setEditable(true);
			hasta.setEditable(false);
			distanciaSubM.setEditable(false);
		}else if(e.getSource()==rdbtnDistanciaMasCorta){
			desde.setEditable(true);
			hasta.setEditable(true);
			distanciaSubM.setEditable(false);
		}else if(e.getSource()==rdbtnFlujoMximoDe){
			desde.setEditable(false);
			hasta.setEditable(false);
			distanciaSubM.setEditable(false);
		}else if(e.getSource()==rdbtnMenorCantidadDe){
			desde.setEditable(true);
			hasta.setEditable(true);
			distanciaSubM.setEditable(false);
		}else if(e.getSource()==rdbtnSubmapa){
			desde.setEditable(true);
			hasta.setEditable(false);
			distanciaSubM.setEditable(true);
		}else if(e.getSource()==rdbtnCambiarEstadoDe){
			desde.setEditable(true);
			hasta.setEditable(true);
			distanciaSubM.setEditable(false);
		}
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


