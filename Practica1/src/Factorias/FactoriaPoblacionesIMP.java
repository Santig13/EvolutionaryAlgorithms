package Factorias;


import Poblacion.PoblacionFuncion1;
import Poblacion.PoblacionFuncion2;
import Poblacion.PoblacionFuncion3;
import Poblacion.PoblacionFuncion4;
import Poblacion.PoblacionFuncion5;
import Poblacion.TPoblacion;

public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	@Override
	public TPoblacion generarPoblacion(String funcion) {
		// TODO Auto-generated method stub
		switch(funcion) {
		case "Funcion 1":
			return new PoblacionFuncion1();
		case "Funcion 2":
			return new PoblacionFuncion2();
		case "Funcion 3":
			return new PoblacionFuncion3();
		case "Funcion 4":
			return new PoblacionFuncion4();
		default:
			return new PoblacionFuncion5();
		}
	}
}


