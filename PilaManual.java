/**
 * Clase PilaManual: Implementación de una Pila (Stack) desde cero
 * utilizando una Lista Ligada de Nodos.
 *
 * RESTRICCIÓN CUMPLIDA: No se usa java.util.Stack.
 * La lógica se basa en el puntero 'tope' que siempre apunta
 * al Nodo más reciente (el "tope" de la pila).
 *
 * Métodos obligatorios implementados:
 *   push()    -> Insertar pizza en el tope
 *   pop()     -> Retirar pizza del tope y devolverla
 *   peek()    -> Ver la pizza del tope sin retirarla
 *   isEmpty() -> Verificar si la pila está vacía
 */
public class PilaManual {

    // Puntero al nodo que está en el tope de la pila
    // Cuando la pila está vacía, tope = null
    private Nodo tope;

    /**
     * Constructor: inicializa la pila vacía.
     */
    public PilaManual() {
        this.tope = null;
    }

    // ── Métodos fundamentales ────────────────────────────────────────────────

    /**
     * push(): Inserta un objeto Pizza en el tope de la pila.
     * Crea un nuevo Nodo, lo encadena al tope actual y
     * actualiza el puntero 'tope' para que apunte al nuevo nodo.
     *
     * @param pizza Objeto Pizza a apilar
     */
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza); // Se crea el nuevo nodo con la pizza
        nuevoNodo.siguiente = tope;       // El nuevo nodo apunta al tope anterior
        tope = nuevoNodo;                 // El tope ahora es el nuevo nodo
    }

    /**
     * pop(): Retira el objeto Pizza del tope y lo devuelve.
     * Mueve el puntero 'tope' al nodo siguiente (el anterior tope).
     * Si la pila está vacía, retorna null y avisa al usuario.
     *
     * @return Pizza del tope, o null si la pila está vacía
     */
    public Pizza pop() {
        if (isEmpty()) {
            System.out.println("  [!] La pila está vacía. No hay pedidos que retirar.");
            return null;
        }
        Pizza pizzaRetirada = tope.dato; // Guardamos el dato del tope
        tope = tope.siguiente;           // Movemos el puntero al siguiente nodo
        return pizzaRetirada;            // Devolvemos la pizza retirada
    }

    /**
     * peek(): Muestra la Pizza en el tope sin retirarla.
     * Solo consulta el dato del nodo tope sin modificar la pila.
     *
     * @return Pizza del tope, o null si la pila está vacía
     */
    public Pizza peek() {
        if (isEmpty()) {
            System.out.println("  [!] La pila está vacía. No hay pedido en producción.");
            return null;
        }
        return tope.dato; // Solo leemos, no modificamos la pila
    }

    /**
     * isEmpty(): Verifica si la pila se encuentra vacía.
     * La pila está vacía cuando el puntero 'tope' es null.
     *
     * @return true si está vacía, false si tiene elementos
     */
    public boolean isEmpty() {
        return tope == null;
    }
}
