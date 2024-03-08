package Poblacion;

import java.util.Random;

public class IndividuoFuncion5  extends IndividuoReal {

	private Random rand;
	private int numD;
	public IndividuoFuncion5(int nDim) {
		this.rand=new Random();
		this.numD=nDim;
        this.cromosoma = new Double [nDim];
        for(int i = 0; i < nDim; i++) this.cromosoma[i] = this.rand.nextDouble() * Math.PI;

	}

	@Override
	public double evalua() {
		return getValor();
	}

	private double getValor() {
		double sum = 0;

		for(int i = 0; i < cromosoma.length; i++)
		{
			double xi=this.cromosoma[i];
			sum = sum + Math.sin(xi)*Math.pow((Math.sin(((i+1)*Math.pow(xi, 2))/Math.PI)),10*2);
		}

		return ((-1) * sum);
	}


	@Override
	public Individuo<?> copia() {
		// TODO Auto-generated method stub
		IndividuoFuncion5 copia=new IndividuoFuncion5(this.numD);
		copia.setCromosoma(cromosoma);
		copia.setFitness(this.fitness);
		return copia;
	}


	@Override
	protected String fenotipoToString() {
		String s= "Encontrado en:( ";
		int indice=0;
		for (int i = 0; i < cromosoma.length-1; i++) {
			 indice=i+1;
			s= s+"X"+indice+" = "+cromosoma[i].doubleValue()+", ";
		}
		indice++;
		s= s+"X"+indice+" = "+cromosoma[indice-1].doubleValue()+") ";
		return s;
	}



}
