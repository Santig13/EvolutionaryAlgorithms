package FunCruzador;

import java.util.Random;

import ppoblacion.Individuo;
import ppoblacion.Poblacion;

public abstract class Cruzador {

	public void crossover(Poblacion poblacion, int tamPoblacion, double probCruce) {
		// TODO Auto-generated method stub

		Random r = new Random();
		Individuo<?>[] seleccionados = new Individuo<?>[tamPoblacion] ;
		int[] indices = new int[tamPoblacion] ;

		int numSeleccionados=0;
	
		Individuo<?>[] individuos=poblacion.getIndivuduos();
		
		//Se seleccionan los individuos que van a ser cruzados
		for(int i=0;i<tamPoblacion;i++) {
			double p=r.nextDouble();
			
			if(p<probCruce) {
				seleccionados[numSeleccionados]=individuos[i].copia();
				indices[numSeleccionados]=i;
				numSeleccionados++;
			}
		}
		
		//Si los seleccionados son impares se reducen 
		if(numSeleccionados%2==1)numSeleccionados--;
		
		for(int i=0;i<numSeleccionados;i+=2) {
			
			cruzar(seleccionados[i],seleccionados[i+1]);
			
			individuos[indices[i]]=seleccionados[i];
			individuos[indices[i+1]]=seleccionados[i+1];
		}
		
	}

	public abstract void  cruzar(Individuo<?> individuo, Individuo<?> individuo2);
	

}
