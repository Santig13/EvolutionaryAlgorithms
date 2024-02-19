package Poblacion;
public class Individuo<T>{
	
	 T[] cromosoma;
    protected int[] tamGen;
    protected int[] inicioGen;
    protected double[] min;
    protected double[] max;
    protected double idoniedad;
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
	public double getIdoniedad() {
		return idoniedad;
	}
	public void setIdoniedad(double idoniedad) {
		this.idoniedad = idoniedad;
	}
    
}
    
   