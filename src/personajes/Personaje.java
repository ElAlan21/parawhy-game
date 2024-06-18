package personajes;

import juego.Juego;
import utilidades.Texto;

import java.util.Random;

/**
 * Un personaje representa a una persona o animal. Tiene un nombre y, opcionalmente, diálogos. Si el personaje tiene
 * diálogos podemos hacerlo hablar.
 */
public class Personaje {
    private final String nombre;
    private final String[] dialogos;

    /**
     * Constructor del personaje solo con su nombre.
     *
     * @param nombre nombre de este personaje
     */
    public Personaje(String nombre) {
        this(nombre, new String[]{});
    }

    /**
     * Constructor del personaje con su nombre y una lista de diálogos.
     *
     * @param nombre   nombre de este personaje
     * @param dialogos frases o sonidos de este personaje
     */
    public Personaje(String nombre, String[] dialogos) {
        if (nombre.split("\\s+").length > 1) {
            throw new IllegalArgumentException("El nombre no puede tener más de una palabra.");
        }

        this.nombre = nombre;
        this.dialogos = dialogos;
    }

    /**
     * Devuelve el nombre de este personaje.
     *
     * @return nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Imprime uno de los diálogos de este personaje aleatoriamente.
     *
     * @param juego juego en el que estamos jugando
     */
    public void hablar(Juego juego) {
        // Si tiene diálogos, que diga uno al azar
        if (dialogos.length > 0) {
            Random random = new Random();
            int indiceRandom = random.nextInt(dialogos.length);

            Texto.imprimir(dialogos[indiceRandom]);
            return;
        }
        Texto.imprimir("Parece que no quiere hablar...");
    }
}
