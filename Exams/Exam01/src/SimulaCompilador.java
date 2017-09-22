
import java.io.*;

class SimulaCompilador {

    private final static char[] simbolosAbrir = {'{', '(', '['};
    private final static char[] simbolosCerrar = {'}', ')', ']'};
    String archivoComprobar;
    IPila pila;

    public SimulaCompilador(String archivo) {
        pila = new Pila();
        this.archivoComprobar = archivo;
    } //constructor

    public String check() throws Exception {
        BufferedReader lector = null;// buffer de lectura
        int n;//Caracter leído (int)
        char c;//Caracter leído (char)

        try {// abrir el fichero (nombre dado)
            lector = new BufferedReader(new FileReader(archivoComprobar));//Recibe toda la informacion del fichero
            System.out.println("chequeando fichero " + archivoComprobar + " ....");
            while ((n = lector.read()) >= 0) {//En la variable n, va guardando los caracteres del fichero
                boolean procesado = false;//Bandera para...
                c = (char) n;//Guardo el caracter n en la variable c
                int i = 0;
                while (i < 3 && !procesado) {//Utilizo 3, xq es el numero de caracteres a comparar
                    if (c == simbolosAbrir[i]) {
                        pila.push(c);
                    } else if (c == simbolosCerrar[i]) {
                        if (pila.isEmpty()) {//Simbolo de terminacion y vacia
                            System.out.println("Caracter no correcto, ya que la pila está vacía.");
                        } else {//Simbolo de terminacion y contiene datos = desapilar
                            pila.pop();
                        }
                    }
                    i++;
                }
            } // while (leer fichero)


        } catch (IOException e) {
            return "Error de lectura: fichero " + archivoComprobar;
        } catch (PilaVaciaException pv) {
            pv.getMessage();
        }
        /******************************
        /*DEVOLVER MENSAJE DE LA COMPROBACIÓN
         *******************************/
        String aux = "";
        if (pila.isEmpty()) {
            aux = "Error: La pila NO está vacía.";
        }
        return aux;
    } // método check()

    public static void main(String args[]) throws Exception {
        /*******************************/
        //PASAR EL NOMBRE DEL FICHERO A COMPROBAR
        /*******************************/
        SimulaCompilador check = new SimulaCompilador("testFile1.java");
        System.out.println(check.check());

        check = new SimulaCompilador("testFile2.java");
        System.out.println(check.check());
    } // main()
}
