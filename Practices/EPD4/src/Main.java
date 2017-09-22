

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        int i;
        Baraja b = new Baraja();
        System.out.println(b);
       
        Carta auxCarta;
        for(i=0;i<=10;i++){
            auxCarta= b.reparteCarta();
            System.out.println(auxCarta);
        }
        
        System.out.println(b);
    }
}
