package FunCruzador;

import java.util.Random;

import Poblacion.Individuo;

public class CruzadorMonoPunto extends Cruzador {

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		Random rand = new Random();
		int lcrom=individuo.getLongitudCromosoma();
        int puntoDeCorte = rand.nextInt(lcrom + 1);

        hijo1.cruzarMonopunto(puntoDeCorte,individuo2);
    	hijo2.cruzarMonopunto(puntoDeCorte,individuo);

    	individuo=hijo1;
 		individuo2=hijo2;
	}

}
