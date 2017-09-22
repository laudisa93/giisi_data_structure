
import java.util.Comparator;

public class ComparadorPersona implements Comparator {

    public int compare(Object o1, Object o2) {
        Persona n = (Persona) o1;
        Persona m = (Persona) o2;
        if (n.getEdad() == m.getEdad()) {
            return 0;
        } else if (n.getEdad() > m.getEdad()) {
            return -1;
        } else {
            return 1;
        }
    }
}
