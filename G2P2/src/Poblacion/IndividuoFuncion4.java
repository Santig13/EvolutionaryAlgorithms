package Poblacion;

import java.util.Random;

public class IndividuoFuncion4  extends IndividuoBinario{
	private double valorError;
	private Random rand;
	private int numD;
	public IndividuoFuncion4(double precision, int nDim) {
		super();
		this.valorError = precision;
		this.numD=nDim;
		//inicializar
		this.rand=new Random();
		this.tamGen=new int[nDim];
		this.min=new double[nDim];
		this.max=new double[nDim];
		this.inicioGen=new int[nDim];

		//asignar limites y parametros
		 int tamTotal = 0;

		for (int i = 0; i < nDim; i++)
		{
			 this.min[i] = 0;
		     this.max[i] = Math.PI;
		     this.tamGen[i] = this.tamGen(this.valorError, min[i], max[i]);
			 inicioGen[i]=tamTotal;
		     tamTotal += this.tamGen[i];
		}


        this.cromosoma = new Boolean [tamTotal];

        //dar valor a los genes
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();

	}

	@Override
	public double evalua() {
		return getValor();
	}

	private double getValor() {
		double sum = 0;

		for(int i = 0; i < inicioGen.length; i++)
		{
			double xi=this.getFenotipo(i);
			sum +=Math.sin(xi)*Math.pow((Math.sin(((i+1)*Math.pow(xi, 2))/Math.PI)),10*2);
		}

		return ((-1) * sum);
	}
	@Override
	public Individuo<?> copia() {
		// TODO Auto-generated method stub
		IndividuoFuncion4 copia=new IndividuoFuncion4(this.valorError, this.numD);
		copia.setCromosoma(cromosoma);
		copia.setFitness(this.fitness);
		return copia;
	}

	@Override
	public double[] getFenotipoTot() {
		double[] v = new double[inicioGen.length];
		for (int i = 0; i < inicioGen.length; i++)
		{
			v[i] = getFenotipo(i);
		}
		return v;
	}

	@Override
	protected String fenotipoToString() {
		String s= "Encontrado en:( ";
		int indice=0;
		for (int i = 0; i < inicioGen.length-1; i++) {
			 indice=i+1;
			s= s+"X"+indice+" = "+getFenotipo(i)+", ";
		}
		indice++;
		s= s+"X"+indice+" = "+getFenotipo(indice-1)+") ";
		return s;
	}
}
