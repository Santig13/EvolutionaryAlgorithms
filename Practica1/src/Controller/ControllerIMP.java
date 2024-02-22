package Controller;

import Algortimo.algoritmoGenetico;
import Factorias.FactoriaCruzador;
import Factorias.FactoriaMutador;
import Factorias.FactoriaPoblaciones;
import Factorias.FactoriaSelector;
import FunCruzador.Cruzador;
import FuncionMutador.Mutador;
import FuncionesSeleccion.Selector;
import Presentacion.GUI;
import ppoblacion.Poblacion;

public class ControllerIMP implements Controller {

	@Override
	public void run(GUI gui,TParametros parametros) {
		// TODO Auto-generated method stub
		Selector selector=FactoriaSelector.getInstancia().generarSelector(parametros.getSelector());
		Cruzador cruzador=FactoriaCruzador.getInstancia().generarCruzador(parametros.getCruzador());
		Mutador mutador=FactoriaMutador.getInstancia().generarMutador(parametros.getMutador());
		Poblacion poblacion=FactoriaPoblaciones.getInstancia().generarPoblacion(parametros.getFuncion());
		algoritmoGenetico AG=new algoritmoGenetico(parametros.getTamPoblacion(),parametros.getMaxGen(),parametros.getProbCruce(),parametros.getProbMuta(),selector,mutador,cruzador,poblacion);
		gui.update(AG.executeAlgorithm());
	}


}
