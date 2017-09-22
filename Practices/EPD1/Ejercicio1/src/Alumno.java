
public class Alumno implements IAlumno{
    private String nombre;
    private String apellidos;
    private String dni;

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getDni() {
        return this.dni;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setApellidos(String apellido) {
        this.apellidos=apellidos;
    }

    public void setDni(String dni) {
        this.dni=dni;
    }

    public Alumno(){
    }

    public Alumno(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    
     public String toString() {
        return "\nDatos Personales de: " + nombre + " " + apellidos + "\n\tDNI: " + dni + "\n";
    }

}
