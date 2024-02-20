package ppoblacion;

import java.util.Random;

public class IndividuoFuncion2 extends Individuo<Boolean> {

    private double valorError = 0;
	private Random rand;


    public IndividuoFuncion2 ()
    {
        super();
        this.tamGen = new int[2];
        this.min = new double[2];
        this.max = new double[2];
        this.min[0] = -10.000;
        this.min[1] = -6.5;
        this.max[0] = 0;
        this.max[1] = 0;
        this.tamGen[0] = this.tamGen(this.valorError, min[0], max[0]);
        this.tamGen[1] = this.tamGen(this.valorError, min[1], max[1]);    
        int tamTotal = tamGen[0] + tamGen[1];

        this.cromosoma = new Boolean [tamTotal];
        for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean(); //Para inicializar el individuo de forma aleatoria
    }
}
