package Poblacion;

public class TEL {
	
	private static Double[][] tiempos=null;
	
	protected static Double[][] getTiempos(){
		return tiempos;
	}
	public static void setTiempos( Double[][] tel){
		 tiempos=tel;
	}
	public static double get(int pista, Integer vuelo) {
		// TODO Auto-generated method stub
		return tiempos[pista][vuelo];
	}
	
}
