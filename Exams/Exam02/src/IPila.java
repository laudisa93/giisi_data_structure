
public interface IPila {

    boolean isEmpty();

    Object pop() throws PilaVaciaException;//Elimina ultima posicion y la muestra

    void push(Object o);//Inserta

    int size();

    Object top() throws PilaVaciaException;//Ultima posicion
}
