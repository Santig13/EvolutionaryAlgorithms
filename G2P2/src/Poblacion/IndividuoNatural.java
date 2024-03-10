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
		int lcrom=getLongitudCromosoma();
		Integer[]padre2=(Integer[]) individuo2.cromosoma;
		Integer[] cro_nuevo=new Integer[lcrom];
		
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
		
		for(int i=puntoDeCorte2;i<lcrom;i++) {
			if(!intercambiados.containsKey(cromosoma[i]))
				cro_nuevo[i]=cromosoma[i];
			else
				cro_nuevo[i]=padre2[intercambiados.get(cromosoma[i])];
		}
	}
	
	
	@Override
	public  void cruzarOX(int puntoDeCorte1, int puntoDeCorte2, Individuo<?> individuo2) {
		Map<Integer, Integer> intercambiados = new HashMap<Integer,Integer>();
		int lcrom=getLongitudCromosoma();
		Integer[]padre2=(Integer[]) individuo2.cromosoma;
		Integer[] cro_nuevo=new Integer[lcrom];
		
		for(int i=puntoDeCorte1;i<puntoDeCorte2;i++) {
			cro_nuevo[i]=padre2[i];
			intercambiados.put(cro_nuevo[i], i);
		}
		
		int indice=puntoDeCorte2;
		int j=puntoDeCorte2;
		
		while(indice!=puntoDeCorte1) {
			if(!intercambiados.containsKey(cromosoma[j])) {
				cro_nuevo[indice]=cromosoma[indice];
				indice=(indice+1)%lcrom;
			}
			j=(j+1)%lcrom;
		}
		
	}
}
