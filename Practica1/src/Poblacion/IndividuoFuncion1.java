package Poblacion;

import java.util.Random;

public class IndividuoFuncion1 extends Individuo<Boolean> {
	private double valorError;
	private Random rand;
	
	public IndividuoFuncion1() {
		super();
		this.rand=new Random();
		this.tamGen=new int[2];
		this.min=new double[2];
		this.max=new double[2];
		this.inicioGen=new int[2];
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
}
