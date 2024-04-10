package Factorias;

import Cruzadores.Cruzador;

public abstract class FactoriaCruzador {
private static FactoriaCruzador fc;

	public static FactoriaCruzador getInstancia() {
		if(fc==null)
			fc=new FactoriaCruzadorIMP();
		return fc;
	}
	public abstract Cruzador generarCruzador(String cruzador);
}
