import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Mapa {
	private Set<Peaje> listaPeajes;
	private ArrayList<Avenida> listaAvenidas;
	private Peaje inicioMapa, finMapa;
	public Mapa(Peaje inicioMapa, Peaje finMapa) {
		listaPeajes=new HashSet<Peaje>();
		listaAvenidas= new ArrayList<Avenida>();
		this.inicioMapa = inicioMapa;
		this.finMapa = finMapa;
		listaPeajes.add(inicioMapa);
		listaPeajes.add(finMapa);
		
	}
	public void agregarPeaje(float costo){
		listaPeajes.add(new Peaje(costo));
		
	}
	
	public void agregarAvenida(String nombreAvenida, int flujoMaximo, int distancia, Peaje inicio, Peaje destino,
			boolean habilitado){
		listaAvenidas.add(new Avenida(nombreAvenida, flujoMaximo, distancia, inicio, destino, habilitado));
	}
	
	public String verEstadoAvenida(Peaje inicio, Peaje fin){
		for(Avenida iterador:listaAvenidas){
			if(iterador.getInicio().equals(inicio) && iterador.getDestino().equals(fin));{
				if (iterador.isHabilitado())
						return " Avenida '"+iterador.getNombreAvenida()+"': Habilitada";
				else
					return " Avenida "+iterador.getNombreAvenida()+": Inhabilitada";
			}
		}
		return null;
	}
	
//	public void editarEstadoAvenida(Peaje inicio, Peaje fin, boolean estado){
//		for(Avenida iterador:listaAvenidas){
//			if(iterador.getInicio().equals(inicio) && iterador.getDestino().equals(fin));{
//				iterador.setEstado(estado);
//				break;
//			}
//		}
//	}

	
	
	
	
	
	
	
}
