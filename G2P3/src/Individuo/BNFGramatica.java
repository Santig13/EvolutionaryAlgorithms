package Individuo;

import java.io.BufferedReader;
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

        // Separamos por l�neas la gramatica
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
                    // Quitamos los par�ntesis
                    reglas.add(reglaIndividual.replace("(", "").replace(")", ""));
                }
                list1.add(reglas);
            }
            // Agregamos la lista de listas de reglas al mapa
            gramatica.put(regla[0].trim(), list1);
        }
    }
    public static void main(String[] args) {
        // Nombre del archivo que contiene la definici�n de la gram�tica
        String nombreArchivo = "./ArchivosExternos/Gramatica.txt";

        try {
            // Lee el contenido del archivo
            String contenido = leerArchivo(nombreArchivo);

            // Crea una instancia de BNFGramatica y pasa el contenido del archivo
           // BNFGramatica gramatica = new BNFGramatica(contenido);

            // Haz lo que necesites con la gram�tica aqu�
            // Por ejemplo, podr�as imprimir el mapa de gram�tica para verificar que se haya creado correctamente
            System.out.println(gramatica);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // M�todo para leer el contenido de un archivo y devolverlo como una cadena
    private static String leerArchivo(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
}
