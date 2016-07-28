package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarMapa extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JButton btnNewButton;
	private String textArea;
	private JFileChooser jf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CargarMapa frame = new CargarMapa();
		frame.setVisible(true);
		
		
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CargarMapa frame = new CargarMapa();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public CargarMapa(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setResizable(false);
		 jf = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
		jf.setFileFilter(filter);
		add(jf);
	
		
		jf.getSelectedFile();

		
	}

	public JFileChooser getJf() {
		return jf;
	}
	
	
}
