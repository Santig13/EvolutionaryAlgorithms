package Individuo;

import java.util.ArrayList;
import java.util.Random;

public class IndividuoCortaCesped extends IndividuoArbolGenetico {
	private static enum PuntoCardinal {
	    NORTE,
	    ESTE,
	    OESTE,
	    SUR
	}
	private static enum Casillas {
	   CESPED,
	   TIERRA,
	   PARED
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
        add("REPEAT");
    }};

	
	private int podado;
	private int n;
	private int m;
	private Casillas[][] jardin;
	private posicion pos;
	private PuntoCardinal orientacion;
	
	//Condicionales de terminacion 
	private int movimientos;
	private int giros;
	
	//COSTRUCTOR VACIO
	public IndividuoCortaCesped(int n, int m) {
		// TODO Auto-generated constructor stub
		this.podado=0;
		this.pos=new posicion(4,4);
		this.orientacion=PuntoCardinal.NORTE;
		
		this.n = n;
		this.m = m;
		
		this.jardin = new Casillas[n][m];
		
		Random r=new Random();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int tipoCasilla = r.nextInt(3);
	            
	            switch (tipoCasilla) {
	                case 0:
	                    jardin[i][j] = Casillas.CESPED;
	                    break;
	                case 1:
	                    jardin[i][j] = Casillas.TIERRA;
	                    break;
	                case 2:
	                    jardin[i][j] = Casillas.PARED;
	                    break;
	            }
			}
		}
	}
	//COSTRUCTOR COPIA
	public IndividuoCortaCesped(IndividuoCortaCesped indv) {
		// TODO Auto-generated constructor stub
		this.pos=indv.pos.copia();
		this.orientacion=indv.orientacion;
		this.movimientos=indv.movimientos;
		this.giros=indv.movimientos;
		
		this.jardin=new Casillas[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				jardin[i][j]=indv.jardin[i][j];
			}
		}
		
		this.raiz=copiaArbol();
		
	}
	
	//RESTO DE COSTRUCTORES
	
	public boolean poda() {
		if(jardin[pos.getY()][pos.getX()]==Casillas.CESPED) {
			jardin[pos.getY()][pos.getX()]=Casillas.TIERRA;
			podado++;
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
		pos.salta(nueva);
		poda();
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
				
				if(puedemoverseY(1))pos.mueveY(1);
				break;
			case ESTE :
				if(puedemoverseX(1))pos.mueveX(1);
				break;
			case OESTE:
				if(puedemoverseX(-1))pos.mueveX(-1);
				break;
			case SUR:
				if(puedemoverseY(-1))pos.mueveY(-1);
				break;
		}
		
		return new posicion(0,0);
	}
	//No se puede avanzar a una pared pero si avanzar desdeella
	private boolean puedemoverseX(int i) {
		posicion nueva=this.pos.copia();
		nueva.mueveX(i);
		if(jardin[nueva.getY()][nueva.getX()]==Casillas.PARED)
			return false;
		else
			return true;
	}
	private boolean puedemoverseY(int i) {
		posicion nueva=this.pos.copia();
		nueva.mueveY(i);
		if(jardin[nueva.getY()][nueva.getX()]==Casillas.PARED)
			return false;
		else
			return true;
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
		int n=jardin.length;
		int m=jardin[0].length;
		Random random = new Random();
		return new posicion(random.nextInt(n),random.nextInt(m));
	}
	@Override
	protected nodo nodoTernminal() {
		int n=terminales.size();
		Random r= new Random();
		return new nodo(terminales.get(r.nextInt(n)),0);
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
		
		return new IndividuoCortaCesped(this);
	}
	@Override
	public  double evalua() {
		while(!terminado()) {
			ejecuta(raiz);
		}
		return podado;
	}
	
	
	
	
}
