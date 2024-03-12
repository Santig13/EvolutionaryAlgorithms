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
			default:
				return null;
			}
		}
	}

