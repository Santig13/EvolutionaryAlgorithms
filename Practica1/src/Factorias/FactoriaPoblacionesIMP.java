package Factorias;


import Poblacion.Individuo;
import Poblacion.IndividuoFuncion1;
import Poblacion.IndividuoFuncion2;
import Poblacion.IndividuoFuncion3;
import Poblacion.IndividuoFuncion4;
import Poblacion.IndividuoFuncion5;
import Poblacion.TPoblacion;

public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	@Override
	public TPoblacion generarPoblacion(String funcion,int tamanio,double precision, int nDim) {
		// TODO Auto-generated method stub
		Individuo<?>[] individuos=new Individuo<?>[tamanio];
		boolean min=false;
		
		switch(funcion) {
		case "Funcion 1":
			 for(int i=0;i<tamanio;i++) {
				 individuos[i]=new IndividuoFuncion1(precision);
			 }
			 break;
		case "Funcion 2":
			min=true;
			for(int i=0;i<tamanio;i++) {
				 individuos[i]=new IndividuoFuncion2(precision);
			 }
			 break;
		case "Funcion 3":
			min=true;
			for(int i=0;i<tamanio;i++) {
				 individuos[i]=new IndividuoFuncion3(precision);
			 }
			 break;
		case "Funcion 4":
			min=true;
			for(int i=0;i<tamanio;i++) {
				 individuos[i]=new IndividuoFuncion4(precision,nDim);
			 }
			 break;
		default:
			min=true;
			for(int i=0;i<tamanio;i++) {
				 individuos[i]=new IndividuoFuncion5(nDim);
			 }
			 break;
		}
		return new TPoblacion(individuos,min);
	}
}


