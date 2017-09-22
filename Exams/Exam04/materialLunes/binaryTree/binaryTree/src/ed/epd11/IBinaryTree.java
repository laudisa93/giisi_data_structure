package ed.epd11;

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
 * IBinaryTree.java
 * Copyright (C) 2008-2012 Miguel Garcia Torres
 */



import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Garcia Torres (mgarciat[at]upo[dot]es)
 */
public interface IBinaryTree<T extends Comparable<T>> {
    public void addRoot(IBinaryNode<T> newRoot) throws Exception;

    /**
     * Attaches two trees to be subtrees of an external node.
     */
    public void attach(IBinaryNode<T> nodeAttaching, IBinaryTree<T> T1, IBinaryTree<T> T2) throws InvalidNodeException;
    public<V extends IBinaryNode<T>> Iterator<V> children(IBinaryNode<T> nodeToParent) throws InvalidNodeException;
    public boolean isEmpty();
    public T getRootElement();
    public<V extends IBinaryNode<T>> V root();
    public boolean hasLeft(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public boolean hasRight(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public Iterator<T> elements() throws InvalidNodeException;
    public ArrayList inOrderTraversal() throws InvalidNodeException;
    public boolean hasParent(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public int size();
    public void insertNodeLeft(IBinaryNode<T> father, T newElement) throws InvalidNodeException;
    public void insertNodeRight(IBinaryNode<T> father, T newElement) throws InvalidNodeException;
    public boolean isRoot(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public boolean isExternal(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public boolean isInternal(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    public T replace(IBinaryNode<T> nodeToChange, T newElement) throws InvalidNodeException;
    public<V extends IBinaryNode<T>> V left(IBinaryNode<T> nodeToCheck) throws InvalidNodeException, BoundaryViolationException;
    public<V extends IBinaryNode<T>> V right(IBinaryNode<T> nodeToCheck) throws InvalidNodeException, BoundaryViolationException;
    public T remove(IBinaryNode<T> node) throws InvalidNodeException;
    public void setNode(IBinaryNode<T> nodeToSet, T newElement) throws InvalidNodeException;
    public<V extends IBinaryNode<T>> V parent(IBinaryNode<T> nodeToCheck) throws InvalidNodeException;
    
}
