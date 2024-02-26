package ppoblacion;

import java.util.Random;

public class IndividuoFuncion2 extends Individuo<Boolean> {

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
    
    private double getFenotipo(int i) {
    	
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
