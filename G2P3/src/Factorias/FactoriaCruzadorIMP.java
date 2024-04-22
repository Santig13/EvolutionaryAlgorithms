package Factorias;

import Cruzadores.CruceSubarbol;
import Cruzadores.Cruzador;
import Cruzadores.CruzadorMonoPunto;
import Cruzadores.CruzadorUniforme;

public class FactoriaCruzadorIMP extends FactoriaCruzador {

	@Override
	public Cruzador generarCruzador(String cruzador) {

			switch(cruzador) {
			case "Mono Punto":
				return new CruzadorMonoPunto();
			case "Uniforme":
				return new CruzadorUniforme();
			default:
				return new CruceSubarbol();
			}
		}
	}

