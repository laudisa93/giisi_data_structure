
import java.util.*;

public class Experimento1 {

    public static void main(String[] args) {
        List l = new ArrayList();
        Iterator it;
        for (int i = 0; i < 10; i++) {
            l.add(new Numero());
        }
        System.out.println("Antes de ordenar:");
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Numero) it.next());
            if (it.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("\nDespués de ordenar:");
        Collections.sort(l);
        it = l.iterator();
        while (it.hasNext()) {
            System.out.print((Numero) it.next());
            if (it.hasNext()) {
                System.out.print(", ");
            }
        }
    }
}
