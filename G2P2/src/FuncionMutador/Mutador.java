package FuncionMutador;


import java.util.Random;

import Poblacion.Individuo;
import Poblacion.TPoblacion;

public abstract class Mutador {

	public void mutate(TPoblacion poblacion, int tamPoblacion, double probMutac) {

		Individuo<?>[] individuos=poblacion.getIndivuduos();
		Random rand = new Random();
		
		for(int i=0;i<tamPoblacion;i++) {
			if(rand.nextDouble() < probMutac)
				mutar(individuos[i]);
		}
	}

	protected abstract void mutar(Individuo<?> individuo);

}
