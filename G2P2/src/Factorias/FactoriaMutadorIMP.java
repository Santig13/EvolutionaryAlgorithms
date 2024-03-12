package Factorias;

import FuncionMutador.*;


public class FactoriaMutadorIMP extends FactoriaMutador {

	@Override
	public Mutador generarMutador(String mutador) {
		// TODO Auto-generated method stub

		switch(mutador) {
		case "Intercambio":
			return new MutadorIntercambio();
		case "Inversion":
			return new MutadorInversion();
		default:
			return null;
		}
	}

}
