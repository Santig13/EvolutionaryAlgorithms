package Factorias;

import FuncionMutador.Mutador;
import FuncionMutador.MutadorBasico;

public class FactoriaMutadorIMP extends FactoriaMutador {

	@Override
	public Mutador generarMutador(String mutador) {
		// TODO Auto-generated method stub

		switch(mutador) {
		case "Basico":
			return new MutadorBasico();
		default:
			return null;
		}
	}

}
