package Factorias;

import Cruzadores.CruceSubarbol;
import Cruzadores.Cruzador;

public class FactoriaCruzadorIMP extends FactoriaCruzador {

	@Override
	public Cruzador generarCruzador(String cruzador) {

			switch(cruzador) {
			
			default:
				return new CruceSubarbol();
			}
		}
	}

