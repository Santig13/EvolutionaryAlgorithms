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
		int tamaño=colors.length;
		jardin= new Casillas[tamaño][tamaño] ;
		 for (int i = 0; i < tamaño; i++) {
	            for (int j = 0; j < tamaño; j++) {
	            	
	            	Color c=colors[i][j];
	            	Casillas cas=null;
	            	if(c==Color.green) {
	            		cas=Casillas.CESPED;
	            	}
	            	else if(c==Color.red) {
	            		cas=Casillas.PARED;
	            	}
	            	
	            	jardin[i][j]=cas;
	              
	            }
	        }
	}
	public static Color[][] getColores(Casillas[][] jar) {
		int tamaño=jar.length;
		Color[][] colors= new Color[tamaño][tamaño] ;
		 for (int i = 0; i < tamaño; i++) {
	            for (int j = 0; j < tamaño; j++) {
	            	
	            	Color c = null;
	            	Casillas cas=jar[i][j];
	            	if(cas==Casillas.CESPED) {
	            		c=Color.green;
	            	}
	            	else if(cas==Casillas.PARED) {
	            		c=Color.red;
	            	}
	            	else if(cas==Casillas.TIERRA) {
	            		c=Color.DARK_GRAY;
	            	}
	            	
	            	colors[i][j]=c;
	              
	            }
	        }
		return colors;
	}
}
