/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolbinario;

/**
 *
 * @author usuarioupo
 */
public interface IBinaryNode {
    public IBinaryNode getLeft();
    public void setLeft(IBinaryNode left);
    public Object getObjeto();
    public void setObjeto(Object objeto);
    public IBinaryNode getRight();
    public void setRight(IBinaryNode right);
    public IBinaryNode getParent();
    public void setParent(IBinaryNode right);
}
