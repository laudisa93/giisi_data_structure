
import java.util.*;


public class Experimento5 {

    public static void main(String[] args) {
        List l = new LinkedList();
        ListIterator it;
        for (int i = 0; i < 5; i++) { // Añadimos letras
            l.add(new Character((char) ('a' + i)));
        }
        System.out.println(l);
        it = l.listIterator(l.size() - 1);
        while (it.hasPrevious()) {
            Character caracter = (Character)it.previous();
            System.out.println(caracter.charValue());
        }
    }
}
