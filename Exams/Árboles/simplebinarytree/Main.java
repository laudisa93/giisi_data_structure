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
            if (tree.isInternal(node)) {
                Iterator children = tree.children(node);
                s += " ( " + generalPreOrderParentheticPrint(tree, (Node) (children.next()));
                while (children.hasNext()) {
                    Object object = children.next();
                    System.out.println("Node " + ((Node) (object)).element());
                    s += ", " + generalPreOrderParentheticPrint(tree, (Node) object);                    
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

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {


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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
