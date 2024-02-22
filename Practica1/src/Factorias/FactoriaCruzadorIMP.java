package Factorias;

import FunCruzador.Cruzador;
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
			default:
				return null;
			}
		}
	}

