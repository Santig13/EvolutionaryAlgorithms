package FuncionMutador;


import Poblacion.Individuo;
import Poblacion.TPoblacion;

public abstract class Mutador {

	public void mutate(TPoblacion poblacion, int tamPoblacion, double probMutac) {

		Individuo<?>[] individuos=poblacion.getIndivuduos();

		for(int i=0;i<tamPoblacion;i++) {
			mutar(individuos[i],probMutac);
		}
	}

	protected abstract void mutar(Individuo<?> individuo, double probMutac);

}
