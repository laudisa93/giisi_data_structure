
import java.util.Iterator;

public class ColaLista {

    private NodoCola inicio;
    private NodoCola termino;
    private int size;

    public ColaLista() {
        inicio = null;
        termino = null;
    }

    public void enqueue(Object o) {
        NodoCola i = new NodoCola(o);
        i.setNext(null);
        if (inicio == null & termino == null) {
            inicio = i;
            termino = i;
        }
        termino.setNext(i);
        termino = termino.getNext();
    }

    public Object dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException("La cola está vacía");
        } else {
            Object dato = inicio.getElemento();;
            inicio = inicio.getNext();
            return dato;
        }

    }

    public Object front() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException("La cola esta vacia");
        } else {
            return inicio.elemento;
        }
    }

    public boolean isEmpty() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("La cola no esta vacia");
            cola = false;
        }
        return cola;
    }

    public int size() {
        return this.size;
    }

    public int buscar(Object o) {
        int i = 0, contador = 0;
        NodoCola c = this.inicio;
        while (i < this.size() && i>0 ) {
            contador++;
            if (c.getElemento() == o) {
                i = contador;
            } else {
                i = -1;
            }
        }
        return i;

    }

    public String toString() {
        NodoCola c = this.inicio;
        String s = "";
        while (c != null) {
            s = s + c.toString();
            c = c.getNext();
        }
        return s;

    }
}