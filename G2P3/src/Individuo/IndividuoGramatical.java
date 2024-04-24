package Individuo;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Individuo.TJardin.Casillas;

public class IndividuoGramatical extends Individuo {
	private Cortacesped cortacesped;
	
	private int wraps;
	private int maxWraps;
    private int[] cromosoma;

	private int i;
    
    public IndividuoGramatical(int wraps) {
    	// TODO Auto-generated constructor stub
    	cortacesped=new Cortacesped();
    	cromosoma = new int[5];
    	this.maxWraps = wraps;
    }
    
    
    @Override
	public double evalua() {
    	
		while(!terminado()) {
			i=0;
			wraps=0;
			ejecuta(BNFGramatica.start());
			if(cortacesped.quieto()) {
				break;
			}
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
	   
	    List<String> l=this.next(clave);
	    String regla=l.get(0);
	    if(regla.equalsIgnoreCase("progn2")) {
	    	ejecuta(l.get(1));
	    	return ejecuta(l.get(2));
	    }
	    else if(regla.equalsIgnoreCase("IF-DIRTY")) {
	    	if (cortacesped.DelanteTierra())//Si est podado
				return ejecuta(l.get(1));
	    	else
				return ejecuta(l.get(2));
			
	    	
	    }else if(regla.equalsIgnoreCase("REPEATY")) {
	    	
	    	int veces=ejecuta(l.get(1)).getY()%8;
	    	int temp=i;
	    	
	    	for (int i = 0; i < veces-1; i++) {
	    		ejecuta(l.get(2));
			}
	    	
	    	this.i=temp;
	    	
	    	return ejecuta(l.get(2));
	    }else if(regla.equalsIgnoreCase("REPEATX")) {
	    	int veces=ejecuta(l.get(1)).getX()%8;
	    	int temp=i;
	    	
	    	for (int i = 0; i < veces-1; i++) {
	    		ejecuta(l.get(2));
			}
	    	
	    	this.i=temp;
	    	
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
	    	if (i >= cromosoma.length){
				 i = 0;
				 this.wraps++;
			}
		    if(this.wraps >= this.maxWraps);
		    String x=this.next(l.get(1)).get(0);
		    if (i >= cromosoma.length){
				 i = 0;
				 this.wraps++;
			}
		    if(this.wraps >= this.maxWraps);
		    String y=this.next(l.get(2)).get(0);
		    return new posicion(Integer.parseInt(x),Integer.parseInt(y));
	    }else if(regla.equalsIgnoreCase("<op>")||(regla.equalsIgnoreCase("<x>"))) {
	    	//Solo entra si es del tipo<...>
	    	if (i >= cromosoma.length){
				 i = 0;
				 this.wraps++;
			}
		    if(this.wraps >= this.maxWraps)
		    	return casilla;
		    
	    	return ejecuta(regla);
	    }
	    return casilla;
	   
	}
	private List<String> next(String clave) {
		// TODO Auto-generated method stub
		List<String> s =BNFGramatica.regla(clave,cromosoma[i]);
		i++;
		return s;
	}


	private boolean terminado() {
		// TODO Auto-generated method stub
		return cortacesped.terminado();
	}
	@Override
	public Individuo copia() {
		IndividuoGramatical copia = new IndividuoGramatical(maxWraps);
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
		cromosoma[pos] =Math.abs(rand.nextInt());
	}
	
	//INICIALIZADOR
	public void inicializacion() {
		Random rand = new Random();
		for (int i = 0 ; i < cromosoma.length;i++)
		{
			cromosoma[i] =  Math.abs(rand.nextInt());
		}
		
	}

	

}
