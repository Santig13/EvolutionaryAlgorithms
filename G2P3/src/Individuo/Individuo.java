package Individuo;

import Individuo.IndividuoArbolGenetico.nodo;
import Individuo.TJardin.Casillas;

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

	public  void cruceSubArbol1(Individuo individuo2) {};
	
	public abstract void reset();
	public abstract Casillas[][] getJardin();
	public int getTamanio() {
		
		return 0;
	}
	
	public int getLongitudCromosoma() {
		return 0;
	}
	public void cruzarUniforme(Boolean[] cruzar, Individuo individuo2) {}
	public void cruzarMonopunto(int puntoDeCorte, Individuo individuo) {}
	public int[] getCromosoma() {return null;}
	public void mutarBasico() {	}
	

    
    
}
