package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearMapa extends JFrame {

	private JPanel contentPane;
	private JButton button_1;
	private JTextField textField;
	private JButton button;
	private JTextField textField_1;
	private JLabel lblInicio;
	private JLabel lblFinal;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearMapa frame = new CrearMapa();
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
	public CrearMapa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 154);
		getContentPane().setLayout(null);
		setTitle("Sentiers - Crear Mapa");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
//		contentPane = new JPanel();
//		contentPane.setBounds(10, 10, 293, 90);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		 button_1 = new JButton("Salir");
		button_1.setBounds(165, 84, 86, 23);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(69, 29, 86, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		 button = new JButton("Agregar");
		button.setBounds(69, 84, 81, 23);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 54, 86, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("Costo:");
		label.setBounds(10, 57, 65, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 32, 93, 14);
		contentPane.add(label_1);
		
		lblInicio = new JLabel("Inicial");
		lblInicio.setBounds(93, 11, 46, 14);
		contentPane.add(lblInicio);
		
		lblFinal = new JLabel("Final");
		lblFinal.setBounds(189, 11, 46, 14);
		contentPane.add(lblFinal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 29, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 54, 86, 20);
		contentPane.add(textField_3);
		
	}

	public JButton getSalir() {
		return button_1;
	}

	public JTextField getId1() {
		return textField;
	}

	public JButton getAgregar() {
		return button;
	}

	public JTextField getCosto1() {
		return textField_1;
	}

	public JTextField getId2() {
		return textField_2;
	}

	public JTextField getCosto2() {
		return textField_3;
	}
	
	
}
