package Datos;
import java.util.ArrayList;

public class Peaje {
	private String id;
	private float costoPeaje;
	private int nivel=-1;


	public float getCostoPeaje() {
		return costoPeaje;
	}

	public Peaje(float costoPeaje, String id) {
		this.costoPeaje = costoPeaje;
		this.id=id;
	}
	public Peaje( String id, float costoPeaje) {
		this.costoPeaje = costoPeaje;
		this.id=id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	@Override
	public String toString() {
		return "Peaje [id=" + id + ", costoPeaje=" + costoPeaje + "]";
	}

	

}
