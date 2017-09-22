/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplebinarytree;

/**
 *
 * @author federico
 */
public interface INode extends IGeneralNode{

    INode getLeft();

    INode getRight();

    INode getParent();

    void setElement(Object element);

    void setLeft(INode left);

    void setRight(INode right);

    public void setParent(INode parent);

}
