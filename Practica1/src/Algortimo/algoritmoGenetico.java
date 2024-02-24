package Algortimo;

import java.awt.Cursor;
import java.util.Random;

import Controller.TResultStatistics;
import FunCruzador.Cruzador;
import FuncionMutador.Mutador;
//import FuncionesEvaluador.Evaluador;
import FuncionesSeleccion.Selector;
import ppoblacion.Individuo;
import ppoblacion.Poblacion;

public class algoritmoGenetico {
    
    private int tamPoblacion;
    private Poblacion poblacion;
    private double[] fitness;
    private int maxGeneraciones;
    
    private double probCruce;
    private double probMutacion;
    private int tamTorneo;
    private Individuo<?> elMejor;
    
    private int pos_mejor;
    private int puntuacion ;

	//Datos para grafica
	//private Individuo<?>[] generationAverage;
	//private Individuo<?>[] generationBest;
	//private Individuo<?>[] absoluteBest;
	private double[] aptitud_media_generacion;
	private double[] aptitud_mejor_generacion;
	private double[] aptitud_absoluta_generacion;
	
	private Cruzador cross;
	private Mutador mut;
	private Selector sel;
	private int currentGeneration;
	
	private double precision;
	private double elitismo;

    public algoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion,
    			Selector sel,Mutador mut,Cruzador cruz,Poblacion poblacion,  double elitismo, double precision)
    {
    	this.tamPoblacion = tamPoblacion;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
        this.sel=sel;
        this.mut=mut;
        this.cross=cruz;
        this.poblacion=poblacion;
        this.precision = precision;
        this.elitismo = elitismo;
        
    	 this.aptitud_media_generacion = new double[maxGeneraciones];
    	 this.aptitud_mejor_generacion = new double[maxGeneraciones];
    	 this.aptitud_absoluta_generacion = new double[maxGeneraciones];
    	 
    	// this.absoluteBest = new Individuo<?>[maxGeneraciones];
        
    }
    
    public TResultStatistics executeAlgorithm() {

    	currentGeneration=0;
    	this.initialize();
    	this.evaluar();
    	currentGeneration++;
    	while(currentGeneration!=maxGeneraciones) {
    		this.seleccionar();
    		this.cross.crossover(this.poblacion,tamPoblacion,probCruce);
    		this.mut.mutate(this.poblacion,tamPoblacion,this.probMutacion);
    		this.evaluar();
    		/*	
    		this.generationAverage[currentGeneration] = getGenerationAvg();
    		this.generationBest[currentGeneration] = getGenerationBest();
    		this.absoluteBest[currentGeneration] = getAbsoluteBest();
    	 */
    		currentGeneration++;
    	
    	}
    	
    	
    	double[] gener = new double[maxGeneraciones]; 
    	for (int i = 0; i < maxGeneraciones; i++)
    		gener[i] = i;
    	
    	
    	return new TResultStatistics(gener,this.aptitud_absoluta_generacion,this.aptitud_mejor_generacion,this.aptitud_media_generacion);
    	
    }

	private void evaluar() {
		// TODO Auto-generated method stub
		Individuo<?>[] individuos=poblacion.getIndivuduos();
		Double punt_acu = 0.0;
		Double aptitud_mejor = Double.MIN_VALUE;
		//Individuo<?> mejor=null;
		
		for(int i=0;i<tamPoblacion;i++) {
			double aptitud=individuos[i].getFitness();
			
			punt_acu= punt_acu + aptitud;
			
			if(aptitud>aptitud_mejor) {
				aptitud_mejor=aptitud;
				//mejor=individuos[i];
			}
		}
		
		this.aptitud_media_generacion[this.currentGeneration]=punt_acu/tamPoblacion;
		this.aptitud_mejor_generacion[this.currentGeneration]=aptitud_mejor;
		
		if(this.currentGeneration>0&&this.aptitud_absoluta_generacion[this.currentGeneration-1]<aptitud_mejor) {
			//this.absoluteBest[this.currentGeneration]=mejor;
			this.aptitud_absoluta_generacion[this.currentGeneration]=aptitud_mejor;
		}
		else if (this.currentGeneration>0){
			this.aptitud_absoluta_generacion[this.currentGeneration]=aptitud_absoluta_generacion[this.currentGeneration-1];

		}
		else
			this.aptitud_absoluta_generacion[this.currentGeneration] = aptitud_mejor;
	
	}

	private void seleccionar() {
		// TODO Auto-generated method stub
		this.poblacion.setNuevaPoblacion(sel.seleccionar(this.poblacion.getIndivuduos()));
	}

	private void initialize() {
		// TODO Auto-generated method stub
		poblacion.inicializarIndividuos(tamPoblacion, precision);
	}

	/*
	private Object getGenerationAvg() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getGenerationBest() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getAbsoluteBest() {
		// TODO Auto-generated method stub
		return null;
	}
    */



}
