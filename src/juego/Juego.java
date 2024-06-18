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
package juego;

import comandos.Comando;
import lugares.Ciudad;
import personajes.Personaje;
import personajes.PersonajeConMisiones;
import utilidades.Texto;
import utilidades.Tiempo;

import static juego.ConstantesCiudades.*;
import static juego.ConstantesPersonajes.*;
import static juego.ConstantesPersonajesConMisiones.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta es la clase principal para el juego "Parawhy". Parawhy es un juego de aventuras, simple y basado en texto. En
 * esta version, los usuarios pueden recorrer algunas ciudades. Para jugarlo, se debe crear una instancia de esta clase
 * y llamar el método {@link #jugar()}. Esta clase inicializa a todas las otras, aquí empieza todo: crea todas las
 * ciudades, crea los parsers (objetos que interpretan texto) y comienza el juego. También evalúa los comandos que
 * devuelve el parser.
 */
public class Juego {
    private final Parser parser = new Parser();
    private final HashMap<String, Integer> objetos = new HashMap<>(); // Inventario, con el nombre y peso
    private final ArrayList<Ciudad> historialDeCiudades = new ArrayList<>();
    private Ciudad ciudadActual = null;
    private Ciudad asuncion = null;
    private Ciudad villaHayes = null;
    private Ciudad filadelfia = null;
    protected static final String OBJETO_VILLA_HAYES = "dinero"; // Objeto que desbloquea la ciudad de Villa Hayes
    protected static final String OBJETO_FILADELFIA = "licencia"; // Objeto que desbloquea la ciudad de Filadelfia
    private static final int PESO_MAXIMO = 500; // Peso máximo que puede cargar el jugador, expresado en gramos

    /**
     * Crea el juego e inicializa su mapa interno.
     */
    public Juego() {
        crearMundo();
    }

    /**
     * Crea todo el mundo inicial. Primero crea las ciudades y las enlaza al establecer los vecinos de cada una. Luego,
     * crea los personajes y los pone en las ciudades. Por último, determinamos la ciudad en la que iniciar el juego.
     */
    private void crearMundo() {
        // Crear las ciudades
        Ciudad villarrica = new Ciudad(NOMBRE_VILLARRICA, DESCRIPCION_VILLARRICA);
        Ciudad encarnacion = new Ciudad(NOMBRE_ENCARNACION, DESCRIPCION_ENCARNACION);
        Ciudad pilar = new Ciudad(NOMBRE_PILAR, DESCRIPCION_PILAR);
        Ciudad ciudadDelEste = new Ciudad(NOMBRE_CIUDAD_DEL_ESTE, DESCRIPCION_CIUDAD_DEL_ESTE);
        this.asuncion = new Ciudad(NOMBRE_ASUNCION, DESCRIPCION_ASUNCION);

        // Establecer los vecinos de cada ciudad, de esta forma vinculamos unas ciudades con otras
        villarrica.setVecinos(
                new String[]{Ciudad.SUR, Ciudad.ESTE, Ciudad.OESTE},
                new Ciudad[]{encarnacion, ciudadDelEste, asuncion}
        );
        encarnacion.setVecinos(
                new String[]{Ciudad.NORTE, Ciudad.OESTE},
                new Ciudad[]{villarrica, pilar}
        )
        ;
        pilar.setVecinos(
                new String[]{Ciudad.NORTE, Ciudad.ESTE},
                new Ciudad[]{asuncion, encarnacion}
        );
        ciudadDelEste.setVecinos(
                new String[]{Ciudad.OESTE},
                new Ciudad[]{villarrica}
        );
        asuncion.setVecinos(
                new String[]{Ciudad.SUR, Ciudad.ESTE},
                new Ciudad[]{pilar, villarrica}
        );
        // Agrega los objetos al mundo
        pilar.addObjeto(OBJETO_MISION1_VENDEDOR, PESO_OBJETO_MISION1_VENDEDOR);
        encarnacion.addObjeto(TERERE, PESO_TERERE);
        asuncion.addObjeto(EMPANADAS, PESO_EMPANADAS);
        // Crear los personajes
        PersonajeConMisiones presidente = new PersonajeConMisiones(NOMBRE_PRESIDENTE, MISIONES_PRESIDENTE);
        PersonajeConMisiones vendedor = new PersonajeConMisiones(NOMBRE_VENDEDOR, MISIONES_VENDEDOR);
        PersonajeConMisiones fantasma = new PersonajeConMisiones(NOMBRE_FANTASMA, MISIONES_FANTASMA, DIALOGOS_FANTASMA);
        Personaje perro = new Personaje(NOMBRE_PERRO, DIALOGOS_PERRO);
        Personaje chipera = new Personaje(NOMBRE_CHIPERA, DIALOGOS_CHIPERA);
        // Poner a los personajes en sus respectivas ciudades
        asuncion.addPersonaje(presidente);
        ciudadDelEste.addPersonaje(vendedor);
        villarrica.addPersonaje(perro);
        encarnacion.addPersonaje(fantasma);
        pilar.addPersonaje(chipera);
        // Empezar el juego en Villarrica
        ciudadActual = villarrica;
    }

    /**
     * Rutina principal: jugar. Itera hasta el fin del juego.
     */
    public void jugar() {
        imprimirBienvenida();
        // Jugar hasta que un comando me diga que ya no quiere jugar más
        boolean continuar = true;
        while (continuar) {
            Comando comando = parser.getComando();
            Texto.imprimir(); // Línea en blanco, para mejor legibilidad
            continuar = comando.ejecutar(this);
        }
        imprimirDespedida();
    }

    /**
     * Devuelve la ciudad en la que se encuentra el jugador actualmente.
     *
     * @return ciudad actual del jugador
     */
    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    /**
     * Cambia la ciudad en la que se encuentra el jugador. Si esta es la ciudad de Filadelfia, el juego termina, pues
     * esta ciudad es la última del juego. Retorna true si el juego debe continuar y false si ya se llegó a la última
     * ciudad, que es Filadelfia.
     *
     * @param ciudadActual nueva ciudad para el jugador
     */
    public void setCiudadActual(Ciudad ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    /**
     * Retorna la ciudad de Filadelfia, que es la última del juego.
     *
     * @return la ciudad de filadelfia, null si esta aún no está desbloqueada
     */
    public Ciudad getFiladelfia() {
        return filadelfia;
    }

    /**
     * Devuelve el mapa de objetos que se encuentran en el inventario del jugador. Cada entrada contiene el nombre y
     * peso respectivamente.
     *
     * @return mapa de objetos del jugador
     */
    public HashMap<String, Integer> getObjetos() {
        return objetos;
    }

    /**
     * Intenta agregar un objeto al inventario del jugador. Si no se tiene suficiente espacio disponible, retorna false.
     * Además, si dicho objeto coincide con {@link #OBJETO_VILLA_HAYES} o {@link #OBJETO_FILADELFIA}, se desbloqueará
     * Villa Hayes o Filadelfia, respectivamente.
     *
     * @param nombre nombre del objeto a agregar
     * @param peso   peso del objeto a agregar
     * @return true si se agregó con éxito al inventario, false si no hay suficiente espacio
     */
    public final boolean addObjeto(String nombre, int peso) {
        if (peso > getEspacioDisponible()) {
            return false;
        }
        if (nombre.equalsIgnoreCase(OBJETO_VILLA_HAYES)) {
            desbloquearVillaHayes();
        }
        if (nombre.equalsIgnoreCase(OBJETO_FILADELFIA)) {
            desbloquearFiladelfia();
        }
        objetos.put(nombre.toLowerCase(), peso);
        return true;
    }

    /**
     * Indica si ya hay un objeto con el mismo nombre en el inventario del jugador.
     *
     * @param nombre nombre del objeto que se quiere encontrar
     * @return true si el jugador ya tiene un objeto con el mismo nombre en su inventario
     */
    public boolean hasObjeto(String nombre) {
        return objetos.containsKey(nombre.toLowerCase());
    }

    /**
     * Remueve un objeto del inventario del jugador.
     *
     * @param nombre nombre del objeto a remover
     * @return el peso del objeto eliminado, null si no se encontró el objeto de nombre dado (un valor null también
     * puede indicar que el peso de dicho objeto era nulo)
     */
    public int removeObjeto(String nombre) {
        return objetos.remove(nombre.toLowerCase());
    }

    /**
     * Devuelve el espacio que tiene disponible el jugador, en gramos. Es la diferencia entre el {@link #PESO_MAXIMO} y
     * el peso de todos los objetos de su inventario.
     *
     * @return espacio disponible en el inventario
     */
    public int getEspacioDisponible() {
        int pesoTotal = 0;

        for (int peso : getObjetos().values()) {
            pesoTotal += peso;
        }
        return PESO_MAXIMO - pesoTotal;
    }

    /**
     * Agrega una ciudad al historial de ciudades. Este historial es útil para poder volver a las ciudades de las que
     * vinimos.
     *
     * @param ciudad ciudad para agregar al historial de ciudades
     */
    public void addToHistorial(Ciudad ciudad) {
        historialDeCiudades.add(ciudad);
    }

    /**
     * Retorna y elimina la última entrada del historial de ciudades. Esto es, la ciudad de la que el jugador vino.
     * Además, la elimina del historial.
     *
     * @return la ciudad de la que el jugador acaba de venir
     */
    public Ciudad readCiudadAnterior() {
        if (historialDeCiudades.isEmpty()) {
            return null;
        }
        return historialDeCiudades.remove(historialDeCiudades.size() - 1);
    }

    /**
     * Desbloquea la ciudad de Villa Hayes. Esta se encuentra al norte de Asunción.
     */
    private void desbloquearVillaHayes() {
        this.villaHayes = new Ciudad(NOMBRE_VILLA_HAYES, DESCRIPCION_VILLA_HAYES);
        PersonajeConMisiones policia = new PersonajeConMisiones(NOMBRE_POLICIA, MISIONES_POLICIA);
        Personaje pombero = new Personaje(NOMBRE_POMBERO, DIALOGOS_POMBERO);

        villaHayes.addPersonaje(policia);
        villaHayes.addPersonaje(pombero);
        villaHayes.addVecino(Ciudad.SUR, asuncion);
        asuncion.addVecino(Ciudad.NORTE, villaHayes);
    }

    /**
     * Desbloquea la ciudad de Filadelfia. Esta se encuentra al norte de Villa Hayes. Es la última ciudad del juego.
     */
    private void desbloquearFiladelfia() {
        this.filadelfia = new Ciudad(NOMBRE_FILADELFIA, DESCRIPCION_FILADELFIA);

        if (villaHayes != null) {
            villaHayes.addVecino(Ciudad.NORTE, filadelfia);
        }
    }

    /**
     * Imprime a la terminal el mensaje de bienvenida del jugador.
     */
    private void imprimirBienvenida() {
        final String BIENVENIDA = "¡Bienvenido a Parawhy! Este es un juego de aventuras \n" +
                                  "con un mapa basado en la República del Paraguay.\n" +
                                  "Escribe \"ayuda\" si no sabes cómo jugar.\n" +
                                  "Escribe \"ir\" para viajar a alguna parte.\n";

        Texto.imprimir(BIENVENIDA);
        Texto.imprimir(ciudadActual.getDescripcion());
        ciudadActual.setConocida(true); // La ciudad ya se conoce, no vuelvas a imprimir su descripción
        Texto.imprimir(ciudadActual.informacion());
    }

    /**
     * Mensaje que se imprime al cerrar el juego.
     */
    private void imprimirDespedida() {
        final String DESPEDIDA = "¡Gracias por jugar Parawhy! ¡Hasta luego!";

        Texto.imprimir(DESPEDIDA);
    }

    /**
     * Mensaje que se imprime para finalizar la historia del juego.
     */
    public void imprimirFinalDelJuego() {
        final int MILISEGUNDOS_ENTRE_ORACIONES = 2500;
        final String[] oraciones = new String[]{
                "Por fin llegas a Filadelfia.",
                "Vas a la ubicación que te mandó el presidente.",
                "El sudor de tu frente cae sobre un mediano paquete...",
                "que acabas de desenterrar a un costado de la ruta.",
                "Subes las cajas a tu automóvil y manejas hasta el helipuerto.",
                "Entras al helicóptero cuidando las cajas como a tu propia vida.",
                "'Vicepresidente'.",
                "Ya falta poco, un último favor, en Asunción te espera tu carrera.",
                "En medio del viaje sientes una turbulencia.",
                "Antes de que te des cuenta, tú y el piloto están cayendo al árido monte chaqueño.",
                "Te usaron, te engañaron, no serás el primer ni el último político en caer así.",
                "Contigo mueren tus sueños de ser ministro...",
                "\nFin.\n"
        };

        for (String oracion : oraciones) {
            Texto.imprimir(oracion);
            Tiempo.esperar(MILISEGUNDOS_ENTRE_ORACIONES);
        }
    }
}
