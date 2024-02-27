package Poblacion;

import java.util.Random;

public class IndividuoFuncion3  extends IndividuoBinario {
	private double valorError;
	private Random rand;
	
	public IndividuoFuncion3(double precision) {
		super();
		this.valorError = precision;
		
		//inicializar
		this.rand=new Random();
		this.tamGen=new int[2];
		this.min=new double[2];
		this.max=new double[2];
		this.inicioGen=new int[2];
		
		//asignar limites y parametros
	    this.min[0] = -10.00;
        this.min[1] = -10.00;
        this.max[0] = 10;
        this.max[1] = 10;
        this.tamGen[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGen[1] = this.tamGen(this.valorError, min[1], max[1]);    
        int tamTotal = tamGen[0] + tamGen[1];
        inicioGen[0]=0;
        inicioGen[1]=tamGen[0];
        this.cromosoma = new Boolean [tamTotal];
        
        //dar valor a los genes 
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
   
	}
	
	public double evalua() {
		return getValor();
	}

	private double getValor() {
		double x1=this.getFenotipo(0);
		double x2=this.getFenotipo(1);
		return ((-1)*Math.abs(Math.sin(x1)*Math.cos(x2)*Math.exp(Math.abs(1-(Math.sqrt(x1*x1+x2*x2)/Math.PI)))));
	}
	@Override
	public Individuo<?> copia() {
		// TODO Auto-generated method stub
		IndividuoFuncion3 copia=new IndividuoFuncion3(this.valorError);
		copia.setCromosoma(cromosoma);
		copia.setFitness(this.fitness);
		return copia;
	}

	
	@Override
	public double[] getFenotipoTot() {
		double[] v = new double[2];
		v[0] = getFenotipo(0);
		v[1] = getFenotipo(1);
		return v;
	}

	@Override
	protected String fenotipoToString() {
		// TODO Auto-generated method stub
		return "Encontrado en:(X1 ="+ getFenotipo(0)+",X2 = " + getFenotipo(1)+") "; 
	}
}
