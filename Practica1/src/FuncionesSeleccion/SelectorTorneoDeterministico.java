package FuncionesSeleccion;

import java.util.Random;

import Poblacion.Individuo;

public class SelectorTorneoDeterministico  implements Selector{

	private int tamTorneo = 2; 
	@Override
	public Individuo<?>[] seleccionar(Individuo<?>[] generacion) {
        Individuo<?>[] nuevaGeneracion = new Individuo<?>[generacion.length];
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
	
	
	int GanadorTorneo (int[] torneo, Individuo<?>[] generacion)
	{
		int ganador = torneo[0];
		for (int i = 1; i < torneo.length ;i++)
		{
			if (generacion[torneo[i]].getFintess() > generacion[ganador].getFintess())
				ganador = torneo[i];
		}
		return ganador;
	}

}
