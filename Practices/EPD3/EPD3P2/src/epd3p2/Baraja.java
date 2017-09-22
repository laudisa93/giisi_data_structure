/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Luis
 */
public class Baraja implements IBaraja{
    private List cartas;
    public Baraja(){
        cartas = new ArrayList();
        int i,j;
        for(i=0;i<4;i++){
            for(j=1;j<=13;j++){
                cartas.add(new Carta(j,i));
            }
            
        }
        
    }
    
    public void barajar(){
        int i,numAleatorio;
        Carta auxiliar;
        Random rn= new Random(cartas.size());
       for(i=0;i<cartas.size();i++){
            numAleatorio=rn.nextInt(cartas.size());
            auxiliar= (Carta)cartas.get(i);
            cartas.set(i,cartas.get(numAleatorio));
            cartas.set(numAleatorio,auxiliar);
        }
    }

    @Override
    public ICarta reparteBaraja() {
        return (ICarta) cartas.remove(0);
    }
    public String toString(){
        String devuelve = "";
        ICarta auxiliar;
        Iterator it = this.cartas.iterator();
        while(it.hasNext()){
            auxiliar=(ICarta) it.next();
            devuelve+=auxiliar.toString();
        }
        return devuelve;
    }
}

