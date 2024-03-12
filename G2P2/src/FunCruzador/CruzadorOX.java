package FunCruzador;

import java.util.Random;

import Poblacion.Individuo;

public class CruzadorOX extends Cruzador{

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
				Individuo<?> hijo1=individuo.copia();
				Individuo<?> hijo2=individuo2.copia();

				Random rand = new Random();
				int lcrom=individuo.getLongitudCromosoma();
		        int puntoDeCorte1 = rand.nextInt(lcrom + 1);
		        int puntoDeCorte2 = rand.nextInt(lcrom + 1);

		        // Garantizar que puntoDeCorte1 sea diferente de puntoDeCorte2
		        while (puntoDeCorte1 == puntoDeCorte2) {
		            puntoDeCorte2 = rand.nextInt(lcrom);
		        }

		        // Garantizar que puntoDeCorte1 sea menor que puntoDeCorte2
		        if (puntoDeCorte1 > puntoDeCorte2) {
		            int temp = puntoDeCorte1;
		            puntoDeCorte1 = puntoDeCorte2;
		            puntoDeCorte2 = temp;
		        }
		        hijo1.cruzarOX(puntoDeCorte1,puntoDeCorte2,individuo2);
		        hijo2.cruzarOX(puntoDeCorte1,puntoDeCorte2,individuo);
		       
		        individuo=hijo1;
		        individuo2=hijo2;
		
	}

}
