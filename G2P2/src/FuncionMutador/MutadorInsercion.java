package FuncionMutador;

import java.util.Random;

import Poblacion.Individuo;

public class MutadorInsercion extends Mutador {

	@Override
	protected void mutar(Individuo<?> individuo, double probMutac) {

		int N = individuo.getLongitudCromosoma();
		Random rand = new Random();
		int pos = rand.nextInt(N);
		int poselem = rand.nextInt(N);
 
		individuo.mutarInsercion(pos,poselem);
	}

}