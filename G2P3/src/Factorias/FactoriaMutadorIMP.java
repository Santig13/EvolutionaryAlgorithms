package Factorias;

import Mutadores.Mutador;
import Mutadores.MutadorArbol_SubArbol;
import Mutadores.MutadorBasico;
import Mutadores.MutadorFuncional;
import Mutadores.MutadorInicializador;
import Mutadores.MutadorTerminal;

public class FactoriaMutadorIMP extends FactoriaMutador {

	@Override
	public Mutador generarMutador(String mutador) {
		// TODO Auto-generated method stub

		switch(mutador) {
		case "Basico":
			return new MutadorBasico();
		case "Terminal":
			return new MutadorTerminal();
		case "Funcional":
			return new MutadorFuncional();
		case "Inicializacion":
			return new MutadorInicializador();
		case "Arbol-SubArbol":
			return new MutadorArbol_SubArbol();    
		default:
			return null;
		}
	}

}
