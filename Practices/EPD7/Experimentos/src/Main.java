
public class Main {


    public static void main(String[] args) throws PilaVaciaException {
        Object o52 = 'a';
        Object o2 = 'b';
        Object o3 = 'c';
        Object o4 = 'd';
        NodoPila Np52= new NodoPila(o52);
        PilaEnlazada Pe1= new PilaEnlazada(Np52,1);
        System.out.println(Pe1.toString());
        Pe1.push(o2);
        Pe1.push(o3);
        Pe1.push(o4);
        System.out.println(Pe1.toString());
        Object pop=Pe1.pop();
        System.out.println("Sacamos " + pop);
        System.out.println(Pe1.toString());
        Pe1.top();

        System.out.println(Pe1.toString());
    }

}
