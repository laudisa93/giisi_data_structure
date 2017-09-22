
public interface Pila {

    boolean isEmpty();

    Object pop() throws PilaVaciaException;

    void push(Object o);

    int size();

    Object top() throws PilaVaciaException;
}
