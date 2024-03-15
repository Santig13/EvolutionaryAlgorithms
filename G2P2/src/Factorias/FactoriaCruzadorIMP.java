package Factorias;

import FunCruzador.*;


public class FactoriaCruzadorIMP extends FactoriaCruzador {

	@Override
	public Cruzador generarCruzador(String cruzador) {

			switch(cruzador) {
			case "PMX":
				return new CruzadorPMX();
			case "OX":
				return new CruzadorOX();
			case "OXPP":
				return new CruzadorOXPP();
			case "OXOP":
				return new CruzadorOXOP();
			case "CX":
				return new CruzadorCX();
			case "CO":
				return new CruzadorCO();
			default:
				return null;
			}
		}
	}

