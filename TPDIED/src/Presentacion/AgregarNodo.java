package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AgregarNodo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JButton button_1,button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarNodo window = new AgregarNodo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarNodo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 309, 128);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 293, 90);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		 button_1 = new JButton("Salir");
		button_1.setBounds(212, 61, 71, 23);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(62, 8, 86, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		 button = new JButton("Agregar");
		button.setBounds(138, 61, 71, 23);
		panel.add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 8, 86, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel label = new JLabel("Costo:");
		label.setBounds(158, 11, 32, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 11, 41, 14);
		panel.add(label_1);
		pack();
	}

	public JTextField getId() {
		return textField;
	}

	public JTextField getCosto() {
		return textField_1;
	}

	public JButton getSalir() {
		return button_1;
	}

	public JButton getAgregar() {
		return button;
	}
}
