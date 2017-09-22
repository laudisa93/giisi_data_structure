
import java.util.*;


public class Baraja implements IBaraja {
    private List lista;

    public Baraja() {
        lista = new ArrayList();
        int i,j;
        for(i=0;i<4;i++){
            for(j=1;j<=13;j++){
                lista.add(new Carta(j,i));
            }
        }
    }

    public Carta reparteCarta(){
        Random r = new Random();
        Carta devuelve;
        int numAleatorio;
        numAleatorio = r.nextInt(this.lista.size()-1);
        devuelve = (Carta) this.lista.get(numAleatorio);

        this.lista.remove(numAleatorio);

        return devuelve;
     }
    
    public String toString(){
        String cadena="";
        Iterator it = this.lista.iterator();
        while(it.hasNext()){
            cadena+=((Carta)it.next()).toString();
        }
        
        return cadena;
    }
}
