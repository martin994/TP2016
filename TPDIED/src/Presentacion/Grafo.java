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
    
    public void paint (Graphics g) throws java.lang.NullPointerException
    {
    	
    	super.paint(g);
        if(!(actual.getInicioMapa()==null)){
        	try{
	        actual.cargarNiveles();
	        posicionesNodos(actual);
	        posicionesAristas(actual);
        	}catch(NullPointerException e){
        		PEmEr error = new PEmEr("Ingrese Peajes validos");
        	}
	        for(Arista a:aristas){
	        	
		       if(a.getAvenida().isHabilitado()) g.setColor (new Color(0,205,0 ));
		       else g.setColor (new Color(255,114,86));
		        g.drawLine(a.getpI().x+12, a.getpI().y+12, a.getpF().x+12, a.getpF().y+12);
		        g.drawLine(a.getpIzqI().x+12,a.getpIzqI().y+12, a.getpIzqF().x+12, a.getpIzqF().y+12);
		        g.drawLine(a.getpDerI().x+12, a.getpDerI().y+12, a.getpDerF().x+12, a.getpDerF().y+12);
	        }
	        for(Nodo n:nodos){
	        	if(actual.getInicioMapa().equals(n.getPeaje()))g.setColor (Color.green);
	        	else if(actual.getFinMapa()==n.getPeaje()) g.setColor (Color.red);
	        	else if(actual.getPeajesposibles()!=null && actual.getPeajesposibles().contains(n.getPeaje())) g.setColor (Color.red);
	        	else g.setColor (Color.blue);
		        g.fillOval(n.getCentro().x, n.getCentro().y, 25, 25);
		        g.setColor (Color.white);
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

	public Mapa getMapa() {
		return actual;
	}
	public Peaje getPeaje(String id){
		for(Nodo iterador: nodos){
			if(iterador.getPeaje().getId().compareTo(id)==0)return iterador.getPeaje();
		}
		return null;
	}

	public void setMapa(Mapa mp) {
		actual=mp;
		
	}
    
}
