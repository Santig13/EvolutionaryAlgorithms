package Poblacion;

import java.util.Random;

public abstract class IndividuoReal extends Individuo<Double> {


	@Override
	public double[] getFenotipoTot() {

		double[] v = new double[cromosoma.length];
		for (int i = 0; i < cromosoma.length; i++)
		{
			v[i] = cromosoma[i].doubleValue();
		}
		return v;
	}
	
}
