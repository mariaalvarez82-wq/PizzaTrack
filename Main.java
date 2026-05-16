import java.util.Scanner;

/**
 * Clase Main: Punto de entrada del programa Pizza-Track.
 *
 * Implementa el menú interactivo en consola con las siguientes opciones:
 *   1. Registrar Pizza (Escribir) -> push() en pila principal
 *   2. Deshacer (Undo)            -> pop() principal + push() secundaria
 *   3. Rehacer (Redo)             -> pop() secundaria + push() principal
 *   4. Mostrar Pedido Actual      -> peek() en pila principal
 *   0. Salir
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();
        int opcion = -1;

        System.out.println("==========================================");
        System.out.println("   Bienvenido a Pizza-Track              ");
        System.out.println("   Sistema de Gestión de Pedidos (Undo/Redo)");
        System.out.println("==========================================");

        // Bucle principal del menú
        while (opcion != 0) {
            mostrarMenu();

            // Leer opción del usuario
            System.out.print("Selecciona una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingresa un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer del salto de línea

            System.out.println("------------------------------------------");

            switch (opcion) {

                case 1:
                    // ── Registrar Pizza ───────────────────────────────────
                    System.out.print("  Nombre de la pizza: ");
                    String nombre = scanner.nextLine().trim();

                    String[] ingredientes = new String[3];
                    System.out.println("  Ingresa los 3 ingredientes:");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("    Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = scanner.nextLine().trim();
                    }

                    Pizza nuevaPizza = new Pizza(nombre, ingredientes);
                    gestion.registrarPedido(nuevaPizza);
                    break;

                case 2:
                    // ── Deshacer (Undo) ───────────────────────────────────
                    gestion.deshacer();
                    break;

                case 3:
                    // ── Rehacer (Redo) ────────────────────────────────────
                    gestion.rehacer();
                    break;

                case 4:
                    // ── Mostrar Pedido Actual ─────────────────────────────
                    gestion.mostrarPedidoActual();
                    break;

                case 0:
                    // ── Salir ─────────────────────────────────────────────
                    System.out.println("  ¡Hasta luego! Cerrando Pizza-Track...");
                    break;

                default:
                    System.out.println("  [!] Opción no válida. Intenta de nuevo.");
                    break;
            }

            System.out.println("------------------------------------------");
        }

        scanner.close();
    }

    /**
     * Muestra el menú de opciones en consola.
     */
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== MENÚ PIZZA-TRACK ==============");
        System.out.println("  1. Registrar Pizza (Escribir)");
        System.out.println("  2. Deshacer (Undo)");
        System.out.println("  3. Rehacer (Redo)");
        System.out.println("  4. Mostrar Pedido Actual");
        System.out.println("  0. Salir");
        System.out.println("==========================================");
    }
}
