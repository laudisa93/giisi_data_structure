package examen.viernes;


import ed.epd11.*;
import examen.viernes.BinaryTreeSergio;
import java.util.*;

/*Crear un programa principal que muestre el funcionamiento de los dos puntos anteriores.*/
public class Prueba {

    public static void main(String[] args) throws Exception {
        /*Creamos el arbol.*/
        IBinaryTree arb = new BinaryTreeSergio();
        IBinaryNode root = new BinaryNode(15, null);
        Iterator itPostOrden;
        arb.addRoot(root);

        IBinaryNode<Integer> nodo6 = new BinaryNode(6, root);
        IBinaryNode<Integer> nodo20 = new BinaryNode(20, root);
        IBinaryNode<Integer> nodo3 = new BinaryNode(3, nodo6);
        IBinaryNode<Integer> nodo9 = new BinaryNode(9, nodo6);
        IBinaryNode<Integer> nodo7 = new BinaryNode(7, nodo9);
        IBinaryNode<Integer> nodo12 = new BinaryNode(12, nodo9);
        IBinaryNode<Integer> nodo18 = new BinaryNode(18, nodo20);
        IBinaryNode<Integer> nodo17 = new BinaryNode(17, nodo18);

        root.setLeft(nodo6);
        root.setRight(nodo20);

        nodo6.setLeft(nodo3);
        nodo6.setRight(nodo9);

        nodo9.setLeft(nodo7);
        nodo9.setRight(nodo12);

        nodo20.setLeft(nodo18);

        nodo18.setLeft(nodo17);

        try {
            /*Visualizamos el arbol en preOrden*/
            System.out.println("Visualizamos el arbol: ");
            itPostOrden = ((BinaryTreeSergio) arb).elementsPostOrden();
            while (itPostOrden.hasNext()) {
                System.out.println(itPostOrden.next());
            }

            ((BinaryTreeSergio) arb).removeLeaf(3);

            System.out.println("Visualizamos el arbol: ");
            itPostOrden = ((BinaryTreeSergio) arb).elementsPostOrden();
            while (itPostOrden.hasNext()) {
                System.out.println(itPostOrden.next());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        /*Añadimos nuevos nodos.*/
//        System.out.println("Añadimos nuevos nodos: ");
//        try {
//            ((arbol) arb).addLeaf(12);
//            ((arbol) arb).addLeaf(9);
//            ((arbol) arb).addLeaf(7);//Debe dar un error, por estar repetido
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        /*Visualizamos el arbol en preOrden*/
//        System.out.println("Visualizamos el arbol despues de insertar: ");
//        try {
//            itPreorden = ((arbol) arb).elementsPreorder();
//            while (itPreorden.hasNext()) {
//                System.out.println(itPreorden.next());
//            }
//        } catch (InvalidNodeException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
