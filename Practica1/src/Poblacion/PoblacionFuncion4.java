package Poblacion;

public class PoblacionFuncion4 extends TPoblacion{

	@Override
	public void inicializarIndividuos(int TamPob, double precision, int nDim) {
		// TODO Auto-generated method stub
		individuos = new Individuo<?>[TamPob];
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion4(precision,nDim);
	
		}
	}
	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return true;
	}

}
