
public class PilaVaciaException extends Exception {

    String msg = "";

    public PilaVaciaException() {
    }

    public PilaVaciaException(String str) {
        msg = str;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
