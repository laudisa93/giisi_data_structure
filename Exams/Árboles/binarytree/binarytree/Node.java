package simplebinarytree;

/**
 *
 * @author federico
 */
public class Node extends GeneralNode implements INode {

    INode right;
    INode left;
    INode parent;

    public Node() {
    }

    public Node(Object element, INode parent,
            INode left, INode right) {
        this.setElement(element);
        this.setParent(parent);
        this.setLeft(left);
        this.setRight(right);
    }

    public Node(Object element, INode parent) {
        this.element = element;
        this.right = null;
        this.left = null;
        this.parent = parent;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public INode getLeft() {
        return left;
    }

    public void setLeft(INode left) {
        this.left = left;
    }

    public INode getRight() {
        return right;
    }

    public void setRight(INode right) {
        this.right = right;
    }

    public INode getParent() {
        return parent;
    }

    public void setParent(INode parent) {
        this.parent = parent;
    }
}
