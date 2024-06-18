package comandos;

import juego.Juego;
import lugares.Ciudad;
import utilidades.Texto;

/**
 * Comando que permite al usuario agarrar un objeto que se encuentre en una ciudad.
 */
public class ComandoAgarrar extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripción, que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion descripción de este comando
     */
    public ComandoAgarrar(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta agarrar el objeto y ponerlo en el inventario del jugador. Dicho objeto debe encontrarse en la ciudad
     * actual y el jugador debe tener espacio suficiente para cargarlo.
     *
     * @param juego el juego en el que se está ejecutando
     * @return true, porque el juego debe continuar
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        Ciudad ciudadActual = juego.getCiudadActual();
        String objeto = getPalabras().get(1);

        if (objeto == null) {
            Texto.imprimir("¿Qué objeto quieres agarrar?");
            return true;
        }
        if (!ciudadActual.hasObjeto(objeto)) {
            Texto.imprimir("El objeto \"" + objeto + "\" no se encuentra en esta ciudad.");
            return true;
        }

        int pesoObjeto = ciudadActual.getPesoDeObjeto(objeto);

        if (!juego.addObjeto(objeto, pesoObjeto)) {
            Texto.imprimir("No tienes suficiente espacio para guardar este objeto en tu inventario.");
            return true;
        }
        ciudadActual.removeObjeto(objeto);
        Texto.imprimir("Has agarrado el objeto \"" + objeto + "\".");
        return true;
    }
}
