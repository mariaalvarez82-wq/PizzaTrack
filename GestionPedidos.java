/**
 * Clase GestionPedidos: Coordina el sistema Undo/Redo usando DOS pilas manuales.
 *
 * Pila Principal (Undo): Almacena los pedidos registrados activos.
 * Pila Secundaria (Redo): Almacena los pedidos deshechos para recuperarlos.
 *
 * Lógica del sistema:
 *  - Registrar: push() a la pila principal. La pila secundaria se vacía
 *               (un nuevo pedido invalida el historial de redo).
 *  - Deshacer:  pop() de la pila principal -> push() a la pila secundaria.
 *  - Rehacer:   pop() de la pila secundaria -> push() a la pila principal.
 */
public class GestionPedidos {

    // Pila Principal: pedidos activos (permite Undo)
    private PilaManual pilaPrincipal;

    // Pila Secundaria: pedidos deshechos (permite Redo)
    private PilaManual pilaSecundaria;

    /**
     * Constructor: inicializa ambas pilas vacías.
     */
    public GestionPedidos() {
        pilaPrincipal  = new PilaManual();
        pilaSecundaria = new PilaManual();
    }

    // ── Operaciones del sistema ──────────────────────────────────────────────

    /**
     * Registrar Pedido (Escribir):
     * Apila la pizza en la pila principal.
     * Al registrar un nuevo pedido, se vacía la pila secundaria
     * porque el historial de "Rehacer" ya no es válido.
     *
     * @param pizza Objeto Pizza a registrar
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        // Vaciar pila secundaria: nuevo pedido invalida el historial de redo
        vaciarPilaSecundaria();
        System.out.println("  [OK] Pedido registrado: " + pizza);
    }

    /**
     * Deshacer (Undo):
     * Saca la pizza del tope de la pila principal (pop)
     * y la mueve a la pila secundaria (push).
     */
    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("  [!] No hay pedidos para deshacer.");
            return;
        }
        Pizza pizza = pilaPrincipal.pop();       // Retira de la pila principal
        pilaSecundaria.push(pizza);              // Guarda en pila secundaria
        System.out.println("  [UNDO] Pedido deshecho: " + pizza);
    }

    /**
     * Rehacer (Redo):
     * Saca la pizza del tope de la pila secundaria (pop)
     * y la devuelve a la pila principal (push).
     */
    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println("  [!] No hay pedidos para rehacer.");
            return;
        }
        Pizza pizza = pilaSecundaria.pop();      // Retira de la pila secundaria
        pilaPrincipal.push(pizza);               // Devuelve a la pila principal
        System.out.println("  [REDO] Pedido recuperado: " + pizza);
    }

    /**
     * Mostrar Pedido Actual:
     * Usa peek() para ver el pedido en producción sin retirarlo.
     */
    public void mostrarPedidoActual() {
        System.out.println("  [PEEK] Pedido en producción:");
        Pizza pizza = pilaPrincipal.peek();
        if (pizza != null) {
            System.out.println("  --> " + pizza);
        }
    }

    // ── Método auxiliar ──────────────────────────────────────────────────────

    /**
     * Vacía completamente la pila secundaria (al registrar un nuevo pedido).
     * Se hace con pop() sucesivos hasta que isEmpty() sea true.
     */
    private void vaciarPilaSecundaria() {
        while (!pilaSecundaria.isEmpty()) {
            pilaSecundaria.pop();
        }
    }
}
