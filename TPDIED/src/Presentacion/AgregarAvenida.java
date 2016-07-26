package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarAvenida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSalir,btnAgregar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarAvenida frame = new AgregarAvenida();
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
	public AgregarAvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicio = new JLabel("Desde:");
		lblInicio.setBounds(10, 11, 46, 14);
		contentPane.add(lblInicio);
		
		textField = new JTextField();
		textField.setBounds(104, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hasta:");
		lblNewLabel.setBounds(10, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 31, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFlujoPorHora = new JLabel("Flujo por hora:");
		lblFlujoPorHora.setBounds(10, 59, 102, 14);
		contentPane.add(lblFlujoPorHora);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 56, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 80, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(10, 83, 66, 14);
		contentPane.add(lblLongitud);
		
		 btnSalir = new JButton("Salir");
		btnSalir.setBounds(115, 111, 89, 23);
		contentPane.add(btnSalir);
		
		 btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 111, 89, 23);
		contentPane.add(btnAgregar);
	}

	public JTextField getDesde() {
		return textField;
	}

	public JTextField getHasta() {
		return textField_1;
	}

	public JTextField getFlujo() {
		return textField_2;
	}

	public JTextField getLongitud() {
		return textField_3;
	}

	public JButton getSalir() {
		return btnSalir;
	}

	public JButton getAgregar() {
		return btnAgregar;
	}

	public void destruir() {
		dispose();
		
	}
	
	
}
