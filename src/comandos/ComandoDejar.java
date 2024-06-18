package comandos;

import juego.Juego;
import utilidades.Texto;

/**
 * Comando que permite al usuario dejar un objeto en la ciudad actual.
 */
public class ComandoDejar extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripción que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion Descripción de este comando.
     */
    public ComandoDejar(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta dejar el objeto en la ciudad actual. El objeto debe estar en el inventario del jugador.
     *
     * @param juego El juego en el que se está ejecutando.
     * @return true, porque el juego debe continuar.
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        String nombreObjeto = getPalabras().get(1);

        if (nombreObjeto == null) {
            Texto.imprimir("¿Qué objeto quieres dejar?");
            return true;
        }
        if (!juego.hasObjeto(nombreObjeto)) {
            Texto.imprimir("No tienes el objeto \"" + nombreObjeto + "\" en tu inventario.");
            return true;
        }

        int peso = juego.removeObjeto(nombreObjeto);

        juego.getCiudadActual().addObjeto(nombreObjeto, peso);
        Texto.imprimir("Has dejado el objeto \"" + nombreObjeto + "\"");
        return true;
    }
}
