package comandos;

import juego.Juego;
import personajes.Personaje;
import utilidades.Texto;

/**
 * Comando que permite al usuario hablar con un personaje en la ciudad actual.
 */
public class ComandoHablar extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripci�n que explica lo que el comando hace y/o da un ejemplo de c�mo
     * utilizarlo.
     *
     * @param descripcion Descripci�n de este comando.
     */
    public ComandoHablar(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta hablar con el personaje especificado en la ciudad actual.
     *
     * @param juego El juego en el que se est� ejecutando.
     * @return true, porque el juego debe continuar.
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        String nombrePersonaje = getPalabras().get(1);

        if(nombrePersonaje == null) {
            Texto.imprimir("�Hablar con qui�n?");
            return true;
        }
        if(!juego.getCiudadActual().hasPersonaje(nombrePersonaje)) {
            Texto.imprimir("Ese tal \"" + nombrePersonaje + "\" no se encuentra aqu�.");
            return true;
        }

        Personaje personaje = juego.getCiudadActual().getPersonaje(nombrePersonaje);

        personaje.hablar(juego);
        return true;
    }
}
