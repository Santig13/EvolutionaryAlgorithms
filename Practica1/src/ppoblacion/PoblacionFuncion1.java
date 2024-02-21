package ppoblacion;

public class PoblacionFuncion1 implements Poblacion {

	private Individuo<?>[] individuos;
	@Override
	public void inicializarIndividuos(int TamPob) {
		// TODO Auto-generated method stub
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion1();
	
		}
	}

	@Override
	public Individuo<?>[] getIndivuduos() {
		// TODO Auto-generated method stub
		return individuos;
	}

	@Override
	public void setNuevaPoblacion(Individuo<?>[] nuevaPob) {
		this.individuos=nuevaPob;

	}

}
