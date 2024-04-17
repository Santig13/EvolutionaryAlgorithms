package Mutadores;

import Individuo.Individuo;
import Individuo.IndividuoArbolGenetico;

public class MutadorInicializador extends Mutador {

	@Override
	protected void mutar(Individuo individuo) {
		// TODO Auto-generated method stub
		((IndividuoArbolGenetico) individuo).mutacionFuncinal();
	}

}
