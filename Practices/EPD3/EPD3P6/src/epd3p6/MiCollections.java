/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luis
 */
public class MiCollections {
    public static List sortAs(List a,List b){
        List devuelve= new ArrayList();
        int objA,objB;
        Iterator itA,itB= b.iterator();
        
        while(itB.hasNext()){
            itA=a.iterator();
            objB=(Integer) itB.next();
            while(itA.hasNext()){
                 objA= (Integer) itA.next();
                 
                 if(objA==objB){
                     devuelve.add(objA);
                     itA.remove();
                 }
            }
        }
        Collections.sort(a);
        devuelve.addAll(a);
        
        return devuelve;
    }
}
