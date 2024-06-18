package juego;

import personajes.Mision;

/**
 * Clase que contiene todas las constantes necesarias para inicializar a los personajes con misiones en la clase
 * {@link juego.Juego}.
 */
public class ConstantesPersonajesConMisiones {

    // Constantes para el Presidente
    public static final String NOMBRE_PRESIDENTE = "Presidente";
    // Objetos que solicita
    public static final String OBJETO_MISION1_PRESIDENTE = "mercaderias";
    public static final int PESO_OBJETO_MISION1_PRESIDENTE = 500;
    public static final String OBJETO_MISION2_PRESIDENTE = "documentos";
    public static final int PESO_OBJETO_MISION2_PRESIDENTE = 150;
    public static final String OBJETO_MISION3_PRESIDENTE = "7cajas";
    // Di�logos de solicitud de objetos
    public static final String SOLICITUD_MISION1_PRESIDENTE = "- \"�Senador! �Qu� gusto verte! Justo estaba preguntando \n" +
                                                              "por vos el patr�n. Andamos necesitando alguien que pueda \n" +
                                                              "traer sus mercader�as de Ciudad del Este. El repartidor \n" +
                                                              "tuvo algunos percances. �Ser�as tan amable de hacernos ese \n" +
                                                              "enorme favor? Te va a sumar muchos puntos con nuestro \n" +
                                                              "comandante...\"";
    public static final String SOLICITUD_MISION2_PRESIDENTE = "- \"�Y los documentos senador? Andate pues a Encarnaci�n.\"";
    public static final String SOLICITUD_MISION3_PRESIDENTE = "- \"Al Chaco ten�s que irte senador. Al norte de ac�, por \n" +
                                                              "si no pasaste quinto grado."; // Placeholder para el di�logo de solicitud del tercer objeto
    // Di�logos de agradecimiento por los objetos
    public static final String AGRADECIMIENTO_MISION1_PRESIDENTE = "- \"Vos s� que sos un maestro, senador. Me salvaste \n" +
                                                                   "el pellejo y por eso te voy a dar este reconocimiento \n" +
                                                                   "en nombre del partido. Ya le coment� al patr�n sobre tu \n" +
                                                                   "lealtad. L�stima que no se pudo dar lo de tu ascenso \n" +
                                                                   "aquella vez. Yo abogu� mucho por vos, pero se tuvieron \n" +
                                                                   "que acatar las �rdenes del comando. Pero siento que \n" +
                                                                   "esta vez va a ser diferente. Otra cosa, necesito que \n" +
                                                                   "vayas a Encarnaci�n. Tengo un socio que te va a dar \n" +
                                                                   "unos papeles muy importantes.\"";
    public static final String AGRADECIMIENTO_MISION2_PRESIDENTE = "- \"Gracias senador, estoy muy contento con usted.\n" +
                                                                   "Tenemos un �ltimo pedido para vos, necesito que me \n" +
                                                                   "traigas unas cajas con contenido altamente sensible \n" +
                                                                   "que se encuentran retenidas en el Chaco. En Filadelfia \n" +
                                                                   "est�n escondidas y no las pudimos traer por no contar \n" +
                                                                   "con alguien de confianza, pero ahora est�s vos. \n" +
                                                                   "All� voy a poner a tu disposici�n un helic�ptero para \n" +
                                                                   "que puedas volver a Asunci�n m�s r�pido. Cuando termines \n" +
                                                                   "este recado, seguro que el patr�n va a querer hacerte \n" +
                                                                   "vicepresidente y todo. Tom� un poco de plata para el viaje.\"";
    public static final String AGRADECIMIENTO_MISION3_PRESIDENTE = "- \"��Estas vivo?!\"";
    // Nombre y peso de cada recompensa
    public static final String RECOMPENSA_MISION1_PRESIDENTE = "poncho";
    public static final int PESO_RECOMPENSA_MISION1_PRESIDENTE = 50;
    public static final String RECOMPENSA_MISION2_PRESIDENTE = "dinero";
    public static final int PESO_RECOMPENSA_MISION2_PRESIDENTE = 100;
    // Misiones del Presidente
    public final static Mision[] MISIONES_PRESIDENTE = {
            new Mision(
                    OBJETO_MISION1_PRESIDENTE,
                    SOLICITUD_MISION1_PRESIDENTE,
                    AGRADECIMIENTO_MISION1_PRESIDENTE,
                    RECOMPENSA_MISION1_PRESIDENTE,
                    PESO_RECOMPENSA_MISION1_PRESIDENTE
            ),
            new Mision(
                    OBJETO_MISION2_PRESIDENTE,
                    SOLICITUD_MISION2_PRESIDENTE,
                    AGRADECIMIENTO_MISION2_PRESIDENTE,
                    RECOMPENSA_MISION2_PRESIDENTE,
                    PESO_RECOMPENSA_MISION2_PRESIDENTE
            ),
            new Mision(
                    OBJETO_MISION3_PRESIDENTE,
                    SOLICITUD_MISION3_PRESIDENTE,
                    AGRADECIMIENTO_MISION3_PRESIDENTE
            ),
    };


