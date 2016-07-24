package Presentacion;

import Datos.Mapa;
import Datos.Peaje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Grafo extends JPanel {
	private LinkedList<Nodo> peajes= null;
	private LinkedList<Arista> aristas=null;
	private Mapa actual=null;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Grafo frame = new Grafo(new Mapa(""));
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
    public Grafo(Mapa m) {
        actual=m;
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(300, 10, 490, 430);
        contentPane.setLayout(null);
       
    }
    
    public void paint (Graphics g)
    {
    	
        super.paint(g);
        actual.cargarNiveles();
        posicionesNodos(actual);
        for(Nodo n:peajes){
	        g.setColor (Color.blue);
	        g.fillOval(n.getCentro().x, n.getCentro().y, 25, 25);
	        g.setColor (Color.red);
	        g.drawString(n.getPeaje().getId(), n.getCentro().x+7, n.getCentro().y+17);
        }
    }
    
    
    private void posicionesNodos(Mapa mp){
    	peajes = new LinkedList<Nodo>();
    	LinkedList<Peaje> aNivel=new LinkedList<>();
    	for(int nivel=0; nivel<mp.getFinMapa().getNivel()+1;nivel++){
    		for(Peaje iterador:mp.getListaPeajes()){
    			if(iterador.getNivel()==nivel)aNivel.add(iterador);
    		}
    		for(Peaje iterador:aNivel){
    			peajes.add(new Nodo(iterador, 25+(getWidth()-25)*(aNivel.indexOf(iterador)+1)/(aNivel.size()+1), 
    					15+(getHeight()-75)*(((float)nivel)/(mp.getFinMapa().getNivel()))));
    		}
    		aNivel.clear();
    	}
		
    	
    }
    
}
