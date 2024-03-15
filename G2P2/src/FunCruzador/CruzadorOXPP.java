package FunCruzador;

import java.util.Random;

import Poblacion.Individuo;

public class CruzadorOXPP extends Cruzador{

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
				Individuo<?> hijo1=individuo.copia();
				Individuo<?> hijo2=individuo2.copia();

				Random rand = new Random();
				int lcrom=individuo.getLongitudCromosoma();
		        int posP1 = rand.nextInt(lcrom);
		        int posP2 = rand.nextInt(lcrom);

		        // Garantizar que puntoDeCorte1 sea diferente de puntoDeCorte2
		        while (posP1 == posP2) {
		            posP2 = rand.nextInt(lcrom);
		        }

		        // Garantizar que puntoDeCorte1 sea menor que puntoDeCorte2
		        if (posP1 > posP2) {
		            int temp = posP1;
		            posP1 = posP2;
		            posP2 = temp;
		        }
		        hijo1.cruzarOXPP(posP1,posP2,individuo2);
		        hijo2.cruzarOXPP(posP1,posP2,individuo);
		       
		        individuo=hijo1;
		        individuo2=hijo2;
		
	}

}
