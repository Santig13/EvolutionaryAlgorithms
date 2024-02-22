package FuncionesSeleccion;

import ppoblacion.Individuo;

public class SelectorRestos  implements Selector{ //POR TERMINAR

	@Override
	public Individuo<?>[] seleccionar(Individuo<?>[] generacion) {
		
		 double [] fitness = new double [generacion.length];

	     double fitness_total = 0;


	     for(int i = 0 ; i < generacion.length; i++)
	     {
	         fitness[i] = generacion[i].getFitness();
	         fitness_total = fitness_total + fitness[i];
	     }
	        
	     double [] probSeleccion = new double [generacion.length];

	     for(int i = 0 ; i < generacion.length; i++)
	     {
	         probSeleccion[i] = fitness[i] / fitness_total;
	     }
	        
	        
		return null;
	}

}
