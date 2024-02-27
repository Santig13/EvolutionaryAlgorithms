package Controlador;

public class TParametros {

	private String selector;
	private String mutador;
	private String cruzador;
	private String funcion;
	private double probMuta;
	private int generaciones;
	private int tamPobla;
	private double probCruce;
	private double elitismo;
	private int ndimensiones;
	private double precision;

	public TParametros(String selector, String mutador, String cruzador, String funcion, double probMuta,
			int generaciones, int tamPobla, double probCruce, double elitismo, int ndimensiones, double precision) {
		this.selector = selector;
		this.mutador = mutador;
		this.cruzador = cruzador;
		this.funcion = funcion;
		this.probMuta = probMuta;
		this.generaciones = generaciones;
		this.tamPobla = tamPobla;
		this.probCruce = probCruce;
		this.elitismo = elitismo;
		this.ndimensiones = ndimensiones;
		this.precision = precision;
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

	public String getFuncion() {
		// TODO Auto-generated method stub
		return funcion;
	}
	
	public double getElitismo() {
		return elitismo;
	}
	
	public int getNDimensiones() {
		return ndimensiones;
	}
	public double getPrecision()
	{
		return precision;
	}

}
