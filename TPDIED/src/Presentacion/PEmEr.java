package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PEmEr extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PEmEr frame = new PEmEr("Hola");
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
	public PEmEr(String dialogo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Error");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(33, 39, 354, 34);
		lblNewLabel.setText(dialogo);
		contentPane.add(lblNewLabel);
	}
}
