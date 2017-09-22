
import com.sun.org.apache.xml.internal.utils.NSInfo;
import java.util.*;

public class Experimento2 {

    public static void main(String[] args) {
        List l = new ArrayList();
        Set s;
        l.add("yo");
        l.add("soy");
        l.add("yo");
        l.add("tu");
        l.add("eres");
        l.add("tu");
        System.out.println("l: " + l);
        s = new HashSet(l);
        System.out.println("s: " + s);
        SortedSet ss= new TreeSet(s);
        System.out.println("s: " + s);

    }
}
