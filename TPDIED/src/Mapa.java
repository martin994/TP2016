import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Mapa {
	private Set<Peaje> listaPeajes;
	private ArrayList<Avenida> listaAvenidas;
	private Peaje inicioMapa, finMapa;
	private static int menosKms = 99, menosPeajes = 99;
	private static LinkedList<LinkedList<Peaje>> caminosCortos,caminosMenosPeajes;

	public static void main(String[] args) {
		Peaje p1 = new Peaje(1);
		Peaje p2 = new Peaje(2);
		Peaje p3 = new Peaje(3);
		Peaje p4 = new Peaje(4);
		Peaje p5 = new Peaje(5);
		Peaje p6 = new Peaje(6);
		Peaje p7 = new Peaje(7);

		Avenida av1 = new Avenida("", 30, 1, p1, p2, true);
		Avenida av2 = new Avenida("", 30, 2, p1, p3, true);
		Avenida av3 = new Avenida("", 30, 2, p1, p4, true);
		Avenida av4 = new Avenida("", 30, 4, p2, p5, true);
		Avenida av5 = new Avenida("", 30, 2, p2, p6, true);
		Avenida av6 = new Avenida("", 30, 2, p3, p2, true);
		Avenida av7 = new Avenida("", 30, 7, p3, p5, true);
		Avenida av8 = new Avenida("", 30, 1, p4, p6, true);
		Avenida av9 = new Avenida("", 30, 3, p5, p7, true);
		Avenida av10 = new Avenida("", 30, 3, p6, p7, true);
		Avenida av11 = new Avenida("", 30, 2, p2, p3, true);

		Mapa mp = new Mapa(p1, p7);
		mp.agregarPeaje(p2);
		mp.agregarPeaje(p3);
		mp.agregarPeaje(p4);
		mp.agregarPeaje(p5);
		mp.agregarPeaje(p6);

		mp.agregarAvenida(av1);
		mp.agregarAvenida(av2);
		mp.agregarAvenida(av3);
		mp.agregarAvenida(av4);
		mp.agregarAvenida(av5);
		mp.agregarAvenida(av6);
		mp.agregarAvenida(av7);
		mp.agregarAvenida(av8);
		mp.agregarAvenida(av9);
		mp.agregarAvenida(av10);
		mp.agregarAvenida(av11);
		
		
		mp.masCortos(p1, p7);
		System.out.println("Menor longitud: "+menosKms);
		for (LinkedList<Peaje> peajes : caminosCortos)
			System.out.println(peajes.toString());
		
		mp.menosPeajes(p1, p7);
		System.out.println("Menor cantidad de peajes: "+menosPeajes);
		for (LinkedList<Peaje> peajes : caminosMenosPeajes)
			System.out.println(peajes.toString());

	}

	public Mapa(Peaje inicioMapa, Peaje finMapa) {
		listaPeajes = new HashSet<Peaje>();
		listaAvenidas = new ArrayList<Avenida>();
		this.inicioMapa = inicioMapa;
		this.finMapa = finMapa;
		listaPeajes.add(inicioMapa);
		listaPeajes.add(finMapa);

	}

	public void agregarPeaje(float costo) {
		listaPeajes.add(new Peaje(costo));

	}

	public void agregarPeaje(Peaje p) {
		listaPeajes.add(p);

	}

	public void agregarAvenida(String nombreAvenida, int flujoMaximo,
			int distancia, Peaje inicio, Peaje destino, boolean habilitado) {
		listaAvenidas.add(new Avenida(nombreAvenida, flujoMaximo, distancia,
				inicio, destino, habilitado));
	}

	public void agregarAvenida(Avenida a) {
		listaAvenidas.add(a);
	}

	public String verEstadoAvenida(Peaje inicio, Peaje fin) {
		for (Avenida iterador : listaAvenidas) {
			if (iterador.getInicio().equals(inicio)
					&& iterador.getDestino().equals(fin))
				;
			{
				if (iterador.isHabilitado())
					return " Avenida '" + iterador.getNombreAvenida()
							+ "': Habilitada";
				else
					return " Avenida " + iterador.getNombreAvenida()
							+ ": Inhabilitada";
			}
		}
		return null;
	}

	public void editarEstadoAvenida(Peaje inicio, Peaje fin, boolean estado) {
		for (Avenida iterador : listaAvenidas) {
			if (iterador.getInicio().equals(inicio)
					&& iterador.getDestino().equals(fin))
				;
			{
				iterador.setEstado(estado);
				break;
			}
		}
	}

	public void masCortos(Peaje inicio, Peaje fin) {
		caminosCortos = new LinkedList<LinkedList<Peaje>>();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio); 
		caminosCortosKmBT(comienzo, fin, 0);
	}

	public void menosPeajes(Peaje inicio, Peaje fin) {
		caminosMenosPeajes = new LinkedList<LinkedList<Peaje>>();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio); 
		caminosMenoresBT(comienzo, fin);

	}

	private void caminosCortosKmBT(LinkedList<Peaje> tramo, Peaje fin,
			int kilometros) {

		if ((tramo.peekLast() == null) || (tramo.peekLast().equals(fin))) { 

			if (kilometros < menosKms) {

				caminosCortos.clear(); 
				caminosCortos.add((LinkedList<Peaje>) tramo.clone());
				menosKms = kilometros; 

			} else if (kilometros == menosKms) { 
				caminosCortos.add((LinkedList<Peaje>) tramo.clone());
			}

		} else { // caso recursivo

			ArrayList<Avenida> candidatos = getCandidatos(tramo.peekLast());
			for (Avenida avenidaAlterantiva : candidatos) { 

				if (!tramo.contains(avenidaAlterantiva.getDestino())) { 

					tramo.add(avenidaAlterantiva.getDestino()); 
					caminosCortosKmBT(tramo, fin,
							avenidaAlterantiva.getDistancia() + kilometros);
					tramo.removeLast();
				}
			}
		}
	}

	private void caminosMenoresBT(LinkedList<Peaje> tramo, Peaje fin) {

		if (tramo.peekLast().equals(fin)) {
			if (tramo.size() < menosPeajes) {
				caminosMenosPeajes.clear();
				caminosMenosPeajes.add((LinkedList<Peaje>) tramo.clone()); 
				menosPeajes = tramo.size();
			} else if (tramo.size() == menosPeajes) {
				caminosMenosPeajes.add((LinkedList<Peaje>) tramo.clone());
			}

		} else { 

			ArrayList<Avenida> candidatos = getCandidatos(tramo.peekLast());
			for (Avenida avenidaAlterantiva : candidatos) { 
				if (!tramo.contains(avenidaAlterantiva.getDestino())) {
					tramo.add(avenidaAlterantiva.getDestino());
					caminosMenoresBT(tramo, fin); 
					tramo.removeLast(); 
				}

			}
		}
	}

	private ArrayList<Avenida> getCandidatos(Peaje inicio) {
		ArrayList<Avenida> candidatos = new ArrayList<Avenida>();

		for (Avenida ruta : listaAvenidas) { // para todas las avenidas buscamos
			if (ruta.getInicio().equals(inicio) && ruta.isHabilitado() == true) { 
				candidatos.add(ruta);
			}
		}
		return candidatos;
	}

}
