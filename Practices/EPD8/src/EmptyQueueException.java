
public class EmptyQueueException extends Exception {
    String msg = "";

    public EmptyQueueException() {
    }

    public EmptyQueueException(String str) {
        msg= str;
    }
    @Override
    public String getMessage(){
        return msg;
    }
}
