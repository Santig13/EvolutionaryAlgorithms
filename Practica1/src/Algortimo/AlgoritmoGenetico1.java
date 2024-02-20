package Algortimo;

import java.util.ArrayList;

import ppoblacion.IndividuoFuncion1;

public class AlgoritmoGenetico1 {
	private int tamPoblacion;
    private IndividuoFuncion1[] poblacion;
    private double[] puntuaciones;
    
   private void inicializarPoblacion() {
	   poblacion=new IndividuoFuncion1[tamPoblacion];
	   for(int i=0;i<tamPoblacion;i++) {
		   poblacion[i]=new IndividuoFuncion1();
	   }
   }
   private void evaluar() {
	   for(int i=0;i<tamPoblacion;i++) {
		   puntuaciones[i]=poblacion[i].getFitness();
	   }
   }
   private void seleccion() {
	  
   }
   
}
