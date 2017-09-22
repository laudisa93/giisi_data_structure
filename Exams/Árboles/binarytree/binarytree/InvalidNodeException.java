package simplebinarytree;

public class InvalidNodeException extends Exception {
    String msg = "";

    public InvalidNodeException() {
    }

    public InvalidNodeException(String str) {
        msg= str;
    }
    @Override
    public String getMessage(){
        return msg;
    }
}

