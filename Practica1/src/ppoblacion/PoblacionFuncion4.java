package ppoblacion;

public class PoblacionFuncion4 extends Poblacion{

	@Override
	public void inicializarIndividuos(int TamPob, double precision, int nDim) {
		// TODO Auto-generated method stub
		individuos = new Individuo<?>[TamPob];
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion4(precision,nDim);
	
		}
	}

}
