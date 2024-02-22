package ppoblacion;

public abstract class Poblacion {
	public abstract void inicializarIndividuos(int TamPob);
	
	protected Individuo<?>[] individuos;
	public Individuo<?>[] getIndivuduos() {
		return individuos;
	}

	public void setNuevaPoblacion(Individuo<?>[] nuevaPob) {
		this.individuos=nuevaPob;

	}
}
