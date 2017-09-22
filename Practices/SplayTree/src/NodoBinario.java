/**
 *
 * @author Laura
 */

class NodoArbolBinario {
    // variables Instancias

    protected NodoArbolBinario izq;         // subarbol izquierdo
    protected NodoArbolBinario der;         // subarbol derecho
    public Comparable datos;                // datos contenidos en el Nodo

    // Constructor
    public NodoArbolBinario(Comparable datosElement) {
        this(datosElement, null, null);
    }

    public NodoArbolBinario(Comparable datosElement, NodoArbolBinario iz, NodoArbolBinario de) {
        datos = datosElement;
        izq = iz;
        der = de;
    }

    public void insertar(Comparable x) {
        if (x.compareTo(datos) > 0) // luego a la derecha
        {
            if (der == null) {
                der = new NodoArbolBinario(x);
            } else {
                der.insertar(x);
            }
        } else // sino izquierda
        {
            if (izq == null) {
                izq = new NodoArbolBinario(x);
            } else {
                izq.insertar(x);
            }
        }
    }

    public NodoArbolBinario getIzq() {
        return izq;
    }

    public NodoArbolBinario getDer() {
        return der;
    }
}
