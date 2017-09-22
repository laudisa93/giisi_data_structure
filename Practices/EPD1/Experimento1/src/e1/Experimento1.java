
import java.util.*;

public class Experimento1 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        System.out.println("La colección tiene " + c.size() + " elementos");
        if (c.isEmpty()) {
            System.out.println("La colección está vacía");
        }
        for (int i = 0; i < 5; i++) // Añadimos elementos a la colección
        {
            c.add(i * 3);
        }
        System.out.println("La colección tiene " + c.size() + " elementos");
        System.out.println("La colección contiene: " + c);
    }
}
