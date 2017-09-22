/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplebinarytree;

/**
 * An interface for a dictionary storing (key-value) pairs.
 * @author federico
 */
//begin#fragment Dictionary
public interface Dictionary {
//end#fragment Dictionary
  /** Returns the number of entries in the dictionary. */
//begin#fragment Dictionary
  public int size();
//end#fragment Dictionary
  /** Returns whether the dictionary is empty. */
//begin#fragment Dictionary
  public boolean isEmpty();
//end#fragment Dictionary
  /** Returns an entry containing the given key, or <tt>null</tt> if
   * no such entry exists. */
//begin#fragment Dictionary
  public Entry find(Object key)
    throws InvalidKeyException;
//end#fragment Dictionary
  /** Returns an iterator containing all the entries containing the
   * given key, or an empty iterator if no such entries exist. */
//begin#fragment Dictionary
  public Iterable findAll(Object key)
    throws InvalidKeyException;
//end#fragment Dictionary
  /** Inserts an item into the dictionary.  Returns the newly created
   * entry. */
//begin#fragment Dictionary
  public Entry insert(Object key, Object value)
    throws InvalidKeyException;
//end#fragment Dictionary
  /** Removes and returns the given entry from the dictionary. */
//begin#fragment Dictionary
  public Entry remove(Entry e)
    throws InvalidEntryException;
//end#fragment Dictionary
  /** Returns an iterator containing all the entries in the dictionary. */
//begin#fragment Dictionary
  public Iterable entries();
}
//end#fragment Dictionary