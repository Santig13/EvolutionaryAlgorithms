package FuncionesSeleccion;

import java.util.Random;

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
	        
	     int seleccionados = 0;
	     Individuo<?>[] nuevaGeneracion = new Individuo<?>[generacion.length];
	     
	     for (int i = 0; i < generacion.length; i++)
	     {
	    	 if (probSeleccion[i] * (generacion.length - seleccionados) > 1)
	    	 {
	    		 nuevaGeneracion[seleccionados] = generacion[seleccionados].copia();
	    	 }
	     }
	     
	     
	     int restantes = generacion.length - seleccionados;
	     // LOS QUE QUEDAN LOS HACEMOS CON RULETA
	     
	     Random random = new Random();


	        for(int i = 0 ; i < restantes; i++)
	        {
	            double numeroAleatorio = random.nextDouble();
	            int x = 0;
	            double sum = 0; 
	            while (numeroAleatorio > sum)
	            {
	                sum = sum + probSeleccion[x];
	                x++;
	            }
	            nuevaGeneracion[seleccionados] = generacion[x-1].copia();
	            seleccionados++;
	        }        

	        
		return nuevaGeneracion;
	}

}
