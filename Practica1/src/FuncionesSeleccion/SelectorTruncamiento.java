package FuncionesSeleccion;


import java.util.Arrays;
import java.util.Comparator;

import ppoblacion.Individuo;

public class SelectorTruncamiento implements Selector{
	
	 //Para este metodo de selección tenemos que ordenar la lista de individuos segun el fitness. Para hacer esto hemos creado una subclase donde guardamos
	// tanto al individuo como su fitness. De este modo evitamos tener dos listas que ordenar.
	private class Indi_Fit{
		public Individuo<?> indi; //Individuo
		public double fit; //Fitness del individuo
	}

	double trunc = 0.5 ;
	
	@Override
	public Individuo<?>[] seleccionar(Individuo<?>[] generacion) {
		
		Indi_Fit [] fit_ind = new Indi_Fit [generacion.length];
		

	        double fitness_total = 0;

	        for(int i = 0 ; i < generacion.length; i++)
	        {
	            fit_ind[i].fit = generacion[i].getFitness();
	            fit_ind[i].indi = generacion[i];
	            fitness_total = fitness_total + fit_ind[i].fit;
	        }
	        
	        
	        Arrays.sort(fit_ind, Comparator.comparingDouble(indi_fit -> -indi_fit.fit)); //Ordena la lista de forma descendiente segun los fitness

	        	
	        int nSeleccionados = (int) (generacion.length * trunc);
	      //El el tamaño de las generaciones tiene que ser multiplo de trunc*10 porq sino podria reducir el tamaño de la poblacion en la siguiente operacion
	        int vecesRep = (int) (generacion.length/(generacion.length*trunc)); 
	        
	        Individuo<?>[] nuevaGeneracion = new Individuo<?>[nSeleccionados];
	        
	        for (int i = 0; i < nSeleccionados; i++) {
	        	for (int j = 0; j<vecesRep; j++)
	        		nuevaGeneracion[i] = fit_ind[i].indi;
	        }

	        return nuevaGeneracion;
	}

}
