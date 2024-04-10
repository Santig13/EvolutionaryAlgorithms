package Selectores;

import java.util.Random;

import Individuo.Individuo;



public class SelectorTorneoProbabilistico  implements Selector{
	private int tamTorneo = 2;
	private double p = 0.5;

	@Override
	public Individuo[]  seleccionar(Individuo[]  generacion){
		  Individuo[] nuevaGeneracion = new Individuo[generacion.length];
			int seleccionados = 0;


			while (seleccionados != generacion.length)
			{
				int[] torneo = SeleccionIndividuosTorneo(generacion.length);
				int ganador = GanadorTorneo(torneo, generacion);
				nuevaGeneracion[seleccionados] = generacion[ganador].copia();
				seleccionados++;
			}


			return nuevaGeneracion;
	}

	int[] SeleccionIndividuosTorneo(int tam)
	{
		int[] torneo = new int[tamTorneo]; //Un array de posiciones de los individuos que participan en el torneo
		int nseleccionados = 0;
		Random random = new Random();

		while(nseleccionados != tamTorneo)
		{
			int i = random.nextInt(tam); //Escojo un individuo al azar
			torneo[nseleccionados] = i;
			nseleccionados++;
		}

		return torneo;

	}


	int GanadorTorneo (int[] torneo, Individuo[] generacion)
	{

		Random random = new Random();
		int ganador = torneo[0];
		if (random.nextDouble() > p)
		{

			for (int i = 1; i < torneo.length ;i++)
			{
				if (generacion[torneo[i]].getFitness() > generacion[ganador].getFitness())
					ganador = torneo[i];
			}
		}
		else
		{
			for (int i = 1; i < torneo.length ;i++)
			{
				if (generacion[torneo[i]].getFitness() < generacion[ganador].getFitness())
					ganador = torneo[i];
			}
		}
		return ganador;


	}

}
