
import java.util.*;
import edi.io.IO;

public class JornadaLiga {
    private int numJornada=0;
    Collection<resultados> c =new ArrayList<resultados>();

    public void setC(Collection<resultados> c) {
        this.c = c;
    }

    public void setNumJornada(int numJornada) throws Exception {
        if(numJornada<0){
            this.numJornada = numJornada;
        }else{
            try {
                //throw Exception e=new Exception;
            } catch (Exception e) {
                System.out.println("El numero de jornadas no puede ser negativo.");
            }
        }
    }

    public Collection<resultados> getC() {
        return c;
    }

    public int getNumJornada() {
        return numJornada;
    }
    public resultados pedirResultado(){
        System.out.println("Equipo local: ");
        String eqLoc = IO.readLine();
        System.out.println("Equipo visitante: ");
        String eqVis = IO.readLine();
        System.out.println("Goles equipo local: ");
        int golLoc= (int)IO.readNumber();
        System.out.println("Goles equipo visitante: ");
        int golVis= (int)IO.readNumber();
        resultados r = new resultados(eqLoc, eqVis, golLoc, golVis);
        return r;
    }
    public void añadirResultado(){
        c.add(pedirResultado());
    }
    public void eliminarResultado(){

        System.out.println("Resultado a eliminar:");
        resultados pedido=pedirResultado();

        Iterator it = c.iterator();
        while(it.hasNext()){
            resultados aux= (resultados) it.next();
            if (aux.equals(pedido)){
                it.remove();
            }
        }
    }
    public void imprimir(){
        c.toString();

    }
}
