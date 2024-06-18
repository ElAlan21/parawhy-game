package comandos;

import juego.Juego;
import lugares.Ciudad;
import utilidades.Texto;

/**
 * Comando que permite al usuario volver a la ciudad de la que vino.
 */
public class ComandoAtras extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripción, que explica lo que el comando hace y/o da un ejemplo
     * de cómo utilizarlo.
     *
     * @param descripcion descripción de este comando
     */
    public ComandoAtras(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta volver a la ciudad de la que el usuario vino. No lo podrá hacer si el historial de ciudades
     * está vacío o si la última ciudad no es vecina de la ciudad actual.
     *
     * @param juego el juego en el que se está ejecutando
     * @return true, porque el juego debe continuar
     */
    @Override
    public boolean ejecutar(Juego juego) {
        Ciudad ciudadAnterior = juego.readCiudadAnterior();
        // Si no hay una ciudad anterior o si la ciudad anterior no es vecina de la ciudad actual
        if (ciudadAnterior == null || !juego.getCiudadActual().hasVecino(ciudadAnterior)) {
            Texto.imprimir("No se puede volver a la ciudad anterior.");
            return true;
        }
        juego.setCiudadActual(ciudadAnterior);
        Texto.imprimir(juego.getCiudadActual().informacion());
        return true;
    }

}
