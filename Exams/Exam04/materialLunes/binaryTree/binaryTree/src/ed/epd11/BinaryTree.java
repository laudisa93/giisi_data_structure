package ed.epd11;

/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/**
 * BinaryTree.java
 * Copyright (C) 2008-2012 Miguel Garcia Torres
 */



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Miguel Garcia Torres (mgarciat[at]upo[dot]es)
 */
public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
    protected IBinaryNode<T> root = null;

    /**
     *
     */
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }
    //add root to the tree
    @Override
    public void addRoot(IBinaryNode<T> r) throws Exception {
        this.root = r;
    }

    /**
     * Attaches two trees to be subtrees of an external node.
     */
    //@Override
    //public void attach(IBinaryNode<T> nodeAttaching, IBinaryTree<T> T1, IBinaryTree<T> T2) throws InvalidNodeException;
    @Override
    public<V extends IBinaryNode<T>> Iterator<V> children(IBinaryNode<T> nodeToParent) throws InvalidNodeException {
        IBinaryNode<T> verifiedNode = this.checkPosition(nodeToParent);
        List childrenList = new ArrayList();
        if (this.hasLeft(verifiedNode)) {
            childrenList.add(verifiedNode.getLeft());
        }
        if (this.hasRight(verifiedNode)) {
            childrenList.add(verifiedNode.getRight());
        }
        return childrenList.iterator();
    }
    
    //return list of children  of a given node
    
    @Override
    public T getRootElement() {
        return root.element();
    }

    @Override
    public BinaryNode<T> root() {
        return (BinaryNode<T>) this.root;
    }
    

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }


    protected BinaryNode<T> checkPosition(IBinaryNode<T> nodeToCheck)
            throws InvalidNodeException {
        if (nodeToCheck == null || !(nodeToCheck instanceof BinaryNode)) {
            throw new InvalidNodeException("The position is invalid");
        }
        return (BinaryNode<T>) nodeToCheck;
    }

    @Override
    public boolean hasLeft(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        //System.out.print("node (has-left): " + nodeToCheck.element());
        BinaryNode<T> verifiedNode = this.checkPosition(nodeToCheck);
        /*if (verifiedNode.getLeft() == null) {
            System.out.println("\t---");
        } else {
            System.out.println("\t" + verifiedNode.getLeft().element());
        }*/
        return verifiedNode.getLeft() != null;
    }

    @Override
    public boolean hasRight(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        //System.out.print("node (has-right): " + nodeToCheck.element());
        BinaryNode<T> verifiedNode = this.checkPosition(nodeToCheck);
        /*if (verifiedNode.getRight() == null) {
            System.out.println("\t---");
        } else {
            System.out.println("\t" + verifiedNode.getRight().element());
        }*/
        return verifiedNode.getRight() != null;
    }

    protected void inOrderVisit(IBinaryNode<T> node, ArrayList<IBinaryNode<T>> listOfNodes) throws InvalidNodeException {
        if (this.hasLeft(node)) {
            //System.out.println("has left:::");
            inOrderVisit(node.getLeft(), listOfNodes);
        }
        listOfNodes.add(node);
        if (this.hasRight(node)) {
            //System.out.println("has right:::");
            inOrderVisit(node.getRight(), listOfNodes);
        }
    }

    @Override
    public ArrayList inOrderTraversal() throws InvalidNodeException {
        ArrayList listOfNodes = new ArrayList();
        this.inOrderVisit(this.root, listOfNodes);
        return listOfNodes;
    }
    //return the node of the tree in a list, order as the inorder visit

    @Override
    public int size() {
        int size = 0;
        try {
            size = this.inOrderTraversal().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return size;
    }


    @Override
    public void attach(IBinaryNode<T> nodeAttaching, IBinaryTree<T> T1, IBinaryTree<T> T2) throws InvalidNodeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<T> elements() throws InvalidNodeException {
        ArrayList<T> listOfElements = new ArrayList();
        this.inOrderVisitElement(this.root, listOfElements);
        return listOfElements.iterator();
    }
    /**
     * return the elements stored in the tree in a list, order as the inorder visit
     * @param node
     * @param listOfNodes
     * @throws InvalidNodeException
     */
    protected void inOrderVisitElement(IBinaryNode<T> node, ArrayList<T> listOfNodes) throws InvalidNodeException {
        if (this.hasLeft(node)) {
            inOrderVisitElement(node.getLeft(), listOfNodes);
        }
        listOfNodes.add(node.element());
        if (this.hasRight(node)) {
            inOrderVisitElement(node.getRight(), listOfNodes);
        }
    }

    @Override
    public boolean hasParent(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        if (verifiedNode.getParent() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertNodeLeft(IBinaryNode<T> father, T newElement) throws InvalidNodeException {
        BinaryNode<T> parentNode = this.checkPosition(father);
        if (this.hasLeft(parentNode)) {
            throw new InvalidNodeException("Node " + parentNode.element() + " has already a left child!!");
        }
        parentNode.setLeft(new BinaryNode<T>(newElement, parentNode));
    }

    @Override
    public void insertNodeRight(IBinaryNode<T> father, T newElement) throws InvalidNodeException {
        BinaryNode<T> parentNode = this.checkPosition(father);
        if (this.hasRight(parentNode)) {
            throw new InvalidNodeException("Node" + parentNode.element() + " has already a right child!!");
        }
        parentNode.setRight(new BinaryNode<T>(newElement, parentNode));
    }

    //check if a node is the root
    @Override
    public boolean isRoot(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        return verifiedNode.getParent() == null;
    }

     //check if a node is internal
    @Override
    public boolean isInternal(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        if (hasLeft(verifiedNode) || (hasRight(verifiedNode))) {
            return true;
        } else {
            return false;
        }
    }
    //check if a node is a leaf

    @Override
    public boolean isExternal(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        return !this.isInternal(nodeToCheck);
    }
    //change element in a given node

    @Override
    public T replace(IBinaryNode<T> nodeToChange, T newElement) throws InvalidNodeException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToChange);
        T oldElement = verifiedNode.element();
        verifiedNode.setElement(newElement);
        return oldElement;
    }

    //return left child if it exists, error otherwise
    @Override
    public<V extends IBinaryNode<T>> V left(IBinaryNode<T> nodeToCheck) throws InvalidNodeException, BoundaryViolationException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        if (hasLeft(verifiedNode)) {
            return (V) verifiedNode.getLeft();
        } else {
            throw new BoundaryViolationException("Node " + verifiedNode.element() + " has no left child");
        }
    }

    //return right child if it exists, error otherwise
    @Override
    public<V extends IBinaryNode<T>> V right(IBinaryNode<T> nodeToCheck) throws InvalidNodeException, BoundaryViolationException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        if (hasRight(verifiedNode)) {
            return (V) verifiedNode.getRight();
        } else {
            //throw new InvalidNodeException("Node " + verifiedNode.getElement() + " has no right child");
            throw new BoundaryViolationException("Node " + verifiedNode.element() + " has no right child");
        }
    }
    
    @Override
    public<V extends IBinaryNode<T>> V parent(IBinaryNode<T> nodeToCheck) throws InvalidNodeException {
        BinaryNode<T> verifiedNode = checkPosition(nodeToCheck);
        BinaryNode<T> parentNode = (BinaryNode<T>) verifiedNode.getParent();
        if (parentNode == null) {
            throw new InvalidNodeException("Node " + verifiedNode.element() + " has no parent");
        }
        return (V) parentNode;
    }

    @Override
    public void setNode(IBinaryNode<T> nodeToSet, T newElement) throws InvalidNodeException {
        IBinaryNode<T> parentNode = this.checkPosition(nodeToSet);
        parentNode.setElement(newElement);

    }

    // Removes a node with zero or one child.
    @Override
    public T remove(IBinaryNode<T> node) throws InvalidNodeException {
        IBinaryNode<T> nodeToRemove = this.checkPosition(node);
        if (this.hasLeft(nodeToRemove) && this.hasRight(nodeToRemove)) {
            throw new InvalidNodeException("Cannot remove node if it has two children!!");
        }
        IBinaryNode<T> onlyChild = null;
        if (this.hasLeft(nodeToRemove)) {
            onlyChild = nodeToRemove.getLeft();
        }
        if (this.hasRight(nodeToRemove)) {
            onlyChild = nodeToRemove.getRight();
        }
        if (this.isRoot(nodeToRemove)) {
            if (onlyChild != null) {
                onlyChild.setParent(null);
            }
            this.root = onlyChild;
        } else {
            IBinaryNode<T> parentOldNode = nodeToRemove.getParent();
            //if node to remove was a left son
            if (parentOldNode.getLeft() == nodeToRemove) {
                parentOldNode.setLeft(onlyChild);
            }
            //if node to remove was a right son
            if (parentOldNode.getRight() == nodeToRemove) {
                parentOldNode.setRight(onlyChild);
            }
            if (onlyChild != null) {
                onlyChild.setElement((T) parentOldNode);
            }
        }
        // this.size--;
        return nodeToRemove.element();
    }

    @Override
    public String toString(){
        String result ="";
        try {
            result = this.inOrderPrintElements();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
    //return a string with the list of elements arranged in inorder
    protected String inOrderPrintElements() throws InvalidNodeException {
        String result = "[";

        for (Iterator it = this.elements(); it.hasNext();) {
            Object object = it.next();
            result += object;
            if (it.hasNext()) {
                result += ",";
            }

        }
        result += "]";
        return result;
    }
}
