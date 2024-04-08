package Individuo;

public abstract class Individuo {
	
    protected double fitness;
    protected double puntuacion;
    
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public abstract double evalua();
	public abstract Individuo copia();
    
    
}
