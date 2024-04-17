package Controlador;

import java.awt.Color;

public class TParametros {

	private String selector;
	private String mutador;
	private String cruzador;
	private double probMuta;
	private int generaciones;
	private int tamPobla;
	private double probCruce;
	private double elitismo;
	private Color[][] sol;
	private String iniciador;

	public TParametros(String selector, String mutador, String cruzador, double probMuta,
			int generaciones, int tamPobla, double probCruce, double elitismo,Color[][] sol,String iniciador) {
		this.selector = selector;
		this.mutador = mutador;
		this.cruzador = cruzador;
		this.probMuta = probMuta;
		this.generaciones = generaciones;
		this.tamPobla = tamPobla;
		this.probCruce = probCruce;
		this.elitismo = elitismo;
		this.setSol(sol);
		this.iniciador= iniciador;
	}

	

	public int getTamPoblacion() {
		// TODO Auto-generated method stub
		return this.tamPobla;
	}

	public int getMaxGen() {
		// TODO Auto-generated method stub
		return this.generaciones;
	}

	public double getProbCruce() {
		// TODO Auto-generated method stub
		return this.probCruce;
	}

	public double getProbMuta() {
		// TODO Auto-generated method stub
		return this.probMuta;
	}

	public String getSelector() {
		// TODO Auto-generated method stub
		return selector;
	}

	public String getCruzador() {
		// TODO Auto-generated method stub
		return cruzador;
	}

	public String getMutador() {
		// TODO Auto-generated method stub
		return mutador;
	}

	

	public double getElitismo() {
		return elitismo;
	}
	



	public Color[][] getSol() {
		return sol;
	}



	public void setSol(Color[][] sol) {
		this.sol = sol;
	}



	public String iniciador() {
		// TODO Auto-generated method stub
		return iniciador;
	}


}
