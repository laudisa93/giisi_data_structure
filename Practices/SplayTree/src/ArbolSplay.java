
/**
 *
 * @author Laura
 */

//
// CONSTRUCCION: sin inicialización
//
// ***************** Operaciones Publicas ********************
// void insertar( x )       --> Insertar x
// void remover( x )       --> Remover x
// Comparable hallar( x )   --> Return item que coincide con x
// Comparable hallarMin( )  --> Return el item más pequeño
// Comparable hallarMax( )  --> Return el item más grande
// boolean esVacio( )     --> Return true si es vacio; sino false
// void hacerVacio( )      --> Remover todos los elementos
// void printArbol( )      --> Print el arbol en un cierto orden

/*
 * Implementacion de un proceso top-down sobre los arboles Splay.
 * Las comparaciones utilizan el método compareTo().
 */
public class ArbolSplay {

    private NodoArbolBinario raiz;
    private static NodoArbolBinario Nodonull;

    {
        Nodonull = new NodoArbolBinario(null);
        Nodonull.izq = Nodonull.der = Nodonull;
    }
    private static NodoArbolBinario nuevoNodo = null;
    // en diversos formas de inserción sera utilizado
    private static NodoArbolBinario ini = new NodoArbolBinario(null);
    /*
     * Constructor.
     */

    public ArbolSplay() {
        raiz = Nodonull;
    }
    /*
     * manipulando la raiz
     */

    public NodoArbolBinario buscarRaiz() {
        return raiz;
    }
    /*
     * Insertar. Parametro x es el elemento a agregar.
     */

    public void insertar(Comparable x) {
        if (nuevoNodo == null) {
            nuevoNodo = new NodoArbolBinario(null);
        }
        nuevoNodo.datos = x;
        if (raiz == Nodonull) {
            nuevoNodo.izq = nuevoNodo.der = Nodonull;
            raiz = nuevoNodo;
        } else {
            raiz = splay(x, raiz);
            if (x.compareTo(raiz.datos) < 0) {
                nuevoNodo.izq = raiz.izq;
                nuevoNodo.der = raiz;
                raiz.izq = Nodonull;
                raiz = nuevoNodo;
            } else if (x.compareTo(raiz.datos) > 0) {
                nuevoNodo.der = raiz.der;
                nuevoNodo.izq = raiz;
                raiz.der = Nodonull;
                raiz = nuevoNodo;
            } else {
                return;
            }
        }
        nuevoNodo = null;   // 
    }
    /*
     * Remover. Parametro x es el elemento a eliminar.
     */

    public void remover(Comparable x) {
        NodoArbolBinario nuevoArbol;
        // Caso que x es encontrado, deja x en la raíz
        raiz = splay(x, raiz);
        if (raiz.datos.compareTo(x) != 0) {
            return;   // Elemento no encontrado; no hace nada
        }
        if (raiz.izq == Nodonull) {
            nuevoArbol = raiz.der;
        } else {
            // Hallar el máximmo en el subarbol izquierdo
            nuevoArbol = raiz.izq;
            nuevoArbol = splay(x, nuevoArbol);
            nuevoArbol.der = raiz.der;
        }
        raiz = nuevoArbol;
    }
    /*
     * Determinar el elemento más pequeño del árbol. Devuelve: el elemento más
     * pequeño, o null caso vacío.
     */

    public Comparable hallarMin() {
        if (esVacio()) {
            return null;
        }
        NodoArbolBinario ptr = raiz;
        while (ptr.izq != Nodonull) {
            ptr = ptr.izq;
        }
        raiz = splay(ptr.datos, raiz);
        return ptr.datos;
    }

