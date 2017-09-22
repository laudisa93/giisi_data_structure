

public class Persona implements IPersona, Comparable {

    private String dni;
    private String nombre;
    private int edad;

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int compareTo(Object o) {
        Persona p = (Persona) o;
        return this.dni.compareTo(getDni());
    }

    public String toString() {
        return dni + " " + nombre + " (" + edad + ")";
    }
}
