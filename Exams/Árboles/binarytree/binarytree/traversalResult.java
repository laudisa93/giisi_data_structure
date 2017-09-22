package simplebinarytree;

/**
 *
 * @author federico
 */
public class traversalResult {

    int left;
    int right;
    int below;
    int out;

    public traversalResult() {
        this.setBelow(0);
        this.setLeft(0);
        this.setRight(0);
        this.setOut(0);
    }

    public int getBelow() {
        return below;
    }

    public void setBelow(int below) {
        this.below = below;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }


}
