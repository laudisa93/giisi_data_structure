package simplebinarytree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author federico
 */
public class Main {

   

    public static String generalPreOrderParentheticPrint(BinaryTree tree, INode node) {
        String s = "";
        try {
            s = node.element().toString();
            // s += node.getClass();
            if (tree.isInternal(node)) {
                Iterator children = tree.children(node);
                s += " ( " + generalPreOrderParentheticPrint(tree, (Node) (children.next()));
                while (children.hasNext()) {
                    Node nodeToVisit = (Node) children.next();
                    //  System.out.println("Node " + ((Node) (object)).element());
                    s += ", " + generalPreOrderParentheticPrint(tree, nodeToVisit);
                }
                s += " )";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public static String generalPreorderPrint(BinaryTree t, INode v) {
        String s = "";
        try {
            s = v.element().toString();
            Iterator children = t.children(v);

            while (children.hasNext()) {
                Object object = children.next();
                s += " " + generalPreorderPrint(t, (Node) object);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return s;
    }

    public static String generalPostorderPrint(BinaryTree t, INode v) {
        String s = "";
        try {

            Iterator children = t.children(v);
            while (children.hasNext()) {
                Object object = children.next();
                s += generalPostorderPrint(t, (Node) object) + " ";

            }
            s += v.element().toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return s;
    }

    public static String inOrderPrint(BinaryTree tree, INode v) {
        String s = "";
        try {
            if (tree.hasLeft(v)) {
                s += inOrderPrint(tree, tree.left(v));
            }
            s += v.element() + " ";
            if (tree.hasRight(v)) {
                s += inOrderPrint(tree, tree.right(v));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public static int EulerCount(BinaryTree tree, INode node) {
        traversalResult result = new traversalResult();
        try {
            //visit node from the left
            result.setRight(result.getRight() + 1);
            result.setLeft(result.getRight());
            if (tree.hasLeft(node)) {
                result.setRight(result.getRight() + EulerCount(tree, tree.left(node)));
            }
            //visit node from below
            if (tree.hasRight(node)) {
                result.setRight(result.getRight() + EulerCount(tree, tree.right(node)));
            }
            //visit node from the right
            //return result.getRight() - result.getLeft() +1;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //visit node from the right
        return result.getRight() - result.getLeft() + 1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            /*
            BinaryTree tree = new BinaryTree();
            if (tree.isEmpty()) {
            System.out.println("tree is empty");
            }
            tree.addRoot("root");
            if (tree.isEmpty()) {
            System.out.println("tree is empty");
            } else {
            System.out.println("tree is NOT empty");
            }

            //tree.right(tree.root());

            tree.insertNodeLeft(tree.root(), "left");
            tree.insertNodeRight(tree.root(), "right");
            System.out.println(tree.inOrderPrintElements());
            tree.replace(tree.root(), "new root");
            System.out.println(tree.inOrderPrintElements());

            System.out.println("Childen of node " + tree.root.element());
            for (Iterator it = tree.children(tree.root()); it.hasNext();) {
            Object object = it.next();
            Node child = (Node) object;
            System.out.print(child.element() + " ");

            }


            System.out.println("\nPreorder tree: \n " + generalPreorderPrint(tree, tree.root()));
            System.out.println("\nPostorder tree: \n " + generalPostorderPrint(tree, tree.root()));
            System.out.println("\nInorder tree: \n " + inOrderPrint(tree, tree.root()));

            //add a node to each child of the root
            int i = 0;
            for (Iterator it = tree.children(tree.root()); it.hasNext(); i++) {
            Object object = it.next();
            Node child = (Node) object;
            tree.insertNodeLeft(child, "node" + i);
            i++;
            tree.insertNodeRight(child, "node" + (i));

            }
            System.out.println("\n\nRoot has " + EulerCount(tree, tree.root()) + " descendants " +tree);


            //System.out.println("Preorder tree: \n " + generalPreOrderParentheticPrint(tree, tree.root()));
            tree.remove(tree.root().getLeft().getLeft());
            System.out.println("Preorder tree: \n " + generalPreOrderParentheticPrint(tree, tree.root()));

            System.out.println("Childen of node " + tree.root().getLeft().element());
            for (Iterator it = tree.children(tree.root().getLeft()); it.hasNext();) {
            Object object = it.next();
            Node child = (Node) object;
            System.out.print(child.element() + " ");

            }
            System.out.println("Childen of node " + tree.root().getRight().element());
            for (Iterator it = tree.children(tree.root().getRight()); it.hasNext();) {
            Object object = it.next();
            Node child = (Node) object;
            System.out.print(child.element() + " ");

            }

            System.out.println("\nIn Order: " + tree.inOrderPrintElements());
            System.out.println("\ntree has " + tree.size() + " nodes");


            ArrayList nodesOfTree = tree.inOrderTraversal();
            for (Iterator it = nodesOfTree.iterator(); it.hasNext();) {
            Object object = it.next();
            Node node = (Node) object;
            if (tree.hasParent(node)) {
            System.out.println("The parent of " + node.element() + " is " + tree.parent(node).element());
            } else {
            if (tree.isRoot(node)) {
            System.out.println("Node " + node.element() + " has no parent since it's the root");
            }
            }
            }

            IBinaryTree tree1 = new BinaryTree("subtree1");
            IBinaryTree tree2 = new BinaryTree("subtree2");
            tree1.insertNodeLeft(tree1.root(), "lc1");
            tree2.insertNodeLeft(tree2.root(), "lc2");
            tree1.insertNodeRight(tree1.root(), "rc1");
            tree2.insertNodeRight(tree2.root(), "rc2");
            tree.attach(tree.root().getLeft().getRight(), tree1, tree2);
            System.out.println("After attaching two subtrees " + generalPreOrderParentheticPrint(tree, tree.root()));
             */


            SimpleBinarySearchTree bst = new SimpleBinarySearchTree(new ComparatorIntKey());
            bst.addBSTRoot(new Entry(12, "root"));
            Entry insert = bst.insert(23, "el");
            insert = bst.insert(23, "el2");
            insert = bst.insert(9, "el");
            insert = bst.insert(8, "el");
            insert = bst.insert(11, "el");
            System.out.println("BST: " + generalPreOrderParentheticPrint(bst, bst.root()));
            System.out.println("BST has " + bst.size() + " nodes");
            insert = bst.remove(new Entry(9, "el"));
            System.out.println("after removal BST: " + generalPreOrderParentheticPrint(bst, bst.root()));
            System.out.println("BST has " + bst.size() + " nodes");
            // insert = bst.remove(new Entry(9, "el"));
            Iterable listNodes = bst.findAll(23);
            for (Iterator it = listNodes.iterator(); it.hasNext();) {
                Entry singleEntry = (Entry) it.next();
                System.out.println(singleEntry);
            }




            /*AVL PART*/
            
            AVLTree avlTree = new AVLTree(new ComparatorIntKey());


            avlTree.addAVLRoot(new Entry(44, "root"));
            System.out.println("AVL tree: " + generalPreOrderParentheticPrint(avlTree, avlTree.root()));



            avlTree.insertAVL(17, "el");
            //rotation
            avlTree.insertAVL(32, "el");
            System.out.println("AVL tree 32: " + generalPreOrderParentheticPrint(avlTree, avlTree.root()));
            avlTree.insertAVL(78, "el");
            //rotation
            avlTree.insertAVL(50, "el");
            //rotation
            avlTree.insertAVL(88, "el");
            System.out.println("AVL tree 88: " + generalPreOrderParentheticPrint(avlTree, avlTree.root()));

            avlTree.insertAVL(48, "el");
            avlTree.insertAVL(62, "el");
            System.out.println("AVL tree: " + generalPreOrderParentheticPrint(avlTree, avlTree.root()));
            //rotation
            avlTree.remove(avlTree.find(17));
            System.out.println("AVL tree: " + generalPreOrderParentheticPrint(avlTree, avlTree.root()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
