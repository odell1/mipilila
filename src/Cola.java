/*********
 * Creación de COLA desde 0. Sin usar APIs; Deque, ArrayDeque, ni java.utils
 * FIFO
 /*********/


public class Cola<T> {

    
///////////
/// Estructuras principales de la cola
/// /////////
private  Nodo<T> frente;// Puntero al primer nodo. Este es el primero en darle puerta
private  Nodo<T> finalNodo;// puntero al último nodo, donde se añade el siguiente elemento
private int numElementos; //Esto es opcional

public Cola(){
    frente=null;
    finalNodo=null;
    numElementos=0;

}//Constructor

//////////
/// Método para insertar un nodo al final de la cola
/// //////
public void meter(T valor){
    Nodo nuevo=new Nodo(valor);

    //Caso 1 que está vacía
    if(isEmpty()){
        frente=nuevo;
    }else{
        finalNodo.siguiente=nuevo;
    }
    finalNodo=nuevo;
    numElementos++;

}//meter

//////////////////
/// Método para sacar un nodo
/// //////
public T sacar(){
    if(isEmpty())
        {
            System.out.println("Pringao la cola está vacía.");
            return null;
        }
    T valor=frente.dato;
    frente=frente.siguiente;
    if(frente==null){//Si no quedan nodos, el final también es null
        finalNodo=null;
    }
    numElementos--;
    return valor;
}//sacar


    private boolean isEmpty() {
        return frente==null;
    }//isEmpty
    
    public static void main(String[] args) {
        

    }//main



}//ColaArray
