/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/**
 * PMartes.java
 * Copyright (C) 2008-2012 Miguel Garcia Torres
 */

package ed.epd11.ejercicio;

import ed.epd11.BinaryNode;
import ed.epd11.BinaryTree;
import ed.epd11.IBinaryNode;
import ed.epd11.InvalidNodeException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Garcia Torres (mgarciat[at]upo[dot]es)
 */
public class PMartes {
    public static BinaryNode<Integer> buildTree() {
        //root
        BinaryNode<Integer> root = new BinaryNode<Integer>(8, null);
        //L1
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3, root);
        BinaryNode<Integer> n10 = new BinaryNode<Integer>(10, root);

        root.setLeft(n3);
        root.setRight(n10);
        
        //L2
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1, n3);
        BinaryNode<Integer> n6 = new BinaryNode<Integer>(6, n3);

        n3.setLeft(n1);
        n3.setRight(n6);

        BinaryNode<Integer> n14 = new BinaryNode<Integer>(14, n10);

        n10.setRight(n14);
        
        //L3
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4, n6);
        BinaryNode<Integer> n7 = new BinaryNode<Integer>(7, n6);

        n6.setLeft(n4);
        n6.setRight(n7);

        BinaryNode<Integer> n13 = new BinaryNode<Integer>(13, n14);

        n14.setLeft(n13);
        
        return root;
    }
    
    public static void testP1() throws InvalidNodeException {
        BinaryNode<Integer> root = PMartes.buildTree();

        BinaryTree<Integer> btree = new BinaryTree<Integer>(root);

        Iterator<Integer> it = btree.elements();
        System.out.println("\n=====");
        while (it.hasNext()) {
            Integer v = it.next();
            System.out.println(v + " ");
        }
    }

    public static void preorder(IBinaryNode<Integer> node, ArrayList<Integer> list) {
        if (node != null) {
            list.add(node.element());
            PMartes.preorder(node.getLeft(), list);
            PMartes.preorder(node.getRight(), list);
        }
    }

    

    public static void testP2() throws InvalidNodeException {
        BinaryNode<Integer> root = PMartes.buildTree();

        ArrayList<Integer> list = new ArrayList<Integer>();
        PMartes.preorder(root, list);

        
        Iterator<Integer> it = list.iterator();
        System.out.println("\n=====");
        while (it.hasNext()) {
            Integer v = it.next();
            System.out.println(v + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        testP2();
    }
}
