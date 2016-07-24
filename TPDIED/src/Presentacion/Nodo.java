package Presentacion;

import java.awt.Point;
import java.util.LinkedList;

import Datos.Peaje;

	
public class Nodo {
	private Point centro;
	private Peaje peaje=null;
	public Nodo( Peaje peaje, float x, float y) {
		centro=new Point((int)x,(int)y);
		this.peaje = peaje;
	}
	public Point getCentro() {
		return centro;
	}
	public void setCentro(Point centro) {
		this.centro = centro;
	}
	public Peaje getPeaje() {
		return peaje;
	}
	public void setPeaje(Peaje peaje) {
		this.peaje = peaje;
	}
	
	

}
