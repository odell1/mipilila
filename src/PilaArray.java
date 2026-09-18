/*********
 * Creación de PILA (STACK) desde 0. Sin usar APIs; Deque, ArrayDeque, ni java.utils
 * LIFO
 /*********/


public class PilaArray<T> {

    private Object[] datos;
    private int tope; //  El número de elementos
    
    public PilaArray(){ //Constructor inicial
        this(8);// Capacidad inicial
    }//PilaArary

    public PilaArray(int capacidadInicial) {
        datos = new Object[capacidadInicial];
        tope=0;
    }//PilaArray (CapacidadInicial)

    ////
    /// Método para añadir un elemento en la cima de la pila
    /// 
    public void push(T valor){
        //1. Comprobamos la longitud
        if(tope==datos.length){
            redimensionar(datos.length*2);//Método para redimensionar la pila
        }//if
        datos[tope]=valor; //Metemos los datos
        tope++;// aumentamos el valor del índice

    }//push

    ////
    /// Método para extraer (eliminar) y devolver el elemento de la cima
    /// 
    @SuppressWarnings("unchecked")
    public T pop(){
        //1 Comprobamos si está vacía
        if(isEmpty()){
            throw new IllegalStateException("Flipao, la pila está vacía");
        }//if
        tope--;
        T valor=(T) datos[tope];
        datos[tope]=null; //eliminamos la referencia
        return valor;

    }//pop

    /// Método para saber si está vacía la pila
    /// 
    public boolean isEmpty(){
        return tope==0;        
    }//isEmpty

    //// 
    // Método para duplicar la capacidad interna de la pilila
    ///
    public void redimensionar(int nuevaCapacidad) {
        Object[] nuevo =new Object[nuevaCapacidad];
        System.arraycopy(datos,0, nuevo, 0, tope);
        datos=nuevo;
    }//redimensionar


    public static void main(String[] args) throws Exception {
          String[] prueba = {
                "(4 + 6)"
            };
        
          
        for (String expr : prueba) {
            System.out.printf("%s -> %s", expr, estaBalanceada(expr) ? "Balanceada" : "NO balanceada");
        }//for
        
    }//main
 
    private static boolean estaBalanceada(String expr) {
        PilaArray<Character> pila = new PilaArray<>();
        System.out.println("Judas");
        for (char c : expr.toCharArray()) {
            if (c == '('  || c == '{') {
                pila.push(c);
            } else if (c == ')' ||  c == '}') {
                if (pila.isEmpty()) return false;
                char apertura = pila.pop();
                if ((c == ')' && apertura != '(') ||
                    (c == '}' && apertura != '{')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }//estaBalanceada


}//public class PilaArray<T> 