    // Constantes para el Vendedor
    public static final String NOMBRE_VENDEDOR = "Vendedor";
    // Objetos que solicita
    public static final String OBJETO_MISION1_VENDEDOR = "chipa";
    public static final int PESO_OBJETO_MISION1_VENDEDOR = 250;
    // Di�logos de solicitud de objetos
    public static final String SOLICITUD_MISION1_VENDEDOR = "- \"Tengo las mercader�as de tu patr�n. Pero demasiado \n" +
                                                            "poco me iba a pagar. Traeme una rica chipa y te voy a \n" +
                                                            "dar la merca.\"";
    // Di�logos de agradecimiento por los objetos
    public static final String AGRADECIMIENTO_MISION1_VENDEDOR = "- \"Nde tavy, est� todo fr�o ya tu chipa socio. \n" +
                                                                 "Pero tom� igual, anike se enoja tu patr�n. \n" +
                                                                 "Con �l no hay que joder legalmente.\"";
    // Nombre y peso de cada recompensa
    public static final String RECOMPENSA_MISION1_VENDEDOR = OBJETO_MISION1_PRESIDENTE;
    public static final int PES0_RECOMPENSA_MISION1_VENDEDOR = PESO_OBJETO_MISION1_PRESIDENTE;
    // Misiones del Vendedor
    public static final Mision[] MISIONES_VENDEDOR = {
            new Mision(
                    OBJETO_MISION1_VENDEDOR,
                    SOLICITUD_MISION1_VENDEDOR,
                    AGRADECIMIENTO_MISION1_VENDEDOR,
                    RECOMPENSA_MISION1_VENDEDOR,
                    PES0_RECOMPENSA_MISION1_VENDEDOR
            ),
    };

    // Constantes para el Fantasma
    public static final String NOMBRE_FANTASMA = "Fantasma";
    public static final String OBJETO_MISION1_FANTASMA = RECOMPENSA_MISION1_PRESIDENTE;
    public static final String SOLICITUD_MISION1_FANTASMA = "- \"Otro m�s que se aprovecha de lo que yo constru�. \n" +
                                                            "Son todos iguales ustedes los pol�ticos de ahora. Por \n" +
                                                            "su ineptitud ahora este pa�s est� lleno de comunistas y \n" +
                                                            "haraganes. Hace falta que les recuerde qui�n es el \n" +
                                                            "verdadero supremo. Traeme un poncho de mi querido \n" +
                                                            "partido y por ah� perdono tu alma.\"";
    public static final String AGRADECIMIENTO_MISION1_FANTASMA = "- \"Ese Pe�a me pidi� estos papeles, tomalos. \n" +
                                                                 "No quiero tener nada que ver con esto.\"";
    public static final String RECOMPENSA_MISION1_FANTASMA = OBJETO_MISION2_PRESIDENTE;
    public static final int PESO_RECOMPENSA_MISION1_FANTASMA = PESO_OBJETO_MISION2_PRESIDENTE;
    public static final Mision[] MISIONES_FANTASMA = {
            new Mision(
                    OBJETO_MISION1_FANTASMA,
                    SOLICITUD_MISION1_FANTASMA,
                    AGRADECIMIENTO_MISION1_FANTASMA,
                    RECOMPENSA_MISION1_FANTASMA,
                    PESO_RECOMPENSA_MISION1_FANTASMA
            ),
    };
    // Di�logos
    public static final String[] DIALOGOS_FANTASMA = {
            "- \"Pod�an dormir con la ventana abierta, malagradecidos.\"",
            "- \"Comunista asqueroso.\"",
            "- \"Gustavito me avis�...\"",
            "- \"Treinta y cinco a�os al pedo.\"",
    };

    // Constantes para el Polic�a
    public static final String NOMBRE_POLICIA = "Policia";
    public static final String OBJETO_MISION1_POLICIA = Juego.OBJETO_VILLA_HAYES;
    public static final String SOLICITUD_MISION1_POLICIA = "- \"No ten�as tu luz prendida socio, eso es 4 jornales \n" +
                                                           "de multa. Pero no te vayas a preocupar, podemos arreglar, \n" +
                                                           "�cu�nto ten�s?\"";
    public static final String AGRADECIMIENTO_MISION1_POLICIA = "- \"Oima socio, pod�s irte. Hacia el norte est� \n" +
                                                                "Filadelfia, por si no pasaste quinto grado.\"";
    public static final String RECOMPENSA_MISION1_POLICIA = Juego.OBJETO_FILADELFIA;
    public static final int PESO_RECOMPENSA_MISION1_POLICIA = 50;
    public static final Mision[] MISIONES_POLICIA = {
            new Mision(
                    OBJETO_MISION1_POLICIA,
                    SOLICITUD_MISION1_POLICIA,
                    AGRADECIMIENTO_MISION1_POLICIA,
                    RECOMPENSA_MISION1_POLICIA,
                    PESO_RECOMPENSA_MISION1_POLICIA
            ),
    };

    private ConstantesPersonajesConMisiones() {
    }
}
