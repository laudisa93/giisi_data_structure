/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolbinario;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author usuarioupo
 */
public interface IBinaryTree {
    int size();
    boolean isEmpty();
    Iterator elementsInOrder();
    Iterator elementsPreOrder(); //apartado 2
    Iterator elementsPostOrder();
    IBinaryNode root();
    IBinaryNode parent(IBinaryNode node);
    Collection children(IBinaryNode node);
    boolean isInternal(IBinaryNode node);
    boolean isExternal(IBinaryNode node);
    boolean isRoot(IBinaryNode node);
    IBinaryNode left(IBinaryNode node);
    IBinaryNode right(IBinaryNode node);
    boolean hasLeft(IBinaryNode node);
    boolean hasRight(IBinaryNode node);
    void addLeaf(int obj) throws Exception; //apartado 3
}
