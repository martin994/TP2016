package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AcercaDe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe frame = new AcercaDe();
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
	public AcercaDe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 170);
		contentPane = new JPanel();
		setTitle("Sentiers - Acerca de...");

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(270, 5, 400, 120);
		textArea.setText("Sentiers fue creado por Gozález José Martín y González Paz Nicolás,\n"
				+ "alumnos de la carrera de ingenieria en sistemas de la catedra de Diseño\n"
				+ " e Implementación de Estructuras de Datos.\n"
				+ "Emails: mar.inc.987@gmail.com (Gozález José Martín)\n"
				+ "               nico_tate07@hotmail.com (González Paz Nicolás)\n"
				+ "Proyecto desarrollado en java descargable desde github:\n"
				+ "https://github.com/martin994/TP2016");
		textArea.setEditable(false);
		contentPane.add(textArea);
	
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


	}

	
	
	public void paint (Graphics g)
    {
        super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("Sentiers.jpg");
        g.drawImage (imagen, 5, 5, this);
    }
}
