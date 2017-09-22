package simplebinarytree;

/**
 *
 * @author federico
 */
public class Node extends GeneralNode implements INode {
   
    Node right;
    Node left;
    Node parent;
    
    public Node(Object element, Node parent) {
        this.element = element;
        this.right = null;
        this.left = null;
        this.parent = parent;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


}
