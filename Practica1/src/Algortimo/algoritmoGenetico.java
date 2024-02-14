package Algortimo;

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
	private Evaluator ev;
	private Object cross;
	private Object mut;
	private Object sel;

    public algoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, String NombreProblema) //AÑADIR FUNCIONES CRUCE, MUTACION, SELECCION Y FITNESS
    {
    	this.tamPoblacion = tamPoblacion;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
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

	private void initialize() {
		// TODO Auto-generated method stub
		
	}
    



}
