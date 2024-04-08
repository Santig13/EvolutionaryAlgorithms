package Individuo;

import java.util.ArrayList;
import java.util.Random;

public abstract class IndividuoArbolGenetico {
	private int maximaProfundidad;
    protected double fitness;
    protected double puntuacion;
	class nodo{
		 
		private String descripcion;
		private ArrayList<nodo> hijos;
		
		public nodo(String descripcion, int size) {
			// TODO Auto-generated constructor stub
			this.descripcion = descripcion;
			hijos=new ArrayList<nodo>(size);
		}
		public nodo() {
			//Costructor para la raiz
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
	}
	 private nodo raiz;
	
	 
	 //INICIALIZACIONES
	 
	 
	 //COMPLETA
	 public void inicializacionCompleta() {
		 raiz=new nodo();
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
		 return nuevo;
	 }
	 
	//GROW
	 public void inicializacionCreciente() {
		 raiz=new nodo();
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
	public abstract IndividuoArbolGenetico copia();
	protected abstract double evalua();
	public double getFintess() {
		// TODO Auto-generated method stub
		return this.fitness;
	}

}
