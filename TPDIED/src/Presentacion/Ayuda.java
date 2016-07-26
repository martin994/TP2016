package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;

public class Ayuda extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAyuda = new JLabel("Ayuda");
		lblAyuda.setBounds(193, 11, 46, 14);
		contentPane.add(lblAyuda);
		
		JLabel lblSentiersEsUna = new JLabel("Sentiers es una herramienta dise\u00F1ada para facilitar a los usuarios el transitar por autopistas o rutas.\r\nPara utilizar sentiers debemos seguir unos simples pasos:\r\n\t+Crear mapa: Accediendo a la opcion Archivo del menu superior, podremos elegir entre cargar un mapa desde un archivo tipo CSV o crear un mapa nuevo designando un peaje de inicio y fin para despues poder cargar los otros.\r\n\t+Cargar mapa: Accediendo a la opcion Editar del menu superior, podremos agregar peajes y avenidas.\r\n\t+Agregar peaje: Para agregar un peaje debemos ir a \"Editar->Agregar Peaje\" y all\u00ED asignarle un identificador y un costo, luego presionamos agregar y podremos cargar otro o salir.\r\n\t+Agregar Avenida: Para agregar una avenida debemos ir a \"Editar->Agregar Avenida\" y asignarle un peaje de inicio, uno de destino, un flujo maximo por hora, longitud de la avenida y si esta habilitada o no.  Luego presionamos agregar y podremos cargar otra o salir.");
		lblSentiersEsUna.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAyuda.setSize(414, 176);
		lblSentiersEsUna.setBounds(10, 43, 414, 176);
		contentPane.add(lblSentiersEsUna);
	}
}
