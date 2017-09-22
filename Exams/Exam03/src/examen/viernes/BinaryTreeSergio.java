package examen.viernes;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import ed.epd11.BinaryNode;
import ed.epd11.BinaryTree;
import ed.epd11.IBinaryNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Sergio
 */
public class BinaryTreeSergio<T extends Comparable> extends BinaryTree {

    public BinaryTreeSergio(BinaryNode root) {
        super(root);
    }

    public BinaryTreeSergio() throws Exception {
        super();
    }

    /*
     * Extender la clase BinaryTree e implementar el método addLeaf. Dicho
     * método insertará un nodo hoja en la posición correspondiente teniendo en
     * cuenta que los nodos a su izquierda tienen valores menores y los de su
     * derecha derecha valores mayores. Recibirá, como parámetro de entrada, el
     * valor del nodo que se quiere añadir. Si ya existe otro nodo con el mismo
     * valor lanzará una excepción.
     */
    public void addLeaf(int obj) throws Exception {
        insertar(this.root, obj);
    }

    private void insertar(IBinaryNode nodo, int obj) throws Exception {
        if (obj == nodo.element()) {
            throw new Exception("ERROR: El número " + nodo.element() + " está duplicado.");
        } else if (obj < (Integer) nodo.element() && nodo.getLeft() != null) {
            insertar(nodo.getLeft(), obj);
        } else if (obj > (Integer) nodo.element() && nodo.getRight() != null) {
            insertar(nodo.getRight(), obj);
        } else {
            if (root == nodo.element()) {
                nodo.setElement(obj);
            } else {
                IBinaryNode nuevo = new BinaryNode(obj, nodo);
                if (obj < (Integer) nodo.element()) {
                    nodo.setLeft(nuevo);
                } else if (obj > (Integer) nodo.element()) {
                    nodo.setRight(nuevo);
                }
            }
        }
    }

    public Iterator elementsPostOrden() {
        Collection c = new ArrayList();
        postorden(root, c);
        Iterator it = c.iterator();
        return it;
    }

    private void postorden(IBinaryNode root, Collection c) {
        if (root != null) {
            postorden(root.getLeft(), c);
            postorden(root.getRight(), c);
            c.add(root.element());
        }
    }

    public void removeLeaf(IBinaryNode<T> elementoEliminar, IBinaryNode<T> nodo) throws Exception {

        if (elementoEliminar.element().compareTo(nodo.element())<0) {
            if (nodo.getLeft() != null) {
                if (nodo.getLeft().element().compareTo(elementoEliminar.element())==0) {
                    if (nodo.getLeft() != null || nodo.getRight() != null) {
                        throw new Exception("NO SE PUEDE ELIMINAR PORQUE TIENE HIJOS");
                    } else {
                        nodo.setLeft(null);
                    }
                } else {
                    removeLeaf(elementoEliminar, nodo.getLeft());
                }
            }
        } else {
            if (nodo.getRight() != null) {
                if (nodo.getRight().element().compareTo(elementoEliminar.element())==0) {
                    if (nodo.getLeft() != null || nodo.getRight() != null) {
                        throw new Exception("NO SE PUEDE ELIMINAR PORQUE TIENE HIJOS");
                    } else {
                        nodo.setRight(null);
                    }
                } else {
                    removeLeaf(elementoEliminar, nodo.getRight());
                }
            }
        }
    }

    public void removeLeaf(int elementoEliminar) throws Exception {
        if (elementoEliminar == this.root.element()) {
            super.root = null;
        } else {
            removeLeaf(new BinaryNode(elementoEliminar, null), root);
        }
    }
}
