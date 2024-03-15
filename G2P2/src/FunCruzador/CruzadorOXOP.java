package FunCruzador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Poblacion.Individuo;

public class CruzadorOXOP extends Cruzador {

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		Random rand = new Random();
		ArrayList<Integer> posiciones=new ArrayList<>();
		int lcrom=individuo.getLongitudCromosoma();
   
        for(int i=0;i<4;i++) {
        	posiciones.add(rand.nextInt(lcrom));
        }
        Collections.sort(posiciones);
        hijo1.cruzarOXOP(posiciones,individuo2);
        hijo2.cruzarOXOP(posiciones,individuo);
       
        individuo=hijo1;
        individuo2=hijo2;
	}

}
