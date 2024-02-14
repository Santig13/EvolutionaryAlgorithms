package Poblacion;
public class Individuo<T>{
	
	T[] cromosoma;
    int[] tamGen;
    double[] min;
    double[] max;

    public int tamGen(double valorError, double min, double max) {
        return (int) (Math.log10(((max - min) / precision) + 1) / Math.log10(2));
    }
}
    
    
}
