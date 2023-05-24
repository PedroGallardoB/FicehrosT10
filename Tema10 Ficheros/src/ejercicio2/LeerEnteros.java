package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeerEnteros {
    public static void main(String[] args) throws FileNotFoundException {
        double media = 0;
        int suma = 0;
        double contador = 0;
        try {
            Scanner sc = new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));
            while (sc.hasNextInt()){
                suma += sc.nextInt();
                contador++;
            }
            media = (double) (suma)/contador;
        } catch (FileNotFoundException e) {
            System.out.println("FICHERO NO ENCONTRADO");
            throw new RuntimeException(e);
        }

        System.out.println("La media aritmetica de los números es: " + media);
        System.out.println("La suma de los números es: " + suma);

    }
}
