
public class PilaEnlazada implements Pila {

    private NodoPila top;
    private int size;

    public PilaEnlazada(NodoPila top, int size) {
        this.top = top;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object pop() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila esta vacia");
        } else {
            NodoPila aux = top;
            top = aux.next;
            this.size--;
            return aux.elemento;
        }
    }

    public void push(Object o) {
        NodoPila n = new NodoPila(o);
        n.next = top;
        top = n;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public Object top() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila esta vacia");
        } else {
            return top.elemento;
        }
    }

    @Override
    public String toString() {
        NodoPila auxP=top;
        String s = "PilaEnlazada :" + "top = ";
        for(int i=0;i<this.size;i++){
            s+=auxP+" ";
            auxP=auxP.next;
        }
        s+=", size = " + size ;
        return s;
    }
}
