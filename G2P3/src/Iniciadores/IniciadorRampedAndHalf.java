package Iniciadores;

import java.util.ArrayList;
import java.util.List;

import Individuo.Individuo;
import Individuo.IndividuoArbolGenetico;
import Individuo.TPoblacion;

public class IniciadorRampedAndHalf extends Iniciador {

	@Override
	public void IniciarPoblacion(TPoblacion poblacion, int profundidad) {
	    IndividuoArbolGenetico[] individuos = (IndividuoArbolGenetico[]) poblacion.getIndivuduos();
		int grupos=profundidad-1;
	   
 
	    // Arrays para almacenar los individuos de cada grupo
		
		List< List<IndividuoArbolGenetico>> lgrupos = new ArrayList<List<IndividuoArbolGenetico>>();
		for(int i=0;i<grupos;i++) {
			lgrupos.add(i,new ArrayList<>());
		}
		int i=0;
	    for (IndividuoArbolGenetico individuo : individuos) {
	    	int asignado=i%grupos;
	    	lgrupos.get(asignado).add(individuo);
	    	i++;
	        // Buscar el primer grupo disponible para la profundidad del individuo
	        
	    }
	    int pmax=2;
	    for (List<IndividuoArbolGenetico> grupo : lgrupos) {
	    	
	        inicializarRampedAndHalf(grupo,pmax);
	        pmax++;
	    }
	  
	    

	   }

	private void inicializarRampedAndHalf(List<IndividuoArbolGenetico> grupo,int pmax) {
		// TODO Auto-generated method stub
		int tamanio=grupo.size();
		for(int i=0;i<tamanio/2;i++) {
			grupo.get(i).inicializacionCompleta(pmax);
		}
		for(int i=tamanio/2;i<tamanio;i++) {
			grupo.get(i).inicializacionCreciente(pmax);
		}
	}

}
