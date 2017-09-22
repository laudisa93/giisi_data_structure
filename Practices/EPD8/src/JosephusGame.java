
public class JosephusGame {

    /** Implementación utilizando una cola Q. Devuelve la persona ganadora */
    public static Object simularJuego(IQueue Q, int k) throws EmptyQueueException {
        Queue colAux; //No está terminado
        Object aux = null;
        int i=0;
        while(i < k && Q.size()==1){
            aux = Q.dequeue();
            i++;
        }
        

        return aux;
    }

    /** Construye una cola desde un array de objectos */
    public static IQueue construirCola(Object a[]) {
        Queue cola = new Queue();
        for (int i = (a.length-1); i >= 0; i--) {
            cola.enqueue(a[i]);
        }
        
        return (IQueue)cola;
    }

    /** Tester method */
    public static void main(String[] args) throws EmptyQueueException {
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[] a3 = {"Mike", "Roberto"};


        System.out.println("Primer ganador: " + simularJuego(construirCola(a1), 3) + "\n");
        System.out.println("Segundo ganador: " + simularJuego(construirCola(a2), 10) + "\n");
        System.out.println("Tercer ganador: " + simularJuego(construirCola(a3), 7) + "\n");
    }
}
