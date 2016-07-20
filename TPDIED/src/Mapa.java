import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Mapa {
	private Set<Peaje> listaPeajes;
	private ArrayList<Avenida> listaAvenidas;
	private Peaje inicioMapa, finMapa;
	private static int menosKms=99,menosPeajes =99;
	private static LinkedList<LinkedList<Peaje>> caminosCortos, caminosMenosPeajes;
	public static void main(String[] args){
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
		
		Mapa mp=new Mapa(p1, p7);
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
		mp.menosPeajes(p1 , p7);
//		System.out.println("  "+menosKms);
		for(LinkedList<Peaje> peajes:caminosMenosPeajes)
		System.out.println(peajes.toString());
		
	}
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
	public void agregarPeaje(Peaje p){
		listaPeajes.add(p);
		
	}
	
	
	public void agregarAvenida(String nombreAvenida, int flujoMaximo, int distancia, Peaje inicio, Peaje destino,
			boolean habilitado){
		listaAvenidas.add(new Avenida(nombreAvenida, flujoMaximo, distancia, inicio, destino, habilitado));
	}
	public void agregarAvenida(Avenida a){
		listaAvenidas.add(a);
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
	
	public void editarEstadoAvenida(Peaje inicio, Peaje fin, boolean estado){
		for(Avenida iterador:listaAvenidas){
			if(iterador.getInicio().equals(inicio) && iterador.getDestino().equals(fin));{
				iterador.setEstado(estado);
				break;
			}
		}
	}
	
	public void masCortos(Peaje inicio, Peaje fin){
		caminosCortos= new LinkedList<LinkedList<Peaje>>();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio);	//enviamos la lista con el inicio
		caminosCortosKmBT(comienzo, fin, 0);
	}
	
	public void menosPeajes(Peaje inicio, Peaje fin){
		caminosMenosPeajes= new LinkedList<LinkedList<Peaje>>();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio);	//enviamos la lista con el inicio
		caminosMenoresBT(comienzo, fin);
		
	}
	
	
	
	private void caminosCortosKmBT(LinkedList<Peaje> tramo,Peaje fin, int kilometros){
		
		if((tramo.peekLast() ==null) || (tramo.peekLast().equals(fin))){	//el caso base es cuando llegamos al nodo fin
			
			if( kilometros<menosKms){		//si la nueva distancia es menor
				
				caminosCortos.clear();	//reiniciamos el array de caminos
				caminosCortos.add((LinkedList<Peaje>) tramo.clone());	//con el nuevo camino
				menosKms=kilometros;	//y actualizamos el kilometraje
				
			}else if(kilometros==menosKms){	//si la distancia es igual
				caminosCortos.add((LinkedList<Peaje>) tramo.clone());	//agregamos el camino a la lista, ya que es otra solucion valida
			}
			
		}else{	//caso recursivo
			
			ArrayList<Avenida> candidatos =getCandidatos(tramo.peekLast());	//buscamos los posibles caminos, lo hacemos como una busqueda en profundidad recursiva
			for(Avenida avenidaAlterantiva: candidatos){	//recorremos los candidatos
				
				if(!tramo.contains(avenidaAlterantiva.getDestino())){	//controlamos que no haya bucles, ya que no hay posibilidades de caminos minimos con bucles
					
					tramo.add(avenidaAlterantiva.getDestino());		//agregamos el candidato a la pila(usamos el tramo o rrecorrido como pila), agregando y quitando solo por el final
					caminosCortosKmBT(tramo, fin, avenidaAlterantiva.getDistancia()+kilometros);	//llamamos recursivamente para verificar la rama
					tramo.removeLast();		//eliminamos el tope para la siguiente rama
				}
			}
		}
	}
	
	private void caminosMenoresBT(LinkedList<Peaje> tramo,Peaje fin){
		
		if(tramo.peekLast().equals(fin)){	//el caso base es cuando llegamos al nodo fin
				if(tramo.size()<menosPeajes){
					caminosMenosPeajes.clear();
					caminosMenosPeajes.add((LinkedList<Peaje>) tramo.clone());	//con el nuevo camino
					menosPeajes=tramo.size();
				}else if(tramo.size()==menosPeajes){
					caminosMenosPeajes.add((LinkedList<Peaje>) tramo.clone());
				}
				
			
		}else{	//caso recursivo
			
			ArrayList<Avenida> candidatos =getCandidatos(tramo.peekLast());	//buscamos los posibles caminos, lo hacemos como una busqueda en profundidad recursiva
			for(Avenida avenidaAlterantiva: candidatos){	//recorremos los candidatos
				if(!tramo.contains(avenidaAlterantiva.getDestino())){	//controlamos que no haya bucles, ya que no hay posibilidades de caminos minimos con bucles
					
					tramo.add(avenidaAlterantiva.getDestino());		//agregamos el candidato a la pila(usamos el tramo o rrecorrido como pila), agregando y quitando solo por el final
					caminosMenoresBT(tramo, fin);	//llamamos recursivamente para verificar la rama
					tramo.removeLast();		//eliminamos el tope para la siguiente rama
				}
	
			}
		}
	}
	
	private ArrayList<Avenida> getCandidatos(Peaje inicio){
		ArrayList<Avenida> candidatos= new ArrayList<Avenida>();
	
		for(Avenida ruta:listaAvenidas){	//para todas las avenidas buscamos
			if(ruta.getInicio().equals(inicio) && ruta.isHabilitado()==true){ 	//partan desde un cierto nodo "inicio" y esten habilitadas
				candidatos.add(ruta);
			}
		}
		return candidatos;
	}
	
	
	
	
	
	
}
