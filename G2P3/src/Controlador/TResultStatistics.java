package Controlador;

import java.awt.Color;

public class TResultStatistics {

	private double[] generaciones;

	private double[] mejorAbsoluto;
	private double[] mejorLocal;
	private double[] medio;
	double[] presion_evolutiva_generacional;
	private String elMejor;
	private double posicion;
	 private Color[][] colors;

	public TResultStatistics(String elMejor,double[] generaciones, double[] aptitud_absoluta_generacion, double[] aptitud_mejor_generacion,
			double[] aptitud_media_generacion, int pos_mejor, double[] presion_evolutiva_generacional, Color[][] colors) {
		super();

		this.generaciones = generaciones;
		this.mejorAbsoluto = aptitud_absoluta_generacion;
		this.mejorLocal = aptitud_mejor_generacion;
		this.medio = aptitud_media_generacion;
		this.posicion = pos_mejor;
		this.setElMejor(elMejor);
		this.presion_evolutiva_generacional=presion_evolutiva_generacional;
		this.colors=colors;
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

	public double getPosicion() {
		return posicion;
	}
	public void setPosicion(double posicion) {
		this.posicion = posicion;
	}
	public String getElMejor() {
		return elMejor;
	}
	public void setElMejor(String elMejor) {
		this.elMejor = elMejor;
	}

	public double[] getPresion() {
		// TODO Auto-generated method stub
		return this.presion_evolutiva_generacional;
	}

	public Color[][] getColors() {
		return colors;
	}

	public void setColors(Color[][] colors) {
		this.colors = colors;
	}

}
