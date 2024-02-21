package FuncionesSeleccion;

import ppoblacion.Individuo;

public interface Selector {

	public Individuo<?>[]  seleccionar(Individuo<?>[]  generacion);

}
