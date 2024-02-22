package ppoblacion;

import java.util.Random;

public class IndividuoFuncion1 extends Individuo<Boolean> {
	private double valorError;
	private Random rand;
	
	public IndividuoFuncion1() {
		super();
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
	
	public double getFitness() {
		return getValor();
	}

	private double getValor() {
		double x1=this.getFenotipo(0);
		double x2=this.getFenotipo(1);
		return Math.pow(x1, 2)+2*Math.pow(x2, 2);
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
