package Selectores;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import Individuo.Individuo;
import Individuo.PuntuacionComparator;



public class SelectorRanking implements Selector{

	
	static private final double _beta = 1.5;

	@Override
	public Individuo[]  seleccionar(Individuo[]  generacion) {
		Arrays.sort(generacion,new PuntuacionComparator());
		rankingPunctuation(generacion);
		
		Selector ruleta = new SelectorRuleta();
		return ruleta.seleccionar(generacion);
	}
	

	private void rankingPunctuation(Individuo[] pop) {

			for (int i = 0; i < pop.length; ++i) {
				double probOfIth = (double)i/pop.length;
				probOfIth *= 2*(_beta-1);
				probOfIth = _beta - probOfIth;
				probOfIth = (double)probOfIth * ((double)1/pop.length);
				
				pop[i].setPuntuacion(probOfIth);
				
			}
		}
		
}
