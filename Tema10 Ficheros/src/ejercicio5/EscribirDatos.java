package ejercicio5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirDatos {
public static void main(String[] args) {
	/*
	 * Diseña una aplicación que pida al usuario su nombre y edad. 
	 * Estos datos deben guardarse en el fichero datos.txt. 
	 * Si este fichero existe, deben añadirse al final en una nueva línea, y en caso de no existir, debe crearse.
	 */
	Scanner sc = new Scanner (System.in);
	String nombre = "";
	int edad = 0;
	BufferedWriter bw = null;
	try {
	bw = new BufferedWriter(new FileWriter("src\\ejercicio5\\datos.txt"));
	String opcion="";
	System.out.println("¿QUIERES INTRODUCIR ALGUIEN EN EL SISTEMA?(s/n)");
	opcion = sc.nextLine();
	while(!opcion.equalsIgnoreCase("n")) {
	switch (opcion) {
	case "s":
		System.out.println("INTRODUZCA SU NOMBRE Y APELLIDOS:");
		nombre=sc.nextLine();
		System.out.println("INTRODUZCA SU EDAD:");
		edad=sc.nextInt();
		sc.nextLine();
		bw.write(nombre + " " + edad + " años");
		bw.newLine();
		System.out.println("¿QUIERES INTRODUCIR ALGUIEN EN EL SISTEMA?(s/n)");
		opcion = sc.nextLine();
		break;
	case "n":
		System.out.println("FIN DEL PROGRAMA");
		break;
		default:
			System.out.println("OPCIÓN NO VÁLIDA");
			System.out.println("¿QUIERES INTRODUCIR ALGUIEN EN EL SISTEMA?(s/n)");
			opcion = sc.nextLine();
	}
	bw.flush();
	}

	}catch(IOException e) {
		e.getMessage();
		System.out.println("FICHERO NO ENCONTRADO");
	}finally{
		try {
			bw.close();
		} catch (IOException e) {
			
			System.out.println("NO SE PUDO CERRAR EL FICHERO");
			e.getMessage();
		}
	}
	
	sc.close();
}
}
