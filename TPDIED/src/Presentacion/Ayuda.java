package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class Ayuda extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
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
	public Ayuda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 248);
		setTitle("Sentiers - Ayuda");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextArea txtrSentiersEsUna_1 = new JTextArea();
		txtrSentiersEsUna_1.setText("Sentiers es una herramienta dise\u00F1ada para facilitar a los usuarios el \n"
				+ "transitar por autopistas o rutas."
				+ "\nPara aprender a utilizar Sentiers se recomienda leer con atenci�n\n"
				+ "la esta breve descripcion de su interfaz:"
				+ "\n  +Archivo: Accediendo a la opcion Archivo del menu superior,\n"
				+ "   podremos elegir entre cargar un mapa desde un archivo tipo CSV o\n"
				+ "   crear un mapa nuevo designando un peaje de inicio y fin para\n"
				+ "   despues poder cargar los otros.\n"
				+ "   +Editar: podemos encontrar las opciones para ampliar nuestro \n"
				+ "   mapa en este men�, ya sea agregando avenidas o peajes.\n"
				+ "   +Ayuda: en este men� encontraremos la informacion para utilizar\n"
				+ "   Sentiers o contactarnos con sus desarrolladores.\n"
				+ "Funcionalidades:\n"
				+ "   +Dibujar: nos permite ver o actualizar el mapa.\n"
				+ "   +Limpiar: as� eliminamos nuestro mapa totalmente\n"
				+ "   +Ejecutar: si seleccionamos una opcion en la parte superior\n"
				+ "   luego completamos los campos disponibles, as� podremos \n"
				+ "   ejecutar y ver los resultados en el mapa o la pantalla inferior\n"
				+ "   +Mostrar Peajes: muestra los peajes creados en la pantalla\n"
				+ "    inferior.\n"
				+ "   +Mostrar Avenidas: muestra las avenidas creadas en la pantalla\n"
				+ "   inferior.\n"
				+ "Muchas gracias por haberse tomado el tiempo de leer esto :D.");

		JScrollPane sc=new JScrollPane(txtrSentiersEsUna_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setBounds(10, 37, 403, 128);
		getContentPane().add(sc);
		txtrSentiersEsUna_1.setEditable(false);
		
		JLabel lblAyuda = new JLabel("Ayuda:");
		lblAyuda.setBounds(185, 11, 46, 14);
		contentPane.add(lblAyuda);
		
		 btnNewButton = new JButton("Listo");
		btnNewButton.setBounds(322, 176, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
	}

	public JButton getListo() {
		return btnNewButton;
	}
	
}
