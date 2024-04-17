package Factorias;


import Individuo.TJardin;
import Individuo.TPoblacion;

public abstract class FactoriaPoblaciones {
	private static  FactoriaPoblaciones fp;

	public static FactoriaPoblaciones getInstancia() {
		if(fp==null)
			fp=new FactoriaPoblacionesIMP();
		return fp;
	}

	 public abstract TPoblacion generarPoblacion(int profundidad);
}
