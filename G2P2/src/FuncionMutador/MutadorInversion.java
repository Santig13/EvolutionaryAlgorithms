package FuncionMutador;

import java.util.Random;

import Poblacion.Individuo;

public class MutadorInversion extends Mutador{

	@Override
	protected void mutar(Individuo<?> individuo) {
		
		Random rand = new Random();
	
		int pos1 = rand.nextInt(individuo.getLongitudCromosoma()-3);
		individuo.mutarInversion(pos1, pos1+3);

		
		
	}

}
