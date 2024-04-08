package Mutadores;


import java.util.Random;

import Individuo.IndividuoArbolGenetico;

public abstract class Mutador {

	public void mutate(Individuo.TPoblacion poblacion, int tamPoblacion, double probMutac) {

		IndividuoArbolGenetico[] individuos=poblacion.getIndivuduos();
		Random rand = new Random();
		
		for(int i=0;i<tamPoblacion;i++) {
			if(rand.nextDouble() < probMutac)
				mutar(individuos[i]);
		}
	}

	protected abstract void mutar(IndividuoArbolGenetico individuo);

}
