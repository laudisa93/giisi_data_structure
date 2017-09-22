
import java.util.Comparator;

public class OrdenarPersonasPorEdad implements Comparator {

    public int compare(Object o1, Object o2) {
        IPersona p1, p2;
        p1=(IPersona)o1;
        p2=(IPersona)o2;
        if (p1.getEdad()<p2.getEdad()) {
                return -1;
        } else if (p1.getEdad()>p2.getEdad()) {
                return +1;
        } else {
                return 0;
        }
    }
}
