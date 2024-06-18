package utilidades;

/**
 * La clase Tiempo proporciona métodos para manejar operaciones relacionadas con el tiempo.
 */
public class Tiempo {

    // Constructor privado para evitar instanciación de la clase.
    private Tiempo() {

    }

    /**
     * Hace que el hilo actual espere el tiempo especificado en milisegundos.
     *
     * @param milisegundos El tiempo en milisegundos que se va a esperar.
     */
    public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
