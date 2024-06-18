package comandos;

import juego.Juego;
import lugares.Ciudad;
import utilidades.Texto;

/**
 * Comando que permite al usuario volver a la ciudad de la que vino.
 */
public class ComandoAtras extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripci�n, que explica lo que el comando hace y/o da un ejemplo
     * de c�mo utilizarlo.
     *
     * @param descripcion descripci�n de este comando
     */
    public ComandoAtras(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta volver a la ciudad de la que el usuario vino. No lo podr� hacer si el historial de ciudades
     * est� vac�o o si la �ltima ciudad no es vecina de la ciudad actual.
     *
     * @param juego el juego en el que se est� ejecutando
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
