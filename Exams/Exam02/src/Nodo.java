
public class Nodo {

    private Nodo next;//Creamos los nodos para utilziar una lista enlazada
    Object elem;//Aqui guardaremos el elemento

    public Nodo() {//Constructor por defecto
        this.next = null;
        this.elem = null;
    }

    public Nodo(Object elem) {//Constructor por parametro
        this.next = null;
        this.elem = elem;
    }

    //Meotodos consultores y modificadores
    public Object getElem() {
        return elem;
    }

    public Nodo getNext() {
        return next;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
