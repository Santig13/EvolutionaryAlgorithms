package ppoblacion;

import java.util.Random;

public class IndividuoFuncion5  extends Individuo<Double> {

	private Random rand;
	private int numD;
	public IndividuoFuncion5(int nDim) {
		this.rand=new Random();
		this.numD=nDim;
        this.cromosoma = new Double [nDim];
        for(int i = 0; i < nDim; i++) this.cromosoma[i] = this.rand.nextDouble() * Math.PI;

	}
	
	public double evalua() {
		return getValor();
	}

	private double getValor() {
		double sum = 0;
		
		for(int i = 0; i < cromosoma.length; i++)
		{
			double xi=this.cromosoma[i];
			sum = sum + Math.sin(xi)*Math.pow((Math.sin((i*xi*xi)/Math.PI)),10*2);
		}
		
		return ((-1) * sum);
	}

	
	@Override
	public void cruzarMonopunto(int i, Individuo<?> padre2) {
		Double[] cromosomaPadre=(Double[]) padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}
		
	}

	@Override
	public void cruzarUniforme(Boolean primero, Boolean[] cruzar, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Double[] cromosomaPadre=(Double[]) padre2.getCromosoma();
		for(int i=0;i<cromosoma.length;i++) {
			if(cruzar[i]==primero) {
				cromosoma[i]=cromosomaPadre[i];
			}
		}
	}

	@Override
	public void mutarBasico(double probMutac) {
		Random r=new Random();
		for(int i=0;i<cromosoma.length;i++) {
			double p=r.nextDouble();
			if(p<probMutac) {
				cromosoma[i]= this.rand.nextDouble() * Math.PI;
			}
		}
		
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
	public double[] getFenotipoTot() {
		
		double[] v = new double[cromosoma.length];
		for (int i = 0; i < cromosoma.length; i++)
		{
			v[i] = cromosoma[i].doubleValue();
		}
		return v;
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
