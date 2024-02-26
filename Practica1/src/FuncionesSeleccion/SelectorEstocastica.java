package FuncionesSeleccion;

import java.util.Random;

import ppoblacion.Individuo;
public class SelectorEstocastica implements Selector {

	@Override
	public Individuo<?>[] seleccionar( Individuo<?>[]  generacion) {
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
        }

        Random random = new Random();

        Individuo<?>[] nuevaGeneracion = new Individuo<?>[generacion.length];

		double n = 1/generacion.length;

        for(int i = 1; i <= generacion.length; i++)
        {
            int x = 0;
            double sum = 0; 
            while (n*i < sum)
            {
                sum = sum + probSeleccion[x];
                x++;
            }
            nuevaGeneracion[i-1] = generacion[x].copia();
             
        }        
        

      return nuevaGeneracion;        
	
	}

}
