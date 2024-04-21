package Individuo;

import java.util.ArrayList;
import java.util.Random;

import Individuo.IndividuoArbolGenetico.nodo;
import Individuo.TJardin.Casillas;

public class IndividuoCortaCesped extends IndividuoArbolGenetico {
	private static enum PuntoCardinal {
	    NORTE,
	    ESTE,
	    OESTE,
	    SUR
	}
	
	private static final ArrayList<String> terminales = new ArrayList<String>() {{
       add("AVANZA");
       add("ALEATORIA");
       add("IZQUIERDA");
       add("DERECHA");
    }};
	private static final ArrayList<String> funciones = new ArrayList<String>() {{
        add("SALTA");
        add("PROGN");
        add("SUMA");
        add("IF-DIRTY");
        add("REPEATY");
        add("REPEATX");
    }};

	
	private Cortacesped cortacesped;
	
	//COSTRUCTOR VACIO
	public IndividuoCortaCesped() {
		// TODO Auto-generated constructor stub
		cortacesped= new Cortacesped();
		}
	
	
	
	//RESTO DE COSTRUCTORES
	
	public boolean terminado() {
		return cortacesped.terminado();
	}
	//Funciones SALTA(V),SUMA(V1,V2),PROGN(OP1,OP2),IF-DIRTY (A,B),(repeat A,B) 
	
	
	public posicion progn(nodo n1,nodo n2) {
		ejecuta(n1);
		return ejecuta(n2);
	}
	
	private posicion ejecuta(nodo n) {
		// TODO Auto-generated method stub
		posicion casilla=null;
		switch (n.getDescript()) {
	    case "AVANZA":
	    	
	    	casilla=cortacesped.avanza();
	    	break;
	    case "IZQUIERDA":
	    	
	    	casilla=cortacesped.izquierda();
	    	break;
	    case "DERECHA":
	    	
	    	casilla=cortacesped.derecha();
	        break;
	    case "SALTA":
	    	
	    	casilla=cortacesped.salta(ejecuta(n.hijo1()));
	    	break;
	    case "PROGN":
	    	
	    	casilla=this.progn(n.hijo1(), n.hijo2());
	    	break;
	    case "SUMA":
	    	casilla=cortacesped.suma(ejecuta(n.hijo1()), ejecuta(n.hijo2()));
	    	break;
	    case "IF-DIRTY":
	    	casilla= cortacesped.DelanteTierra() ? ejecuta(n.hijo1()) : ejecuta(n.hijo2());
	    	//casilla=this.ifDirty(n.hijo1(), n.hijo2());
	    	break;
	    case "REPEATY":
	    	int vecesy=ejecuta(n.hijo1()).getY()%8;
	    	for(int i=0;i<vecesy;i++)
	    		casilla=ejecuta(n.hijo2());
	        break;
	    case "REPEATX":
	    	int vecesx=ejecuta(n.hijo1()).getY()%8;
	    	for(int i=0;i<vecesx;i++)
	    		casilla=ejecuta(n.hijo2());
	        break;
	    default:
	    	casilla=new posicion(n.getDescript());
	        break;
	}

		return casilla;
		
	}
	//No se puede avanzar a una pared pero si avanzar desdeella
	
	@Override
	protected nodo nodoTernminal() {
		int n=terminales.size();
		Random r= new Random();
		String t=terminales.get(r.nextInt(n));
		if(t.equalsIgnoreCase("ALEATORIA")) {
			t=cortacesped.aleatoria();
		}
		return new nodo(t,0);
	}
	@Override
	protected nodo nodoFuncional() {
		// TODO Auto-generated method stub
		int n=funciones.size();
		Random r= new Random();
		int hijos ;
		String funcion=funciones.get(r.nextInt(n));
		switch(funcion){
			case "SALTA":
				hijos=1;
				break;
			default:
				hijos=2;
				break;
		}
		return new nodo(funcion,hijos);
	}
	
	@Override
	public Individuo copia() { 
		
		IndividuoCortaCesped copia=new IndividuoCortaCesped();
		copia.maximaProfundidad = this.maximaProfundidad;
		copia.fitness=this.fitness;
		copia.puntuacion=this.puntuacion;
		copia.cortacesped=cortacesped.copia();
		copia.raiz=copiaArbol();
		return copia;
	}
	@Override
	public double evalua() {
		while(!terminado()) {
			ejecuta(raiz);
			
			if(cortacesped.quieto()) {
				break;
			}
			
		}
		return cortacesped.getPodado();
	}
	@Override
	public void reset() {
		cortacesped.reset();
	}
	@Override
	protected nodo nodoFuncionalConAridadN(int n) {
		
		
		int size=funciones.size();
		Random r = new Random();
		int hijos ;
		int seleccionado = r.nextInt(size);
		String funcion=funciones.get(seleccionado);
		
		switch(funcion){
			case "SALTA":
				hijos=1;
				break;
			default:
				hijos=2;
				break;
		}
		
		
		while (hijos != n)
		{
			 funcion=funciones.get(seleccionado);
			
			switch(funcion){
				case "SALTA":
					hijos=1;
					break;
				default:
					hijos=2;
					break;
			}
			seleccionado = (seleccionado + 1)%size;
			
		}
		
		return new nodo(funcion,hijos);
	}
	
	
	public Casillas[][] getJardin() {
		return cortacesped.getJardin();
	}



	public void setJardin(Casillas[][] jardin) {
		cortacesped.setJardin(jardin);
	}
	
	
	
}
