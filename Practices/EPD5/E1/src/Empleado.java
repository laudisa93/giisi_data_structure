
import java.util.*;

public class Empleado implements IEmpleado {

    private String nombre;
    private String apellidos;
    private int edad;
    private int sueldo;
    private IFecha fechaDeIncorporacion;

    public Empleado(String nombre, String apellidos, int edad, int sueldo, IFecha fechaDeIncorporacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sueldo = sueldo;
        this.fechaDeIncorporacion = fechaDeIncorporacion;
    }

    public String toString() {
        return "Empleado:\n" + "\tNombre: " + this.getNombre()
                + "\n\tApellidos: " + this.getApellidos()
                + "\n\tEdad: " + edad + "\n\tSueldo: " + sueldo
                + "\n\tFecha De Incorporacion: " + fechaDeIncorporacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public IFecha getFechaDeIncorporacion() {
        return fechaDeIncorporacion;
    }

    public void setFechaDeIncorporacion(IFecha fechaDeIncorporacion) {
        this.fechaDeIncorporacion = fechaDeIncorporacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int compareTo(Object o) {
        Empleado emp = (Empleado) o;
        int res = this.getApellidos().compareToIgnoreCase(emp.getApellidos());

        if (res == 0) {
            this.getNombre().compareToIgnoreCase(emp.getNombre());
        }

        return res;
    }
}
