package comandos;

import juego.Juego;
import utilidades.Texto;

/**
 * Comando que muestra información sobre la ciudad actual.
 */
public class ComandoInfo extends ComandoAbstracto{

    /**
     * Constructor del Comando. Recibe una descripción que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion Descripción de este comando.
     */
    public ComandoInfo(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra en consola información sobre la ciudad actual.
     *
     * @param juego El juego en el que se está ejecutando.
     * @return true, porque el juego debe continuar.
     */
    @Override
    public boolean ejecutar(Juego juego) {
        Texto.imprimir(juego.getCiudadActual().informacion());
        return true;
    }
}
