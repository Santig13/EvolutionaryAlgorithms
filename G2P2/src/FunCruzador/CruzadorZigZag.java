package FunCruzador;

import Poblacion.Individuo;

public class CruzadorZigZag extends Cruzador {

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();
		hijo1.cruzarZigZag(individuo2,true);
		hijo2.cruzarZigZag(individuo,false);
	
       individuo=hijo1;
	   individuo2=hijo2;
	}

}
