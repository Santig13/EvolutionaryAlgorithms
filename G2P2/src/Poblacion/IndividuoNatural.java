package Poblacion;

import java.util.ArrayList;
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
		
		int indice=puntoDeCorte2%lcrom;
		int j=puntoDeCorte2%lcrom;
		

		while(indice!=puntoDeCorte1) {
			
			if(!intercambiados.containsKey(cromosoma[j])) {
				
				cro_nuevo[indice]=cromosoma[indice];
				indice=(indice+1)%lcrom;
			}
			
			j=(j+1)%lcrom;
		}
		
	}
	
	@Override
	public void mutarInsercion(int pos, int elem) {
		// TODO Auto-generated method stub
		Integer [] newCromosoma = new Integer[this.getLongitudCromosoma()];
		int x = 0;
		for (int i = 0; i < pos; i++)
		{
			if (cromosoma[i]!= elem)
			{
				newCromosoma[x] = cromosoma[i];
				x++;
			}
		}
		
		newCromosoma[x] = elem;
		
		for (int i = x+1; i < this.getLongitudCromosoma(); i++)
		{
			if (cromosoma[i]!= elem)
			{
				newCromosoma[x] = cromosoma[i];
				x++;
			}
		}
		
	}
	
	public void mutarIntercambio(int pos1, int pos2)
	{
		int aux = cromosoma[pos2];
		cromosoma[pos2] = cromosoma[pos1];
		cromosoma[pos1] = aux;
	}
	
	public void mutarInversion(int pos1, int pos2)
	{
		int Tam = pos2 - pos1 +1;
		Integer aux[] = new Integer[Tam];
		int x = 0;
		for (int i = pos1; i <= pos2; i++)
		{
			aux[x] = cromosoma[i];
			x++;
		}
		
		x--;
		
		for (int i = pos1; i <= pos2; i++)
		{
			cromosoma[i] = aux[x] ;
			x--;
		}
	}
	
	public void mutarHeuristica(int[] posSelec)
	{
		Integer[]CromosomaOriginal = cromosoma.clone();
		Integer[]CromosomaMejor = cromosoma.clone();
		Double mejorpunt = this.evalua();
		
		ArrayList<ArrayList<Integer>> permutations = permute(posSelec);
		
		for (ArrayList<Integer> permutation : permutations)
		{
			for (int i = 0; i < permutation.size();i++)
			{
				cromosoma[posSelec[i]] = CromosomaOriginal[permutation.get(i)];
				Double punt = this.evalua();
				if (punt < mejorpunt)
				{
					CromosomaMejor = cromosoma.clone();
					mejorpunt = punt;
				}
			}
		}
		
		this.cromosoma = CromosomaMejor.clone();
		
	}
	
	 private static ArrayList<ArrayList<Integer>> permute(int[] nums) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 ArrayList<Integer> current = new ArrayList<>();
	        boolean[] used = new boolean[nums.length];
	        permute(nums, result, current, used);
	        return result;
	    }

	 private static void permute(int[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, boolean[] used) {
	        if (current.size() == nums.length) {
	            result.add(new ArrayList<>(current));
	            return;
	        }

	        for (int i = 0; i < nums.length; i++) {
	            if (!used[i]) {
	                current.add(nums[i]);
	                used[i] = true;
	                permute(nums, result, current, used);
	                used[i] = false;
	                current.remove(current.size() - 1);
	            }
	        }
	 }
	 @Override
		protected String fenotipoToString() {
			// TODO Auto-generated method stub
		 	//return cromosoma.toString();
		 return "";
		}
	

}
