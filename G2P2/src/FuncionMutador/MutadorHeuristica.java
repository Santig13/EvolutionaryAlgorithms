package FuncionMutador;

import java.util.ArrayList;
import java.util.Random;

import Poblacion.Individuo;

public class MutadorHeuristica extends Mutador{

	private int n = 3;
	@Override
	protected void mutar(Individuo<?> individuo, double probMutac) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		//SELECCION DE LAS N POSICIONES
		Boolean[] seleccionado = new Boolean[individuo.getLongitudCromosoma()];
		int[]posSelec = new int[n];
		for(int i = 0 ; i < individuo.getLongitudCromosoma(); i++)
			seleccionado[i]=false;
		
		for(int i = 0; i < n; i++)
		{
			int pos = rand.nextInt(individuo.getLongitudCromosoma());
			if (seleccionado[pos]) {
				i--;
			}
			else
			{
				posSelec[i]=pos;
			}
		}
		
		
		individuo.mutarHeuristica(posSelec);
		
		
		
	}
	


}
