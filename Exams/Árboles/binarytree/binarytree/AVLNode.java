package simplebinarytree;

/**
 *
 * @author federico
 */
public class AVLNode extends Node implements INode {
    protected int height;

    AVLNode() {/* default constructor */

        }

        /** Preferred constructor */
        AVLNode(Object element, INode parent,
                INode left, INode right) {
            super(element, parent, left, right);
            height = 0;
            if (left != null) {
                height = Math.max(height, 1 + ((AVLNode) left).getHeight());
            }
            if (right != null) {
                height = Math.max(height, 1 + ((AVLNode) right).getHeight());
            }
        } // we assume that the parent will revise its height if needed


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



}
