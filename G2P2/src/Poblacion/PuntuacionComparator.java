package Poblacion;

import java.util.Comparator;

public class PuntuacionComparator implements Comparator<Individuo<?>>{

	@Override
	public int compare(Individuo<?> o1, Individuo<?> o2) {
		// TODO Auto-generated method stub
		return Double.compare( o2.getPuntuacion(),o1.getPuntuacion());
	}

}
