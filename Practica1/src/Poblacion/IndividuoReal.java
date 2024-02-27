package Poblacion;

import java.util.Random;

public abstract class IndividuoReal extends Individuo<Double> {

	@Override
	public void cruzarMonopunto(int i, Individuo<?> padre2) {
		Double[] cromosomaPadre=(Double[]) padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}

	}

	@Override
	public void cruzarUniforme(Boolean primero, Boolean[] cruzar, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Double[] cromosomaPadre=(Double[]) padre2.getCromosoma();
		for(int i=0;i<cromosoma.length;i++) {
			if(cruzar[i]==primero) {
				cromosoma[i]=cromosomaPadre[i];
			}
		}
	}

	@Override
	public void mutarBasico(double probMutac) {
		Random r=new Random();
		for(int i=0;i<cromosoma.length;i++) {
			double p=r.nextDouble();
			if(p<probMutac) {
				cromosoma[i]= r.nextDouble() * Math.PI;
			}
		}

	}
	@Override
	public double[] getFenotipoTot() {

		double[] v = new double[cromosoma.length];
		for (int i = 0; i < cromosoma.length; i++)
		{
			v[i] = cromosoma[i].doubleValue();
		}
		return v;
	}
	@Override
	public void cruzarBLXalpha(double max2, double min2) {
		Random random = new Random();
		for (int i = 0; i < cromosoma.length; i++)
		{
			cromosoma[i] = random.nextDouble(min2, max2);
		}
	}
	@Override
	public void cruzarAritmetico(double alpha, Individuo<?> individuo) {

		Double[] cromosoma1 = (Double[]) individuo.getCromosoma();

		for(int i = 0; i < cromosoma.length; i++)
		{
			cromosoma[i] = cromosoma[i]*alpha + cromosoma1[i]*(1-alpha);
		}
	}
}
