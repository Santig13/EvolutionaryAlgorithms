package ppoblacion;

public abstract class Poblacion {
	public abstract void inicializarIndividuos(int TamPob, double precision, int nDim);
	
	protected Individuo<?>[] individuos;
	public Individuo<?>[] getIndivuduos() {
		return individuos;
	}

	public void setNuevaPoblacion(Individuo<?>[] nuevaPob) {
		this.individuos=nuevaPob;

	}

	public double getFitnessAvg() {
		double sum = 0;
		for (Individuo x : individuos)
		{
			sum = sum + x.getFitness();
		}
		sum = sum / individuos.length;
		
		return sum;
	}

	public double getBestFitness() {
		double mejor = 0;
		for (Individuo x : individuos)
		{
			if (x.getFitness() > mejor)
				mejor = x.getFitness();
		}
		return mejor;
	}
}
