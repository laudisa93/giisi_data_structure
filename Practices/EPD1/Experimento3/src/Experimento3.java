
import java.util.*;
import edi.io.IO;

public class Experimento3 {

    public static void main(String args[]) {
        Collection c = new ArrayList();
        Integer[] v;
        int elementos;
        System.out.println("Introduzca el número de datos: ");
        elementos = Integer.valueOf(IO.readLine()) ;//Casting es de objeto a objeto. De primitivo a objeto es Integer.valueOf()
        for (int i = 0; i < elementos; i++) {
            System.out.println("Elemento " + (i + 1) + ": ");
            c.add((int) IO.readNumber());
        }
        v=new Integer[c.size()];
        v = (Integer[]) c.toArray(v); //toArray devuelve un array de objetos, v es un entero => casting
        for (int i = 0; i < v.length; i++) {
            System.out.println("Elemento " + (i + 1) + ": " + v[i].toString());
        }
        Iterator it = c.iterator();
        while (it.hasNext()){
            Integer e =(Integer)it.next();
        }
    }
}
