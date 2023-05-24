package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerAlumno {
	public static void main(String[] args) throws FileNotFoundException {
		String[] datos = new String[3];
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<Integer> edades = new ArrayList<Integer>();
		ArrayList<Double> alturas = new ArrayList<Double>();
		String linea = "";
		double mediaEdad = 0;
		double mediaAltura = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio3\\Alumnos.txt"));

			while ((linea = br.readLine()) != null) {
				datos = linea.split(" ");

				nombres.add(datos[0]);
				edades.add(Integer.parseInt(datos[1]));
				alturas.add(Double.parseDouble(datos[2]));
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("FICHERO NO ENCONTRADO");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		//Calcular la media de edad
		double sumaEdades = 0;
		for (int edad : edades) {
			sumaEdades += edad;
		}
		mediaEdad = sumaEdades / edades.size();

		//Calcular la media de altura
		double sumaAlturas = 0;
		for (double altura : alturas) {
			sumaAlturas += altura;
		}

		//Imprimir resultados
		System.out.println("Nombres: " + nombres);
		System.out.println("Edades: " + edades);
		System.out.println("Alturas: " + alturas);
		System.out.println("Media de edades: " + mediaEdad);
		System.out.println("Media de alturas: " + mediaAltura);

	}
}
