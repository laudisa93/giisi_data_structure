

/**
 *
 * @author federico
 */
public interface IPila {

    boolean isEmpty();

    Object pop() throws EmptyStackError;

    void push(Object o);

    int size();

    Object top() throws EmptyStackError;

}
