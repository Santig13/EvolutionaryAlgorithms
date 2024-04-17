package Iniciadores;

import Individuo.IndividuoArbolGenetico;
import Individuo.TPoblacion;

public class IniciadorCompleta extends Iniciador{

	@Override
	public void IniciarPoblacion(TPoblacion poblacion) {
		// TODO Auto-generated method stub
		IndividuoArbolGenetico[] individuos= poblacion.getIndivuduos();
		for(IndividuoArbolGenetico indv:individuos) {
			indv.inicializacionCompleta();
		}
	}

}
