package ppoblacion;

import java.util.Random;

public class IndividuoFuncion4  extends Individuo<Boolean>{
	private double valorError;
	private Random rand;
	
	public IndividuoFuncion4(double precision, int nDim) {
		super();
		this.valorError = precision;
		
		//inicializar
		this.rand=new Random();
		this.tamGen=new int[nDim];
		this.min=new double[nDim];
		this.max=new double[nDim];
		this.inicioGen=new int[nDim];
		
		//asignar limites y parametros
		 int tamTotal = 0;
		 this.min[0] = 0;
	     this.max[0] = Math.PI;
	     this.tamGen[0] = this.tamGen(this.valorError, min[0], max[0]);
	     tamTotal = tamTotal + this.tamGen[0];
		 inicioGen[0]=0;

		for (int i = 1; i < nDim; i++)
		{
			 this.min[i] = 0;
		     this.max[i] = Math.PI;
		     this.tamGen[i] = this.tamGen(this.valorError, min[i], max[i]);
			 inicioGen[i]=tamTotal;
		     tamTotal = tamTotal + this.tamGen[i];
		}
	   
       
        this.cromosoma = new Boolean [tamTotal];
        
        //dar valor a los genes 
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
   
	}
	
	public double getFitness() {
		return getValor();
	}

	private double getValor() {
		double sum = 0;
		
		for(int i = 0; i < inicioGen.length; i++)
		{
			double xi=this.getFenotipo(i);
			sum = sum + Math.sin(xi)*Math.pow((Math.sin((i*xi*xi)/Math.PI)),10*2);
		}
		
		return -((-1) * sum);
	}

	private double getFenotipo(int i) {
		// TODO Auto-generated method stub
		return min[i]+this.bin2dec(i)*((max[i]-min[i])/(Math.pow(2,this.tamGen[i])-1)) ;
	}

	private double bin2dec(int v) {
		int decimal=0;
		for(int i=inicioGen[v]+this.tamGen[v]-1;i>=inicioGen[v];i--) {
			int posicion=(inicioGen[v]+this.tamGen[v]-1)-i;//no es asi aun
			if(this.cromosoma[i]) {
				decimal+=Math.pow(2, posicion);
			}
		}
		return decimal;
	}

	@Override
	public void cruzarMonopunto(int i, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Boolean[] cromosomaPadre=(Boolean[]) padre2.getCromosoma();
		for(int x=i;x<cromosoma.length;x++) {
			cromosoma[x]=cromosomaPadre[x];
		}
		
	}


	@Override
	public void cruzarUniforme(Boolean primero,Boolean[] cruzar, Individuo<?> padre2) {
		// TODO Auto-generated method stub
		Boolean[] cromosomaPadre=(Boolean[]) padre2.getCromosoma();
		for(int i=0;i<cromosoma.length;i++) {
			if(cruzar[i]==primero) {
				cromosoma[i]=cromosomaPadre[i];
			}
		}
	}

	@Override
	public void mutarBasico(double probMutac) {
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=0;i<cromosoma.length;i++) {
			double p=r.nextDouble();
			if(p<probMutac) {
				cromosoma[i]=!cromosoma[i];
			}
		}
	}
}
