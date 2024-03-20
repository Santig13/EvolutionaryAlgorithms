package FuncionMutador;

import java.util.Random;

import Poblacion.Individuo;

public class MutadorIntercambio extends Mutador{

	@Override
	protected void mutar(Individuo<?> individuo) {
		
		Random rand = new Random();
		int pos1 = rand.nextInt(individuo.getLongitudCromosoma());
		int pos2 = rand.nextInt(individuo.getLongitudCromosoma());
	      
		individuo.mutarIntercambio(pos1, pos2);
	}
}
