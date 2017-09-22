/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplebinarytree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author federico
 */
public interface IBinaryTree {

    void addRoot(Object newRoot) throws Exception;

    /**
     * Attaches two trees to be subtrees of an external node.
     */
    void attach(INode nodeAttaching, BinaryTree T1, BinaryTree T2) throws InvalidNodeException;

    Iterator children(INode nodeToParent) throws InvalidNodeException;

    Iterator elements() throws InvalidNodeException;

    Object getRootElement();

    boolean hasLeft(INode nodeToCheck) throws InvalidNodeException;

    boolean hasParent(INode nodeToCheck) throws InvalidNodeException;

    boolean hasRight(INode nodeToCheck) throws InvalidNodeException;

    String inOrderPrintElements() throws InvalidNodeException;

    ArrayList inOrderTraversal() throws InvalidNodeException;

    void insertNodeLeft(INode father, Object newElement) throws InvalidNodeException;

    void insertNodeRight(INode father, Object newElement) throws InvalidNodeException;

    boolean isEmpty();

    boolean isExternal(INode nodeToCheck) throws InvalidNodeException;

    boolean isInternal(INode nodeToCheck) throws InvalidNodeException;

    boolean isRoot(INode nodeToCheck) throws InvalidNodeException;

    Node left(INode nodeToCheck) throws InvalidNodeException, BoundaryViolationException;

    Node parent(INode nodeToCheck) throws InvalidNodeException;

    Iterator positions() throws InvalidNodeException;

    /**
     * Removes a node with zero or one child.
     */
    Object remove(INode node) throws InvalidNodeException;

    Object replace(INode nodeToChange, Object newElement) throws InvalidNodeException;

    Node right(INode nodeToCheck) throws InvalidNodeException, BoundaryViolationException;

    INode root();

    void setNode(INode nodeToSet, Object newElement) throws InvalidNodeException;

    int size();

}
