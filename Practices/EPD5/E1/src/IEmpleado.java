
public interface IEmpleado extends Comparable {

    int compareTo(Object o);

    String getApellidos();

    int getEdad();

    IFecha getFechaDeIncorporacion();

    String getNombre();

    int getSueldo();

    void setApellidos(String apellidos);

    void setEdad(int edad);

    void setFechaDeIncorporacion(IFecha fechaDeIncorporacion);

    void setNombre(String nombre);

    void setSueldo(int sueldo);

    String toString();

}
