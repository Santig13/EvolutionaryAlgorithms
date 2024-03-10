package Poblacion;
public abstract class Individuo<T> {

	 T[] cromosoma;
    protected int[] tamGen;
    protected int[] inicioGen;
    protected double[] min;
    protected double[] max;
    protected double fitness;
    protected double puntuacion;

    public double getPuntuacion() {
		return puntuacion;
	}
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
	public abstract double evalua();

	public int getLongitudCromosoma() {
		// TODO Auto-generate
		return cromosoma.length;
	}

	public abstract double[] getFenotipoTot();

	/*public abstract void cruzarMonopunto(int puntoCorte, Individuo<?> padre2);
	public abstract void cruzarUniforme(Boolean[] cruzar, Individuo<?> padre2);
	public abstract void mutarBasico(double probMutac);*/
	public abstract Individuo<?> copia();
	@Override
	public String toString() {
		return "Valor optimo ("+ evalua()+")"+fenotipoToString();

	}
	protected abstract String fenotipoToString();
	public void setPuntuacion(double d) {
		this.puntuacion=d;

	}
	public void setFitness(double aux) {
		// TODO Auto-generated method stub
		this.fitness=aux;
	}
	public Double getFintess() {
		// TODO Auto-generated method stub
		return fitness;
	}
	public void cruzarBLXalpha(double max2, double min2) {
		//SOLO PARA LOS INDIVIDUOS DE LA FUNCION 5
	}
	public void cruzarAritmetico(double alpha, Individuo<?> individuo2) {
		//SOLO PARA LOS INDIVIDUOS DE LA FUNCION 5

	}
	public  void cruzarPMX(int puntoDeCorte1, int puntoDeCorte2, Individuo<?> individuo2) {
		
	}
	public void cruzarOX(int puntoDeCorte1, int puntoDeCorte2, Individuo<?> individuo2) {
		// TODO Auto-generated method stub
		
	}
	public abstract void mutarInsercion(int pos, int elem);
	public abstract void mutarIntercambio(int pos1, int pos2);
	public abstract void mutarInversion(int pos1, int pos2);

}

