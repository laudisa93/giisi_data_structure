/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author usuarioupo
 */
public class BinaryTree implements IBinaryTree {

    public BinaryTree(IBinaryNode root) {
        this.root = root;
        this.numElementos = 0;
    }
    private IBinaryNode root;
    private int numElementos;

    public int size() {
        return numElementos;
    }

    public boolean isEmpty() {
        return (numElementos == 0);
    }

    public Iterator elementsInOrder() {
        Collection c = new ArrayList();
        inOrden(c, root);
        Iterator it = c.iterator();
        return it;
    }

    public Iterator elementsPreOrder() {
        Collection c = new ArrayList();
        preOrden(c, root);
        Iterator it = c.iterator();
        return it;
    }

    public Iterator elementsPostOrder() {
        Collection c = new ArrayList();
        postOrden(c, root);
        Iterator it = c.iterator();
        return it;

    }

    private void inOrden(Collection c, IBinaryNode node) {
        if (this.hasLeft(node)) {
            inOrden(c, node.getLeft());
        }
        tratamiento(c, node.getObjeto());
        if (this.hasRight(node)) {
            inOrden(c, node.getRight());
        }
    }

    private void preOrden(Collection c, IBinaryNode node) {
        tratamiento(c, node.getObjeto());
        if (this.hasLeft(node)) {
            preOrden(c, node.getLeft());
        }
        if (this.hasRight(node)) {
            preOrden(c, node.getRight());
        }
    }

    private void postOrden(Collection c, IBinaryNode node) {
        if (this.hasLeft(node)) {
            postOrden(c, node.getLeft());
        }
        if (this.hasRight(node)) {
            postOrden(c, node.getRight());
        }
        tratamiento(c, node.getObjeto());
    }

    private void tratamiento(Collection c, Object obj) {
        c.add(obj);
    }

    public IBinaryNode root() {
        return root;
    }

    public IBinaryNode parent(IBinaryNode node) {
        return node.getParent();
    }

    public Collection children(IBinaryNode node) {
        Collection c = new ArrayList();
        c.add(node.getLeft().getObjeto());
        c.add(node.getRight().getObjeto());
        return c;
    }

    public boolean isInternal(IBinaryNode node) {
        return (hasLeft(node) && hasRight(node));
    }

    public boolean isExternal(IBinaryNode node) {
        return (!hasLeft(node) && !hasRight(node));
    }

    public boolean isRoot(IBinaryNode node) {
        return (root == node);
    }

    public IBinaryNode left(IBinaryNode node) {
        return ((BinaryNode) node).getLeft();
    }

    public IBinaryNode right(IBinaryNode node) {
        return ((BinaryNode) node).getRight();
    }

    public boolean hasLeft(IBinaryNode node) {
        return node.getLeft().getObjeto() != null;
    }

    public boolean hasRight(IBinaryNode node) {
        return node.getRight().getObjeto() != null;
    }

    public void addLeaf(int obj) throws Exception {

        IBinaryNode nodo = this.root;
        insertar(nodo, obj);

    }

    private void insertar(IBinaryNode nodo, int obj) throws Exception {
        if (nodo.getObjeto() == null) { // insertamos el objeto
            if (root == nodo.getObjeto()) {
                nodo.setObjeto(obj);
            } else {
                nodo.setObjeto(obj);
                nodo.setLeft(new BinaryNode(nodo));
                nodo.setRight(new BinaryNode(nodo));
            }
        } else if (obj == nodo.getObjeto()) { //si esta duplicado, salta un error
            throw new Exception("ERROR: numero " + obj + " duplicado");
        } else if (obj < (Integer) nodo.getObjeto()) { //si el objeto es menor que el objeto del arbol, nos dirigimos al hijo izquierdo
            insertar(nodo.getLeft(), obj);
        } else if (obj > (Integer) nodo.getObjeto()) { //si el objeto es menor que el objeto del arbol, nos dirigimos al hijo derecho
            insertar(nodo.getRight(), obj);
        }
    }
}
