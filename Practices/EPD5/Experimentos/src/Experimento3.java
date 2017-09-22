
import java.util.*;


public class Experimento3 {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        for (int i = 0; i < 5; i++) {
            c.add(new Persona(i * 10));
        }
        System.out.println("Edades: " + c);
        System.out.println("Maxima edad: " + Collections.max(c));
        System.out.println("Minima edad: " + Collections.min(c));
        System.out.println("Maxima edad: " + Collections.max(c, new ComparadorPersona()));
        System.out.println("Minima edad: " + Collections.min(c, new ComparadorPersona()));
    }
}
