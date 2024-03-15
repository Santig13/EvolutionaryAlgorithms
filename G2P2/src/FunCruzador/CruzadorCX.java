package FunCruzador;

import java.util.Random;

import Poblacion.Individuo;

public class CruzadorCX extends Cruzador {

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

        hijo1.cruzarCX(individuo2);
        hijo2.cruzarCX(individuo);
       
        individuo=hijo1;
        individuo2=hijo2;
	}

}
