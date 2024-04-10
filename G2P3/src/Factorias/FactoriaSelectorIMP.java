package Factorias;

import Selectores.*;

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
