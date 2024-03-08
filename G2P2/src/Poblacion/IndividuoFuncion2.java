package Poblacion;

import java.util.Random;

public class IndividuoFuncion2 extends IndividuoBinario {

    private double valorError = 0;
	private Random rand;


    public IndividuoFuncion2 (double precision)
    {
        super();
        this.valorError = precision;

		this.rand=new Random();
        this.tamGen = new int[2];
        this.min = new double[2];
        this.max = new double[2];
		this.inicioGen=new int[2];


        this.min[0] = -10.000;
        this.min[1] = -6.5;
        this.max[0] = 0;
        this.max[1] = 0;
        this.tamGen[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGen[1] = this.tamGen(this.valorError, min[1], max[1]);
        int tamTotal = tamGen[0] + tamGen[1];
        inicioGen[0]=0;
        inicioGen[1]=tamGen[0];
        this.cromosoma = new Boolean [tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean(); //Para inicializar el individuo de forma aleatoria
    }

    @Override
	public double evalua() {
		return getValor();
	}

    private double getValor() {
    	double x1 = this.getFenotipo(0);
    	double x2 = this.getFenotipo(1);

    	double parte1 = Math.sin(x2) * Math.exp(1 - Math.cos(x1)) * Math.exp(1 - Math.cos(x1));
        double parte2 = Math.cos(x1) * Math.exp(1 - Math.sin(x2)) * Math.exp(1 - Math.sin(x2));
        double parte3 = (x1 - x2) * (x1 - x2);
        return (parte1 + parte2 + parte3);
	}

	@Override
	public Individuo<?> copia() {
		// TODO Auto-generated method stub
		IndividuoFuncion2 copia=new IndividuoFuncion2(this.valorError);
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
