/**
 *
 * @author federico
 */
public class LinkedStack implements IPila {

    NodoPila top;
    int size;
    int maxSize;
    public LinkedStack(int maxSize) {
        top = null;
        size = 0;
        this.maxSize = maxSize;
    }

    public LinkedStack(){
        top = null;
        size = 0;
        this.maxSize = 1000;
    }
    public void push(Object o)  {

        //inserta el objeto o en el tope de la pila
        //no lanza exceptiones ya que se implementa con una lista
        //use maxSize if you want to establish a maximum size for the stack
        NodoPila nuevo = new NodoPila(o);
        if (top == null) {
            top = nuevo;
        } else {
            nuevo.next = top;
            top = nuevo;
        }
        size++;
    }

    public Object pop() throws EmptyStackError{
        if (top == null) {
            throw  new  EmptyStackError("Operación pop: pila vacía!!");
           
        }

        Object o = top.elemento;
        top = top.next;
        size--;
        return o;
    }//coge el objeto del tope de la pila y lo retira

    public boolean isEmpty() {

        return (size == 0);
    }

    public int size() {

        return size;
    }

    public Object top() throws EmptyStackError{

        if (top == null) {
            throw  new EmptyStackError("Operación top: pila vacía!!!");
        } else {
            return top.elemento;
        }
    }
}
