package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Ordenador {

	public static void main(String[] args) throws IOException {
		TreeSet<Integer> numeros = new TreeSet<Integer>();
		BufferedWriter bw = null;
		Scanner sc = null;
		
		try {
			sc = new Scanner(new FileReader("src\\ejercicio6\\desordenados.txt"));
			while (sc.hasNextInt()) {
				numeros.add(sc.nextInt());
				
			}
			bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\ordenados.txt"));
			for (int numero : numeros) {
				bw.write(Integer.toString(numero));
				bw.newLine();
			}
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR AL ABRIR EL FICHERO");
		} finally {
			try {
				if(bw!=null)
				bw.close();
				if(sc!=null)
					sc.close();
			} catch (IOException e) {
				e.getMessage();
				System.err.println("NO SE PUDO CERRAR EL FICHERO CORRECTAMENTE");
			}
		}

		System.out.println("FIN DEL PROGRAMA, COMPRUEBA EL ARCHIVO");
		
	}

}
