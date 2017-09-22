
/**
 *
 * @author Laura
 */

import java.io.*;

public class main {

    public static void main(String[] args) {
        ArbolSplay b = new ArbolSplay();
        String lineaEntrada = null;
        System.out.println("Ingrese Datos: ");
        BufferedReader entrada = null;
        entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numero;
            do {
                System.out.println("Numero:  ");
                lineaEntrada = entrada.readLine();
                try {
                    numero = Integer.parseInt(lineaEntrada);
                    b.insertar(new Integer(numero));
                    b.salidaArbolBinario(b.buscarRaiz(), 2);
                } catch (NumberFormatException ne) {
                    break;
                }
            } while (lineaEntrada != "");
        } catch (IOException ioe) {
            System.out.println("Entrada en main()");
        }
        System.out.println("Hallar el elemento mas pequeño");
        b.hallarMin();
        b.salidaArbolBinario(b.buscarRaiz(), 2);
        System.out.println("Hallar el elemento más grande");
        b.hallarMax();
        b.salidaArbolBinario(b.buscarRaiz(), 2);
        
        try {
            int numero;
            do {
                System.out.println("Numero:  ");
                lineaEntrada = entrada.readLine();
                try {
                    numero = Integer.parseInt(lineaEntrada);
                    b.remover(new Integer(numero));
                    b.salidaArbolBinario(b.buscarRaiz(), 2);
                } catch (NumberFormatException ne) {
                    break;
                }
            } while (lineaEntrada != "");
        } catch (IOException ioe) {
            System.out.println("Entrada en main()");
        }
    }
}
