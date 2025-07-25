package FunCruzador;

import Poblacion.Individuo;

public class CruzadorBLXa extends Cruzador {

	double alpha = 0.6;
	@Override
	public void cruzar(Individuo<?> individuo, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		Individuo<?> hijo1=individuo.copia();
		Individuo<?> hijo2=individuo2.copia();

		Double[] cromosoma1 = (Double[]) hijo1.getCromosoma();
		Double[] cromosoma2 = (Double[]) hijo2.getCromosoma();

		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;

		for (int i = 0; i < cromosoma1.length; i++)
		{
			max=Math.max(max, cromosoma1[i]);
			max=Math.max(max, cromosoma2[i]);

			min=Math.min(min, cromosoma1[i]);
			min=Math.min(min, cromosoma2[i]);
		}

		double I = max - min;
		max = max + I*alpha;
		min = min - I*alpha;

		hijo1.cruzarBLXalpha(max,min);
		hijo2.cruzarBLXalpha(max,min);

		individuo=hijo1;
 		individuo2=hijo2;
	}

}
