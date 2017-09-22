
public class Pila implements IPila {

    private Nodo top;
    private int tam;

    public Pila() {//Constructor por defecto de la pila, inicialziando el tamaño a 0
        this.tam = 0;
        this.top = new Nodo();
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public Object pop() throws PilaVaciaException {//Elimina ultima posicion y la muestra
        if (isEmpty()) {//Si esta vacia, no se puede eliminar la ultima posicion y salta el error
            throw new PilaVaciaException("La pila está vacía.");
        }
        Nodo aux = top;//Guardamos el ultimo elemento
        tam--;//Y eliminamos la ultima posicion
        return aux.getElem();//Devolvemos el elemento, para mostrarlo
    }

    public void push(Object o) {//Insertamos un nuevo elemento en la pila
        Nodo aux = new Nodo(o);//Creamos el nuevo nodo
        top.setNext(aux);//Unimos el nodo al nuevo
        top = aux;//Actualizamos el nuevo top
        tam++;//Incrementamos el tamaño de la pila
    }

    public int size() {
        return tam;
    }

    public Object top() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila está vacía.");
        }
        return top.getElem();//Devuelve el ultimo elemento
    }
}
