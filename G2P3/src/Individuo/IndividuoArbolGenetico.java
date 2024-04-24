package Individuo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import Individuo.IndividuoArbolGenetico.nodo;

public abstract class IndividuoArbolGenetico extends Individuo {
	
	protected int maximaProfundidad;
	private int minimaProfundidad;
	
	class nodo{
		 
		private String descripcion;
		private ArrayList<nodo> hijos;
		private int numNodos;
		private int numHijos;
		private nodo padre = null;
		private int idHijo = -1;
		
		public nodo(String descripcion, int size) {// nodo raiz
			// TODO Auto-generated constructor stub
			this.padre = null;
			this.idHijo = -1;
			this.numHijos=size;
			this.numNodos=1;
			this.descripcion = descripcion;
			hijos=new ArrayList<nodo>();
		}
		
		public nodo(String descripcion, int size, nodo padre, int idHijo) {
			// TODO Auto-generated constructor stub
			this.padre = padre;
			this.idHijo = idHijo;
			this.numNodos=1;
			this.descripcion = descripcion;
			hijos=new ArrayList<nodo>(size);
		}
		
		public String getDescript() {
			return descripcion;
		}
		protected nodo hijo1() {
			return this.hijos.get(0);
		}
		protected nodo hijo2() {
			return this.hijos.get(1);
		}
		protected ArrayList<nodo> hijos(){
			return hijos;
		}
		protected boolean funcional() {
			return hijos.size()>0;
			
		}
		
		public nodo copia() {
			nodo n;
			n=new nodo(this.descripcion,this.hijos.size());
			int cont = 0;
			n.numHijos=numHijos;
			n.numNodos=numNodos;
			for(nodo hijo:hijos) {
				n.hijos.add(hijo.copiaConPadre(n,cont));
				cont++;
			}
			return n;
		}
		
		private nodo copiaConPadre(nodo Padre, int HijoId)
		{
			nodo n;
			n=new nodo(this.descripcion,this.hijos.size(), Padre, HijoId);
			int cont = 0;
			n.numNodos=numNodos;
			n.numHijos=numHijos;
			for(nodo hijo:hijos) {
				n.hijos.add(hijo.copiaConPadre(n,cont));
				cont++;
			}
			return n;

		}
		
		
		
		@Override
		public String toString() {
			if(numHijos>0) {
				String s=descripcion+"(";
			
			for(nodo n: hijos) {
				s=s+n.toString()+",";
			}
			s=s.substring(0, s.length()-1);
			s=s+")";
			return s;
			}
			else return descripcion;
		}

		public int calcularMiProfundidad() {
			// TODO Auto-generated method stub
			int i=1;
			nodo n=this.padre;
			while(n!=null) {
				i++;
				n=n.padre;
			}
			return i;	
		}
	}
	 protected nodo raiz;
	protected int totNodos;
	
	 
	 //INICIALIZACIONES
	 
	 
	 //COMPLETA
	 public void inicializacionCompleta(int profundidad) {
		 this.maximaProfundidad=profundidad;
		 raiz=inicializacionCompleta(1,null,-1);
		 this.totNodos=numNodos(raiz);
	 }
	 private nodo inicializacionCompleta(int profundidad, nodo Padre, int HijoId) {
		nodo nuevo;
		 if(profundidad<maximaProfundidad) {
			 nuevo=nodoFuncional();
			 int cont = 0;
			 for(int i=0;i<nuevo.numHijos;i++)
			 {
				 nuevo.hijos().add(inicializacionCompleta(profundidad + 1, nuevo, cont));
				 cont++;
			 }
		 }
		 else
			 nuevo=nodoTernminal();
		 nuevo.padre = Padre;
		 nuevo.idHijo = HijoId;
		 
		 return nuevo;
	 }
	 
	//GROW
	 public void inicializacionCreciente(int profundidad) {
		 this.maximaProfundidad=profundidad;
		 raiz=inicializacionCreciente(1,null,-1);
		 this.totNodos=numNodos(raiz);
	 }
	 private nodo inicializacionCreciente(int profundidad,  nodo Padre, int HijoId) {
		nodo nuevo;
		
		 if(profundidad<maximaProfundidad) {
			if(profundidad==1)  nuevo=nodoFuncional();
			else	nuevo=nodoaleatorio();
			
			 int cont = 0;
			 for(int i=0;i<nuevo.numHijos;i++)
			 {
				 nuevo.hijos().add(inicializacionCompleta(profundidad + 1, nuevo, cont));
				 cont++;
			 }
		 }
		 else
			 nuevo=nodoTernminal();
		 nuevo.padre = Padre;
		 nuevo.idHijo = HijoId;
		 return nuevo;
	 }

