package ppoblacion;
public abstract class Individuo<T> {
	
	 T[] cromosoma;
    protected int[] tamGen;
    protected int[] inicioGen;
    protected double[] min;
    protected double[] max;
    protected double fitness;
    
    public int tamGen(double valorError, double min, double max) {
        return (int) (Math.log10(((max - min) / valorError) + 1) / Math.log10(2));
    }
	public T[] getCromosoma() {
		return cromosoma;
	}
	public void setCromosoma(T[] cromosoma) {
		this.cromosoma = cromosoma;
	}
	public int[] getTamGen() {
		return tamGen;
	}
	public void setTamGen(int[] tamGen) {
		this.tamGen = tamGen;
	}
	public double[] getMin() {
		return min;
	}
	public void setMin(double[] min) {
		this.min = min;
	}
	public double[] getMax() {
		return max;
	}
	public void setMax(double[] max) {
		this.max = max;
	}
	public double getFitness() {
		return fitness;
	}
	public void setIdoniedad(double fitness) {
		this.fitness = fitness;
		
	}
	public int getLongitudCromosoma() {
		// TODO Auto-generate
		return cromosoma.length;
	}
	public abstract void cruzarMonopunto(int puntoCorte, Individuo<?> padre2);
	public abstract void cruzarUniforme(Boolean primero, Boolean[] cruzar, Individuo<?> padre2);
	public abstract void mutarBasico(double probMutac);
	

}
    
   