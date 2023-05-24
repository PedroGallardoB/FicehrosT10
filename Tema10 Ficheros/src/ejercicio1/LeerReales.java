package ejercicio1;

import java.io.*;
import java.util.Scanner;

public class LeerReales {
    public static void main(String[] args) throws FileNotFoundException {
        double media = 0;
        double suma = 0;
        int contador = 0;
        try {
            Scanner sc = new Scanner(new FileReader("src\\ejercicio1\\NumerosReales.txt"));
            while (sc.hasNext()){
                suma += sc.nextDouble();
            contador++;
            }
           media = suma/contador;
        } catch (FileNotFoundException e) {
            System.out.println("FICHERO NO ENCONTRADO");
            throw new RuntimeException(e);
        }

        System.out.println("La media aritmetica de los números es: " + media);
        System.out.println("La suma de los números es: " + suma);

    }
}
