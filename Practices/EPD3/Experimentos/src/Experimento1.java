
import java.util.*;

public class Experimento1 {

    public static void main(String[] args) {
        List l = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            l.add(i * Math.PI);
        }
        System.out.println(l);
        for (int i = 0; i < 5; i++) {
            l.add(i * 2, i * Math.E);
        }
        System.out.println(l);
        for (int i = 0; i < 5; i++) {
            System.out.println(l.get(i * 2));
        }
        for (int i = 0; i < 5; i++) {
            l.remove(i + 1);
        }
        System.out.println(l);
    }
}
