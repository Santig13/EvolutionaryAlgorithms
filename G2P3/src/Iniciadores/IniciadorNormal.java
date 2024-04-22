package Iniciadores;

import Individuo.IndividuoGramatical;
import Individuo.TPoblacion;

public class IniciadorNormal extends Iniciador{

	@Override
	public void IniciarPoblacion(TPoblacion poblacion, int profundidad) {
		IndividuoGramatical[] individuos= (IndividuoGramatical[]) poblacion.getIndivuduos();
		for(IndividuoGramatical indv:individuos) {
			indv.inicializacion();
		}
		
	}

}
