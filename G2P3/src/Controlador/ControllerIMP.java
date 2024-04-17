package Controlador;

import Algoritmo.algoritmoGenetico;
import Cruzadores.Cruzador;
import Factorias.FactoriaCruzador;
import Factorias.FactoriaIniciador;
import Factorias.FactoriaMutador;
import Factorias.FactoriaSelector;
import Individuo.TJardin;
import Individuo.TPoblacion;
import Iniciadores.Iniciador;
import Mutadores.Mutador;
import Presentacion.GUI;
import Selectores.Selector;

public class ControllerIMP implements Controller {

	@Override
	public void run(GUI gui,TParametros parametros) {

		//Pasar de parametros a las factorias
		Selector selector=FactoriaSelector.getInstancia().generarSelector(parametros.getSelector());
		Cruzador cruzador=FactoriaCruzador.getInstancia().generarCruzador(parametros.getCruzador());
		Mutador mutador=FactoriaMutador.getInstancia().generarMutador(parametros.getMutador());
		Iniciador iniciador=FactoriaIniciador.getInstancia().generarIniciador(parametros.iniciador());
		TJardin.setCasillas(parametros.getSol());
		TPoblacion poblacion=null;
		//Ejecutar algoritmo
		algoritmoGenetico AG =new algoritmoGenetico(parametros.getTamPoblacion(),parametros.getMaxGen(),parametros.getProbCruce(),parametros.getProbMuta(),selector,mutador,cruzador,poblacion,parametros.getElitismo(),iniciador);

		//Informar a la vista
		gui.update(AG.executeAlgorithm());
	}


}
