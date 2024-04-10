package Selectores;

import java.util.Random;

import Individuo.Individuo;



public class SelectorRestos  implements Selector{ //POR TERMINAR

	@Override
	public Individuo[]  seleccionar(Individuo[]  generacion) {

	  
	     double [] probSeleccion = new double [generacion.length];

	     for(int i = 0 ; i < generacion.length; i++)
	     {
	       //  probSeleccion[i] = fitness[i] / fitness_total;
	    	 probSeleccion[i] = generacion[i].getPuntuacion();
	     }

	     int seleccionados = 0;
	     Individuo[] nuevaGeneracion = new Individuo[generacion.length];

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
