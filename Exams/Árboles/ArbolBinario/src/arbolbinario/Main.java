/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolbinario;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuarioupo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IBinaryNode root = new BinaryNode(8);
        IBinaryNode node3 = new BinaryNode(3,root);
        IBinaryNode node10 = new BinaryNode(10,root);
        IBinaryNode node1 = new BinaryNode(1,node3);
        IBinaryNode node6 = new BinaryNode(6,node3);
        IBinaryNode node4 = new BinaryNode(4,node6);
        IBinaryNode node7 = new BinaryNode(7,node6);
        IBinaryNode node14 = new BinaryNode(14,node10);
        IBinaryNode node13 = new BinaryNode(13,node14);
        
        root.setLeft(node3);
        root.setRight(node10);
        node3.setLeft(node1);
        node3.setRight(node6);
        node6.setLeft(node4);
        node6.setRight(node7);
        node10.setRight(node14);
        node14.setLeft(node13);
        
        
        IBinaryTree arbol= new BinaryTree(root);
        Iterator itInOrden=arbol.elementsInOrder();
        Iterator itPreOrden=arbol.elementsPreOrder();
        Iterator itPostOrden=arbol.elementsPostOrder();
        while(itPreOrden.hasNext()) System.out.println(" "+itPreOrden.next()+" ");
        try {
            arbol.addLeaf(15);
            //arbol.addLeaf(7); //este está duplicado
            arbol.addLeaf(12);
            arbol.addLeaf(5);
            arbol.addLeaf(2);
            arbol.addLeaf(9);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        itPreOrden=arbol.elementsPreOrder();
        while(itPreOrden.hasNext()) System.out.println(" "+itPreOrden.next()+" ");
        

    }

}
