/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Luis
 */
public class Entero implements IEntero {
    private List lista;
    
    public Entero(int v[]){
        int i;
        lista=new ArrayList();
        for(i=0;i<v.length;i++){
            lista.add(v[i]);
        }
        
    }

    @Override
    public void desordenar() {
        Random rn=new Random();
        int i,numAleatorio;
        for(i=0;i<lista.size();i++){
            numAleatorio=rn.nextInt(lista.size());
            this.intercambio(i, numAleatorio);
        }
    }

    public Entero() {
    }

    @Override
    public void intercambio(int a, int b) {
        Object auxiliar;
        auxiliar= lista.get(a);
        lista.set(a,lista.get(b));
        lista.set(b,auxiliar);
        
    }
 
    public String toString(){
        return "lista: "+lista.toString();
    }
}

