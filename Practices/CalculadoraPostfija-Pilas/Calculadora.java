
import java.util.*;

public class Calculadora {

    private StringTokenizer expr;
    private LinkedStack pilaOperadores;
    private LinkedStack pilaValores;
    private Long valorActual;
    private static final int TOK_EOL = -1;
    private static final int TOK_VALOR = 0;
    private static final int TOK_MAS = 1;
    private static final int TOK_POR = 2;

    public Calculadora(String expr) {

        this.expr = new StringTokenizer(expr, "+*", true);
        pilaOperadores = new LinkedStack();
        pilaValores = new LinkedStack();
        pilaOperadores.push(new Integer(TOK_EOL));
    }

    /**
     * Devuelve el resultado de evaluar la expresión.
     * Sucesivamente, lee un token y lo procesa, hasta que ya no queden
     * tokens. En ese momento, devuelve el valor de la pila de valores.
     */
    public long getValor() {
        int token;

        do {
            token = obtenerToken();
            procesarToken(token);
        } while (token != TOK_EOL);

        try {
            Long resultado = (Long) pilaValores.pop();
            //  if (resultado == null || pilaVal.pop() != null) {
            //si el resultado es null o la pila de valores no está vací algo ha ido mal!!!
            if (resultado == null || pilaValores.size() != 0) {

                System.out.println("Expresión errónea");
                return 0;
            } else {
                return resultado.longValue();
            }
        } catch (Exception e) {
            System.out.println("Expresión errónea");
            return 0;
        }
    }

    /**
     * Lee el siguiente token de la expresión. Si es un valor (número),
     * devuelve TOK_VALOR y actualiza el atributo valorActual.
     */
    private int obtenerToken() {
        String s;

        try {
            s = expr.nextToken();
        } catch (NoSuchElementException e) {
            System.out.println("FIN EXPRESION: simbolo TOK_EOL");
            return TOK_EOL;
        }
        System.out.println("Procesando simbolo " + s);
        //en este ejemplo solo consideramos + y *
        if (s.equals("+")) {
            return TOK_MAS;
        } else if (s.equals("*")) {
            return TOK_POR;
        }

        // es un valor
        try {
            valorActual = new Long(s);
        } catch (NumberFormatException ex) {
            System.out.println("Valor con formato incorrecto");
            return TOK_EOL;
        }

        return TOK_VALOR;
    }

    /**
     * Desapila dos valores de la pila de valores y apila el
     * resultado de aplicarles el operador recibido com parámetro.
     */
    private void operadorBinario(int token) {

        long op1, op2;

        try {


            Long lop2 = (Long) pilaValores.pop();
            Long lop1 = (Long) pilaValores.pop();

            if (lop1 == null || lop2 == null) {
                System.out.println("Pila de valores incorrecta");
                return;
            }

            op1 = lop1.longValue();
            op2 = lop2.longValue();

            switch (token) {

                case TOK_MAS:
                    System.out.println("Calculando " + op1 + " + " +op2);
                    pilaValores.push(new Long(op1 + op2));
                    System.out.println("Apilando valor " + (op1+op2));
                    break;

                case TOK_POR:
                    System.out.println("Calculando " + op1 + " * " +op2);
                    pilaValores.push(new Long(op1 * op2));
                    System.out.println("Apilando valor " + op1*op2);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Procesa un token:
     *   - si es TOK_VALOR, apila valorActual
     *   - si es TOK_EOL, vacía la pila de operadores
     *   - si es TOK_MAS, vacía la pila menos el TOK_EOL final
     *   - si es TOK_POR, vacía la pila hasta llegar a un TOK_MAS o TOK_EOL
     * Para cada token de operador desapilado, realiza el cálculo
     * invocando a operadorBinario.
     */
    private void procesarToken(int token) {
        int top;
        try {
            switch (token) {

                case TOK_VALOR:
                    System.out.println("Apilando " + valorActual + " en pila valores ");
                    pilaValores.push(valorActual);
                    break;

                case TOK_EOL:
                    // se desapila todo
                    System.out.println("Desapilando todo y calculando resultado");
                    while ((top = ((Integer) pilaOperadores.pop()).intValue()) != TOK_EOL) {
                        operadorBinario(top);
                    }
                    break;

                case TOK_MAS:
                    // precedencia menor: se desapila todo y calculan todos
                    //los operandos de la pila de operandos, hasta encontrar TOK_EOL.
                    //recordar que el último valor leido todavia no está en la pila
                    while ((top = ((Integer) pilaOperadores.pop()).intValue()) != TOK_EOL) {

                        operadorBinario(top);
                    }

                    // devuelve el EOL desapilado
                    System.out.println("Apilando simbolo " + top + " (EOF) en pila operadores ");
                    pilaOperadores.push(new Integer(top));
                    System.out.println("Apilando simbolo " + token + " (+) en pila operadores");
                    // apila el operador
                    pilaOperadores.push(new Integer(token));
                    break;

                case TOK_POR:
                    // precedencia mayor: se desapila todo hasta un + o un eol
                    // se calculan todos los operandos de la pila de operandos,
                    //hasta encontrar TOK_MAS o TOK_EOL.
                    while ((top = ((Integer) pilaOperadores.pop()).intValue()) != TOK_EOL
                            && top != TOK_MAS) {
                        operadorBinario(top);
                    }

                    // devuelve el último operador desapilado
                    if (top == TOK_MAS) {
                        System.out.println("Apilando simbolo " + top + " (+) en pila operadores ");
                    } else {
                        System.out.println("Apilando simbolo " + top + " (EOF) en pila operadores ");
                    }

                    pilaOperadores.push(new Integer(top));
                    // apila el operador
                    System.out.println("Apilando simbolo " + token + " (*) en pila operadores ");
                    pilaOperadores.push(new Integer(token));
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        long result = 0;

        Calculadora c = new Calculadora("3+2*4");

        try {
            result = c.getValor();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
