
import java.util.*;


public class Numero implements INumero {
    Set numeros = new HashSet<Integer>();

    public boolean addNumero(int n){
        return numeros.add(n);
    }

    public Numero() {
       numeros=new HashSet();
    }

    public void getPrimos(){
        Set primos = new HashSet<Integer>();

        Iterator it;
        it = this.numeros.iterator();
        while (it.hasNext()) {
            if(esPrimo((Integer)it.next())==true){

            }
        }
    }

    public boolean esPrimo(int n){
        int i=2;
        boolean primo=true;

        while(i<n && primo==true){
            if(n%i==0){
                primo=false;
            }else{
                i++;
            }
        }
        return primo;
    }

    public String toString() {
        return "Numero { "+ numeros + '}';
    }


}
