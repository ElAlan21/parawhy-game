/*
 * Universidad Nacional de Itapúa.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Versión: 1.1
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
     * Constructor del Comando. Recibe una descripción que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion Descripción de este comando.
     */
    public ComandoIr(String descripcion) {
        super(descripcion);
    }

    /**
     * Cambia la ubicación del jugador a una ciudad vecina en la dirección especificada. Además, imprime información
     * sobre la nueva ciudad actual y su descripción si es la primera vez que se visita.
     *
     * @param juego El juego en el que se está ejecutando.
     * @return true si el juego debe continuar, false si se alcanzó el final del juego, o sea, ya se llegó a Filadelfia
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        String direccion = getPalabras().get(1);

        if (direccion == null) {
            Texto.imprimir("¿Ir en qué dirección?");  // Si no hay dirección, no sabemos a dónde ir
            return true;
        }
        if (!juego.getCiudadActual().hasVecino(direccion)) {
            Texto.imprimir("No puedes ir en la dirección \"" + direccion + "\".");
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
        // Si es la primera vez que se visita esta ciudad, deberá imprimir su descripción/narración
        if (!ciudadActual.isConocida()) {
            Texto.imprimir(ciudadActual.getDescripcion());
            ciudadActual.setConocida(true);
        }
        Texto.imprimir(ciudadActual.informacion());
        return true;
    }

    /**
     * Cambia la ciudad actual del juego por la ciudad vecina en la dirección especificada.
     *
     * @param juego     El juego en el que se está ejecutando.
     * @param direccion La dirección en la que el jugador desea ir.
     */
    private void cambiarCiudad(Juego juego, String direccion) {
        // Agregamos la ciudad actual al historial de ciudades
        juego.addToHistorial(juego.getCiudadActual());
        // Cambiamos la ciudad actual por la que el jugador solicitó
        juego.setCiudadActual(juego.getCiudadActual().getVecino(direccion));
    }
}
