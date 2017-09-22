/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author federico
 */
public class EmptyStackError extends Exception {

    String msg = "";

    public EmptyStackError() {
    }

    public EmptyStackError(String str) {
        msg= str;
    }
    @Override
    public String getMessage(){
        return msg;
    }
}