	//RAMPED AND HALF
	private nodo nodoaleatorio() {
		// TODO Auto-generated method stub
		Random rand =new Random();
		if(rand.nextDouble()<0.5) 
			return nodoFuncional();
		else
			return nodoTernminal();
		}
	
	protected abstract nodo nodoFuncional();
	protected abstract nodo nodoTernminal();
	protected abstract nodo nodoFuncionalConAridadN(int n);
	
	protected nodo copiaArbol() {	
		return raiz.copia();
	}
	//MUTADORES
	//Mutador terminal
	public void mutacionTerminal() {
		//this.mutarTerminal(raiz);
		List<nodo> nodos = new ArrayList<nodo>();
		obtenerNodosTerminales(raiz,nodos);
		Random rand = new Random();
		int seleccionado = rand.nextInt(nodos.size());
		
		
		//CambiarTerminal
		int HijoId = nodos.get(seleccionado).idHijo;
		nodo padre = nodos.get(seleccionado).padre;
		
		nodo nuevoNodoTerm = nodoTernminal();
		nuevoNodoTerm.padre = padre;
		nuevoNodoTerm.idHijo = HijoId;
		padre.hijos.set(HijoId, nuevoNodoTerm);
		
	}
	/*private void mutarTerminal(nodo n) { 
		int hijos=n.hijos.size();
		if(hijos==0)//es terminal
			n=nodoTernminal();
		else {
			 Random rand = new Random();
	         int indiceAleatorio = rand.nextInt(hijos);
	         mutarTerminal(n.hijos.get(indiceAleatorio));
		}
		
	}*/
	//Mutador funcional
	public void mutacionFuncinal() {
		this.mutacionFuncinal(raiz);
	}
    private void mutacionFuncinal(nodo n) {
        Random rand = new Random();

        // Lista de nodos funcionales
        List<nodo> nodosFuncionales = new ArrayList<>();
        obtenerNodosFun(n, nodosFuncionales);

        // Si hay nodos funcionales, elige uno aleatoriamente y cambia su valor
        if (!nodosFuncionales.isEmpty()) {
            int indiceAleatorio = rand.nextInt(nodosFuncionales.size()-1)+1;
            nodo nodoAleatorio = nodosFuncionales.get(indiceAleatorio);
            
            
            int HijoId = nodoAleatorio.idHijo;
    		nodo padre = nodoAleatorio.padre;
    		
        	nodo nuevo = nodoFuncionalConAridadN(nodoAleatorio.hijos.size());
    		
        	nuevo.hijos = nodoAleatorio.hijos;
        	
        	padre.hijos.set(HijoId, nuevo);

    		
        	nuevo.padre = padre;
        	nuevo.idHijo = HijoId;
        }
    }    
	// Método para obtener todos los nodos funcionales del árbol
    private void obtenerNodosFuncionales(nodo n, List<nodo> nodosFuncionales) {
        if (!n.hijos.isEmpty()) {
            nodosFuncionales.add(n);
            for (nodo hijo : n.hijos) {
                obtenerNodosFuncionales(hijo, nodosFuncionales);
            }
        }
    }
    private void obtenerNodosFun(nodo n, List<nodo> nodosFuncionales) {
        nodosFuncionales.add(n);
        for (nodo hijo : n.hijos) {
            obtenerNodosFuncionales(hijo, nodosFuncionales);
        }
        
    }    
    
    
    
    //Mutacion arbol-subarbol
    	//1 Inicializacion
    public void mutacionInicializacion() {
    	inicializacionCompleta(this.maximaProfundidad);
    }
    	//2 Parcial
    public void mutacionArbolSubArbol() {
    	  Random rand = new Random();

          // Lista de nodos funcionales
          List<nodo> nodos = new ArrayList<>();
          obtenerTodosLosNodos(raiz, nodos);

          // Si hay nodos funcionales, elige uno aleatoriamente y cambia su valor
          if (!nodos.isEmpty()) {
        	  int indiceAleatorio = rand.nextInt(nodos.size());
              nodo nodoAleatorio = nodos.get(indiceAleatorio);

        	  while(nodoAleatorio.padre == null)
        	  {
        		  indiceAleatorio = rand.nextInt(nodos.size());
                  nodoAleatorio = nodos.get(indiceAleatorio);
        	  }
              
              int p= nodoAleatorio.calcularMiProfundidad();
              int HijoId = nodoAleatorio.idHijo;
              nodo padre = nodoAleatorio.padre;
              nodoAleatorio= inicializacionCompleta(p, padre, HijoId);
              
              padre.hijos.set(HijoId, nodoAleatorio);
          }
          this.totNodos=numNodos(raiz);
      }  
    
    

