package Iniciadores;

import Individuo.TPoblacion;

public abstract class Iniciador {
	protected int tamanio;
	protected int profundidad;
	public abstract void IniciarPoblacion(TPoblacion poblacion,int profundidad);
	
	public void setTam(int tamPoblacion) {
		tamanio=tamPoblacion;
	}
	
}
