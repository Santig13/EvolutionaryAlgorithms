package Factorias;

import FuncionesSeleccion.Selector;
import FuncionesSeleccion.SelectorEstocastica;
import FuncionesSeleccion.SelectorRestos;
import FuncionesSeleccion.SelectorRuleta;
import FuncionesSeleccion.SelectorTorneoDeterministico;
import FuncionesSeleccion.SelectorTorneoProbabilistico;
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
		case "Torneo Deterministico":
			return new SelectorTorneoDeterministico();
		case "Torneo Probabilistico":
			return new SelectorTorneoProbabilistico();
		default:
			return new SelectorRestos();
		}
	}

}
