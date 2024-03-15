package FunCruzador;



import Poblacion.Individuo;

public class CruzadorCO extends Cruzador {

	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		
		hijo1.ordinal();
		hijo2.ordinal();
		
		Cruzador mono=new CruzadorMonoPunto();
		mono.cruzar(hijo1, hijo2);
		
	    hijo1.cruzarCO();
		hijo2.cruzarCO();
	}

	
}
