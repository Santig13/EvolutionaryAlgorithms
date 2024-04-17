package Cruzadores;

import Individuo.Individuo;
import Individuo.IndividuoArbolGenetico;

public class CruceSubarbol extends Cruzador{

	
	

	@Override
	public void cruzar(Individuo individuo, Individuo individuo2) {
		
		individuo.cruceSubArbol1(individuo2);
		
		
	}

}
