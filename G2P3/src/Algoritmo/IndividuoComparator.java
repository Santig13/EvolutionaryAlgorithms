package Algoritmo;

import java.util.Comparator;

import Individuo.IndividuoArbolGenetico;


public class IndividuoComparator implements Comparator<IndividuoArbolGenetico> {

	@Override
	public int compare(IndividuoArbolGenetico o1, IndividuoArbolGenetico o2) {
		return Double.compare(o1.getFintess(), o2.getFintess());
	}

}
