package ppoblacion;

public interface Poblacion {
	public void inicializarIndividuos(int TamPob);
	public Individuo<?>[] getIndivuduos();
	public void setNuevaPoblacion(Individuo<?>[] nuevaPob);
}
