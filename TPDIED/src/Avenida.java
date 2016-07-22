public class Avenida {
	private String nombreAvenida;
	private int flujoMaximo, distancia;
	private Peaje inicio, destino;
	private boolean habilitado;

	public String getNombreAvenida() {
		return nombreAvenida;
	}

	public int getFlujoMaximo() {
		return flujoMaximo;
	}

	public int getDistancia() {
		return distancia;
	}

	public Peaje getInicio() {
		return inicio;
	}

	public Peaje getDestino() {
		return destino;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setEstado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Avenida(String nombreAvenida, int flujoMaximo, int distancia,
			Peaje inicio, Peaje destino, boolean habilitado) {
		this.nombreAvenida = nombreAvenida;
		this.flujoMaximo = flujoMaximo;
		this.distancia = distancia;
		this.inicio = inicio;
		this.destino = destino;
		this.habilitado = habilitado;
	}

	@Override
	protected Avenida clone() {
		Avenida mellizaMaligna= new Avenida(getNombreAvenida(), getFlujoMaximo(), getDistancia(), getInicio(), getDestino(), isHabilitado());
		return mellizaMaligna;
	}

}
