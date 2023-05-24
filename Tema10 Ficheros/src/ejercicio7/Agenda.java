package ejercicio7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Agenda {

	public static void main(String[] args) throws IOException {
		/*
		 * La opción 3 mostrará un listado con toda la información (nombres y teléfonos)
		 * ordenados alfabéticamente por nombre. Por último, la opción 4 guarda todos
		 * los datos de la agenda en el archivo agenda.txt. La próxima vez que se
		 * ejecute la aplicación, si hay datos guardados, se cargarán en memoria.
		 */
		String nombre = "";
		long tlf = 0;
		int opcion = 0;
		BufferedWriter bw = null;
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Long> contactos = new TreeMap<>();
		while (contactos.size() < 20 && opcion!=4) {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {

			case 1:
				System.out.println("INTRODUZCA UN NOMBRE:");
				nombre = sc.nextLine();
				System.out.println("INTRODUZCA UN TELÉFONO:");
				tlf = sc.nextLong();
				sc.nextLine();
				if (!contactos.containsKey(nombre)) {
					contactos.put(nombre, tlf);
				} else {
					System.out.println("USUARIO YA AGREGADO");
				}

				break;

			case 2:
				System.out.println("INTRODUZCA UN NOMBRE:");
				nombre = sc.nextLine();

				if (contactos.containsKey(nombre)) {
					System.out.println(contactos.get(nombre));
				} else {
					System.out.println("EL NOMBRE NO EXISTE");
				}
				break;

			case 3:
				if (contactos.isEmpty()) {
					System.out.println("La agenda está vacía.");
				} else {
					System.out.println("Lista de contactos:");
					for (Map.Entry<String, Long> contacto : contactos.entrySet()) {
						System.out.println("Nombre: " + contacto.getKey() + ", tlf: " + contacto.getValue());
					}
				}
				break;
			case 4:
				System.out.println("SALIENDO");
				break;
			default:
				System.out.println("VALOR INCORRECTO");
			}

		}
		try {
			bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\agenda.txt"));
			for (Map.Entry<String, Long> contacto : contactos.entrySet()) {
				bw.write("Nombre: " + contacto.getKey() + ", tlf: " + contacto.getValue().toString());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.getMessage();
			System.out.println("ERROR AL ABRIR O ESCRIBIR EN EL ARCHIVO");
		} finally {
			if (bw != null)
				bw.close();
			System.out.println("FIN DEL PROGRAMA");
		}

		sc.close();
	}

	public static void menu() {
		System.out.println("1) Nuevo contacto");
		System.out.println("2) Buscar por nombre");
		System.out.println("3) Mostrar todos");
		System.out.println("4) Salir");
	}
}
