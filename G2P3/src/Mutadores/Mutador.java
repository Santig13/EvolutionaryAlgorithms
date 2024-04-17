package Mutadores;


import java.util.Random;

import Individuo.Individuo;
import Individuo.TPoblacion;

public abstract class Mutador {

	public void mutate(TPoblacion poblacion, int tamPoblacion, double probMutac) {

		Individuo[] individuos=poblacion.getIndivuduos();
		Random rand = new Random();
		
		for(int i=0;i<tamPoblacion;i++) {
			if(rand.nextDouble() < probMutac) {
				mutar(individuos[i]);
				individuos[i].reset();
			}
				
		}
	}

	protected abstract void mutar(Individuo individuo);

}
