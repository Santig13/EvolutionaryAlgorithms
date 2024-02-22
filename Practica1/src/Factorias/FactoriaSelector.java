package Factorias;

import FuncionesSeleccion.Selector;

public abstract class FactoriaSelector {
	private static  FactoriaSelector fc;
	
	public static FactoriaSelector getInstancia() {
		if(fc==null)
			fc=new FactoriaSelectorIMP();
		return fc;
	}
	public abstract Selector generarSelector(String selector);
}
