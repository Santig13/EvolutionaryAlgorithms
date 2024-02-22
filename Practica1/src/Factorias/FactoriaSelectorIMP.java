package Factorias;

import FuncionesSeleccion.Selector;
import FuncionesSeleccion.SelectorEstocastica;
import FuncionesSeleccion.SelectorRestos;
import FuncionesSeleccion.SelectorRuleta;
import FuncionesSeleccion.SelectorTruncamiento;

public class FactoriaSelectorIMP extends FactoriaSelector {

	@Override
	public Selector generarSelector(String selector) {
		// TODO Auto-generated method stub
		switch(selector) {
		case "Ruleta":
			return new SelectorRuleta();
		case "Estocastico":
			return new SelectorEstocastica();
		case "Truncamiento":
			return new SelectorTruncamiento();
		default:
			return new SelectorRestos();
		}
	}

}
