package Iniciadores;

import Individuo.IndividuoArbolGenetico;
import Individuo.TPoblacion;

public class IniciadorCreciente extends Iniciador{

	@Override
	public void IniciarPoblacion(TPoblacion poblacion,int profundidad) {
		// TODO Auto-generated method stub
		IndividuoArbolGenetico[] individuos= (IndividuoArbolGenetico[]) poblacion.getIndivuduos();
		for(IndividuoArbolGenetico indv:individuos) {
			indv.inicializacionCreciente(profundidad);
		}
	}



}
