package Poblacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class IndividuoControlAero extends IndividuoNatural {
	
	private ArrayList<Vuelo>  vuelos;
	private final double[][] SEP = {
            {1, 1.5, 2},
            {1, 1.5, 1.5},
            {1, 1, 1}
        	};
	private ArrayList<ArrayList<Vuelo>> pistas;
	private Random rand;
	private Integer numVuelos;
	
	public IndividuoControlAero(Integer numVuelos,Integer numPistas) {
		this.pistas = new ArrayList<>();
		
		this.rand=new Random();
		this.numVuelos=numVuelos;
		this.cromosoma = new Integer [numVuelos];
       this.vuelos=new ArrayList<>(numVuelos);

		ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < numVuelos; i++) {
            numeros.add(i);
        }
        for (int i = 0; i < numVuelos; i++) {
            int indice = rand.nextInt(numeros.size());
            this.cromosoma[i]=numeros.get(indice);
            numeros.remove(indice);
        }
		for (int i = 0; i < numVuelos; i++) 
			this.vuelos.add(VuelosINFO.getVuelo(i));
		
		for (int i = 0; i < numPistas; i++) 
			this.pistas.add(new ArrayList<Vuelo>());
	}
	
	
	public IndividuoControlAero(IndividuoControlAero copia) {
		
		this.rand=new Random();
		this.numVuelos=copia.numVuelos;
		this.cromosoma =copia.cromosoma.clone();
		this.pistas = new ArrayList<>();
		//igual es innecesario
		 for (ArrayList<Vuelo> pistaOriginal : copia.pistas) {
		        ArrayList<Vuelo> pistaClonada = new ArrayList<>();
		        for (Vuelo vuelo : pistaOriginal) {
		            pistaClonada.add(vuelo.clone());
		        }
		        this.pistas.add(pistaClonada);
		    }
		 //Serias dudas
		// Clonar los vuelos
		    this.vuelos =new ArrayList<>(this.numVuelos);
		    for (int i=0;i<this.numVuelos;i++) {
		        this.vuelos.add(copia.vuelos.get(i).clone());
		    }
	}


	@Override
	public double evalua() {
		double fitness = 0;
		for(int i=0;i<numVuelos;i++) {
			int vuelo = cromosoma[i];
			   // se asigna el vuelo actual a la pista con mínimo TLA (menor_TLA)
			fitness = fitness + Math.pow((menor_TLA(vuelo) -menor_TEL(vuelo)),2);
			 
		}
		return fitness;
	}

	

	@Override
	public Individuo<?> copia() {
		// TODO Auto-generated method stub
		return  new IndividuoControlAero(this);
	}

	@Override
	protected String fenotipoToString() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * Dados dos vuelos v1 y v2 el metodo devuelve la separacion necesaria entre ellos
	 */
	private double calc_sep(Vuelo v1,Vuelo v2) {
		return SEP[v1.getTipoNumber()][v2.getTipoNumber()];
	}
	
	/*
	 * Dado el numero de un vuelo devuelve el menor TEL para ese vuelo
	 */
	private double menor_TEL(Integer vuelo) {
		double menor_TLE=Double.MAX_VALUE;

		for(int pista=0;pista<pistas.size();pista++) {
			menor_TLE=Math.min(menor_TLE, TEL.get(pista,vuelo));
		}
		
		return menor_TLE;
	}

	/*
	 * Dado el numero de un vuelo devuelve el menor TLA para ese vuelo
	 */
	private double menor_TLA(int vuelo) {
		
		double menor_TLA=Double.MAX_VALUE;
		int pista=0;
		Vuelo v_act=vuelos.get(vuelo);
		
		for(int j=0;j<pistas.size();j++){
			double TLA =TEL.get(j,vuelo);
			
			if(pistas.get(j).size()>0) {
				Vuelo v_ant=pistas.get(j).get(pistas.get(j).size()-1);
				//calculamos el TLA del vuelo en la pista j
				TLA= Math.max( v_ant.getTLA()+ calc_sep(v_ant, v_act), TLA);
			}

			if(TLA < menor_TLA) {
				menor_TLA=TLA;
				pista=j;
			}
		}
		v_act.setTLA(menor_TLA);
		pistas.get(pista).add(v_act);

		return menor_TLA;
	}


	

}
