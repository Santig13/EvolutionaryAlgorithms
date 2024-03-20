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
		setCromosoma(cro_nuevo);
		
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
		setCromosoma(cro_nuevo);
		
	}
	@Override
	public  void cruzarOXPP(int posP1,int posP2, Individuo<?> individuo2) {
		Map<Integer, Integer> intercambiados = new HashMap<Integer,Integer>();
		int lcrom=getLongitudCromosoma();
		Integer[]padre2=(Integer[]) individuo2.cromosoma;
		Integer[] cro_nuevo=new Integer[lcrom];
		
		
		cro_nuevo[posP1]=padre2[posP1];
		intercambiados.put(cro_nuevo[posP1], posP1);
		cro_nuevo[posP2]=padre2[posP2];
		intercambiados.put(cro_nuevo[posP2], posP2);
	
		
		int indice=(posP2+1)%lcrom;
		int j=(posP2+1)%lcrom;
		

		while(indice!=posP2) {
			
			if(!intercambiados.containsKey(cromosoma[j])) {
				
				cro_nuevo[indice]=cromosoma[indice];
				indice=(indice+1)%lcrom;
			}
			
			j=(j+1)%lcrom;
		}
		setCromosoma(cro_nuevo);
	}
		@Override
		public void cruzarOXOP(ArrayList<Integer> posiciones, Individuo<?> individuo2) {
			Map<Integer, Integer> intercambiados = new HashMap<Integer,Integer>();
			int lcrom=getLongitudCromosoma();
			Integer[]padre2=(Integer[]) individuo2.cromosoma;
			Integer[] cro_nuevo=new Integer[lcrom];
			
			for(int i=0;i<posiciones.size();i++) {
				intercambiados.put(cromosoma[posiciones.get(i)], posiciones.get(i));
			}
		
			
			int indice=0;
			
			
			for(int i=0;i<lcrom;i++) {
				if(intercambiados.containsKey(padre2[i])) {
					cro_nuevo[i]=cromosoma[posiciones.get(indice)];
					indice++;
				}
				else
					cro_nuevo[i]=padre2[i];
			}
			setCromosoma(cro_nuevo);

	}
		
	@Override
	public void cruzarCX(Individuo<?> individuo) {
		int lcrom=getLongitudCromosoma();
		Integer[]padre2=(Integer[]) individuo.cromosoma;
		Integer[] cro_nuevo=new Integer[lcrom];
		
		cro_nuevo[0]=cromosoma[0];
		int indice=0;
		
		//Vamos siguiendo los ciclos hasta que llegamos a un elemento ya introducido
		while(busca(cro_nuevo,padre2[indice])==-1) {
			int i=busca(cromosoma,padre2[indice]);
			cro_nuevo[i]=padre2[indice];
			indice=i;
		}
		
		//Rellenamos los huecos con los elementos del padre
		for(int i=0;i<lcrom;i++) {
			if(cro_nuevo[i]==null)
				cro_nuevo[i]=padre2[i];
		}
		setCromosoma(cro_nuevo);
	}
	private int busca(Integer[] elems,int x) {
		int i=-1;
		int j=0;
		while(i==-1&&j<elems.length) {
			if(elems[j]!=null&&elems[j]==x)
				i=j;
			
			j++;
		}
		return i;
	}
	@Override
	public void cruzarMonopunto(int i, Individuo<?> padre2) {
		Integer[] cromosomaPadre=(Integer[]) padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}

	}
	@Override
	public void ordinal() {
		// TODO Auto-generated method stub
		int lcrom=getLongitudCromosoma();
		ArrayList<Integer> lista=new ArrayList<>();
		for(int i=0;i<lcrom;i++) {
			lista.add(i,i);
		}
		for(int i=0;i<lcrom;i++) {
			int value=cromosoma[i];
			int index=lista.indexOf(value);
			cromosoma[i]=index;
			lista.remove(index);
		}
		
	}
	
	
	@Override
	public void cruzarCO() {
		// TODO Auto-generated method stub
		int lcrom=getLongitudCromosoma();
		ArrayList<Integer> lista=new ArrayList<>();
		for(int i=0;i<lcrom;i++) {
			lista.add(i,i);
		}
		
		for(int i=0;i<lcrom;i++) {
			int indice=cromosoma[i];
			cromosoma[i]=lista.get(indice);
			lista.remove(indice);
		}
		
	}
	@Override
	public void mutarInsercion(int pos, int poselem) {
		// TODO Auto-generated method stub
		Integer [] newCromosoma = new Integer[this.getLongitudCromosoma()];
		if (pos == poselem) {
            return; // No hay necesidad de mover si el �ndice de origen y destino son iguales
        }
		
		ArrayList<Integer> lista = new ArrayList<>();
		for (int i:cromosoma)
			lista.add(i);
		
        Integer elemento = lista.remove(poselem); // Remover el elemento en el �ndice de origen
        lista.add(pos, elemento); // Insertar el elemento en el �ndice de destino
		
        for (int i = 0; i < lista.size(); i++)
        {
        	newCromosoma[i] = lista.get(i);
        }
		
        this.setCromosoma(newCromosoma);
		
	}
	
	public void mutarIntercambio(int pos1, int pos2)
	{
		int aux = cromosoma[pos2];
		cromosoma[pos2] = cromosoma[pos1];
		cromosoma[pos1] = aux;
	}
	
	public void mutarInversion(int pos1, int pos2)
	{
		System.out.println("-----INVERSION DE POS:" + pos1+" A POS:" +pos2 +"-----");

		for (int i : cromosoma)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		
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
		
		for (int i : cromosoma)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-----FIN DE INVERSION-----");


	}
	
	public void mutarHeuristica(int[] posSelec)
	{
		Integer[]CromosomaOriginal = cromosoma.clone();
		Integer[]CromosomaMejor = cromosoma.clone();
		Double mejorpunt = this.evalua();
		
		System.out.println("------INICIO MUTACI�N HEURISTICA-----");
		System.out.print("cromosoma original: ");
		for (int i : cromosoma)
			System.out.print(i+" ");
		System.out.println();
		System.out.print("Posiciones seleccionadas:");
		for (int i : posSelec)
			System.out.print(i+" con eleme (" + CromosomaOriginal[i]+ ") ");
		System.out.println();

		
		ArrayList<ArrayList<Integer>> permutations = permute(posSelec);
		int cont = 0;
		for (ArrayList<Integer> permutation : permutations)
		{
			System.out.print("Permutacion n� " + cont + ": ");
			for (Integer pos : permutation)
				System.out.print(pos + " ");
			cont++;

			for (int i = 0; i < permutation.size();i++)
			{		
				cromosoma[posSelec[i]] = CromosomaOriginal[permutation.get(i)];
			}
			
			Double punt = this.evalua();
			if (punt < mejorpunt)
			{
				CromosomaMejor = cromosoma.clone();
				mejorpunt = punt;
			}
			
			System.out.print("cromosoma permutado: ");
			for (int pos : cromosoma)
				System.out.print(pos+" ");
			System.out.println();
		}
		
		this.cromosoma = CromosomaMejor.clone();
		System.out.println("------FIN MUTACI�N HEURISTICA-----");

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
