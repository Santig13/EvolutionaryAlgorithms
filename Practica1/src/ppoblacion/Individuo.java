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
		for(int i = 0; i < cromosoma.length;i++) {
			this.cromosoma[i] = cromosoma[i];
		}
	}
	public abstract double getFitness();
	
	public int getLongitudCromosoma() {
		// TODO Auto-generate
		return cromosoma.length;
	}
	
	public abstract double[] getFenotipoTot();
	
	public abstract void cruzarMonopunto(int puntoCorte, Individuo<?> padre2);
	public abstract void cruzarUniforme(Boolean primero, Boolean[] cruzar, Individuo<?> padre2);
	public abstract void mutarBasico(double probMutac);
	public abstract Individuo<?> copia();
	@Override
	public String toString() {
		return "Valor optimo ("+ getFitness()+")"+fenotipoToString();
		
	}
	protected abstract String fenotipoToString();

}
    
   