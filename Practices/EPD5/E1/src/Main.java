
import java.util.*;


public class Main {
    public static void main(String [] args){
        Empleado e1 = new Empleado("Laura", "Diaz de Castro", 26, 1500, new Fecha(14,5,1999));
        Empleado e2 = new Empleado("Laura", "Diaz Saez", 19, 2300, new Fecha(8,6,2003));
        Empleado e3 = new Empleado("Mónica", "Sánchez Martín",22,500, new Fecha(19,12,2005));
        Empleado e4 = new Empleado("Sara","Boza Infantes",19,840,new Fecha(24,2,2008));

        e1.toString();
        e2.toString();
        e3.toString();
        e4.toString();

        List<Empleado> elClubDePatoo = new ArrayList();
        elClubDePatoo.add(e1);
        elClubDePatoo.add(e2);
        elClubDePatoo.add(e3);
        elClubDePatoo.add(e4);

        Iterator it = elClubDePatoo.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        Collections.sort(elClubDePatoo);
        it = elClubDePatoo.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        System.out.println("Orden inverso:\n");
        Collections.sort(elClubDePatoo,Collections.reverseOrder());
        it = elClubDePatoo.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
