package Mutadores;

import Individuo.Individuo;
import Individuo.IndividuoArbolGenetico;

public class MutadorArbol_SubArbol extends Mutador {

	@Override
	protected void mutar(Individuo individuo) {
		// TODO Auto-generated method stub
		((IndividuoArbolGenetico) individuo).mutacionArbolSubArbol();
		
	}

	

}
