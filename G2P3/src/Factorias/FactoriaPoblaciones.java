package Factorias;


import Individuo.Jardin;
import Individuo.TPoblacion;

public abstract class FactoriaPoblaciones {
	private static  FactoriaPoblaciones fp;

	public static FactoriaPoblaciones getInstancia() {
		if(fp==null)
			fp=new FactoriaPoblacionesIMP();
		return fp;
	}

	 public abstract TPoblacion generarPoblacion(Jardin jardin);
}
