package FuncionMutador;

import java.util.ArrayList;
import java.util.Random;

import Poblacion.Individuo;

public class MutadorHeuristica extends Mutador{

	private int n = 3;
	@Override
	protected void mutar(Individuo<?> individuo) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		//SELECCION DE LAS N POSICIONES
		Boolean[] seleccionado = new Boolean[individuo.getLongitudCromosoma()];
		int[]posSelec = new int[n];
		for(int i = 0 ; i < individuo.getLongitudCromosoma(); i++)
			seleccionado[i]=false;
		int i = 0;
		while(i < n)
		{
			int pos = rand.nextInt(individuo.getLongitudCromosoma());
			if (!seleccionado[pos]) {
				seleccionado[pos] = true;
				posSelec[i]=pos;
				i++;
			}
		}
		
		
		individuo.mutarHeuristica(posSelec);
		
		
		
	}
	


}
