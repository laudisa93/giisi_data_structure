public interface Queue {

    int buscar(Object o);

    Object dequeue() throws EmptyQueueException;

    void enqueue(Object o);

    Object front() throws EmptyQueueException;

    boolean isEmpty();

    int size();
}
