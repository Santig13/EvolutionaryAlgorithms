package Poblacion;

import java.util.Random;

public class IndividuoFuncion1 extends Individuo<Boolean> {
	private double valorError;
	private Random rand;
	
	public IndividuoFuncion1() {
		super();
		this.tamGen=new int[2];
		this.min=new double[2];
		this.max=new double[2];
	    this.min[0] = -10.00;
        this.min[1] = -10.00;
        this.max[0] = 10;
        this.max[1] = 10;
        this.tamGen[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGen[1] = this.tamGen(this.valorError, min[1], max[1]);    
        int tamTotal = tamGen[0] + tamGen[1];
        
        this.cromosoma = new Boolean [tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
   
	}
	

}
