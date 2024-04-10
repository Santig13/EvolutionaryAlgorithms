package Mutadores;

import Individuo.IndividuoArbolGenetico;

public class MutadorArbol_SubArbol extends Mutador {

	@Override
	protected void mutar(IndividuoArbolGenetico individuo) {
		// TODO Auto-generated method stub
		individuo.mutacionArbolSubArbol();

	}

}
