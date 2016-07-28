package Datos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

public class Mapa {
	private Set<Peaje> listaPeajes;
	private ArrayList<Avenida> listaAvenidas;
	private Peaje inicioMapa, finMapa;
	private  int menosKms = 99999, menosPeajes = 99,flujoMaximo=0 ;
	private  LinkedList<LinkedList<Peaje>> caminosCortos,caminosMenosPeajes;
	private  Mapa subMap=null;
	private  Set<Peaje>  peajesposibles=null;
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Peaje p1 = new Peaje(1,"p1");
		Peaje p2 = new Peaje(2,"p1");
		Peaje p3 = new Peaje(3,"p1");
		Peaje p4 = new Peaje(4,"p1");
		Peaje p5 = new Peaje(5,"p1");
		Peaje p6 = new Peaje(6,"p1");
		Peaje p7 = new Peaje(7,"p1");

		Avenida av1 = new Avenida("", 1, 1, p1, p2, true);
		Avenida av2 = new Avenida("", 3, 2, p1, p3, true);
		Avenida av3 = new Avenida("", 4, 2, p1, p4, true);
		Avenida av4 = new Avenida("", 2, 4, p2, p5, true);
		Avenida av5 = new Avenida("", 5, 2, p2, p6, true);
		Avenida av6 = new Avenida("", 3, 2, p3, p2, true);
		Avenida av7 = new Avenida("", 5, 7, p3, p5, true);
		Avenida av8 = new Avenida("", 4, 1, p4, p6, true);
		Avenida av9 = new Avenida("", 2, 3, p5, p7, true);
		Avenida av10 = new Avenida("", 2, 3, p6, p7, true);
		Avenida av11 = new Avenida("", 3, 2, p2, p3, true);

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
//		Mapa mp2= new Mapa("C:\\Users\\Usuario\\Desktop\\TPDIED\\Prueba1.csv");
		
//		System.out.println(mp2.flujoMaximo());
		
//		mp.subGrafo(p2, 4);
//		Mapa  mp2 = null;
		//	mp.getListaAvenidas().get(0).setEstado(false);
//		subMap.destinosPosibles(p2);
//		
//		System.out.println("Peajes: "+ subMap.peajesposibles.toString());
//		
//		mp2= mp.clone();
//		
//		mp2.masCortos(p1, p7);
//		System.out.println("Menor longitud: "+menosKms);
//		for (LinkedList<Peaje> peajes : caminosCortos)
//			System.out.println(peajes.toString());
//		
//		mp2.menosPeajes(p1, p7);
//		System.out.println("Menor cantidad de peajes: "+menosPeajes);
//		for (LinkedList<Peaje> peajes : caminosMenosPeajes)
//			System.out.println(peajes.toString());

	}

	public Mapa(Peaje inicioMapa, Peaje finMapa) {
		listaPeajes = new HashSet<Peaje>();
		listaAvenidas = new ArrayList<Avenida>();
		this.inicioMapa = inicioMapa;
		this.finMapa = finMapa;
		listaPeajes.add(inicioMapa);
		if(finMapa!=null)listaPeajes.add(finMapa);

	}
	public Mapa(){
		listaPeajes = new HashSet<Peaje>();
		listaAvenidas = new ArrayList<Avenida>();
	}

	public Mapa(File fichero) throws FileNotFoundException, IOException {
		listaPeajes = new HashSet<Peaje>();
		listaAvenidas = new ArrayList<Avenida>();
		cargarMapa(fichero);
	}
	
	public Peaje getFinMapa() {
		return finMapa;
	}

	public void agregarPeaje(float costo, String id) {
		listaPeajes.add(new Peaje(costo,id));

	}

	public void agregarPeaje(Peaje p) {
		listaPeajes.add(p);

	}
	
	
	

	public Peaje getInicioMapa() {
		return inicioMapa;
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

	public void editarEstadoAvenida(Peaje inicio, Peaje fin, boolean estado) {//sin terminar
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
	
	public void subGrafo(Peaje inicio, int nivel) {
		subMap=new Mapa(inicio, null);
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio); 
		subGrafoBT(comienzo, nivel);

	}
	
	
	private void subGrafoBT(LinkedList<Peaje> tramo, int nivel) {
			
		
		subMap.agregarPeaje(tramo.peekLast());
		if (nivel==0)
			subMap.finMapa=tramo.peekLast();
		if(nivel !=0){

			ArrayList<Avenida> candidatos = getCandidatos(tramo.peekLast());
			for (Avenida avenidaAlterantiva : candidatos) { 
				if (!subMap.getListaPeajes().contains(avenidaAlterantiva.getDestino())) {
					subMap.agregarAvenida(avenidaAlterantiva.clone());
					tramo.add(avenidaAlterantiva.getDestino());
					subGrafoBT(tramo, nivel-1);
					
					tramo.removeLast(); 
				}

			}
		}
	}
	
	public void destinosPosibles(Peaje inicio) {
		peajesposibles= new HashSet<Peaje>();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(inicio); 
		destinosPosiblesBT(comienzo);

	}
	
	
	private void destinosPosiblesBT(LinkedList<Peaje> tramo) {
		peajesposibles.add(tramo.peekLast());
		// caso recursivo
				
			ArrayList<Avenida> candidatos = getCandidatos(tramo.peekLast());
			for (Avenida avenidaAlterantiva : candidatos) { 

				if (!tramo.contains(avenidaAlterantiva.getDestino())) { 

					tramo.add(avenidaAlterantiva.getDestino()); 
					destinosPosiblesBT(tramo);
					tramo.removeLast();
				
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

	@Override
	protected Mapa clone() {
		Mapa mapaNuevo = new Mapa(this.inicioMapa, this.finMapa);
		for(Avenida iterador:listaAvenidas)
		mapaNuevo.agregarAvenida(iterador.clone());;
		mapaNuevo.setListaPeajes(listaPeajes);
		return mapaNuevo;
	}
	
	public int flujoMaximo(){
		Mapa clonMaligno= this.clone();
		LinkedList<Peaje> comienzo = new LinkedList<Peaje>();
		comienzo.add(clonMaligno.inicioMapa); 
		clonMaligno.flujoMaximoBT(new LinkedList<Avenida>(),comienzo,9999);
			
		
		
		return clonMaligno.flujoMaximo;
		
	}
	
	private void flujoMaximoBT(LinkedList<Avenida> tramo,LinkedList<Peaje> peajes,int minimo){
		if (!tramo.isEmpty() && peajes.peekLast().equals(finMapa)) {
			for(Avenida iterador:tramo){
				iterador.setFlujoMaximo(iterador.getFlujoMaximo()-minimo);
			}
			flujoMaximo=flujoMaximo+minimo;

		} else {

			ArrayList<Avenida> candidatos = getCandidatos(peajes.peekLast());
			for (Avenida avenidaAlterantiva : candidatos) { 
				if (!tramo.contains(avenidaAlterantiva) && avenidaAlterantiva.getFlujoMaximo()>0
						&& noCero(tramo)) {
					tramo.add(avenidaAlterantiva);
					peajes.add(avenidaAlterantiva.getDestino());
					flujoMaximoBT(tramo,peajes, Math.min(minimo, tramo.peekLast().getFlujoMaximo())); 
					peajes.removeLast();
					
					tramo.removeLast(); 
				}

			}
		}
	}
	
	
	

	private boolean noCero(LinkedList<Avenida> tramo) {//no contiene avenidas que no permitan mas autos
		for(Avenida iterador:tramo){
			if(iterador.getFlujoMaximo()==0) return false;
		}
		return true;
	}

	public Set<Peaje> getListaPeajes() {
		return listaPeajes;
	}

	public void setListaPeajes(Set<Peaje> listaPeajes) {
		this.listaPeajes = listaPeajes;
	}

	public ArrayList<Avenida> getListaAvenidas() {
		return listaAvenidas;
	}

	
	void cargarMapa(File archivo) throws FileNotFoundException, IOException {
	      String cadena;
	      FileReader f = new FileReader(archivo);
	      BufferedReader b = new BufferedReader(f);
	      while((cadena = b.readLine())!=null) {
	    	  StringTokenizer st = new StringTokenizer(cadena, ";");


	    	   switch(st.nextToken()){
		    	   case "P":
		    		   Peaje nuevoPeaje=new Peaje(st.nextToken(), Float.parseFloat(st.nextToken()));
		    		   agregarPeaje(nuevoPeaje);
		    		   if(st.nextToken().compareTo("SI")==0)inicioMapa=nuevoPeaje;
		    		   if(st.nextToken().compareTo("SI")==0) finMapa=nuevoPeaje;
		    		   break;
		    	   case"A":
		    		   String inicio=st.nextToken(),fin=st.nextToken();
		    		   Peaje p1=null,p2=null;
		    		   for(Peaje p:listaPeajes){
		    			   if (inicio.compareTo(p.getId())==0) p1=p;
		    			   if(fin.compareTo(p.getId())==0)p2=p;
		    		   }
		    		   Avenida nuevaAvenida=new Avenida("", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), p1, p2, (st.nextToken().compareTo("SI")==0));
		    		   agregarAvenida(nuevaAvenida);
		    		   break;
		    		  default:break;
	    	   }

	    	   
	      }
	      b.close();
	}
	
	
	public void cargarNiveles(){
		int nivelFin=0;
		LinkedList<Peaje> cola= new LinkedList<Peaje>();
		LinkedList<Peaje> recorridos= new LinkedList<Peaje>();
		inicioMapa.setNivel(0);
		cola.add(inicioMapa);
		recorridos.add(inicioMapa);
		while (!cola.isEmpty()){
			for(Avenida iterador:listaAvenidas){
				if(finMapa!=null && iterador.getDestino()!= finMapa && iterador.getInicio()==cola.getFirst() && !recorridos.contains(iterador.getDestino())){
					cola.add(iterador.getDestino());
					iterador.getDestino().setNivel(iterador.getInicio().getNivel()+1);
					nivelFin=(iterador.getInicio().getNivel()+1>nivelFin) ? iterador.getInicio().getNivel()+2:nivelFin;
					recorridos.add(iterador.getDestino());
				}
//				if(!recorridos.contains(iterador.getDestino())) recorridos.add(iterador.getDestino());
				
			}
			cola.removeFirst();
		}
		if(finMapa!=null)finMapa.setNivel(nivelFin+1);
	}

	public  int getFlujoMaximo() {
		return flujoMaximo;
	}

	public  LinkedList<LinkedList<Peaje>> getCaminosCortos() {
		return caminosCortos;
	}

	public  LinkedList<LinkedList<Peaje>> getCaminosMenosPeajes() {
		return caminosMenosPeajes;
	}

	public  Mapa getSubMap() {
		return subMap;
	}

	public Set<Peaje> getPeajesposibles() {
		return peajesposibles;
	}

	public Peaje getPeaje(String text) {
		for(Peaje iterador: listaPeajes){
			if(iterador.getId().compareTo(text)==0) return iterador;
		}
		return null;
	}

	public void cambiarEstado(Peaje peaje, Peaje peaje2) {
		for(Avenida iterador:listaAvenidas){
			if(iterador.getInicio()==peaje && iterador.getDestino()==peaje2)iterador.setEstado(!iterador.isHabilitado());
			
		}
		
		
	}

	public int getMenosKms() {
		return menosKms;
	}

	public void setMenosKms(int menosKms) {
		this.menosKms = menosKms;
	}

	public void reSet() {
		
		 
		menosKms = 99999;
		menosPeajes = 99;
		flujoMaximo=0 ;
		caminosCortos=null;
		caminosMenosPeajes=null;
		peajesposibles=null;
		
	}
	
	
	
}
