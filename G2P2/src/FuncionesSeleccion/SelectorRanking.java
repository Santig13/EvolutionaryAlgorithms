package FuncionesSeleccion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import Poblacion.Individuo;

public class SelectorRanking implements Selector{

	private class Indi_Fit{
		public Individuo<?> indi; //Individuo
		public double fit; //Fitness del individuo
		public double prob;
	}
	
	@Override
	public Individuo<?>[] seleccionar(Individuo<?>[] generacion) {
		
		Indi_Fit [] fit_ind = new Indi_Fit [generacion.length];
		double fitness_total = 0;
		double mayorfitness = Double.MIN_VALUE;
		
        for(int i = 0 ; i < generacion.length; i++)
        {
        	Indi_Fit x = new Indi_Fit();
        	x.fit = generacion[i].getFintess();
            x.indi = generacion[i].copia();
            fit_ind [i] = x;
            fitness_total = fitness_total + fit_ind[i].fit;
            if (fit_ind[i].fit > mayorfitness)
            	mayorfitness = fit_ind[i].fit;
        }
        
        double presionSelec = mayorfitness/(fitness_total/generacion.length);
        
        Arrays.sort(fit_ind, Comparator.comparingDouble(indi_fit -> indi_fit.fit)); //Ordena la lista de forma ascendiente segun los fitness
        
        for(int i = 0 ; i < generacion.length; i++)
        {
        	double p = (double) i/generacion.length ;
        	p *= 2*(presionSelec-1);
        	p = presionSelec - p;
        	p = (double)p * ((double)1/generacion.length);
        	fit_ind[i].prob = p;
        }
        
        //RULETA PERO CON LAS PROBABILIDADES DE RANKING
        Individuo<?>[]NuevaGeneracion = new Individuo[generacion.length];
        Random random = new Random();
        
        for(int i = 0 ; i < generacion.length; i++)
        {
            double numeroAleatorio = random.nextDouble();
            int x = 0;
            double sum = 0;

            while (numeroAleatorio > sum)
            {
                sum = sum + fit_ind[x].prob;
                x++;
            }
            NuevaGeneracion[i] = fit_ind[x-1].indi.copia();
        }

		// TODO Auto-generated method stub
		return NuevaGeneracion;
	}

}
