/**
 * Clase Pizza: Representa el modelo de datos de un pedido.
 * Utiliza un arreglo fijo de tamaño 3 para almacenar los ingredientes,
 * tal como lo exige la especificación del proyecto.
 */
public class Pizza {

    // Atributos del objeto Pizza
    private String nombre;
    private String[] ingredientes; // Arreglo fijo de tamaño 3 (obligatorio)

    /**
     * Constructor de Pizza.
     * Recibe el nombre y un arreglo de exactamente 3 ingredientes.
     *
     * @param nombre       Nombre de la pizza
     * @param ingredientes Arreglo de 3 ingredientes
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        // Se crea un arreglo fijo de tamaño 3 para cumplir la restricción
        this.ingredientes = new String[3];
        // Se copian los ingredientes recibidos al arreglo interno
        for (int i = 0; i < 3; i++) {
            if (i < ingredientes.length) {
                this.ingredientes[i] = ingredientes[i];
            } else {
                this.ingredientes[i] = "N/A"; // Valor por defecto si faltan ingredientes
            }
        }
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    /**
     * Representación en texto del pedido (útil para mostrar en consola).
     */
    @Override
    public String toString() {
        return "Pizza: " + nombre
                + " | Ingredientes: [" + ingredientes[0]
                + ", " + ingredientes[1]
                + ", " + ingredientes[2] + "]";
    }
}
