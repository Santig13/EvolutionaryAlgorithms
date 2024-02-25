package Factorias;


import ppoblacion.Poblacion;
import ppoblacion.PoblacionFuncion1;
import ppoblacion.PoblacionFuncion2;
import ppoblacion.PoblacionFuncion3;
import ppoblacion.PoblacionFuncion4;
import ppoblacion.PoblacionFuncion5;

public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	@Override
	public Poblacion generarPoblacion(String funcion) {
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


