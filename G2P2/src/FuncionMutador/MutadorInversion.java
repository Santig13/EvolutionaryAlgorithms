package FuncionMutador;

import java.util.Random;

import Poblacion.Individuo;

public class MutadorInversion extends Mutador{

	@Override
	protected void mutar(Individuo<?> individuo, double probMutac) {
		
		Random rand = new Random();
		if(rand.nextDouble() < probMutac)
		{
			int pos1 = rand.nextInt(individuo.getLongitudCromosoma());
			int pos2 = rand.nextInt(individuo.getLongitudCromosoma());
			if (pos1 < pos2)
				individuo.mutarInversion(pos1, pos2);
			else
				individuo.mutarInversion(pos2, pos1);

		}
		
	}

}
