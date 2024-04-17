package Individuo;

import Individuo.posicion;

public class posicion {
		private int y;
		private int x;
		protected static int maxancho;
		protected static int maxalto;
		
		public posicion(int x,int y,int maxalto,int maxancho) {
			this.setX(x);
			this.setY(y);
		
		}
		
		// Constructor para inicializar desde una cadena de texto en formato "(y,x)"
	    public posicion(String posicionStr) {
	        // Remover los paréntesis y dividir la cadena en las coordenadas y e x
	        String[] coordenadas = posicionStr.substring(1, posicionStr.length() - 1).split(",");
	        // Convertir las coordenadas a enteros y asignarlas a x e y
	        this.setY(Integer.parseInt(coordenadas[0].trim()));
	        this.setX(Integer.parseInt(coordenadas[1].trim()));
	       
	    }
		public posicion(int x,int y) {
			// TODO Auto-generated constructor stub
			this.setX(x);
			this.setY(y);
		}

		public void suma(posicion nueva) {
			// TODO Auto-generated method stub
			setX((getX() + nueva.getX())%8);
			setY((getY() + nueva.getY())%8);
		}
		public String toString()
		{
			return "("+getY()+","+getX()+")";
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public posicion copia() {
			// TODO Auto-generated method stub
			return new posicion(this.x,this.y);
		}

		public void mueveY(int i) {
		    this.y += i;
		    if (y < 0) {
		        while (y < 0)
		            y = maxalto + y; 
		    } else if (y >= maxalto) {
		        while (y >= maxalto)
		            y = y - maxalto; 
		    }
		}

		public void mueveX(int i) {
		    this.x += i;
		    if (x < 0) {
		        while (x < 0)
		            x = maxancho + x; 
		    } else if (x >= maxancho) {
		        while (x >= maxancho)
		            x = x - maxancho; 
		    }
		}

		public void salta(posicion nueva) {
			mueveX(nueva.x);
			mueveY(nueva.y);
			
		}
		
}
