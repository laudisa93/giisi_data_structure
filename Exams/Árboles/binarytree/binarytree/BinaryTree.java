/*
 * Simple implementation of a binary tree
 */
package simplebinarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author federico
 */
public class BinaryTree implements IBinaryTree  {

    INode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Object rootElement) {
        root = new Node(rootElement, null);
    }

    public Object getRootElement() {
        return root.element();
    }

    public INode root() {
        return this.root;
    }
    //add root to the tree

    public void addRoot(Object newRoot) throws EmptyTreeException {
        if (this.isEmpty()) {
            this.root = new Node(newRoot, null);

        } else {
            throw new EmptyTreeException("Cannot add a root: tree is not empty!!");
        }
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    //use a traversal for computing the number of nodes of the tree
    public int size() {
        int size = 0;
        try {
            size = this.inOrderTraversal().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return size;
    }

    //change element in a given node
    public Object replace(INode nodeToChange, Object newElement) throws InvalidNodeException {
        INode verifiedNode = checkPosition(nodeToChange);
        Object oldElement = verifiedNode.element();
        verifiedNode.setElement(newElement);
        return oldElement;
    }

    //check if a node is internal
    public boolean isInternal(INode nodeToCheck) throws InvalidNodeException {
        Node verifiedNode = (Node)checkPosition(nodeToCheck);
        if (hasLeft(verifiedNode) || (hasRight(verifiedNode))) {
            return true;
        } else {
            return false;
        }
    }
    
    //check if a node is a leaf
    public boolean isExternal(INode nodeToCheck) throws InvalidNodeException {
        return !this.isInternal(nodeToCheck);
    }

    //check if a node is the root
    public boolean isRoot(INode nodeToCheck) throws InvalidNodeException {
        Node verifiedNode = (Node)checkPosition(nodeToCheck);
        if (verifiedNode.getParent() == null) {
            return true;
        } else {
            return false;
        }
    }

    public INode parent(INode nodeToCheck) throws InvalidNodeException {
        INode verifiedNode = checkPosition(nodeToCheck);

        INode parentNode = verifiedNode.getParent();
        if (parentNode == null) {
            throw new InvalidNodeException("Node " + verifiedNode.element() + " has no parent");
        }
        return parentNode;
    }

    //return list of children  of a given node
    public Iterator children(INode nodeToParent) throws InvalidNodeException {
        Node verifiedNode = (Node)checkPosition(nodeToParent);
        List childrenList = new ArrayList();
        if (this.hasLeft(verifiedNode)) {
            childrenList.add(verifiedNode.getLeft());
        }
        if (this.hasRight(verifiedNode)) {
            childrenList.add(verifiedNode.getRight());
        }
        return childrenList.iterator();
    }
    //return left child if it exists, error otherwise

    public INode left(INode nodeToCheck) throws InvalidNodeException, BoundaryViolationException {
        INode verifiedNode = checkPosition(nodeToCheck);
        if (hasLeft(verifiedNode)) {
            return verifiedNode.getLeft();
        } else {
            throw new BoundaryViolationException("Node " + verifiedNode.element() + " has no left child");
        }
    }

    //return right child if it exists, error otherwise
    public INode right(INode nodeToCheck) throws InvalidNodeException, BoundaryViolationException {
        Node verifiedNode = (Node)checkPosition(nodeToCheck);
        if (hasRight(verifiedNode)) {
            return verifiedNode.getRight();
        } else {
            //throw new InvalidNodeException("Node " + verifiedNode.getElement() + " has no right child");
            throw new BoundaryViolationException("Node " + verifiedNode.element() + " has no right child");
        }
    }

    //return iterator of nodes in inOrder way
    public Iterator positions() throws InvalidNodeException {
        return this.inOrderTraversal().iterator();
    }
    //returns iterator of elements stored in the nodes of the tree

    public Iterator elements() throws InvalidNodeException {
        ArrayList listOfElements = new ArrayList();
        this.inOrderVisitElement(root, listOfElements);
        return listOfElements.iterator();
    }
    //return the elements stored in the tree in a list, order as the inorder visit

    private void inOrderVisitElement(INode node, ArrayList listOfNodes) throws InvalidNodeException {

        if (this.hasLeft(node)) {
            inOrderVisitElement(node.getLeft(), listOfNodes);
        }
        listOfNodes.add(node.element());
        if (this.hasRight(node)) {
            inOrderVisitElement(node.getRight(), listOfNodes);
        }
    }

    //return a string with the list of elements arranged in inorder
    public String inOrderPrintElements() throws InvalidNodeException {
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

    public String toString(){
        String result ="";
        try {
            result = this.inOrderPrintElements();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public void setNode(INode nodeToSet, Object newElement) throws InvalidNodeException {
        INode parentNode = this.checkPosition(nodeToSet);
        parentNode.setElement(newElement);

    }

    protected INode checkPosition(INode nodeToCheck)
            throws InvalidNodeException {
        if (nodeToCheck == null || !(nodeToCheck instanceof Node)) {
            throw new InvalidNodeException("checkPosition: The position \"" +nodeToCheck+ "\" is invalid");
        }
        return (Node) nodeToCheck;
    }

    public boolean hasLeft(INode nodeToCheck) throws InvalidNodeException {
        INode verifiedNode = checkPosition(nodeToCheck);
        if (verifiedNode.getLeft() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRight(INode nodeToCheck) throws InvalidNodeException {
        Node verifiedNode = (Node)checkPosition(nodeToCheck);
        if (verifiedNode.getRight() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasParent(INode nodeToCheck) throws InvalidNodeException {
        Node verifiedNode = (Node)checkPosition(nodeToCheck);
        if (verifiedNode.getParent() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertNodeLeft(INode father, Object newElement) throws InvalidNodeException {
        Node parentNode = (Node)this.checkPosition(father);
        if (this.hasLeft(parentNode)) {
            throw new InvalidNodeException("Node " + parentNode.element() + " has already a left child!!");
        }
        parentNode.setLeft(new Node(newElement, parentNode));
    }

    public void insertNodeRight(INode father, Object newElement) throws InvalidNodeException {
        Node parentNode = (Node)this.checkPosition(father);
        if (this.hasRight(parentNode)) {
            throw new InvalidNodeException("Node" + parentNode.element() + " has already a right child!!");
        }
        parentNode.setRight(new Node(newElement, parentNode));
    }

    public ArrayList inOrderTraversal() throws InvalidNodeException {
        ArrayList listOfNodes = new ArrayList();
        this.inOrderVisit(root, listOfNodes);
        return listOfNodes;
    }
    //return the node of the tree in a list, order as the inorder visit

    private void inOrderVisit(INode node, ArrayList listOfNodes) throws InvalidNodeException {

        if (this.hasLeft(node)) {
            inOrderVisit(node.getLeft(), listOfNodes);
        }
        listOfNodes.add(node);
        if (this.hasRight(node)) {
            inOrderVisit(node.getRight(), listOfNodes);
        }
    }

    /** Removes a node with zero or one child. */
    public Object remove(INode node) throws InvalidNodeException {
        INode nodeToRemove = this.checkPosition(node);
        if (this.hasLeft(nodeToRemove) && this.hasRight(nodeToRemove)) {
            throw new InvalidNodeException("Cannot remove node if it has two children!!");
        }
        INode onlyChild = null;
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
            INode parentOldNode = nodeToRemove.getParent();
            //if node to remove was a left son
            if (parentOldNode.getLeft() == nodeToRemove) {
                parentOldNode.setLeft(onlyChild);
            }
            //if node to remove was a right son
            if (parentOldNode.getRight() == nodeToRemove) {
                parentOldNode.setRight(onlyChild);
            }
            if (onlyChild != null) {
                onlyChild.setParent(parentOldNode);
            }
        }
        // this.size--;
        return nodeToRemove.element();

    }

    /** Attaches two trees to be subtrees of an external node. */
    public void attach(INode nodeAttaching, IBinaryTree T1, IBinaryTree T2)
            throws InvalidNodeException {
        Node vv = (Node)checkPosition(nodeAttaching);
        if (isInternal(nodeAttaching)) {
            throw new InvalidNodeException("Cannot attach from internal node");
        }
        try {


            if (!T1.isEmpty()) {
                Node r1 = (Node)checkPosition(T1.root());
                vv.setLeft(r1);
                r1.setParent(vv);		// T1 should be invalidated
            }
            if (!T2.isEmpty()) {
                Node r2 = (Node)checkPosition(T2.root());
                vv.setRight(r2);
                r2.setParent(vv);		// T2 should be invalidated
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
