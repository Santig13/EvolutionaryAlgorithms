package FunCruzador;

import Poblacion.Individuo;

public class CruzadorAritmetico extends Cruzador{

	double alpha = 0.6;

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		hijo1.cruzarAritmetico(alpha,individuo2);
		hijo2.cruzarAritmetico(alpha,individuo);


	}

}
