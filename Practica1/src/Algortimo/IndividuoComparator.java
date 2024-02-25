package Algortimo;

import java.util.Comparator;

import ppoblacion.Individuo;

public class IndividuoComparator implements Comparator<Individuo<?>> {

	@Override
	public int compare(Individuo<?> o1, Individuo<?> o2) {
		int sol=-1;
		if(o1.getFitness()==o2.getFitness())sol=0;
		else if(o1.getFitness()>o2.getFitness())sol=1;
		return sol;
	}

}
