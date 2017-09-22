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

    Node getLeft();

    Node getRight();

    void setElement(Object element);

    void setLeft(Node left);

    void setRight(Node right);

}
