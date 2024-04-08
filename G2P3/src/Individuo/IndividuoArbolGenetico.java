package Individuo;

import java.util.ArrayList;
import java.util.Random;

import Individuo.IndividuoArbolGenetico.nodo;

public abstract class IndividuoArbolGenetico extends Individuo {
	
	private int maximaProfundidad;
	private int minimaProfundidad;

	class nodo{
		 
		private String descripcion;
		private ArrayList<nodo> hijos;
		public int profundidad;
		private int numNodos;
		
		public nodo(String descripcion, int size) {
			// TODO Auto-generated constructor stub
			this.numNodos=0;
			this.profundidad=0;
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
		public nodo copia() {
			nodo n=new nodo(this.descripcion,this.hijos.size());
			for(nodo hijo:hijos) {
				n.hijos.add(hijo.copia());
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
		 raiz=inicializacionCompleta(0);
	 }
	 private nodo inicializacionCompleta(int profundidad) {
		nodo nuevo;
		 if(profundidad<maximaProfundidad) {
			 nuevo=nodoFuncional();
			 for(nodo h:nuevo.hijos)
				 h=inicializacionCompleta(profundidad + 1);
		 }
		 else
			 nuevo=nodoTernminal();
		 nuevo.calcularProfundidad();
		 nuevo.calculaNodos();//suma los nodos de sus hijos +1 por cada hijo
		 return nuevo;
	 }
	 
	//GROW
	 public void inicializacionCreciente() {
		 raiz=inicializacionCreciente(0);
	 }
	 private nodo inicializacionCreciente(int profundidad) {
		nodo nuevo;
		 if(profundidad<maximaProfundidad) {
			 nuevo=nodoaleatorio();
			 for(nodo h:nuevo.hijos)
				 h=inicializacionCompleta(profundidad + 1);
		 }
		 else
			 nuevo=nodoTernminal();
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
	protected nodo copiaArbol() {	
		return raiz.copia();
	}
	//MUTADORES
	//Mutador terminal
	
}
