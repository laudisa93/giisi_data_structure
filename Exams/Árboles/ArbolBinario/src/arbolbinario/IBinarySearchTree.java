/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolbinario;

/**
 *
 * @author usuarioupo
 */
public interface IBinarySearchTree extends IBinaryTree {
    void addElement(Object element);
    Object removeElement(Object element);
    void removeAllOcurrences(Object element);
    Object removeMin();
    Object removeMax();
    Object findMin();
    Object findMax();
}
