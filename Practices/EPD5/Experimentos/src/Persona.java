

public class Persona implements IPersona, Comparable {

    private int edad;

    public Persona(int edad) {
        setEdad(edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return String.valueOf(edad);
    }

    public int compareTo(Object o) {
        IPersona otherPerson = (Persona)o;
        if(this.getEdad()==otherPerson.getEdad()){
            return 0;
        }else if(this.getEdad()<otherPerson.getEdad()){
            return -1;
        }else{
            return 1;
        }
    }
}
