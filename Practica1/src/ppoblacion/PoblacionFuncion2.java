package ppoblacion;

public class PoblacionFuncion2 extends Poblacion {

	@Override
	public void inicializarIndividuos(int TamPob, double precision, int nDim) {
		// TODO Auto-generated method stub
		individuos = new Individuo<?>[TamPob];
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion2(precision);
	
		}
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
