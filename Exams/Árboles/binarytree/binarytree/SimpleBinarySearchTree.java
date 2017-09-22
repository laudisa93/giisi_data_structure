package simplebinarytree;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author federico
 */
public class SimpleBinarySearchTree extends BinaryTree {// implements Dictionary {

    //root from Binary tree
    //the element of a node will be an entry
    //external nodes will have element equal to "leaf"
    Comparator bstKeysComparator;
    int numberNodes;
    

    public SimpleBinarySearchTree(Comparator comparator) {
        this.bstKeysComparator = comparator;
        this.numberNodes = 0;
    }

    public void addBSTRoot(Object newRoot) throws EmptyTreeException, InvalidNodeException {
        if (this.isEmpty()) {
            if (newRoot.getClass() == Entry.class) {
                this.root = new Node(newRoot, null);
                //adding leafs
                this.addLeafs(root);
                this.numberNodes++;
            } else {
                throw new InvalidNodeException("addRoot: a node must be a dictionary entry!!!");
            }
        } else {
            throw new EmptyTreeException("addRoot: tree is not empty!!!");
        }
    }

    protected void checkKey(Object key) throws InvalidKeyException {
        if (key == null) // just a simple test for now
        {
            throw new InvalidKeyException("null key");
        }
    }

    public Entry find(Object key) throws InvalidKeyException {

        checkKey(key);		// may throw an InvalidKeyException
        try {
            INode curPos = this.search(key, root());
           // actionNode = (Node)curPos;		// node where the search ended
            if (this.isInternal(curPos)) {
                return this.entry(curPos);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    protected INode search(Object key, INode startingPoint) {
        INode nodeSearched = null;
        try {
            INode currentPosition = checkPosition(startingPoint);
            if (this.isExternal(currentPosition)) {
                return currentPosition;
            } else {
                Entry currentEntry = (Entry) currentPosition.element();
                Object currentKey = currentEntry.getKey();
                int compareResult = bstKeysComparator.compare(key, currentKey);
                if (compareResult < 0) {
                    return search(key, this.left(currentPosition));	// search left subtree
                } else if (compareResult > 0) {
                    return search(key, this.right(currentPosition));	// search right subtree
                }
                return currentPosition;		// return internal node where key is found
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return nodeSearched;
    }

    /** Extracts the key of the entry at a given node of the tree. */
    protected Object key(INode position) throws InvalidNodeException {
        Entry entry = (Entry) position.element();
        return entry.getKey();
        //return position.element().getKey();
    }

    /** Extracts the value of the entry at a given node of the tree. */
    protected Object value(INode position) throws InvalidNodeException {
        Entry entry = (Entry) position.element();
        return entry.getElement();
        // return position.element().getValue();
    }

    /** Extracts the entry at a given node of the tree. */
    protected Entry entry(INode position) throws InvalidNodeException {
        Entry entry = (Entry) position.element();
        return entry;
    }

    protected Entry insertAtExternal(INode nodeToInsert, Entry newEntry) {
        Entry oldEntry = null;
        try {
            this.addLeafs(nodeToInsert);
            Object returnedObject = this.replace(nodeToInsert, newEntry);
            //if the old entry was an entry for a leaf it was not an entry
            //so we cannot return the "old" entry. In this case we return
            //null to symbolize the leaf
            if (returnedObject.getClass() == Entry.class) {
                oldEntry = (Entry) returnedObject;
            }
            this.numberNodes++;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return oldEntry;
    }

    public Entry insert(Object k, Object x) throws InvalidKeyException {
        Entry entryToReturn = null;
        try {
            this.checkKey(k);	// may throw an InvalidKeyException
            INode insertPosition = search(k, this.root());
            while (!this.isExternal(insertPosition)) // iterative search for insertion position
            {
                insertPosition = this.search(k, this.left(insertPosition));
            }
          // actionNode = (Node)insertPosition;	// node where the new entry is being inserted
            entryToReturn = insertAtExternal(insertPosition, new Entry(k, x));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return entryToReturn;
    }

    /** Remove an external node v and replace its parent with v's
    sibling */
    public void removeAboveExternal(INode nodeToRemove)
            throws InvalidNodeException {
        if (!isExternal(nodeToRemove)) {
            throw new InvalidNodeException("Node is not external");
        }
        try {
            if (this.isRoot(nodeToRemove)) {
                // this.remove(nodeToRemove);
                throw new InvalidNodeException("removeAboveExternal: cannot remove root of the tree!!");
            } else {
                INode parentNodeToRemove = parent(nodeToRemove);
                //remove remove only node with at most one child
                this.remove(nodeToRemove);
                this.remove(parentNodeToRemove);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Checks whether a given entry is valid. */
    protected void checkEntry(Entry ent) throws InvalidEntryException {
        if (ent == null || !(ent instanceof Entry)) {
            throw new InvalidEntryException("invalid entry");
        }
    }

    /** Replaces an entry with a new entry (and reset the entry's location) */
    protected void replaceEntry(INode pos, Entry ent) {
        try {
            replace(pos, ent);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Entry remove(Entry ent) throws InvalidEntryException {
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
                //this.actionNode = this.sibling(nodeToRemove);	// sibling of the leaf to be removed
                this.removeAboveExternal(nodeToRemove);
                this.numberNodes--;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return toReturn;
    }

     /** Return the sibling of a node */
    public INode sibling(INode brother)
            throws InvalidNodeException, BoundaryViolationException {
        INode brotherVerified = checkPosition(brother);
        INode parentNode = brotherVerified.getParent();
        if (parentNode != null) {
            INode siblingNode;
            INode leftNode = parentNode.getLeft();
            if (leftNode == brotherVerified) {
                siblingNode = parentNode.getRight();
            } else {
                siblingNode = parentNode.getLeft();
            }
            if (siblingNode != null) {
                return siblingNode;
            }
        }
        throw new BoundaryViolationException("No sibling");
    }

    protected  void addLeafs(INode node) throws InvalidNodeException {
        INode verifiedNode = checkPosition(node);
        verifiedNode.setLeft(new Node("leaf", verifiedNode));
        verifiedNode.setRight(new Node("leaf", verifiedNode));
    }

    @Override
    public int size() {
        return this.numberNodes;
    }

    /** Returns whether the tree is empty. */
    public boolean isEmpty() {
        return size() == 0;
    }

    /** Returns an iterable collection of all the entries containing the
     * given key. */

    public Iterable findAll(Object key) throws InvalidKeyException {
        checkKey(key);		// may throw an InvalidKeyException
        ArrayList listOfAllEntriesWithEqualKey = new ArrayList();
        try {
            addAllEqualKeys(listOfAllEntriesWithEqualKey, root(), key);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return listOfAllEntriesWithEqualKey;
    }
    protected void addAllEqualKeys(ArrayList list, INode rootSubtree, Object key) {
        try {
            if (this.isExternal(rootSubtree)) {
                return;
            }
            INode node = this.search(key, rootSubtree);
            if (!this.isExternal(node)){
                addAllEqualKeys(list, node.getLeft(), key);
                list.add(node.element());
                addAllEqualKeys(list, node.getRight(), key);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
