
public class Principal {

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//Creo el vector

        INumero num = new Numero(vector);//Realizamos la llamada al constructor
        System.out.println(num);

        num.intercambio(3, 6);//Realizo un intercambio
        System.out.println("\n\nIntercambio de la posicion 4 con la posicion 7:");
        System.out.println("\t"+num);

        num.desordenar();//Desordeno el vector
        System.out.println("\n\nDesordenamos el vector:");
        System.out.println("\t"+num);
    }
}
