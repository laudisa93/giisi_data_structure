/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class EPD3P6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int v1[] ={1, 6, 3, 6, 4, 7, 2, 3, 8, 3};
        int v2[] ={4, 3, 8, 5, 1, 8, 2};
        List l1 = new ArrayList(),l2=new ArrayList();
        int i;
        for(i=0;i<v1.length;i++) l1.add(v1[i]);
        for(i=0;i<v2.length;i++) l2.add(v2[i]);
         System.out.println("Primera fila: "+l1+"\nSegunda fila: "+l2);
        
        List lResult= MiCollections.sortAs(l1, l2);
        System.out.println("Primera fila: "+l1+"\nSegunda fila: "+l2+"\n Resultado: "+lResult);
        
    }
}