    //CRUCE

	public void cruceSubArbol1(Individuo individuo2)
	{
		
		reset();
		//Obtener los nodos
		if(this.maximaProfundidad<2)return;
		List<nodo> nodos = new ArrayList<nodo>();
		Random rand = new Random();
		boolean fun=false;
		if (rand.nextDouble() <= 0.9)
		{
			obtenerNodosFuncionales(raiz,nodos);
			fun=true;
		}
		else
		{
			obtenerNodosTerminales(raiz,nodos);
		}
		
		//Seleccionar un Nodo aleatorio donde haremos el cruce
		int pos=0;
		if(fun) {
			if(nodos.size()==1)return;
			while(pos==0)
				pos = rand.nextInt(nodos.size());
		}
		else
			pos = rand.nextInt(nodos.size());
		nodo subArbolSeleccionado = nodos.get(pos).copia();
		nodo subArbolParaCruce = ((IndividuoArbolGenetico)individuo2).cruceSubArbol2(subArbolSeleccionado);
		if(subArbolParaCruce==null)return;
		//CRUCE
		nodo padre = nodos.get(pos).padre;
		int Hijoid = nodos.get(pos).idHijo;
		
		subArbolParaCruce.padre = padre;
		subArbolParaCruce.idHijo = Hijoid;
		padre.hijos.set(Hijoid, subArbolParaCruce);
		this.totNodos=numNodos(raiz);
	}
	
	public nodo cruceSubArbol2(nodo subArbolParaCruce)
	{
		reset();
		List<nodo> nodos = new ArrayList<nodo>();
		Random rand = new Random();
		boolean fun=false;
		if (rand.nextDouble() <= 0.9)
		{
			obtenerNodosFuncionales(raiz,nodos);
			fun=true;
		}
		else
		{
			obtenerNodosTerminales(raiz,nodos);
		}
		//Seleccionar un Nodo aleatorio donde haremos el cruce
		int pos=0;
		if(fun) {
			if(nodos.size()==1)return null;
			while(pos==0)
				pos = rand.nextInt(nodos.size());
		}
		else
			pos = rand.nextInt(nodos.size());
		
		nodo subArbolSeleccionado = nodos.get(pos).copia();
		
		// CRUCE
		nodo padre = nodos.get(pos).padre;
		int Hijoid = nodos.get(pos).idHijo;
		
		subArbolParaCruce.padre = padre;
		subArbolParaCruce.idHijo = Hijoid;
		padre.hijos.set(Hijoid, subArbolParaCruce);
		this.totNodos=numNodos(raiz);
		
		// DEVOLVEMOS EL SUBARBOL QUE IRÁ EN EL OTRO INDIVIDUO
		return subArbolSeleccionado;
	}

	
	
	
	private void obtenerNodosTerminales(nodo n, List<nodo> nodosTerm) {
		if (!n.hijos.isEmpty()) {
            for (nodo hijo : n.hijos) {
                obtenerNodosTerminales(hijo, nodosTerm);
            }
        }
		else
			nodosTerm.add(n);
	}


	private void obtenerTodosLosNodos(nodo n, List<nodo> nodos) {
		nodos.add(n);
		if (!n.hijos.isEmpty()) {
            for (nodo hijo : n.hijos) {
            	obtenerTodosLosNodos(hijo, nodos);
            }
        }
	}
	public  abstract void reset();
    
	@Override
	public String toString() {
		String s="El cortacesped ha podado:"+this.fitness+"\n(";
		
			s=s+raiz.toString();
	
		s=s+")"+totNodos;
		return s;
	}
	private int numNodos(nodo n) {
		int contador=1;
		for(nodo h:n.hijos) {
			contador+=numNodos(h);
		}
		return contador;
	}
	public int getTamanio() {
		
		return this.totNodos;
	}
}
