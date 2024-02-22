package Factorias;


import ppoblacion.Poblacion;
import ppoblacion.PoblacionFuncion1;
import ppoblacion.PoblacionFuncion2;

public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	@Override
	public Poblacion generarPoblacion(String funcion) {
		// TODO Auto-generated method stub
		switch(funcion) {
		case "Funcion 1":
			return new PoblacionFuncion1();
		case "Funcion 2":
			return new PoblacionFuncion2();
		default:
			return null;
		}
	}
}


