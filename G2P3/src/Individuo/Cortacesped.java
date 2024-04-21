package Individuo;


import java.util.Random;

import Individuo.IndividuoArbolGenetico.nodo;
import Individuo.TJardin.Casillas;

public class Cortacesped {
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
	private int movimientosAnt;
	private int girosAnt;
	private int movimientos;
	private int giros;
    public Cortacesped() {
    	
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
	public boolean poda() {
		if(jardin[pos.getY()][pos.getX()]==Casillas.CESPED) {
			jardin[pos.getY()][pos.getX()]=Casillas.TIERRA;
			podado++;
			return true;
		}
		return false;		
	}
	public boolean terminado() {
		return giros>200||movimientos>100;
	}
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
	public posicion avanza() {
		movimientos++;
		switch(orientacion) {
			case NORTE:
				
				if(puedemoverseY(-1))pos.mueveY(-1);
				break;
			case ESTE :
				if(puedemoverseX(1))pos.mueveX(1);
				break;
			case OESTE:
				if(puedemoverseX(-1))pos.mueveX(-1);
				break;
			case SUR:
				if(puedemoverseY(1))pos.mueveY(1);
				break;
		}
		this.poda();
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
		public String aleatoria() {
			int n=jardin.length;
			int m=jardin[0].length;
			Random random = new Random();
			//return new posicion(random.nextInt(n),random.nextInt(m));
			return "("+random.nextInt(n)+","+random.nextInt(m)+")";
		}
		public Cortacesped copia() {
			Cortacesped copia=new Cortacesped();
			copia.pos=this.pos.copia();
			copia.orientacion=this.orientacion;
			copia.movimientos=this.movimientos;
			copia.giros=this.giros;
			copia.girosAnt = this.girosAnt;
			copia.movimientosAnt = this.movimientosAnt;
			copia.podado=podado;
			copia.n=n;
			copia.m=m;
			copia.jardin=new Casillas[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					copia.jardin[i][j]=this.jardin[i][j];
				}
			}
			return copia;
		}
		public void reset() {
			this.girosAnt = 0;
			this.movimientosAnt = 0;
			this.giros = 0;
			this.movimientos = 0;
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
		public Casillas[][] getJardin() {
			return jardin;
		}



		public void setJardin(Casillas[][] jardin) {
			this.jardin = jardin;
		}
		public double getPodado() {
			// TODO Auto-generated method stub
			return this.podado;
		}
		public boolean quieto() {
			// TODO Auto-generated method stub
			if (giros==girosAnt && movimientos==movimientosAnt)
			 return true;
			else
			{
				girosAnt = giros;
				movimientosAnt = movimientos;
				return false;
			}
		}

		public boolean DelanteTierra() {
			
			switch(orientacion) {
			case NORTE:
				int Y = (pos.getY()-1);
				if (Y == -1)
					Y = n-1;
				if (jardin[Y][pos.getX()] != Casillas.TIERRA)
					return false;
				break;
			case ESTE :
				if (jardin[pos.getY()][(pos.getX()+1)%m] != Casillas.TIERRA)
					return false;
				break;
			case OESTE:
				int X =(pos.getX()-1);
				if (X == -1)
					X = m-1;
				if (jardin[pos.getY()][X] != Casillas.TIERRA)
					return false;
				break;
			case SUR:
				if (jardin[(pos.getY()+1)%n][ pos.getX()] != Casillas.TIERRA)
					return false;
				break;
			}
			
			return true;
		}
}
