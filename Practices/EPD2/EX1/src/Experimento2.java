
import java.util.*;

public class Experimento2 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        Iterator it; // Referencia al iterador
        for (int i = 1; i <= 11; i++) // Rellenamos la coleccion
        {
            c.add(i);
        }
        it = c.iterator(); // Obtenemos un iterador para la colección
        while (it.hasNext()) { // Mientras haya más elementos
            Integer i = (Integer) it.next();
            Integer j;
            if(it.hasNext()){
                j = (Integer) it.next();
                System.out.println(i.intValue() + j.intValue()); // Imprimimos la suma
            }else{
                System.out.println(i.intValue());
            }
            
        }
    }
}
