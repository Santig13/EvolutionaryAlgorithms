package Controlador;

public class TParametros {

	private String selector;
	private String mutador;
	private String cruzador;
	private String vuelostxt;
	private String TELtxt;
	private double probMuta;
	private int generaciones;
	private int tamPobla;
	private double probCruce;
	private double elitismo;

	public TParametros(String selector, String mutador, String cruzador, String vuelostxt, String TELtxt, double probMuta,
			int generaciones, int tamPobla, double probCruce, double elitismo) {
		this.selector = selector;
		this.mutador = mutador;
		this.cruzador = cruzador;
		this.vuelostxt = vuelostxt;
		this.probMuta = probMuta;
		this.generaciones = generaciones;
		this.tamPobla = tamPobla;
		this.probCruce = probCruce;
		this.elitismo = elitismo;
		this.TELtxt = TELtxt;
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

	public String getvuelostxt() {
		// TODO Auto-generated method stub
		return vuelostxt;
	}

	public double getElitismo() {
		return elitismo;
	}
	
	public String getTELtxt()
	{
		return TELtxt;
	}


}
