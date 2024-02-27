package Poblacion;

public class PoblacionFuncion5 extends TPoblacion {
	@Override
	public void inicializarIndividuos(int TamPob, double precision, int nDim) {
		// TODO Auto-generated method stub
		individuos = new Individuo<?>[TamPob];
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion5(nDim);

		}
	}
	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return true;
	}
}
