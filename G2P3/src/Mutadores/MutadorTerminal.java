package Mutadores;

import Individuo.IndividuoArbolGenetico;

public class MutadorTerminal extends Mutador {

	@Override
	protected void mutar(IndividuoArbolGenetico individuo) {
		// TODO Auto-generated method stub
		individuo.mutacionTerminal();
	}

}
