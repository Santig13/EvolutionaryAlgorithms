package Factorias;

import ppoblacion.Poblacion;

public abstract class FactoriaPoblaciones {
	private static  FactoriaPoblaciones fp;
	
	public static FactoriaPoblaciones getInstancia() {
		if(fp==null)
			fp=new FactoriaPoblacionesIMP();
		return fp;
	}
	
	 public abstract Poblacion generarPoblacion(String funcion);
}
