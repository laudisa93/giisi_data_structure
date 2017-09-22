/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplebinarytree;

/**
 *
 * @author federico
 */
public class InvalidEntryException  extends RuntimeException {
  public InvalidEntryException (String message) {
    super (message);
  }
}