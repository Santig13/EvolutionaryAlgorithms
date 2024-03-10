package FuncionMutador;

import java.util.Random;

import Poblacion.Individuo;

public class MutadorIntercambio extends Mutador{

	@Override
	protected void mutar(Individuo<?> individuo, double probMutac) {
		
		Random rand = new Random();
		if(rand.nextDouble() < probMutac)
		{
			int pos1 = rand.nextInt(individuo.getLongitudCromosoma());
	        int pos2 = rand.nextInt(individuo.getLongitudCromosoma());
	      
			individuo.mutarIntercambio(pos1, pos2);
		}
		
	}
}
