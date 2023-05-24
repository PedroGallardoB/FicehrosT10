package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainTemperatura {
	private static String FICHERO="src\\ejercicio8\\Temperatura.txt";
public static void main(String[] args) throws IOException {
	int opcion=0;
	String fecha="";
	String linea="";
	double tempMin=0;
	double tempMax=0;
	double tempMinTotal=Double.MAX_VALUE;
	double tempMaxTotal=Double.MIN_VALUE;
	String[] datos;
	Scanner sc =  new Scanner(System.in);
    BufferedWriter bw = null;
    BufferedReader br = null;
	
	try {
	bw = new BufferedWriter(new FileWriter(FICHERO,true));
	do {
		menu();
		switch(opcion) {
		case 1:
			System.out.println("INTRODUZCA LA FECHA");
			fecha=sc.nextLine();
			System.out.println("INTRODUZCA LA TEMPERATURA MÁXIMA");
			tempMax=sc.nextDouble();
			System.out.println("INTRODUZCA LA TEMPERATURA MÍNIMA");
			tempMin=sc.nextDouble();
			bw.write(fecha+"," + tempMin+","+tempMin);
			bw.newLine();
			bw.flush();
			break;
		case 2:
			br = new BufferedReader(new FileReader(FICHERO));
			br.readLine();
			linea=br.readLine();
			while(linea!=null) {
				linea=br.readLine();
				datos=linea.split(",");
				System.out.println("Fecha: " + datos[0]);
				
				tempMaxTotal=Double.parseDouble(datos[1]);
				tempMinTotal=Double.parseDouble(datos[2]);
				if(tempMaxTotal<tempMax) {
					tempMaxTotal=tempMax;
				}
				if(tempMinTotal>tempMin) {
					tempMinTotal=tempMin;
				}
				System.out.println("Temperatura máxima: " + datos[1]);
				System.out.println("Temperatura mínima: " + datos[2]);
			}
			System.out.println("Temperatura máxima total " + tempMaxTotal);
			System.out.println("Temperatura mínima total " + tempMinTotal);
			break;
		case 3:
			System.out.println("SALIENDO DEL PROGRAMA");
			break;
			default:
				System.out.println("OPCIÓN INVÁLIDA");
		}
	
	} while(opcion!=3);
	}catch(IOException e){
		System.out.println("ERROR AL ABRIR FICHERO");
		e.getMessage();
	 } finally {
         try {
             if (bw != null) {
                 bw.close();
             }
             if (br != null) {
                 br.close();
             }
         } catch (IOException e) {
             System.out.println("ERROR AL CERRAR EL FICHERO");
             e.getMessage();
         }
     }

     sc.close();
 }

 public static void menu() {
     System.out.println("1) Registra nueva temperatura");
     System.out.println("2) Mostrar historial de registros");
     System.out.println("3) Salir");
 }
}
