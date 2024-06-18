package comandos;

import juego.Juego;
import personajes.Personaje;
import personajes.PersonajeConMisiones;
import utilidades.Texto;

/**
 * Este comando permite al jugador dar un objeto a un personaje.
 */
public class ComandoDar extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripción, que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion descripción de este comando
     */
    public ComandoDar(String descripcion) {
        super(descripcion);
    }

    /**
     * Intenta dar el objeto a un personaje. El jugador debe tener el objeto en su inventario y el personaje debe estar
     * en la ciudad actual y poder aceptar objetos, o sea, ser un Personaje Con Misiones activo.
     *
     * @param juego el juego en el que se está ejecutando
     * @return true, porque el juego debe continuar
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Al comando le faltan palabras o argumentos.");
        }

        String nombreObjeto = getPalabras().get(1);
        String nombrePersonaje = getPalabras().get(2);

        if (nombreObjeto == null) {
            Texto.imprimir("¿Qué objeto quieres dar?");
            return true;
        }
        if (!juego.hasObjeto(nombreObjeto)) {
            Texto.imprimir("No tienes el objeto \"" + nombreObjeto + "\" en tu inventario.");
            return true;
        }
        if (nombrePersonaje == null) {
            Texto.imprimir("¿A quién le quieres dar un objeto?");
            return true;
        }
        if(!juego.getCiudadActual().hasPersonaje(nombrePersonaje)) {
            Texto.imprimir("Ese tal \"" + nombrePersonaje + "\" no se encuentra aquí.");
            return true;
        }

        Personaje personaje = juego.getCiudadActual().getPersonaje(nombrePersonaje);

        if (personaje.getClass() != PersonajeConMisiones.class) {
            Texto.imprimir(nombrePersonaje + " no acepta objetos.");
            return true;
        }
        ((PersonajeConMisiones) personaje).recibirObjeto(nombreObjeto, juego);
        return true;
    }
}
