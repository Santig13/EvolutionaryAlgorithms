package Selectores;

import Individuo.IndividuoArbolGenetico;

public interface Selector {

	public IndividuoArbolGenetico[]  seleccionar(IndividuoArbolGenetico[]  generacion);

}
