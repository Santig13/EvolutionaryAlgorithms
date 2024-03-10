package Algortimo;

import java.util.Comparator;

import Poblacion.Individuo;

public class IndividuoComparator implements Comparator<Individuo<?>> {

	@Override
	public int compare(Individuo<?> o1, Individuo<?> o2) {
		return Double.compare(o1.getFintess(), o2.getFintess());
	}

}
