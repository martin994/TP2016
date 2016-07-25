package Presentacion;

import Datos.Avenida;
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
	private LinkedList<Nodo> nodos= null;
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
        if(!(actual.getInicioMapa()==null)){
	        actual.cargarNiveles();
	        posicionesNodos(actual);
	        posicionesAristas(actual);
	        for(Arista a:aristas){
		        g.setColor (Color.green);
		        g.drawLine(a.getpI().x, a.getpI().y, a.getpF().x, a.getpF().y);
		        g.drawLine(a.getpIzqI().x,a.getpIzqI().y, a.getpIzqF().x, a.getpIzqF().y);
		        g.drawLine(a.getpDerI().x, a.getpDerI().y, a.getpDerF().x, a.getpDerF().y);
	        }
	        for(Nodo n:nodos){
		        g.setColor (Color.blue);
		        g.fillOval(n.getCentro().x, n.getCentro().y, 25, 25);
		        g.setColor (Color.red);
		        g.drawString(n.getPeaje().getId(), n.getCentro().x+7, n.getCentro().y+17);
	        }
        
        }
        
    }
    
    
    private void posicionesNodos(Mapa mp){
    	nodos = new LinkedList<Nodo>();
    	LinkedList<Peaje> aNivel=new LinkedList<>();
    	for(int nivel=0; nivel<mp.getFinMapa().getNivel()+1;nivel++){
    		for(Peaje iterador:mp.getListaPeajes()){
    			if(iterador.getNivel()==nivel)aNivel.add(iterador);
    		}
    		for(Peaje iterador:aNivel){
    			nodos.add(new Nodo(iterador, 25+(getWidth()-25)*(aNivel.indexOf(iterador)+1)/(aNivel.size()+1), 
    					15+(getHeight()-75)*(((float)nivel)/(mp.getFinMapa().getNivel()))));
    		}
    		aNivel.clear();
    	}
		
    	
    }
    private void posicionesAristas(Mapa mp){
    	aristas= new LinkedList<Arista>();
    	Nodo aux1=null,aux2=null;
    	for(Avenida av:mp.getListaAvenidas()){
    		for(Nodo nd:nodos){
    			if(av.getInicio()==nd.getPeaje())aux1=nd;
    			if(av.getDestino()==nd.getPeaje())aux2=nd;
    		}
    		aristas.add(new Arista(av, aux1.getCentro(),aux2.getCentro()));
    		
    	}
    		
    }
    
}
