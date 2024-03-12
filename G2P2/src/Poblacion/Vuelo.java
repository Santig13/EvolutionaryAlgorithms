package Poblacion;

public class Vuelo {
	protected int nVuelo;
	protected String identificador;
	private String tipo;
	private Integer TLA;
	private Integer retraso;
	
	public Vuelo(int nVuelo, String identificador, String tipo) {
		this.nVuelo = nVuelo;
		this.identificador = identificador;
		this.tipo=tipo;
	}
	
	public Vuelo(int nVuelo, String identificador, String tipo, Integer tLA, Integer retraso) {
		super();
		this.nVuelo = nVuelo;
		this.identificador = identificador;
		this.tipo = tipo;
		TLA = tLA;
		this.retraso = retraso;
	}
	public String getTipo() {
		return tipo;
	}
	public int getnVuelo() {
		return nVuelo;
	}
	public void setnVuelo(int nVuelo) {
		this.nVuelo = nVuelo;
	}
	public String getIdentificador() {
		return identificador;
	}
	@Override
	public Vuelo clone() {
		return new Vuelo(nVuelo,identificador,tipo,TLA,retraso);
		
	}
	@Override
	public String toString() {
		StringBuilder str=new StringBuilder();
		return null;
	}
	public Integer getTLA() {
		return TLA;
	}
	public void setTLA(Integer tLA) {
		TLA = tLA;
	}
	public Integer getRetraso() {
		return retraso;
	}
	public void setRetraso(Integer retraso) {
		this.retraso = retraso;
	}
	public int getTipoNumber() {
		switch(this.tipo) {
		case "W":return 0;
		case"G":return 1;
		default:return 2;
		}
	}
	
}
