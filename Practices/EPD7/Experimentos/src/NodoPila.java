
public class NodoPila {

    Object elemento;
    NodoPila next;

    public NodoPila(Object o) {
        elemento = o;
        next = null;
    }

    @Override
    public String toString() {
        return elemento.toString();
    }
//OTROS MÉTODOS
}
