package personajes;

import juego.Juego;
import utilidades.Texto;

/**
 * Un personaje especial que, además de nombre y diálogos, tiene misiones para el jugador. Opcionalmente, puede ofrecer
 * un objeto de recompensa para el jugador al completar cada misión.
 */
public class PersonajeConMisiones extends Personaje {
    private final Mision[] misiones;
    private int indiceMisionActual = 0;
    private boolean recompensaEntregada = true;

    /**
     * Constructor de la clase personajeConMisiones.
     *
     * @param nombre   el nombre del personaje.
     * @param misiones las misiones que este personaje ofrece.
     */
    public PersonajeConMisiones(String nombre, Mision[] misiones) {
        super(nombre);
        this.misiones = misiones;
    }

    /**
     * Constructor de la clase personajeConMisiones.
     *
     * @param nombre   el nombre del personaje.
     * @param misiones las misiones que este personaje ofrece.
     * @param dialogos frases o sonidos de este personaje
     */
    public PersonajeConMisiones(String nombre, Mision[] misiones, String[] dialogos) {
        super(nombre, dialogos);
        this.misiones = misiones;
    }

    /**
     * Método que permite que el personaje reciba un objeto del jugador y le dé la recompensa correspondiente, si es que
     * la misión tiene recompensa.
     *
     * @param objeto el objeto entregado al personaje.
     * @param juego  el juego en el que estamos jugando.
     */
    public void recibirObjeto(String objeto, Juego juego) {
        // Revisamos si hay misiones disponibles
        if (indiceMisionActual >= misiones.length) {
            Texto.imprimir("Este personaje ya no acepta objetos.");
            return;
        }

        // Revisamos si esta misión existe
        Mision misionActual = misiones[indiceMisionActual];

        if (misionActual == null) {
            throw new IllegalStateException("Este personaje fue inicializado con una misión nula.");
        }

        // Revisamos si el objeto es el solicitado en la misión actual
        boolean esElObjetoSolicitado = misionActual.getObjetoSolicitado().equalsIgnoreCase(objeto);

        if (!esElObjetoSolicitado) {
            Texto.imprimir("El objeto \"" + objeto + "\" no es el solicitado.");
            return;
        }
        juego.removeObjeto(objeto); // Le quitamos el objeto al jugador
        Texto.imprimir(misionActual.getDialogoDeAgradecimiento()); // El personaje agradece
        if (misionActual.hasRecompensa()) {
            recompensaEntregada = darRecompensa(misionActual, juego);
            return;
        }
        indiceMisionActual++;
    }

    private boolean darRecompensa(Mision mision, Juego juego) {
        String recompensa = mision.getRecompensa();
        int pesoRecompensa = mision.getPesoRecompensa();

        if (!juego.addObjeto(recompensa, pesoRecompensa)) {
            Texto.imprimir("No tienes espacio suficiente para llevar la recompensa " +
                           "\n\"" + recompensa + "\" que pesa " + pesoRecompensa + "g." +
                           "\nDeja un objeto y vuelve a hablar con este personaje para reclamarla.");
            return false;
        }
        Texto.imprimir("Recompensa agregada a tu inventario: \"" + recompensa + "\".");
        indiceMisionActual++;
        return true;
    }

    /**
     * Permite al personaje hablar con el jugador. Si el personaje tiene una misión para el jugador, se lo dice. Si no
     * tiene misiones para el jugador, sencillamente imprime un diálogo aleatorio en la pantalla.
     *
     * @param juego el juego en el que estamos jugando.
     */
    @Override
    public void hablar(Juego juego) {
        // Si no hay misiones disponibles, que diga uno de sus diálogos
        if (indiceMisionActual >= misiones.length) {
            super.hablar(juego);
            return;
        }

        Mision misionActual = misiones[indiceMisionActual];

        if (!recompensaEntregada) {
            Texto.imprimir(misionActual.getDialogoDeAgradecimiento());
            recompensaEntregada = darRecompensa(misionActual, juego);
            return;
        }
        Texto.imprimir(misionActual.getDialogoDeSolicitud());
        Texto.imprimir("Objeto solicitado: \"" + misionActual.getObjetoSolicitado() + "\".");
    }
}
