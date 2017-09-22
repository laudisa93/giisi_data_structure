/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p1;

/**
 *
 * @author Luis
 */
public class EPD3P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int v[]={1,2,3,4,5,6,7,8,9,10};
        IEntero l=new Entero(v);
        System.out.println(l);
        l.desordenar();
        System.out.println(l);
    }

}
