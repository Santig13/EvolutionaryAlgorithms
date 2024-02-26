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
			sum = sum + x.evalua();
		}
		sum = sum / individuos.length;
		
		return sum;
	}

	public double getBestFitness() {
		double mejor = 0;
		for (Individuo x : individuos)
		{
			if (x.evalua() > mejor)
				mejor = x.evalua();
		}
		return mejor;
	}

	public  Individuo<?> getCopiaIndivuduo(int i){
		if(i>=individuos.length)return null;
		return individuos[i].copia();
	}

	public void swap(int i, Individuo<?> individuo) {
		// TODO Auto-generated method stub
		individuos[i]=individuo;
	}

	public abstract boolean isMin();
}
