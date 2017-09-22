
public class Queue implements IQueue{
    private NodoCola top;
    private NodoCola tail;
    private int size;


    public Queue(/*NodoCola top, NodoCola tail*/) {
        this.top = null;
        this.tail = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        boolean vacio=false;
        if(this.top==null && this.tail==null){
            vacio=true;
        }
        return vacio;
    }

    public Object front() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException("La cola está vacía");
        }else{
            return this.top.getElemento();
        }

    }

    public void enqueue(Object o){
        NodoCola i = new NodoCola(o);
        if(isEmpty()){
            top=i;
            tail=i;
        }
        tail.setNext(i);
        tail.setElemento(o);
        tail=tail.getNext();
        this.size++;
    }

    public Object dequeue() throws EmptyQueueException{
        NodoCola aux = top;
        if(isEmpty()){
            throw new EmptyQueueException("La cola está vacía");
        }else{
            aux.setElemento(top);
            top=top.getNext();
            this.size--;
            return aux.getElemento();
        }
        
    }

    @Override
    public String toString() {
        String s="";
        NodoCola sig = top.getNext();
        while(sig!=null){
            s+=top+", ";
            sig=sig.getNext();
        }

        return s;
    }

    
}
