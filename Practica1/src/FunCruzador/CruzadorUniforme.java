package FunCruzador;

import java.util.Random;

import Poblacion.Individuo;

public class CruzadorUniforme extends Cruzador{

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		Random rand = new Random();
		int lcrom=individuo.getLongitudCromosoma();
		Boolean[] cruzar=new Boolean[lcrom];

		for(int i=0;i<lcrom;i++) {
			if(rand.nextDouble()<0.5)cruzar[i]=true;
			else cruzar[i]=false;
		}

        hijo1.cruzarUniforme(true,cruzar,individuo2);
    	hijo2.cruzarUniforme(false,cruzar,individuo);

    	individuo=hijo1;
 		individuo2=hijo2;

	}

}
