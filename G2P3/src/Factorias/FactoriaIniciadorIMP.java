package Factorias;

import Cruzadores.Cruzador;
import Iniciadores.Iniciador;
import Iniciadores.IniciadorCompleta;
import Iniciadores.IniciadorCreciente;
import Iniciadores.IniciadorNormal;
import Iniciadores.IniciadorRampedAndHalf;

public class FactoriaIniciadorIMP extends FactoriaIniciador {


	@Override
	public Iniciador generarIniciador(String iniciador) {
		switch(iniciador) {
		case "Completo":
			return new IniciadorCompleta();
		case "Creciente":
			return new IniciadorCreciente();
		case "Ramped-Half":
			return new IniciadorRampedAndHalf();
		case "Normal":
			return new IniciadorNormal();
		default:
			return null;
		}
	}
}

