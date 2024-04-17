package Factorias;

import Iniciadores.Iniciador;

public abstract class FactoriaIniciador {
	private static  FactoriaIniciador fm;
	public static FactoriaIniciador getInstancia() {
		if(fm==null)
			fm=new FactoriaIniciadorIMP();
		return fm;
	}
	public abstract Iniciador generarIniciador(String iniciador);
}
