package Algortimo;

import java.awt.Cursor;

import FunCruzador.Cruzador;
import FuncionMutador.Mutador;
import FuncionesEvaluador.Evaluador;
import FuncionesSeleccion.Selector;
import ppoblacion.Individuo;

public class algoritmoGenetico {
    
    private int tamPoblacion;
    private Individuo[] poblacion;
    private double[] fitness;
    private int maxGeneraciones;
    private double probCruce;
    private double probMutacion;
    private int tamTorneo;
    private Individuo elMejor;
    private int pos_mejor;
	private Individuo[] generationAverage;
	private Individuo[] generationBest;
	private Individuo[] absoluteBest;
	private Evaluador ev;
	private Cruzador cross;
	private Mutador mut;
	private Selector sel;

    public algoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion,
    			Evaluador ev,Selector sel,Mutador mut,Cruzador cruz) //A�ADIR FUNCIONES CRUCE, MUTACION, SELECCION, FITNESS, INICIALIZACION
    {
    	this.tamPoblacion = tamPoblacion;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
        this.ev=ev;
        this.sel=sel;
        this.mut=mut;
        this.cross=cruz;
        
    }
    
    public AGView executeAlgorithm() {

    	int currentGeneration=0;
    	this.initialize();
    	this.ev.evaluar();
    	while(currentGeneration!=maxGeneraciones) {
    		this.sel.seleccionar();
    		this.cross.crossover();
    		this.mut.mutate();
    		this.ev.evaluar();
    		this.generationAverage[currentGeneration] = getGenerationAvg();
    		this.generationBest[currentGeneration] = getGenerationBest();
    		this.absoluteBest[currentGeneration] = getAbsoluteBest();

    		currentGeneration++;
    	}
    
    }

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
    



}
