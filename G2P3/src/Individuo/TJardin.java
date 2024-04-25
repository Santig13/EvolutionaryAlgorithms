package Individuo;

import java.awt.Color;

public class TJardin {

	protected static enum Casillas {
		   CESPED,
		   TIERRA,
		   PARED
		}
	protected static Casillas[][] jardin;
	
	public static void setCasillas(Color[][] colors) {
		int tamanio=colors.length;
		jardin= new Casillas[tamanio][tamanio] ;
		 for (int i = 0; i < tamanio; i++) {
	            for (int j = 0; j < tamanio; j++) {
	            	
	            	Color c=colors[i][j];
	            	Casillas cas=null;
	            	if(c==Color.GREEN) {
	            		cas=Casillas.CESPED;
	            	}
	            	else if(c==Color.RED) {
	            		cas=Casillas.PARED;
	            	}
	            	else  {
	            		cas=Casillas.TIERRA;
	            	}
	            	
	            	jardin[i][j]=cas;
	              
	            }
	        }
		 posicion.maxalto=tamanio;
		 posicion.maxancho=tamanio;
	}
	public static Color[][] getColores(Casillas[][] jar) {
		int tamanio=jar.length;
		Color[][] colors= new Color[tamanio][tamanio] ;
		 for (int i = 0; i < tamanio; i++) {
	            for (int j = 0; j < tamanio; j++) {
	            	
	            	Color c = null;
	            	Casillas cas=jar[i][j];
	            	if(cas==Casillas.CESPED) {
	            		c=Color.green;
	            	}
	            	else if(cas==Casillas.PARED) {
	            		c=Color.RED;
	            	}
	            	else if(cas==Casillas.TIERRA) {
	            		c=Color.WHITE;
	            	}
	            	
	            	colors[i][j]=c;
	              
	            }
	        }
		return colors;
	}
	public static Object translate(Casillas[][] jardin2) {
		// TODO Auto-generated method stub
		return null;
	}
}
