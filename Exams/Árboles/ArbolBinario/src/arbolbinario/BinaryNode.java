/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolbinario;

/**
 *
 * @author usuarioupo
 */
public class BinaryNode implements IBinaryNode{





    private Object objeto;
    private IBinaryNode left,right,parent;

    public BinaryNode(IBinaryNode parent) {
        this.objeto = null;
        this.left=null;
        this.right=null;
        this.parent=parent;
    }

    public BinaryNode(Object objeto,IBinaryNode parent) {
        this.objeto = objeto;
        this.left= new BinaryNode(this);
        this.right= new BinaryNode(this);
        this.parent=parent;
    }
    public BinaryNode(Object objeto) {
        this.objeto = objeto;
        this.left= new BinaryNode(this);
        this.right= new BinaryNode(this);
        this.parent=null;
    }

    public BinaryNode(Object objeto, IBinaryNode left, IBinaryNode right,IBinaryNode parent) {
        this.objeto = objeto;
        this.left = left;
        this.right = right;
        this.parent=parent;
    }
    public BinaryNode(Object objeto, IBinaryNode left, IBinaryNode right) {
        this.objeto = objeto;
        this.left = left;
        this.right = right;
        this.parent=null;
    }
    public IBinaryNode getLeft() {
        return left;
    }

    public void setLeft(IBinaryNode left) {
        this.left = left;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public IBinaryNode getRight() {
        return right;
    }

    public void setRight(IBinaryNode right) {
        this.right = right;
    }

    public IBinaryNode getParent() {
        return parent;
    }

    public void setParent(IBinaryNode parent) {
        this.parent = parent;
    }
}
