
public class Carta implements ICarta {
    private int numero;
    private int palo;

    Carta(int numero, int palo) {
        this.numero = numero;
        this.palo = palo;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    public String toString() {
        String cadena="\n";
        if(this.numero>1 && this.numero<11){
            cadena=this.numero+" de ";
        }
        switch(getNumero()){
            case 1:
                cadena="As de ";
                break;
            case 11:
                cadena="J de ";
                break;
            case 12:
                cadena="Q de ";
                break;
            case 13:
                cadena="K de ";
                break;
        }
        switch(getPalo()){
            case 0:
                cadena = cadena+"picas\n";
                break;
            case 1:
                cadena = cadena+"corazones\n";
                break;
            case 2:
                cadena = cadena+"treboles\n";
                break;
            case 3:
                cadena = cadena+"diamantes\n";
                break;
        }
        return cadena;
    }

}
