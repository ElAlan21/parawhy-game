package comandos;

import juego.Juego;
import utilidades.Texto;

/**
 * Comando que muestra informaci�n sobre la ciudad actual.
 */
public class ComandoInfo extends ComandoAbstracto{

    /**
     * Constructor del Comando. Recibe una descripci�n que explica lo que el comando hace y/o da un ejemplo de c�mo
     * utilizarlo.
     *
     * @param descripcion Descripci�n de este comando.
     */
    public ComandoInfo(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra en consola informaci�n sobre la ciudad actual.
     *
     * @param juego El juego en el que se est� ejecutando.
     * @return true, porque el juego debe continuar.
     */
    @Override
    public boolean ejecutar(Juego juego) {
        Texto.imprimir(juego.getCiudadActual().informacion());
        return true;
    }
}
