package Individuo;

import Individuo.TJardin.Casillas;

public class IndividuoGramatical extends Individuo {
	private Cortacesped cortacesped;
	
	private int wraps;
	private int maxWraps;
    private int[] cromosoma;
    
    public IndividuoGramatical() {
    	// TODO Auto-generated constructor stub
    	cortacesped=new Cortacesped();
    }
    @Override
	public double evalua() {
		while(!terminado()) {
			start();
		}
		return cortacesped.getPodado();
	}

	private void start() {
		// TODO Auto-generated method stub
		
	}
	private int ejecuta(int i, boolean operativa) {
		// TODO Auto-generated method stub
		if (i >= cromosoma.length){
			 i = 0;
			 this.wraps++;
		}
	    if(this.wraps >= this.maxWraps)
		 return i;
	    
	    
	    
	    
		return i;
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
	

	

}
