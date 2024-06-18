package personajes;

/**
 * Una misión puede ser asignada a un personaje de tipo {@link PersonajeConMisiones}. Una misión consiste en solicitar
 * un objeto, proporcionar un diálogo de solicitud y un diálogo de agradecimiento al completarse. Opcionalmente, puede
 * ofrecer una recompensa al completarse la misión.
 */
public class Mision {
    private final String objetoSolicitado;
    private final String dialogoDeSolicitud;
    private final String dialogoDeAgradecimiento;
    private final String recompensa;
    private final int pesoRecompensa;

    /**
     * Constructor de la misión.
     *
     * @param objetoSolicitado        El objeto que se solicita como parte de la misión.
     * @param dialogoDeSolicitud      El diálogo que presenta la solicitud del objeto al jugador.
     * @param dialogoDeAgradecimiento El diálogo de agradecimiento que se muestra al completar la misión.
     */
    public Mision(String objetoSolicitado, String dialogoDeSolicitud, String dialogoDeAgradecimiento) {
        this(objetoSolicitado, dialogoDeSolicitud, dialogoDeAgradecimiento, null, 0);
    }

    /**
     * Constructor de la misión.
     *
     * @param objetoSolicitado        El objeto que se solicita como parte de la misión.
     * @param dialogoDeSolicitud      El diálogo que presenta la solicitud del objeto al jugador.
     * @param dialogoDeAgradecimiento El diálogo de agradecimiento que se muestra al completar la misión.
     * @param recompensa              La recompensa ofrecida al completar la misión.
     * @param pesoRecompensa          El peso de la recompensa ofrecida.
     */
    public Mision(String objetoSolicitado, String dialogoDeSolicitud, String dialogoDeAgradecimiento, String recompensa,
                  int pesoRecompensa) {
        this.objetoSolicitado = objetoSolicitado;
        this.dialogoDeSolicitud = dialogoDeSolicitud;
        this.dialogoDeAgradecimiento = dialogoDeAgradecimiento;
        this.recompensa = recompensa;
        this.pesoRecompensa = pesoRecompensa;
    }

    /**
     * Obtiene el objeto solicitado como parte de la misión.
     *
     * @return el objeto solicitado
     */
    public String getObjetoSolicitado() {
        return objetoSolicitado;
    }

    /**
     * Obtiene el diálogo que presenta la solicitud de la misión al jugador.
     *
     * @return el diálogo de solicitud
     */
    public String getDialogoDeSolicitud() {
        return dialogoDeSolicitud;
    }

    /**
     * Obtiene el diálogo de agradecimiento que se muestra al completar la misión.
     *
     * @return el diálogo de agradecimiento
     */
    public String getDialogoDeAgradecimiento() {
        return dialogoDeAgradecimiento;
    }

    /**
     * Verifica si la misión ofrece alguna recompensa.
     *
     * @return true si la misión ofrece una recompensa, false en caso contrario
     */
    public boolean hasRecompensa() {
        return recompensa != null;
    }

    /**
     * Obtiene la recompensa ofrecida al completar la misión.
     *
     * @return la recompensa ofrecida
     */
    public String getRecompensa() {
        return recompensa;
    }

    /**
     * Obtiene el peso de la recompensa ofrecida al completar la misión.
     *
     * @return el peso de la recompensa
     */
    public int getPesoRecompensa() {
        return pesoRecompensa;
    }
}
