package ppoblacion;

public class PoblacionFuncion1 extends Poblacion {


	@Override
	public void inicializarIndividuos(int TamPob) {
		// TODO Auto-generated method stub
		for(int i=0;i<TamPob;i++) {
			individuos[i]=new IndividuoFuncion1();
	
		}
	}

	

}
