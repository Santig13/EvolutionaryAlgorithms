package Algortimo;

import java.util.Arrays;

import Controlador.TResultStatistics;
import Factorias.FactoriaPoblaciones;
import FunCruzador.Cruzador;
import FuncionMutador.Mutador;
//import FuncionesEvaluador.Evaluador;
import FuncionesSeleccion.Selector;
import Poblacion.Individuo;
import Poblacion.TPoblacion;

public class algoritmoGenetico {

    private int tamPoblacion;
    private TPoblacion poblacion;
    private int maxGeneraciones;

    private double probCruce;
    private double probMutacion;
    private Individuo<?>[] elite;
    private Individuo<?> elMejor;
    
    //Datos para grafica
    private int pos_mejor;
	private double[] aptitud_media_generacion;
	private double[] aptitud_mejor_generacion;
	private double[] aptitud_absoluta_generacion;
	private double[] presion_evolutiva_generacional;
	double[] gener;

	private Cruzador cross;
	private Mutador mut;
	private Selector sel;
	private int currentGeneration;

	private int nElite;
	private boolean minimizar;
	
	private String vuelostxt;
	private String TELtxt;

    public algoritmoGenetico(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion,
    			Selector sel,Mutador mut,Cruzador cruz,TPoblacion poblacion,  double porcenElite, String vuelostxt, String TELtxt)
    {
    	this.tamPoblacion = tamPoblacion;
        this.maxGeneraciones = maxGeneraciones;
        this.probCruce = probCruce;
        this.probMutacion = probMutacion;
        this.sel=sel;
        this.mut=mut;
        this.cross=cruz;
        this.poblacion=poblacion;
        this.nElite = (int) (porcenElite*tamPoblacion);
    	this.aptitud_media_generacion = new double[maxGeneraciones];
    	this.aptitud_mejor_generacion = new double[maxGeneraciones];
    	this.aptitud_absoluta_generacion = new double[maxGeneraciones];
    	this.presion_evolutiva_generacional = new double[maxGeneraciones];
    	gener= new double[maxGeneraciones];
    	this.vuelostxt = vuelostxt;
    	this.TELtxt = TELtxt;
    }

    public TResultStatistics executeAlgorithm() {

    	currentGeneration=0;
    	this.initialize();
    	this.evaluar();
    	currentGeneration++;
    	while(currentGeneration!=maxGeneraciones) {
    		if(nElite>0) {
    			apartarElite();
    		}
    		this.seleccionar();
    		this.cross.crossover(this.poblacion,tamPoblacion,probCruce);
    		this.mut.mutate(this.poblacion,tamPoblacion,this.probMutacion);
    		if(nElite>0) {
    			introducirElite();
    		}
    		this.evaluar();
    	//	if(aptitud_media_generacion[this.currentGeneration]>aptitud_media_generacion[currentGeneration-1])//Contractividad
    			currentGeneration++;

    	}






    	return new TResultStatistics(elMejor.toString(),gener,this.aptitud_absoluta_generacion,this.aptitud_mejor_generacion,this.aptitud_media_generacion,this.pos_mejor,this.presion_evolutiva_generacional);

    }

	private void introducirElite() {
		// TODO Auto-generated method stub
		Arrays.sort(poblacion.getIndivuduos(),new IndividuoComparator());
		for(int i=0;i<nElite;i++) {
			poblacion.swap(i,elite[i]);
		}
	}

	private void apartarElite() {
		// TODO Auto-generated method stub
		this.elite=new Individuo<?>[nElite];
		Arrays.sort(poblacion.getIndivuduos(),new IndividuoComparator());
		int x=0;
		for(int i=tamPoblacion-nElite;i<tamPoblacion;i++) {
			elite[x]=poblacion.getCopiaIndivuduo(i);
			x++;
		}
	}

	private void evaluar() {
		// TODO Auto-generated method stub
		Individuo<?>[] individuos=poblacion.getIndivuduos();
		double sumaFit = 0.0;
		Double maximo = Double.MIN_VALUE;
		Individuo<?> mejor=null;
		gener[currentGeneration]=currentGeneration;

		for(int i=0;i<tamPoblacion;i++) {
			double aptitud=individuos[i].evalua();

			sumaFit+=aptitud;
			individuos[i].setFitness(aptitud);
			if(aptitud>maximo) {
				maximo=aptitud;
				mejor = individuos[i].copia();
			}
		}


		this.aptitud_media_generacion[this.currentGeneration]=sumaFit/tamPoblacion;
		


		if(minimizar) {

			sumaFit = 0.0;
			double aux=0;
			for(int i=0;i<tamPoblacion;i++) {
				aux=(maximo*1.05)-individuos[i].evalua();
				individuos[i].setFitness(aux);
				sumaFit+=aux;
			}
			maximo = Double.MIN_VALUE;
			for(int i=0;i<tamPoblacion;i++) {
				double aptitud=individuos[i].getFintess();
				if( aptitud > maximo)
				{
					maximo=individuos[i].getFintess();
					mejor = individuos[i].copia();
				}
			}
		}

		for(int i=0;i<tamPoblacion;i++) {
			individuos[i].setPuntuacion(individuos[i].getFintess()/sumaFit);
		}

		this.aptitud_mejor_generacion[this.currentGeneration]=mejor.evalua();
		this.presion_evolutiva_generacional[this.currentGeneration]=this.aptitud_mejor_generacion[this.currentGeneration]/this.aptitud_media_generacion[this.currentGeneration];
		if(this.currentGeneration==0||(this.currentGeneration>0&&
				((this.elMejor.getFintess()<mejor.getFintess()&&!minimizar)||
						(this.elMejor.evalua()>mejor.evalua()&&minimizar)))){
			elMejor=mejor;
			this.aptitud_absoluta_generacion[this.currentGeneration]=mejor.evalua();
			this.pos_mejor=currentGeneration;
		}
		else{
			this.aptitud_absoluta_generacion[this.currentGeneration]=aptitud_absoluta_generacion[this.currentGeneration-1];

		}
	}


	private void seleccionar() {
		// TODO Auto-generated method stub
		this.poblacion.setNuevaPoblacion(sel.seleccionar(this.poblacion.getIndivuduos()));
	}

	private void initialize() {
		// TODO Auto-generated method stub
		poblacion=FactoriaPoblaciones.getInstancia().generarPoblacion(vuelostxt,TELtxt,tamPoblacion);
		this.minimizar=poblacion.isMin();
	}

}
