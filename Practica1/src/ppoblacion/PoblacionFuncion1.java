package ppoblacion;

public class PoblacionFuncion1 extends Poblacion {


	@Override
	public void inicializarIndividuos(int TamPob, double precision) {
		// TODO Auto-generated method stub
		individuos = new Individuo<?>[TamPob];
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion1(precision);
	
		}
	}

	

}
