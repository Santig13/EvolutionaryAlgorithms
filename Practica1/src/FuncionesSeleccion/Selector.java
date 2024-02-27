package FuncionesSeleccion;

import Poblacion.Individuo;

public interface Selector {

	public Individuo<?>[]  seleccionar(Individuo<?>[]  generacion);

}
