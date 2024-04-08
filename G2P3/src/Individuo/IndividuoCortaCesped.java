package Individuo;

import java.util.ArrayList;
import java.util.Random;

public class IndividuoCortaCesped extends IndividuoArbolGenetico {
	private enum PuntoCardinal {
	    NORTE,
	    ESTE,
	    OESTE,
	    SUR
	}
	private ArrayList<String> terminales = new ArrayList<String>() {{
        add("AVANZA");
        add("ALEATORIA");
        add("IZQUIERDA");
        add("DERECHA");
    }};
	private ArrayList<String> funciones = new ArrayList<String>() {{
        add("SALTA");
        add("PROGN");
        add("SUMA");
        add("IF-DIRTY");
        add("REPEAT");
    }};

	
	private int porPodar;
	private boolean[][] cesped;
	private posicion pos;
	private PuntoCardinal orientacion;
	
	//Condicionales de terminacion 
	private int movimientos;
	private int giros;
	
	public boolean poda() {
		if(cesped[pos.getY()][pos.getX()]) {
			cesped[pos.getY()][pos.getX()]=false;
			return true;
		}
		return false;		
	}
	public boolean terminado() {
		return giros>100||movimientos>100;
	}
	//Funciones SALTA(V),SUMA(V1,V2),PROGN(OP1,OP2),IF-DIRTY (A,B),(repeat A,B) 
	public posicion salta(posicion nueva) {
		movimientos++;
		pos.suma(nueva);
		if(poda())
			porPodar--;
		return nueva;
	}
	
	public posicion suma(posicion v1,posicion v2) {
		 v1.suma(v2);
		 return v1;
	}
	public posicion progn(nodo n1,nodo n2) {
		ejecuta(n1);
		return ejecuta(n2);
	}
	
	private posicion ejecuta(nodo n) {
		// TODO Auto-generated method stub
		posicion casilla=null;
		switch (n.getDescript()) {
	    case "AVANZA":
	    	
	    	this.avanza();
	    	break;
	    case "IZQUIERDA":
	    	
	    	this.izquierda();
	    	break;
	    case "DERECHA":
	    	
	    	this.derecha();
	        break;
	    case "SALTA":
	    	
	    	this.salta(ejecuta(n.hijo1()));
	    	break;
	    case "PROGN":
	    	
	    	this.progn(n.hijo1(), n.hijo2());
	    	break;
	    case "SUMA":
	    	this.suma(ejecuta(n.hijo1()), ejecuta(n.hijo2()));
	    	break;
	    case "IF-DIRTY":
	    	
	    	break;
	    case "REPEAT":
	    	
	        break;
	    default:
	    	casilla=new posicion(n.getDescript());
	        break;
	}

		return casilla;
		
	}
	//Terminales AVANZA IZQUIERDA DERECHA ALEATORIA
	public posicion avanza() {
		movimientos++;
		switch(orientacion) {
			case NORTE:
				pos.setY(pos.getY() + 1);
				break;
			case ESTE :
				pos.setX(pos.getX() + 1);
				break;
			case OESTE:
				pos.setX(pos.getX() - 1);
				break;
			case SUR:
				pos.setY(pos.getY() - 1);
				break;
		}
		if(poda())
			porPodar--;
		
		return new posicion(0,0);
	}
	public posicion izquierda() {
		giros++;
		switch(orientacion) {
			case NORTE:
				orientacion=PuntoCardinal.OESTE;
				break;
			case ESTE :
				orientacion=PuntoCardinal.NORTE;
				break;
			case OESTE:
				orientacion=PuntoCardinal.SUR;
				break;
			case SUR:
				orientacion=PuntoCardinal.ESTE;
				break;
		}
		return new posicion(0,0);
	}
	public posicion derecha() {
		giros++;
		
		switch(orientacion) {
			case NORTE:
				orientacion=PuntoCardinal.ESTE;
				break;
			case ESTE :
				orientacion=PuntoCardinal.SUR;
				break;
			case OESTE:
				orientacion=PuntoCardinal.NORTE;
				break;
			case SUR:
				orientacion=PuntoCardinal.OESTE;
				break;
		}
		return new posicion(0,0);
	}
	public posicion aleatoria() {
		int n=cesped.length;
		int m=cesped[0].length;
		Random random = new Random();
		return new posicion(random.nextInt(n),random.nextInt(m));
	}
	@Override
	protected nodo nodoFuncional() {
		int n=terminales.size();
		Random r= new Random();
		return new nodo(terminales.get(r.nextInt(n)),0);
	}
	@Override
	protected nodo nodoTernminal() {
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
	public IndividuoArbolGenetico copia() {
		return null;
	}
	@Override
	protected double evalua() {
		return 0;
	}
	
	
}
