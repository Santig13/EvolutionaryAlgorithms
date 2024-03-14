package Factorias;

import FuncionesSeleccion.Selector;
import FuncionesSeleccion.SelectorEstocastica;
import FuncionesSeleccion.SelectorRanking;
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
		case "Torneo Det":
			return new SelectorTorneoDeterministico();
		case "Torneo Pro":
			return new SelectorTorneoProbabilistico();
		case "Ranking":
			return new SelectorRanking();
		default:
			return new SelectorRestos();
		}
	}

}
