package Controller;

import java.awt.Color;

public class TResultStatistics {

	private double[] generaciones;
	
	private double[] mejorAbsoluto;
	private double[] mejorLocal;
	private double[] medio;
	


	public TResultStatistics(double[] generaciones, double[] mejorAbsoluto, double[] mejorLocal, double[] medio) {
		super();
		this.generaciones = generaciones;
		this.mejorAbsoluto = mejorAbsoluto;
		this.mejorLocal = mejorLocal;
		this.medio = medio;
	}
	public double[] getGenreaciones() {
		return generaciones;
	}
	public double[] getMejoresAbsolutos() {
		return mejorAbsoluto;
	}

	public double[] getMejorLocal() {
		return mejorLocal;
	}

	public double[] getMedio() {
		return medio;
	}

}
