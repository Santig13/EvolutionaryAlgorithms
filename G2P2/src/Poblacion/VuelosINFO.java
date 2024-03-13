package Poblacion;

import java.util.ArrayList;

public class VuelosINFO {

	private static ArrayList <Vuelo> infoVuelos;

	private static ArrayList <Vuelo> getInfoVuelos() {
		return infoVuelos;
	}

	public static void setInfoVuelos(ArrayList <Vuelo> infoVuelos) {
		VuelosINFO.infoVuelos = infoVuelos;
	}

	public static Vuelo getVuelo(Integer id) {
		
		return infoVuelos.get(id).clone();
	}
	
}
