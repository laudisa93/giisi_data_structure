/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuarioupo
 */
class NodoCola {
    Object elemento;
    NodoCola next;

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoCola getNext() {
        return next;
    }

    public void setNext(NodoCola next) {
        this.next = next;
    }

    public NodoCola(Object o) {
        elemento = o;
        next = null;
    }

    @Override
    public String toString() {
        return elemento.toString();
    }
}
