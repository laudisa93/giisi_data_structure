/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package epd3p2;

/**
 *
 * @author Luis
 */
public class Carta implements ICarta{
    private int numero,palo;
    
    public Carta(int numero, int palo) {
        this.numero = numero;
        this.palo = palo;
    }
    
     public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    public String toString(){
        String cadena="\n"+this.numero+" de ";
        switch(this.palo){
            case 0:
                cadena+="picas";
                break;
            
            case 1:
                cadena+="corazones";
                break;
            
            case 2:
                cadena+="treboles";
                break;
             
            case 3:
                cadena+="diamantes";
                break;
        }
        return cadena;
    }
    
}
