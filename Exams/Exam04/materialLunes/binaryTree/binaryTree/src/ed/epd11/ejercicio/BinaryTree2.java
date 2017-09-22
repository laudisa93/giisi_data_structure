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
 * BinaryTree2.java
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
public class BinaryTree2<T extends Comparable<T>>   extends BinaryTree<T> {

    public BinaryTree2(BinaryNode<T> root) {
        super(root);
    }

    public void addLeaf(T element) throws InvalidNodeException, Exception {
        this.addLeaf(new BinaryNode<T>(element, null), super.root);
    }

    public void addLeaf(IBinaryNode<T> node) throws InvalidNodeException, Exception {
        this.addLeaf(node, super.root);
    }

    protected void addLeaf(IBinaryNode<T> nnode, IBinaryNode<T> cnode) throws InvalidNodeException, Exception {
        if (nnode.element().compareTo(cnode.element()) == 0) {
            throw new Exception("No repeated values allowed!");
        } else if (nnode.element().compareTo(cnode.element()) < 0) {
            if (cnode.getLeft() == null) {
                cnode.setLeft(nnode);
                nnode.setParent(cnode);
            } else {
                this.addLeaf(nnode, cnode.getLeft());
            }
        } else {
            if (cnode.getRight() == null) {
                cnode.setRight(nnode);
                nnode.setParent(cnode);
            } else {
                this.addLeaf(nnode, cnode.getRight());
            }
        }
    }

    public void removeLeaf(T element) throws InvalidNodeException, Exception {
        this.removeLeaf(new BinaryNode<T>(element, null), super.root);
    }

    public void removeLeaf(IBinaryNode<T> node) throws InvalidNodeException, Exception {
        if (node.element().compareTo(super.root.element()) == 0) {
            super.root = null;
        } else {
            this.removeLeaf(node, super.root);
        }
    }

    protected void removeLeaf(IBinaryNode<T> nnode, IBinaryNode<T> cnode) throws InvalidNodeException, Exception {
        if (nnode.element().compareTo(cnode.element()) < 0) {
            if (cnode.getLeft() != null) {
                if (cnode.getLeft().element().compareTo(nnode.element()) == 0) {
                    cnode.setLeft(null);
                } else {
                    this.removeLeaf(nnode, cnode.getLeft());
                }
            }
        } else {
            if (cnode.getRight() != null) {
                if (cnode.getRight().element().compareTo(nnode.element()) == 0) {
                    cnode.setRight(null);
                } else {
                    this.removeLeaf(nnode, cnode.getRight());
                }
            }
        }
    }

    public Iterator<T> inorderTraversalElements() {
        ArrayList<T> list = new ArrayList<T>();
        this.inorder(super.root, list);

        return list.iterator();
    }

    protected void inorder(IBinaryNode<T> node, ArrayList<T> list) {
        if (node != null) {
            this.inorder(node.getLeft(), list);
            list.add(node.element());
            this.inorder(node.getRight(), list);
        }
    }


    public static void testBinaryTree2AddLeaf() throws Exception {
        BinaryNode<Integer> root = PMartes.buildTree();
        BinaryTree2<Integer> btree = new BinaryTree2<Integer>(root);
        btree.addLeaf(5);
        btree.addLeaf(9);
        btree.addLeaf(11);
        Iterator<Integer> iterator = btree.inorderTraversalElements();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    public static void testBinaryTree2RemoveLeaf() throws Exception {
        BinaryNode<Integer> root = PMartes.buildTree();
        BinaryTree2<Integer> btree = new BinaryTree2<Integer>(root);
        btree.addLeaf(5);
        btree.removeLeaf(5);
        btree.removeLeaf(1);
        btree.removeLeaf(4);
        Iterator<Integer> iterator = btree.inorderTraversalElements();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    public static void main(String[] args) throws Exception {
        testBinaryTree2RemoveLeaf();
    }
}
