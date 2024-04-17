package Iniciadores;

import Individuo.TPoblacion;

public abstract class Iniciador {
	protected int tamaño;
	protected int profundidad;
	public abstract void IniciarPoblacion(TPoblacion poblacion);
	
}
