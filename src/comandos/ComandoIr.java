/*
 * Universidad Nacional de Itap�a.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Versi�n: 1.1
 * Fecha: Marzo de 2000
 * Derechos de autor (c) Michael Kolling
 *
 * Nombre del Alumno: Alan Valenzuela
 *
 */
package comandos;

import juego.Juego;
import lugares.Ciudad;
import utilidades.Texto;

/**
 * Esta clase es un comando que cambia el cuarto actual del protagonista del juego.
 */
public class ComandoIr extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripci�n que explica lo que el comando hace y/o da un ejemplo de c�mo
     * utilizarlo.
     *
     * @param descripcion Descripci�n de este comando.
     */
    public ComandoIr(String descripcion) {
        super(descripcion);
    }

    /**
     * Cambia la ubicaci�n del jugador a una ciudad vecina en la direcci�n especificada. Adem�s, imprime informaci�n
     * sobre la nueva ciudad actual y su descripci�n si es la primera vez que se visita.
     *
     * @param juego El juego en el que se est� ejecutando.
     * @return true si el juego debe continuar, false si se alcanz� el final del juego, o sea, ya se lleg� a Filadelfia
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        String direccion = getPalabras().get(1);

        if (direccion == null) {
            Texto.imprimir("�Ir en qu� direcci�n?");  // Si no hay direcci�n, no sabemos a d�nde ir
            return true;
        }
        if (!juego.getCiudadActual().hasVecino(direccion)) {
            Texto.imprimir("No puedes ir en la direcci�n \"" + direccion + "\".");
            Texto.imprimir(juego.getCiudadActual().textoDirecciones());
            return true;
        }

        cambiarCiudad(juego, direccion);

        Ciudad ciudadActual = juego.getCiudadActual(); // Trabajamos con la nueva ciudad actual
        Ciudad filadelfia = juego.getFiladelfia();

        if (filadelfia != null && filadelfia == ciudadActual) {
            juego.imprimirFinalDelJuego();
            return false;
        }
        // Si es la primera vez que se visita esta ciudad, deber� imprimir su descripci�n/narraci�n
        if (!ciudadActual.isConocida()) {
            Texto.imprimir(ciudadActual.getDescripcion());
            ciudadActual.setConocida(true);
        }
        Texto.imprimir(ciudadActual.informacion());
        return true;
    }

    /**
     * Cambia la ciudad actual del juego por la ciudad vecina en la direcci�n especificada.
     *
     * @param juego     El juego en el que se est� ejecutando.
     * @param direccion La direcci�n en la que el jugador desea ir.
     */
    private void cambiarCiudad(Juego juego, String direccion) {
        // Agregamos la ciudad actual al historial de ciudades
        juego.addToHistorial(juego.getCiudadActual());
        // Cambiamos la ciudad actual por la que el jugador solicit�
        juego.setCiudadActual(juego.getCiudadActual().getVecino(direccion));
    }
}
