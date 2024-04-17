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
		public int profundidad;
		private int numNodos;
		
		private nodo padre = null;
		private int idHijo = -1;
		
		public nodo(String descripcion, int size) {// nodo raiz
			// TODO Auto-generated constructor stub
			this.padre = null;
			this.idHijo = -1;

			this.numNodos=1;
			this.profundidad=1;
			this.descripcion = descripcion;
			hijos=new ArrayList<nodo>(size);
		}
		
		public nodo(String descripcion, int size, nodo padre, int idHijo) {
			// TODO Auto-generated constructor stub
			this.padre = padre;
			this.idHijo = idHijo;
			
			this.numNodos=1;
			this.profundidad=1;
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
			for(nodo hijo:hijos) {
				n.hijos.add(hijo.copiaConPadre(n,cont));
				cont++;
			}
			return n;

		}
		
		
		public void calculaNodos() {
		    numNodos = 1; // Contar el nodo actual
		    for (nodo hijo : hijos) {
		        numNodos += hijo.numNodos;
		    }
		    
		}

		public void calcularProfundidad() {
		    profundidad = 0; 
		    for (nodo hijo : hijos) {
		        profundidad = Math.max(profundidad, hijo.profundidad);
		    }
		    profundidad++; 
		}
	}
	 protected nodo raiz;
	
	 
	 //INICIALIZACIONES
	 
	 
	 //COMPLETA
	 public void inicializacionCompleta() {
		 raiz=inicializacionCompleta(0,null,-1);
	 }
	 private nodo inicializacionCompleta(int profundidad, nodo Padre, int HijoId) {
		nodo nuevo;
		 if(profundidad<maximaProfundidad) {
			 nuevo=nodoFuncional();
			 int cont = 0;
			 for(nodo h:nuevo.hijos)
			 {
				 h=inicializacionCompleta(profundidad + 1, nuevo, cont);
				 cont++;
			 }
		 }
		 else
			 nuevo=nodoTernminal();
		 nuevo.padre = Padre;
		 nuevo.idHijo = HijoId;
		 nuevo.calcularProfundidad();
		 nuevo.calculaNodos();//suma los nodos de sus hijos +1 por cada hijo
		 return nuevo;
	 }
	 
	//GROW
	 public void inicializacionCreciente() {
		 raiz=inicializacionCreciente(0,null,-1);
	 }
	 private nodo inicializacionCreciente(int profundidad,  nodo Padre, int HijoId) {
		nodo nuevo;
		 if(profundidad<maximaProfundidad) {
			 nuevo=nodoaleatorio();
			 int cont = 0;
			 for(nodo h:nuevo.hijos)
			 {
				 h=inicializacionCreciente(profundidad + 1, nuevo, cont);
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
            int indiceAleatorio = rand.nextInt(nodosFuncionales.size());
            nodo nodoAleatorio = nodosFuncionales.get(indiceAleatorio);
            
            
            int HijoId = nodoAleatorio.idHijo;
    		nodo padre = nodoAleatorio.padre;
    		
        	nodo nuevo = nodoFuncionalConAridadN(nodoAleatorio.hijos.size());
        	nuevo.padre = padre;
        	nuevo.idHijo = HijoId;
    		padre.hijos.set(HijoId, nuevo);
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
    	inicializacionCompleta();
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
              nodoAleatorio.calcularProfundidad();
              int HijoId = nodoAleatorio.idHijo;
              nodo padre = nodoAleatorio.padre;
              nodoAleatorio= inicializacionCompleta(nodoAleatorio.profundidad, padre, HijoId);
          }
      }  
    
    

    //CRUCE

	public void cruceSubArbol1(Individuo individuo2)
	{
		
		
		//Obtener los nodos
		List<nodo> nodos = new ArrayList<nodo>();
		Random rand = new Random();
		if (rand.nextDouble() <= 0.9)
		{
			obtenerNodosFuncionales(raiz,nodos);
		}
		else
		{
			obtenerNodosTerminales(raiz,nodos);
		}
		
		//Seleccionar un Nodo aleatorio donde haremos el cruce
		int pos = rand.nextInt(nodos.size());
		nodo subArbolSeleccionado = nodos.get(pos).copia();
		nodo subArbolParaCruce = individuo2.cruceSubArbol2(subArbolSeleccionado);
		
		//CRUCE
		nodo padre = nodos.get(pos).padre;
		int Hijoid = nodos.get(pos).idHijo;
		
		subArbolParaCruce.padre = padre;
		subArbolParaCruce.idHijo = Hijoid;
		padre.hijos.set(Hijoid, subArbolParaCruce);
		
	}
	
	public nodo cruceSubArbol2(nodo subArbolParaCruce)
	{
		List<nodo> nodos = new ArrayList<nodo>();
		Random rand = new Random();
		if (rand.nextDouble() <= 0.9)
		{
			obtenerNodosFuncionales(raiz,nodos);
		}
		else
		{
			obtenerNodosTerminales(raiz,nodos);
		}
		//Seleccionar un Nodo aleatorio donde haremos el cruce
		int pos = rand.nextInt(nodos.size());
		nodo subArbolSeleccionado = nodos.get(pos).copia();
		
		// CRUCE
		nodo padre = nodos.get(pos).padre;
		int Hijoid = nodos.get(pos).idHijo;
		
		subArbolParaCruce.padre = padre;
		subArbolParaCruce.idHijo = Hijoid;
		padre.hijos.set(Hijoid, subArbolParaCruce);
		
		
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

    
	
}
