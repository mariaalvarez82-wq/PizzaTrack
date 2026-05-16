/**
 * Clase Nodo: Elemento fundamental de la Lista Ligada.
 * Cada nodo almacena un objeto Pizza y un puntero (referencia)
 * al siguiente nodo en la pila.
 *
 * La pila manual se construye encadenando nodos mediante
 * el puntero 'siguiente', sin usar java.util.Stack.
 */
public class Nodo {

    // Dato almacenado en este nodo
    Pizza dato;

    // Puntero al siguiente nodo de la lista ligada
    // (null si es el último nodo)
    Nodo siguiente;

    /**
     * Constructor del Nodo.
     *
     * @param dato Objeto Pizza que almacena este nodo
     */
    public Nodo(Pizza dato) {
        this.dato = dato;
        this.siguiente = null; // Al crear el nodo, no apunta a ningún siguiente
    }
}
