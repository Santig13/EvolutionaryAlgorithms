package Individuo;

import Individuo.posicion;

public class posicion {
		private int y;
		private int x;
		public posicion(int x,int y) {
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
		public void suma(posicion nueva) {
			// TODO Auto-generated method stub
			setX(getX() + nueva.getX());
			setY(getY() + nueva.getY());
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
		
}
