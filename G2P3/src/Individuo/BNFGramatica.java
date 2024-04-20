package Individuo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNFGramatica {
    protected static Map<String, List<List<String>>> gramatica;

    public static void setReglas(String s) {
        gramatica = new HashMap<String, List<List<String>>>();

        // Separamos por líneas la gramatica
        String r[] = s.split("\n");
        for (int i = 0; i < r.length; i++) {
            // Separamos las reglas de sus variables
            String regla[] = r[i].split("::=");
            // Separamos cada una de las variables
            String reglas_sig[] = regla[1].split("\\|");
            // Creamos la lista para las listas de reglas
            List<List<String>> list1 = new ArrayList<List<String>>();
            for (int j = 0; j < reglas_sig.length; j++) {
                // Hacemos un split de las reglas por los espacios
                String reglas_juntas[] = reglas_sig[j].split(" ");
                // Agregamos la lista de reglas al list1
                List<String> reglas = new ArrayList<String>();
                for (String reglaIndividual : reglas_juntas) {
                    // Quitamos los paréntesis
                    reglas.add(reglaIndividual.replace("(", "").replace(")", ""));
                }
                list1.add(reglas);
            }
            // Agregamos la lista de listas de reglas al mapa
            gramatica.put(regla[0].trim(), list1);
        }
    }
    // Método para leer el contenido de un archivo y devolverlo como una cadena
    private static String leerArchivo(String nombreArchivo)  {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return contenido.toString();
    }
    protected static List<String> regla(String key, int codon) {
    	List<List<String>> lista =gramatica.get(key);
    	int regla = codon % (lista.size());
		return lista.get(regla);
    }
	public static String start() {
		// TODO Auto-generated method stub
		List<List<String>> lista =gramatica.get("start");
		return lista.get(0).get(0);
	}
}
