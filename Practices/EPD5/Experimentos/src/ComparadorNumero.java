
import java.util.Comparator;

public class ComparadorNumero implements Comparator {

    public int compare(Object o1, Object o2) {
        Numero n = (Numero) o1;
        Numero m = (Numero) o2;
        if (n.getNumero() == m.getNumero()) {
            return 0;
        } else if (n.getNumero() > m.getNumero()) {
            return -1;
        } else {
            return 1;
        }
    }
}
