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
		int tama�o=colors.length;
		jardin= new Casillas[tama�o][tama�o] ;
		 for (int i = 0; i < tama�o; i++) {
	            for (int j = 0; j < tama�o; j++) {
	            	
	            	Color c=colors[i][j];
	            	Casillas cas=null;
	            	if(c==Color.green) {
	            		cas=Casillas.CESPED;
	            	}
	            	else if(c==Color.red) {
	            		cas=Casillas.PARED;
	            	}
	            	else  {
	            		cas=Casillas.TIERRA;
	            	}
	            	
	            	jardin[i][j]=cas;
	              
	            }
	        }
		 posicion.maxalto=tama�o;
		 posicion.maxancho=tama�o;
	}
	public static Color[][] getColores(Casillas[][] jar) {
		int tama�o=jar.length;
		Color[][] colors= new Color[tama�o][tama�o] ;
		 for (int i = 0; i < tama�o; i++) {
	            for (int j = 0; j < tama�o; j++) {
	            	
	            	Color c = null;
	            	Casillas cas=jar[i][j];
	            	if(cas==Casillas.CESPED) {
	            		c=Color.green;
	            	}
	            	else if(cas==Casillas.PARED) {
	            		c=Color.red;
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
