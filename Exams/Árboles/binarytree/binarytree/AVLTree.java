package simplebinarytree;

import java.util.Comparator;

/**
 *
 * @author federico
 */
public class AVLTree extends SimpleBinarySearchTree {

    protected INode actionNode;

    public AVLTree(Comparator c) {
        super(c);
    }

    //need to redefine some methods in order to keep track of the node modified
    public Entry find(Object key) throws InvalidKeyException {

        checkKey(key);		// may throw an InvalidKeyException
        try {
            INode curPos = this.search(key, root());
            this.actionNode = curPos;		// node where the search ended
            if (this.isInternal(curPos)) {
                return this.entry(curPos);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private Entry removeAVL(Entry ent) throws InvalidEntryException {
        this.checkEntry(ent);
        Entry toReturn = null;
        try {
            Object keyToRemove = ent.getKey();
            this.checkKey(keyToRemove);
            INode nodeToRemove = (Node) this.search(keyToRemove, this.root);
            if (this.isExternal(nodeToRemove)) {
                throw new InvalidEntryException("remove: there is no entry with key " + ent.getKey());
            } else {
                toReturn = (Entry) nodeToRemove.element();
                if (this.isExternal(this.left(nodeToRemove))) {
                    //this is the easy case
                    //we just remove above external the left child of the node
                    nodeToRemove = nodeToRemove.getLeft();
                } else if (this.isExternal(this.right(nodeToRemove))) {
                    //easy case from the right
                    nodeToRemove = nodeToRemove.getRight();
                } else {
                    //node is internal with children
                    //must find next node in an inorder traversal
                    INode swapNode = nodeToRemove;
                    nodeToRemove = this.right(swapNode);
                    do {
                        nodeToRemove = left(nodeToRemove);
                    } while (isInternal(nodeToRemove));
                    replaceEntry(swapNode, (Entry) parent(nodeToRemove).element());
                }
                this.actionNode = this.sibling(nodeToRemove);	// sibling of the leaf to be removed
                this.removeAboveExternal(nodeToRemove);
                this.numberNodes--;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return toReturn;
    }

    /** Returns the height of a node (call back to an AVLNode). */
    protected int height(INode node) {
        return ((AVLNode) node).getHeight();
    }

    /** Sets the height of an internal node (call back to an AVLNode). */
    protected void setHeight(INode nodeToSet) {
        try {
            ((AVLNode) nodeToSet).setHeight(1 + Math.max(height(left(nodeToSet)), height(right(nodeToSet))));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    protected INode tallerChild(INode node) {
        try {
            if (height(left(node)) > height(right(node))) {
                return left(node);
            } else if (height(left(node)) < height(right(node))) {
                return right(node);
            }
            // equal height children - break tie using parent's type
            if (isRoot(node)) {
                return left(node);
            }
            if (node == left(parent(node))) {
                return left(node);
            } else {
                return right(node);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /** Returns whether a node has balance factor between -1 and 1. */
    protected boolean isBalanced(INode nodeToCheck) {
        boolean balanced = false;
        try {
            int heightDifference = this.height(left(nodeToCheck)) - this.height(right(nodeToCheck));
            balanced = ((-1 <= heightDifference) && (heightDifference <= 1));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return balanced;
    }

    /**
     * Performs a tri-node restructuring.  Assumes the nodes are in one
     * of following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     * @return the new root of the restructured subtree
     */
    protected INode restructure(INode x) {
        AVLNode a, b, c, t1, t2, t3, t4;
        b = null;
        try {


            INode y = parent(x);	// assumes x has a parent
            INode z = parent(y);	// assumes y has a parent
            boolean xLeft = (x == left(y));
            boolean yLeft = (y == left(z));
            AVLNode xx = (AVLNode) x,
                    yy = (AVLNode) y, zz = (AVLNode) z;
            if (xLeft && yLeft) {
                a = xx;
                b = yy;
                c = zz;
                t1 = (AVLNode) a.getLeft();
                t2 = (AVLNode) a.getRight();
                t3 = (AVLNode) b.getRight();
                t4 = (AVLNode) c.getRight();
            } else if (!xLeft && yLeft) {
                a = yy;
                b = xx;
                c = zz;
                t1 = (AVLNode) a.getLeft();
                t2 = (AVLNode) b.getLeft();
                t3 = (AVLNode) b.getRight();
                t4 = (AVLNode) c.getRight();
            } else if (xLeft && !yLeft) {
                a = zz;
                b = xx;
                c = yy;
                t1 = (AVLNode) a.getLeft();
                t2 = (AVLNode) b.getLeft();
                t3 = (AVLNode) b.getRight();
                t4 = (AVLNode) c.getRight();
            } else { // right-right
                a = zz;
                b = yy;
                c = xx;
                t1 = (AVLNode) a.getLeft();
                t2 = (AVLNode) b.getLeft();
                t3 = (AVLNode) c.getLeft();
                t4 = (AVLNode) c.getRight();
            }
            // put b at z's place
            if (isRoot(z)) {
                root = b;
                b.setParent(null);
            } else {
                AVLNode zParent = (AVLNode) parent(z);
                if (z == left(zParent)) {
                    b.setParent(zParent);
                    zParent.setLeft(b);
                } else { // z was a right child
                    b.setParent(zParent);
                    zParent.setRight(b);
                }
            }
            // place the rest of the nodes and their children
            b.setLeft(a);
            a.setParent(b);
            b.setRight(c);
            c.setParent(b);
            a.setLeft(t1);
            t1.setParent(a);
            a.setRight(t2);
            t2.setParent(a);
            c.setLeft(t3);
            t3.setParent(c);
            c.setRight(t4);
            t4.setParent(c);
            // Reset the location-aware
        /*SHOULD NOT BE NEEDED IN MY IMPLEMENTATION
            try {
            ((Entry) a.element()).pos = a;
            ((Entry) b.element()).pos = b;
            ((Entry) c.element()).pos = c;
            } catch (Exception e) {
            System.err.println(e.getMessage());
            }*/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return b; // the new root of this subtree
    }

    /**
     * Rebalance method called by insert and remove.  Traverses the path from
     * zNode to the root. For each node encountered, we recompute its height
     * and perform a trinode restructuring if it's unbalanced.
     */
    protected void rebalance(INode zNode) {
        try {
            if (isInternal(zNode)) {
                setHeight(zNode);
            }
            while (!isRoot(zNode)) {  // traverse up the tree towards the root
                zNode = parent(zNode);
                setHeight(zNode);
                if (!isBalanced(zNode)) {
                    // perform a trinode restructuring at zPos's tallest grandchild
                    INode xNode = tallerChild(tallerChild(zNode));
                    zNode = restructure(xNode); // tri-node restructure (from parent class)
                    setHeight(left(zNode));  // recompute heights
                    setHeight(right(zNode));
                    setHeight(zNode);
                }
            }
        } catch (Exception e) {
        }
    }

    private Entry insertInAVLTree(Object k, Object x) throws InvalidKeyException {
        Entry entryToReturn = null;
        try {
            this.checkKey(k);	// may throw an InvalidKeyException
            INode insertPosition = search(k, this.root());
            while (!this.isExternal(insertPosition)) // iterative search for insertion position
            {
                insertPosition = this.search(k, this.left(insertPosition));
            }
            this.actionNode = insertPosition;	// node where the new entry is being inserted
            entryToReturn = this.insertAtExternal(insertPosition, new Entry(k, x));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return entryToReturn;
    }

    public Entry insertAVL(Object key, Object value) throws InvalidKeyException {
        Entry entryToReturn = this.insertInAVLTree(key, value);
        rebalance(actionNode);
        return entryToReturn;
    }

    @Override
    public Entry remove(Entry ent) throws InvalidEntryException {
        Entry toReturn = this.removeAVL(ent);
        if (toReturn != null) // we actually removed something
        {
            rebalance(actionNode);  // rebalance up the tree
        }
        return toReturn;
    }

    @Override
    protected INode checkPosition(INode nodeToCheck)
            throws InvalidNodeException {
        if (nodeToCheck == null || !(nodeToCheck instanceof AVLNode)) {
            throw new InvalidNodeException("checkPosition: The position \"" + nodeToCheck + "\" is invalid");
        }
        return (AVLNode) nodeToCheck;
    }

    @Override
    protected void addLeafs(INode node) {
        try {
            INode verifiedNode = checkPosition(node);
            verifiedNode.setLeft(new AVLNode("leaf", verifiedNode, null, null));
            verifiedNode.setRight(new AVLNode("leaf", verifiedNode,null,null));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void addAVLRoot(Object newRoot) throws EmptyTreeException, InvalidNodeException {
        if (this.isEmpty()) {
            if (newRoot.getClass() == Entry.class) {
                this.root = new AVLNode((Entry) newRoot, null, null, null);
                //adding leafs
                //TODO THE ADD LEAFS ADD TWO LEAF OF TYPE NODE, THIS WILL CAUSE PROBLEM FOR THE AVT TREE
                this.addLeafs(root);
                this.numberNodes++;
            } else {
                throw new InvalidNodeException("addRoot: a node must be a dictionary entry!!!");
            }
        } else {
            throw new EmptyTreeException("addRoot: tree is not empty!!!");
        }
    }
}
