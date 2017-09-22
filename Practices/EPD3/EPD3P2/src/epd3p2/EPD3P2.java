/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p2;

/**
 *
 * @author Luis
 */
public class EPD3P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IBaraja barajaCartas = new Baraja();
        ICarta auxiliar;
        System.out.println("\nCARTAS:"+barajaCartas);
        barajaCartas.barajar();
        System.out.println("\nCARTAS BARAJADAS: "+barajaCartas);
        auxiliar = barajaCartas.reparteBaraja();
        auxiliar = barajaCartas.reparteBaraja();
        auxiliar = barajaCartas.reparteBaraja();
        auxiliar = barajaCartas.reparteBaraja();
        auxiliar = barajaCartas.reparteBaraja();
        System.out.println("\nDESPUES DE SACAR LAS 5 PRIMERAS CARTAS: "+barajaCartas);
        
        
    }
}
