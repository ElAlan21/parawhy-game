package personajes;

/**
 * Una misi�n puede ser asignada a un personaje de tipo {@link PersonajeConMisiones}. Una misi�n consiste en solicitar
 * un objeto, proporcionar un di�logo de solicitud y un di�logo de agradecimiento al completarse. Opcionalmente, puede
 * ofrecer una recompensa al completarse la misi�n.
 */
public class Mision {
    private final String objetoSolicitado;
    private final String dialogoDeSolicitud;
    private final String dialogoDeAgradecimiento;
    private final String recompensa;
    private final int pesoRecompensa;

    /**
     * Constructor de la misi�n.
     *
     * @param objetoSolicitado        El objeto que se solicita como parte de la misi�n.
     * @param dialogoDeSolicitud      El di�logo que presenta la solicitud del objeto al jugador.
     * @param dialogoDeAgradecimiento El di�logo de agradecimiento que se muestra al completar la misi�n.
     */
    public Mision(String objetoSolicitado, String dialogoDeSolicitud, String dialogoDeAgradecimiento) {
        this(objetoSolicitado, dialogoDeSolicitud, dialogoDeAgradecimiento, null, 0);
    }

    /**
     * Constructor de la misi�n.
     *
     * @param objetoSolicitado        El objeto que se solicita como parte de la misi�n.
     * @param dialogoDeSolicitud      El di�logo que presenta la solicitud del objeto al jugador.
     * @param dialogoDeAgradecimiento El di�logo de agradecimiento que se muestra al completar la misi�n.
     * @param recompensa              La recompensa ofrecida al completar la misi�n.
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
     * Obtiene el objeto solicitado como parte de la misi�n.
     *
     * @return el objeto solicitado
     */
    public String getObjetoSolicitado() {
        return objetoSolicitado;
    }

    /**
     * Obtiene el di�logo que presenta la solicitud de la misi�n al jugador.
     *
     * @return el di�logo de solicitud
     */
    public String getDialogoDeSolicitud() {
        return dialogoDeSolicitud;
    }

    /**
     * Obtiene el di�logo de agradecimiento que se muestra al completar la misi�n.
     *
     * @return el di�logo de agradecimiento
     */
    public String getDialogoDeAgradecimiento() {
        return dialogoDeAgradecimiento;
    }

    /**
     * Verifica si la misi�n ofrece alguna recompensa.
     *
     * @return true si la misi�n ofrece una recompensa, false en caso contrario
     */
    public boolean hasRecompensa() {
        return recompensa != null;
    }

    /**
     * Obtiene la recompensa ofrecida al completar la misi�n.
     *
     * @return la recompensa ofrecida
     */
    public String getRecompensa() {
        return recompensa;
    }

    /**
     * Obtiene el peso de la recompensa ofrecida al completar la misi�n.
     *
     * @return el peso de la recompensa
     */
    public int getPesoRecompensa() {
        return pesoRecompensa;
    }
}
