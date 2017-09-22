
import java.util.*;

public class GrupoAlumnos implements IGrupoAlumnos {

    private Collection c;

    public GrupoAlumnos() {
        c = new ArrayList();
    }

    public Collection getCollection() {
        return c;
    }

    public void imprimir() {
        Iterator iter=c.iterator();
        Alumno a;
        while(iter.hasNext()){
            a = (Alumno)iter.next();
            System.out.println("Nombre: "+a.getNombre());
            System.out.println("Apellidos: " + a.getApellidos());
            System.out.println("DNI:" + a.getDni());
        }
    }

    public int add(IAlumno o) {
        int devolver=1;

        Iterator iter=c.iterator();
        Alumno a;
        
        while(iter.hasNext()){
            a = (Alumno)iter.next();
            int cmp = a.getDni().compareTo(o.getDni());
            if(cmp<0){
                c.add(o);
            }
            else{
               devolver= -1;
            }
        }return devolver;
    }

    public static IGrupoAlumnos obtenerGrupoPrueba() {
        IGrupoAlumnos gPrueba;
        GrupoAlumnos gprueba = new GrupoAlumnos();
        
        
        return gPrueba;
    }


}
