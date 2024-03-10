package Poblacion;

import java.util.HashMap;
import java.util.Map;

public abstract class IndividuoNatural extends Individuo<Integer> {


	@Override
	public double[] getFenotipoTot() {
		double[] v = new double[cromosoma.length];
		for (int i = 0; i < cromosoma.length; i++)
		{
			v[i] = cromosoma[i].doubleValue();
		}
		return v;
	}
	
	@Override
	public  void cruzarPMX(int puntoDeCorte1, int puntoDeCorte2, Individuo<?> individuo2) {
		Map<Integer, Integer> intercambiados = new HashMap<Integer,Integer>();
		
		Integer[]padre2=(Integer[]) individuo2.cromosoma;
		Integer[] cro_nuevo=new Integer[getLongitudCromosoma()];
		
		for(int i=puntoDeCorte1;i<puntoDeCorte2;i++) {
			cro_nuevo[i]=padre2[i];
			intercambiados.put(cro_nuevo[i], i);
		}
		
		for(int i=0;i<puntoDeCorte1;i++) {
			if(!intercambiados.containsKey(cromosoma[i]))
				cro_nuevo[i]=cromosoma[i];
			else
				cro_nuevo[i]=padre2[intercambiados.get(cromosoma[i])];
		}
		
		for(int i=puntoDeCorte2;i<getLongitudCromosoma();i++) {
			if(!intercambiados.containsKey(cromosoma[i]))
				cro_nuevo[i]=cromosoma[i];
			else
				cro_nuevo[i]=padre2[intercambiados.get(cromosoma[i])];
		}
	}
	
	
	
}
