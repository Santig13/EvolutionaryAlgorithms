package FuncionMutador;

import Poblacion.Individuo;

public class MutadorFibonacci extends Mutador {

	@Override
	protected void mutar(Individuo<?> individuo) {
		// TODO Auto-generated method stub
		individuo.mutarFibonacci();
	}

}
