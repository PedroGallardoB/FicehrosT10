package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirLineas {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String linea = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio4\\textoEscribir.txt"));//ruta relativa???
			System.out.println("INTRODUCE LINEAS Y FIN PARA TERMINAR");
			linea = sc.nextLine();
			while (!linea.equalsIgnoreCase("fin")) {
				bw.write(linea+"\n");
				System.out.println("INTRODUCE LINEAS Y FIN PARA TERMINAR");
				linea = sc.nextLine();
			}
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("FICHERO NO ENCONTRADO");
		}
		sc.close();
	}

}
