/*
 * Universidad Nacional de Itapúa.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1
 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Alan Valenzuela
 *
 */
package comandos;

import java.util.*;

/**
 * La fábrica de comandos centraliza todas las acciones relacionadas con los comandos. Contiene una lista de todos los
 * comandos conocidos con sus respectivos nombres. Además, es capaz de crear y devolver una copia de cualquier comando
 * conocido con el método {@link #crearComando(String, String, String)}.
 */
public class FabricaDeComandos {
    private final HashMap<String, Comando> comandosConocidos = new HashMap<>();

    // No te olvides de incluir esto en la lista de comandos conocidos
    private static final String AGARRAR = "agarrar";
    private static final String ATRAS = "atras";
    private static final String AYUDA = "ayuda";
    private static final String DAR = "dar";
    private static final String DEJAR = "dejar";
    private static final String HABLAR = "hablar";
    private static final String INVENTARIO = "inventario";
    private static final String INFO = "info";
    private static final String IR = "ir";
    private static final String SALIR = "salir";

    // Ejemplos de cómo usar cada comando
    private static final String DESCRIPCION_AGARRAR = "agarrar [objeto] / agarrar chipa";
    private static final String DESCRIPCION_ATRAS = "atras";
    private static final String DESCRIPCION_AYUDA = "ayuda";
    private static final String DESCRIPCION_DAR = "dar [objeto] [personaje] / dar chipa presidente";
    private static final String DESCRIPCION_DEJAR = "dejar [objeto] / dejar chipa";
    private static final String DESCRIPCION_HABLAR = "hablar [personaje] / hablar presidente";
    private static final String DESCRIPCION_INVENTARIO = "inventario";
    private static final String DESCRIPCION_INFO = "info";
    private static final String DESCRIPCION_IR = "ir [direccion] / ir sur";
    private static final String DESCRIPCION_SALIR = "salir";

    /**
     * Constructor - inicializa los comandos.
     */
    public FabricaDeComandos() {
        /*
        Para agregar un comando nuevo tienes que:
        1. Crear una nueva clase de comando.
        2. Crear una nueva constante en esta clase que indica el nombre del comando que va a usar el usuario.
        3. No olvidarte de incluirlo en el mapa comandosConocidos.
         */
        this.comandosConocidos.put(AGARRAR, new ComandoAgarrar(DESCRIPCION_AGARRAR));
        this.comandosConocidos.put(AYUDA, new ComandoAyuda(DESCRIPCION_AYUDA));
        this.comandosConocidos.put(ATRAS, new ComandoAtras(DESCRIPCION_ATRAS));
        this.comandosConocidos.put(DAR, new ComandoDar(DESCRIPCION_DAR));
        this.comandosConocidos.put(DEJAR, new ComandoDejar(DESCRIPCION_DEJAR));
        this.comandosConocidos.put(HABLAR, new ComandoHablar(DESCRIPCION_HABLAR));
        this.comandosConocidos.put(INFO, new ComandoInfo(DESCRIPCION_INFO));
        this.comandosConocidos.put(INVENTARIO, new ComandoInventario(DESCRIPCION_INVENTARIO));
        this.comandosConocidos.put(IR, new ComandoIr(DESCRIPCION_IR));
        this.comandosConocidos.put(SALIR, new ComandoSalir(DESCRIPCION_SALIR));
    }

    /**
     * Crea un comando a base de tres palabras. Los comandos pueden o no usar todas las tres palabras ingresadas.
     * <ol>
     *      <li>La primera palabra indica qué comando usar, por ejemplo "ir" o "dar".</li>
     *      <li>La segunda palabra es un dato adicional para el comando invocado, por ejemplo "norte" o "dinero".</li>
     *      <li>La tercera palabra es otro dato adicional, por ejemplo "policía".</li>
     * </ol>
     *  Estos comandos de ejemplo serían, respectivamente, "ir norte" y "dar dinero policía", cada comando
     * decide si requiere o no las tres palabras.
     *
     * @param principal   la palabra principal del comando, puede ser el verbo. Por ejemplo: "dar"
     * @param complemento la palabra complemento del comando, puede ser un sustantivo. Por ejemplo: "dinero"
     * @param adicional   una palabra adicional del comando, puede ser otro sustantivo. Por ejemplo: "policía"
     * @return el comando creado
     */
    public Comando crearComando(String principal, String complemento, String adicional) {
        Comando comando = comandosConocidos.get(principal.toLowerCase());
        if (comando == null) {
            comando = crearComandoDesconocido();
        } else {
            // No queremos modificar nuestra version original, hacemos una copia para que no afecte en el futuro.
            comando = comando.copiar();
        }
        comando.setPalabras(Arrays.asList(principal, complemento, adicional));
        return comando;

    }

    /**
     * Crea un comando de tipo ComandoDesconocido.
     *
     * @return un comando de tipo ComandoDesconocido
     */
    public Comando crearComandoDesconocido() {
        return new ComandoDesconocido();
    }

    /**
     * Retorna el mapa con todos los comandos conocidos.
     *
     * @return los comandos conocidos
     */
    public HashMap<String, Comando> getComandosConocidos() {
        return comandosConocidos;
    }
}
