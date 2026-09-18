public class Nodo<T> {
 
    T dato;
    Nodo<T> siguiente; // puntero al siguiente nodo (null si es el último)
 
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
 
    public T getDato() {
        return dato;
    }
 
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
}