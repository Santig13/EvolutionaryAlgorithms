package Individuo;

import java.util.ArrayList;
import java.util.HashMap;

import Individuo.IndividuoArbolGenetico.nodo;
import Individuo.TJardin.Casillas;

public class IndividuoGramatical extends Individuo {
	private static final HashMap< String,ArrayList<String>> terminales = new HashMap<ArrayList<String>, String>() {{
        put("start",new ArrayList<String>() {{
            add("AVANZA");
            add("ALEATORIA");
            add("IZQUIERDA");
            add("DERECHA");
        }});
    }};
	@Override
	public double evalua() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Individuo copia() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public Casillas[][] getJardin() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void cruceSubArbol1(Individuo individuo2) {
	
	}

	@Override
	public nodo cruceSubArbol2(nodo subArbolParaCruce) {
		return null;
	}

}
