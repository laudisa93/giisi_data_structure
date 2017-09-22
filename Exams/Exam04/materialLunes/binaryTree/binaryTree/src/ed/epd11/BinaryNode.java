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
 * BinaryNode.java
 * Copyright (C) 2008-2012 Miguel Garcia Torres
 */



/**
 *
 * @author Miguel Garcia Torres (mgarciat[at]upo[dot]es)
 */
public class BinaryNode<T extends Comparable<T>> implements IBinaryNode<T> {
    private T element = null;
    private IBinaryNode<T> right = null;
    private IBinaryNode<T> left = null;
    private IBinaryNode<T> parent = null;

    public BinaryNode(T element, IBinaryNode<T> parent) {
        this.setElement(element);
        this.setRight(null);
        this.setLeft(null);
        this.setParent(parent);
    }

    public T getElement() {
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public IBinaryNode<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(IBinaryNode<T> left) {
        this.left = left;
    }

    @Override
    public IBinaryNode<T> getParent() {
        return parent;
    }

    @Override
    public void setParent(IBinaryNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public IBinaryNode<T> getRight() {
        return right;
    }

    @Override
    public void setRight(IBinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public T element() {
        return this.element;
    }

   

   
}
