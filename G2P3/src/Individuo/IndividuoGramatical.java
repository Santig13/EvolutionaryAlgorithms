package Individuo;

import java.util.List;
import java.util.Random;

import Individuo.TJardin.Casillas;

public class IndividuoGramatical extends Individuo {
	private Cortacesped cortacesped;
	
	private int wraps;
	private int maxWraps;
    private int[] cromosoma;

	private int i;
    
    public IndividuoGramatical() {
    	// TODO Auto-generated constructor stub
    	cortacesped=new Cortacesped();
    }
    @Override
	public double evalua() {
    	
		while(!terminado()) {
			i=0;
			wraps=0;
			ejecuta(BNFGramatica.start());
		}
		return cortacesped.getPodado();
	}

	private void start() {
		// TODO Auto-generated method stub
		List<String> l=BNFGramatica.regla("start",cromosoma[0]);
		this.i=1;
		this.ejecuta(l.get(0));
	}
	private posicion ejecuta(String clave) {
		// TODO Auto-generated method stub
		posicion casilla=new posicion(0,0);
		if (i >= cromosoma.length){
			 i = 0;
			 this.wraps++;
		}
	    if(this.wraps >= this.maxWraps)
		 return casilla;
	    
	    List<String> l=BNFGramatica.regla(clave,cromosoma[i]);
	    String regla=l.get(0);
	    if(regla.equalsIgnoreCase("progn2")) {
	    	i++;
	    	ejecuta(l.get(1));
	    	return ejecuta(l.get(2));
	    }
	    else if(regla.equalsIgnoreCase("suma")) {
	    	return cortacesped.suma(ejecuta(l.get(1)), ejecuta(l.get(2)));
	    }else if(regla.equalsIgnoreCase("salta")) {
	    	return cortacesped.salta(ejecuta(l.get(1)));
	    }
	    else if(regla.equalsIgnoreCase("avanza")) {
	    	return cortacesped.avanza();
	    }else if(regla.equalsIgnoreCase("izquierda")) {
	    	return cortacesped.izquierda();
	    }else if(regla.equalsIgnoreCase("derecha")) {
	    	return cortacesped.derecha();
	    }else if(regla.equalsIgnoreCase("cte")) {
	    	return new posicion(cortacesped.aleatoria());
	    }else {
	    	return casilla;
	    }
	    
	}
	private boolean terminado() {
		// TODO Auto-generated method stub
		return cortacesped.terminado();
	}
	@Override
	public Individuo copia() {
		IndividuoGramatical copia = new IndividuoGramatical();
		copia.cortacesped=this.cortacesped;
		for(int i=0;i<cromosoma.length;i++)
			copia.cromosoma[i]=this.cromosoma[i];
		
		return copia;
	}

	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		cortacesped.reset();
	}

	@Override
	public Casillas[][] getJardin() {
		// TODO Auto-generated method stub
		return cortacesped.getJardin();
	}
	
	
	//CRUCES
	public int getLongitudCromosoma() {
		return cromosoma.length;
	}
	
	@Override
	public void cruzarMonopunto(int i, Individuo padre2) {
		// TODO Auto-generated method stub
		int[] cromosomaPadre= padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}

	}
	
	@Override
	public int[] getCromosoma() {
		return cromosoma;
	}
	
	@Override
	public void cruzarUniforme(Boolean[] cruzar, Individuo individuo2) {
		int[] cromosomaPadre= individuo2.getCromosoma();
		for(int i=0;i<cromosoma.length;i++) {
			if(cruzar[i]) {
				cromosoma[i]=cromosomaPadre[i];
			}
		}
	}

	// MUTACION
	@Override
	public void mutarBasico() {	
		
		Random rand = new Random();
		int pos = rand.nextInt(cromosoma.length);
		cromosoma[pos] = rand.nextInt();
	}

	

}
