package FuncionMutador;


import ppoblacion.Individuo;
import ppoblacion.Poblacion;

public abstract class Mutador {

	public void mutate(Poblacion poblacion, int tamPoblacion, double probMutac) {
		
		Individuo<?>[] individuos=poblacion.getIndivuduos();
		
		for(int i=0;i<tamPoblacion;i++) {
			mutar(individuos[i],probMutac);			
		}
		poblacion.setNuevaPoblacion(individuos);
	}

	protected abstract void mutar(Individuo<?> individuo, double probMutac);

}
