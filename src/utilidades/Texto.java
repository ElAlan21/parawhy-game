package utilidades;

/**
 * La clase Texto proporciona m�todos para imprimir texto en la consola.
 */
public class Texto {

    // Constructor privado para evitar instanciaci�n de la clase.
    private Texto() {
    }

    /**
     * Imprime el texto especificado seguido de un salto de l�nea.
     *
     * @param texto El texto que se va a imprimir.
     */
    public static void imprimir(String texto) {
        System.out.println(texto);
    }

    /**
     * Imprime un salto de l�nea.
     */
    public static void imprimir() {
        System.out.println();
    }

    /**
     * Imprime el texto especificado sin agregar un salto de l�nea al final.
     *
     * @param texto El texto que se va a imprimir.
     */
    public static void imprimirSinSalto(String texto) {
        System.out.print(texto);
    }
}

