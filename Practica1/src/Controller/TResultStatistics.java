package Controller;

import java.awt.Color;

public class TResultStatistics {

	private double[] generaciones;
	
	private double[] mejorAbsoluto;
	private double[] mejorLocal;
	private double[] medio;
	private double optimo;
	private double posicion;


	public TResultStatistics(double[] generaciones, double[] mejorAbsoluto, double[] mejorLocal, double[] medio,
			double optimo, double posicion) {
		super();
		this.generaciones = generaciones;
		this.mejorAbsoluto = mejorAbsoluto;
		this.mejorLocal = mejorLocal;
		this.medio = medio;
		this.optimo = optimo;
		this.posicion = posicion;
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
	public double getOptimo() {
		return optimo;
	}
	public void setOptimo(double optimo) {
		this.optimo = optimo;
	}
	public double getPosicion() {
		return posicion;
	}
	public void setPosicion(double posicion) {
		this.posicion = posicion;
	}

}