    /*
     * Determinar el elemento más grande del árbol. Devuelve: el elemento más
     * grande, o null, caso vacío.
     */
    public Comparable hallarMax() {
        if (esVacio()) {
            return null;
        }
        NodoArbolBinario ptr = raiz;
        while (ptr.der != Nodonull) {
            ptr = ptr.der;
        }
        raiz = splay(ptr.datos, raiz);
        return ptr.datos;
    }
    /*
     * Determina un elemento en el árbol. Parametro x contiene el elemento
     * buscado. Devuelve: El elemnto adecuado o null, caso vacío
     */

    public Comparable hallar(Comparable x) {
        raiz = splay(x, raiz);
        if (raiz.datos.compareTo(x) != 0) {
            return null;
        }
        return raiz.datos;
    }
    /*
     * Hacer el arbol vacío.
     */

    public void hacerVacio() {
        raiz = Nodonull;
    }
    /*
     * Comprobar si el árbol es vacío Devuelve true caso vacío, en otro caso
     * false.
     */

    public boolean esVacio() {
        return raiz == Nodonull;
    }
    /*
     * Entrega el contenido del árbol según un cierto formato u orden.
     */

    public void printArbol() {
        if (esVacio()) {
            System.out.println("Arbol vacio");
        } else {
            printArbol(raiz);
        }
    }
    /*
     * Salida del arbol binario rotado en 90 Grados
     */

    public void salidaArbolBinario(NodoArbolBinario b, int nivel) {
        if (b != b.izq) {
            salidaArbolBinario(b.izq, nivel + 3);
            for (int i = 0; i < nivel; i++) {
                System.out.print(' ');
            }
            System.out.println(b.datos.toString());
            salidaArbolBinario(b.der, nivel + 3);
        }
    }
    /*
     * Metodo Interno para llevar a cabo un "top down" para splay. El último
     * Nodo encontrado en el árbol es la nueva raíz. Parametro x es elemento
     * objetivo, para el proceso Splaying o "biselado". Parameter b es la raíz
     * del subárbol, luego de llevado a cabo el Splaying. Devuelve de subarbol.
     */

    private NodoArbolBinario splay(Comparable x, NodoArbolBinario t) {
        NodoArbolBinario izqArbolMax, derArbolMin;
        ini.izq = ini.der = Nodonull;
        izqArbolMax = derArbolMin = ini;
        Nodonull.datos = x;   // garantiza coincidencia
        for (;;) {
            if (x.compareTo(t.datos) < 0) {
                if (x.compareTo(t.izq.datos) < 0) {
                    t = rotacion_con_HijoIzq(t);
                }
                if (t.izq == Nodonull) {
                    break;
                }
                // a la derecha
                derArbolMin.izq = t;
                derArbolMin = t;
                t = t.izq;
            } else if (x.compareTo(t.datos) > 0) {
                if (x.compareTo(t.der.datos) > 0) {
                    t = rotacion_con_HijoDer(t);
                }
                if (t.der == Nodonull) {
                    break;
                }
                // a la izquierda
                izqArbolMax.der = t;
                izqArbolMax = t;
                t = t.der;
            } else {
                break;
            }
        }
        izqArbolMax.der = t.izq;
        derArbolMin.izq = t.der;
        t.izq = ini.der;
        t.der = ini.izq;
        return t;
    }
    /*
     * Rotacion NodoArbolBinario con descendiente a la izquierda.
     */

    static NodoArbolBinario rotacion_con_HijoIzq(NodoArbolBinario k2) {
        NodoArbolBinario k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        return k1;
    }
    /*
     * Rotacion NodoArbolBinario con descendiente a la derecha.
     */

    static NodoArbolBinario rotacion_con_HijoDer(NodoArbolBinario k1) {
        NodoArbolBinario k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        return k2;
    }
    /*
     * Metodo Interno edita un subarbol en una secuencia ordenada. Parametro b
     * es el respectivo nodo raíz.
     */

    private void printArbol(NodoArbolBinario b) {
        if (b != b.izq) {
            printArbol(b.izq);
            System.out.println(b.datos.toString());
            printArbol(b.der);
        }
    }
}
