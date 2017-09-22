
import java.util.*;

public class Experimento2 {

    public static void main(String[] args) {
        List l, m;
        l = new ArrayList();
        m = new ArrayList();
        for (int i = 0; i < 5; i++) {
            l.add(i);
        }
        System.out.println("l: " + l);
        m.addAll(l);
        System.out.println("m: " + m);
    }
}
