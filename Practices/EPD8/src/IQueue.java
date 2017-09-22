
public interface IQueue {
     public int size();
     public boolean isEmpty();
     public Object front() throws EmptyQueueException;
     public void enqueue(Object element);
     public Object dequeue() throws EmptyQueueException;
}
