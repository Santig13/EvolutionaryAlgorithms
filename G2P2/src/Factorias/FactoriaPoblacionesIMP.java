package Factorias;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Poblacion.Individuo;
import Poblacion.IndividuoControlAero;
import Poblacion.TEL;
import Poblacion.TPoblacion;
import Poblacion.Vuelo;
import Poblacion.VuelosINFO;

public class FactoriaPoblacionesIMP extends FactoriaPoblaciones {

	@Override
	public TPoblacion generarPoblacion(String vuelotxt, String TELtxt,int tamanio) {
		// TODO Auto-generated method stub
		Individuo<?>[] individuos=new Individuo<?>[tamanio];
		boolean min=false;
		
		ArrayList <Vuelo> vuelos = new ArrayList<>();
		//LECTURA DE ARCHIVOS
		int nVuelos = 0;
		try (Scanner scanner = new Scanner(new File("ArchivosExternos/" +vuelotxt))) {
            while (scanner.hasNext()) {
                String id = scanner.next();
                String tipo = scanner.next();
                vuelos.add(new Vuelo(nVuelos,id,tipo));
                nVuelos++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
		
		
		int nPistas = 0;
		ArrayList <Double> aux  = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("ArchivosExternos/" +TELtxt))) {
			while (scanner.hasNext()) {
                double x = Double.parseDouble(scanner.next());
                aux.add(x);
                nPistas++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
		nPistas = nPistas/nVuelos;
		Double[][] tel = new Double [nPistas][nVuelos];
		
		int x = 0;
		for (int i = 0; i < nPistas; i++)
		{
			for (int j = 0; j < nVuelos; j++)
			{
				tel[i][j] = aux.get(x);x++;
			}
		}
		
		TEL.setTiempos(tel);
		VuelosINFO.setInfoVuelos(vuelos);
		
		min = true;
		for(int i=0;i<tamanio;i++) {
			individuos[i]=new IndividuoControlAero(nVuelos,nPistas);
		}
		
		
		return new TPoblacion(individuos,min);
	}
}


