
import java.util.*;

public class Experimento1 {

    public static void main(String[] args) {
        List l = new ArrayList();
        Set s = new HashSet();
        Iterator it;
        for (int i = 5; i >= 1; i--) {
        //for (int i = 1; i <= 5; i++) {
            l.add(i);
            s.add(i);
        }
        it = l.iterator();
        while (it.hasNext()) {
            System.out.println((Integer) it.next());
        }
        System.out.println("-------------------");
        it = s.iterator();
        while (it.hasNext()) {
            System.out.println((Integer) it.next());
        }
    }
}
