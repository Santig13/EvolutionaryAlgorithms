package Factorias;

import FunCruzador.Cruzador;
import FunCruzador.CruzadorAritmetico;
import FunCruzador.CruzadorBLXa;
import FunCruzador.CruzadorMonoPunto;
import FunCruzador.CruzadorUniforme;

public class FactoriaCruzadorIMP extends FactoriaCruzador {

	@Override
	public Cruzador generarCruzador(String cruzador) {
		
			switch(cruzador) {
			case "Mono Punto":
				return new CruzadorMonoPunto();
			case "Uniforme":
				return new CruzadorUniforme();
			case "BLXa":
				return new CruzadorBLXa();
			default:
				return new CruzadorAritmetico();
			}
		}
	}

