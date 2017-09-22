
public class NodoCola {

    private Object elemento;
    private NodoCola next;

    public NodoCola(Object elemento) {
        this.elemento = elemento;
        this.next = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object o) {
        this.elemento = o;
    }

    public NodoCola getNext() {
        return next;
    }

    public void setNext(NodoCola next) {
        this.next = next;
    }

    public String toString() {
        return " " + elemento.toString() + " ";
    }
}
