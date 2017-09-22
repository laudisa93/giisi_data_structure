
import java.util.*;

public class Numero implements INumero {

    private List lista;

    public Numero(int[] vector) {
        lista = new ArrayList();

        for (int i = 0; i < vector.length; i++) {
            lista.add(vector[i]);
        }
    }
    
    public void intercambio(int num1, int num2) {
        Object aux = (Integer) this.lista.get(num1);
        lista.set(num1, lista.get(num2));
        lista.set(num2, aux);
    }

    public void desordenar() {
        Iterator it = this.lista.iterator();

        while (it.hasNext()) {
            int x = new Random().nextInt(lista.size()-1);
            intercambio(lista.indexOf(it.next()), x);
        }
    }

    @Override
    public String toString() {
        return "La lista de numeros es: " + lista;
    }
}
