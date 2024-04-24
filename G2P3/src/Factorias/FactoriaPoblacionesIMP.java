package Factorias;

import Individuo.*;


public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	

	
	@Override
	public TPoblacion generarPoblacion( int tamPoblacion, String tIndividuo,int wraps,Boolean funAgregadas) {
		 
		if (tIndividuo == "Programacion Genetica")
		{
			IndividuoArbolGenetico[] individuos= new IndividuoArbolGenetico[tamPoblacion];
			 for(int i=0;i<tamPoblacion;i++) {
				 individuos[i]=new IndividuoCortaCesped(funAgregadas);
			 }
			 return new TPoblacion(individuos, false);
		}
		else
		{
			IndividuoGramatical[] individuos= new IndividuoGramatical[tamPoblacion];
			 for(int i=0;i<tamPoblacion;i++) {
				 individuos[i]=new IndividuoGramatical(wraps);
			 }
			 return new TPoblacion(individuos, false);
		}
		
		
	}
}


