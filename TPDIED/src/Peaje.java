import java.util.ArrayList;

public class Peaje {
	
	private float costoPeaje;

	public float getCostoPeaje() {
		return costoPeaje;
	}
	public Peaje(float costoPeaje) {
		this.costoPeaje = costoPeaje;
	}
	@Override
	public String toString() {
		return "Peaje [costoPeaje=" + costoPeaje + "]";
	}
	
	
}
