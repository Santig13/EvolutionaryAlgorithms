package Factorias;

import Individuo.*;


public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	

	
	@Override
	public TPoblacion generarPoblacion(int profundidad, int tamPoblacion) {
		 IndividuoArbolGenetico[] individuos= new IndividuoArbolGenetico[tamPoblacion];
		 for(int i=0;i<tamPoblacion;i++) {
			 individuos[i]=new IndividuoCortaCesped(profundidad);
		 }
		 return new TPoblacion(individuos, false);
	}
}


