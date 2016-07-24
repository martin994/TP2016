package Presentacion;

import java.awt.Point;

import Datos.Avenida;
import Datos.Peaje;

public class Arista {
	private Point pI=null, pF=null;
	private Avenida avenida=null;
	public Arista(Avenida avenida,int xI,int yI,int xF,int yF){
		pI=new Point(xI, yI);
		pF=new Point(xF, yF);
		
	}
	
}
