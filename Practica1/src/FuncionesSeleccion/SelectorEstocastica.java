package FuncionesSeleccion;

import java.util.Random;

import Poblacion.Individuo;
public class SelectorEstocastica implements Selector {

	@Override
	public Individuo<?>[] seleccionar( Individuo<?>[]  generacion) {
        //double [] fitness = new double [generacion.length];

       // double fitness_total = 0;
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

		 
		double min = 0;
		double max = 1.0 /generacion.length;
        double a = random.nextDouble(min, max);


        for(int i = 0; i < generacion.length; i++)
        {
            int x = -1;
            double pointer = (a + (i+1.0) - 1.0)/generacion.length;
            
            double sum = 0; 
            while (pointer > sum)
            {
                x++;
                sum = sum + probSeleccion[x];
            }
            
           
            nuevaGeneracion[i] = generacion[x].copia();
             
        }        
        

      return nuevaGeneracion;        
	
	}

}
