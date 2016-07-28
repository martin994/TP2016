package Presentacion;

import java.awt.Point;

import Datos.Avenida;
import Datos.Peaje;

public class Arista {
	private Point pI=null, pF=null,pIzqI=null, pIzqF=null,pDerI=null, pDerF=null;
	private Avenida avenida=null;
	
	public Arista(Avenida avenida,int xI,int yI,int xF,int yF){
		pI=new Point(xI, yI);
		pF=new Point(xF, yF);
		
		
	}

	public Arista( Avenida avenida,Point pI, Point pF) {
		
		double alfa=Math.atan2(pF.y-pI.y,pF.x-pI.x);
		this.pI = pI;
		this.pF=new Point((int) (pF.x-13*Math.cos(alfa)), (int) (pF.y-13*Math.sin(alfa)));
		
		pDerF=this.pF;
		pIzqF=this.pF;
		this.avenida = avenida;
		int xa=(int)(this.pF.x-12*Math.cos(alfa+1));
		int ya=(int)(this.pF.y-12*Math.sin(alfa+1));
		pIzqI=new Point(xa, ya);
		xa=(int)(this.pF.x-12*Math.cos(alfa-1));
		ya=(int)(this.pF.y-12*Math.sin(alfa-1));
		pDerI=new Point(xa, ya);
	}

	public Point getpI() {
		return pI;
	}

	public void setpI(Point pI) {
		this.pI = pI;
	}

	public Point getpF() {
		return pF;
	}

	public void setpF(Point pF) {
		this.pF = pF;
	}

	public Point getpIzqI() {
		return pIzqI;
	}

	public void setpIzqI(Point pIzqI) {
		this.pIzqI = pIzqI;
	}

	public Point getpIzqF() {
		return pIzqF;
	}

	public void setpIzqF(Point pIzqF) {
		this.pIzqF = pIzqF;
	}

	public Point getpDerI() {
		return pDerI;
	}

	public void setpDerI(Point pDerI) {
		this.pDerI = pDerI;
	}

	public Point getpDerF() {
		return pDerF;
	}

	public void setpDerF(Point pDerF) {
		this.pDerF = pDerF;
	}

	public Avenida getAvenida() {
		return avenida;
	}

	public void setAvenida(Avenida avenida) {
		this.avenida = avenida;
	}
	
	
	
	
	
}
