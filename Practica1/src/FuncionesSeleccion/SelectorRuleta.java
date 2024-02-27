package FuncionesSeleccion;

import java.util.Random;

import Poblacion.Individuo;

public class SelectorRuleta implements Selector{

    

	@Override
	public Individuo<?>[]  seleccionar(Individuo<?>[]  generacion) {
        
      
        double [] fitness = new double [generacion.length];

        double fitness_total = 0;
/*
        for(int i = 0 ; i < generacion.length; i++)
        {
            fitness[i] = generacion[i].evalua();
            fitness_total = fitness_total + fitness[i];
        }
        */
        double [] probSeleccion = new double [generacion.length];

        for(int i = 0 ; i < generacion.length; i++)
        {
        	 probSeleccion[i] = generacion[i].getPuntuacion();
        	//probSeleccion[i] = fitness[i] / fitness_total;
        }

        Random random = new Random();

        Individuo<?>[]NuevaGeneracion = new Individuo[generacion.length];

        for(int i = 0 ; i < generacion.length; i++)
        {
            double numeroAleatorio = random.nextDouble();
            int x = 0;
            double sum = 0; 
            
            while (numeroAleatorio > sum)
            {
                sum = sum + probSeleccion[x];
                x++;
            }
            NuevaGeneracion[i] = generacion[x-1].copia();
        }        
        

       return NuevaGeneracion;        
	}


}
