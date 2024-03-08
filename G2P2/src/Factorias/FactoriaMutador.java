package Factorias;

import FuncionMutador.Mutador;

public abstract class FactoriaMutador {
	private static  FactoriaMutador fm;
	public static FactoriaMutador getInstancia() {
		if(fm==null)
			fm=new FactoriaMutadorIMP();
		return fm;
	}
	public abstract Mutador generarMutador(String mutador);
}
