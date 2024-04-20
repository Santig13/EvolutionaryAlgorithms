package Individuo;


import java.util.Random;

import Individuo.IndividuoArbolGenetico.nodo;
import Individuo.TJardin.Casillas;

public class IndividuoGramatical extends Individuo {
	private static enum PuntoCardinal {
	    NORTE,
	    ESTE,
	    OESTE,
	    SUR
	}
	private int podado;
	private int n;
	private int m;
	private Casillas[][] jardin;
	
	private posicion pos;
	private PuntoCardinal orientacion;
	
	//Condicionales de terminacion 
	private int movimientos;
	private int giros;
	
	private int wraps;
	private int maxWraps;
    private int[] cromosoma;
    
    public IndividuoGramatical() {
    	Random r= new Random();
    	// TODO Auto-generated constructor stub
    			this.podado=0;
    			this.pos=new posicion(4,4);
    			this.orientacion=PuntoCardinal.NORTE;
    			Casillas[][] original= TJardin.jardin;
    			n=original.length;
    			m=original[0].length;
    			this.jardin = new Casillas[n][m];
    			
    			
    			for(int i=0;i<n;i++) {
    				for(int j=0;j<m;j++) {
    					
    		              jardin[i][j] = original[i][j];
    		                  
    		            }
    				}
    }
	@Override
	public double evalua() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Individuo copia() {
		IndividuoGramatical copia = new IndividuoGramatical();
		
		copia.fitness=this.fitness;
		copia.puntuacion=this.puntuacion;
		copia.pos=this.pos.copia();
		copia.orientacion=this.orientacion;
		copia.movimientos=this.movimientos;
		copia.giros=this.giros;
		copia.podado=podado;
		copia.n=n;
		copia.m=m;
		copia.jardin=new Casillas[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copia.jardin[i][j]=this.jardin[i][j];
			}
		}
		for(int i=0;i<cromosoma.length;i++)
			copia.cromosoma[i]=this.cromosoma[i];
		
		return copia;
	}

	
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public Casillas[][] getJardin() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void cruceSubArbol1(Individuo individuo2) {
	
	}

	@Override
	public nodo cruceSubArbol2(nodo subArbolParaCruce) {
		return null;
	}

}
