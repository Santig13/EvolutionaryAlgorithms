package Controlador;

import Algortimo.algoritmoGenetico;
import Factorias.FactoriaCruzador;
import Factorias.FactoriaMutador;
import Factorias.FactoriaPoblaciones;
import Factorias.FactoriaSelector;
import FunCruzador.Cruzador;
import FuncionMutador.Mutador;
import FuncionesSeleccion.Selector;
import Poblacion.TPoblacion;
import Presentacion.GUI;

public class ControllerIMP implements Controller {

	@Override
	public void run(GUI gui,TParametros parametros) {

		//Pasar de parametros a las factorias
		Selector selector=FactoriaSelector.getInstancia().generarSelector(parametros.getSelector());
		Cruzador cruzador=FactoriaCruzador.getInstancia().generarCruzador(parametros.getCruzador());
		Mutador mutador=FactoriaMutador.getInstancia().generarMutador(parametros.getMutador());
		TPoblacion poblacion=null;

		//Ejecutar algoritmo
		algoritmoGenetico AG =new algoritmoGenetico(parametros.getTamPoblacion(),parametros.getMaxGen(),parametros.getProbCruce(),parametros.getProbMuta(),selector,mutador,cruzador,poblacion,parametros.getElitismo(),parametros.getFuncion());

		//Informar a la vista
		gui.update(AG.executeAlgorithm());
	}


}
