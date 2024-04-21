package Selectores;

import java.util.Arrays;
import java.util.Random;

import Individuo.Individuo;
import Individuo.PuntuacionComparator;



public class SelectorRuleta implements Selector{



	@Override
	public Individuo[]  seleccionar(Individuo[]  generacion){
        double [] probSeleccion = new double [generacion.length];

        Arrays.sort(generacion,new PuntuacionComparator());
        for(int i = 0 ; i < generacion.length; i++)
        {
        	 probSeleccion[i] = generacion[i].getPuntuacion();
        }

        Random random = new Random();

        Individuo []NuevaGeneracion = new Individuo[generacion.length];

        for(int i = 0 ; i < generacion.length; i++)
        {
            double numeroAleatorio = random.nextDouble();
            int x = 0;
            double sum = 0;

            while (numeroAleatorio > sum && x<generacion.length)
            {
                sum = sum + probSeleccion[x];
                x++;
            }
            NuevaGeneracion[i] = generacion[x-1].copia();
        }


       return NuevaGeneracion;
	}


}
