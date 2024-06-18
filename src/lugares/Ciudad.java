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
package lugares;

import personajes.Personaje;

import java.util.*;

/**
 * Una ciudad representa un lugar del juego. Cada ciudad puede tener otras ciudades vecinas a las que el jugador se
 * puede trasladar. Además, puede albergar a personajes con los que el jugador puede interactuar y objetos que el
 * jugador puede agarrar.
 */
public class Ciudad {
    private final String nombre;
    private final String descripcion;
    private boolean conocida = false;

    // Ciudades vecinas de esta, con dirección y ciudad respectivamente
    private final HashMap<String, Ciudad> vecinos = new HashMap<>();
    // Objetos que se encuentran en esta ciudad
    private final HashMap<String, Integer> objetos = new HashMap<>();
    // Contiene la lista de personajes de esta ciudad
    private final ArrayList<Personaje> personajes = new ArrayList<>();

    /**
     * Constante para almacenar la dirección norte en la lista de vecinos
     */
    public static final String NORTE = "norte";
    /**
     * Constante para almacenar la dirección sur en la lista de vecinos
     */
    public static final String SUR = "sur";
    /**
     * Constante para almacenar la dirección este en la lista de vecinos
     */
    public static final String ESTE = "este";
    /**
     * Constante para almacenar la dirección oeste en la lista de vecinos
     */
    public static final String OESTE = "oeste";

    /**
     * Crea una ciudad descrita como "descripción". Inicialmente, esta no existe. "Descripción" es alguna cosa como "una
     * cocina" o "la sala de descanso".
     *
     * @param nombre      nombre de la ciudad
     * @param descripcion descripción de la ciudad
     */
    public Ciudad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Retorna la descripción de esta ciudad.
     *
     * @return la descripción de la ciudad
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el atributo de conocida, que indica si el jugador ya pasó por esta ciudad al menos una vez.
     *
     * @param conocida true si el jugador ya pasó por esta ciudad
     */
    public void setConocida(boolean conocida) {
        this.conocida = conocida;
    }

    /**
     * Indica si el jugador ya ha pasado por esta ciudad antes.
     *
     * @return true si la ciudad es conocida
     */
    public boolean isConocida() {
        return conocida;
    }

    /**
     * Retorna la ciudad vecina en la dirección indicada. Si no existe, retorna null.
     *
     * @param direccion dirección de la ciudad vecina
     * @return ciudad vecina
     */
    public Ciudad getVecino(String direccion) {
        for (String direccionVecino : vecinos.keySet()) {
            if (direccionVecino.equalsIgnoreCase(direccion)) {
                return vecinos.get(direccionVecino);
            }
        }
        return null;
    }

    /**
     * Establece las ciudades vecinas de esta ciudad. Se puede visitar a los vecinos yendo a su respectiva dirección.
     * Cada ciudad vecina se asigna a una dirección específica.
     *
     * @param direcciones un array de cadenas que representan las direcciones correspondientes para llegar a cada ciudad
     *                    vecina
     * @param vecinos     un array de objetos Ciudad que representan las ciudades vecinas
     * @throws IllegalArgumentException si los arrays 'ciudades' y 'direcciones' no tienen la misma longitud
     */
    public void setVecinos(String[] direcciones, Ciudad[] vecinos) {
        if (direcciones.length != vecinos.length) {
            throw new IllegalArgumentException("Los arrays de 'ciudades' y 'direcciones' deben tener la misma longitud.");
        }
        for (int index = 0; index < direcciones.length; index++) {
            this.vecinos.put(direcciones[index].toLowerCase(), vecinos[index]);
        }
    }

    /**
     * Agrega una nueva ciudad vecina en la dirección especificada.
     *
     * @param direccion dirección de la nueva ciudad vecina
     * @param vecino    ciudad de clase Ciudad a la que podrá dirigirse el usuario
     */
    public void addVecino(String direccion, Ciudad vecino) {
        vecinos.put(direccion.toLowerCase(), vecino);
    }

    /**
     * Retorna true si esta ciudad tiene como vecina a la ciudad ingresada.
     *
     * @param vecino ciudad a evaluar
     * @return true si la ciudad es vecina de esta, false si no
     */
    public boolean hasVecino(Ciudad vecino) {
        return vecinos.containsValue(vecino);
    }

    /**
     * Retorna true si esta ciudad tiene un vecino en la dirección ingresada.
     *
     * @param direccion direccion a evaluar
     * @return true si la ciudad tiene un vecino en esta direccion
     */
    public boolean hasVecino(String direccion) {
        return vecinos.containsKey(direccion.toLowerCase());
    }

    /**
     * Agrega un objeto a esta ciudad. Los objetos siempre estarán en minúscula.
     *
     * @param nombre nombre del objeto
     * @param peso   peso del objeto
     */
    public void addObjeto(String nombre, int peso) {
        objetos.put(nombre.toLowerCase(), peso);
    }

    /**
     * Intenta remover un objeto.
     *
     * @param nombre nombre del objeto
     */
    public void removeObjeto(String nombre) {
        objetos.remove(nombre.toLowerCase());
    }


    /**
     * Retorna el peso del objeto indicado.
     *
     * @param nombre nombre del objeto cuyo peso se desea conocer
     * @return el peso del objeto, null si el objeto no se encuentra en la ciudad
     */
    public int getPesoDeObjeto(String nombre) {
        return objetos.get(nombre.toLowerCase());
    }

    /**
     * Indica si el objeto se encuentra en la ciudad
     *
     * @param nombre nombre del objeto a buscar
     * @return true si y solo si el objeto está en la ciudad
     */
    public boolean hasObjeto(String nombre) {
        return objetos.containsKey(nombre.toLowerCase());
    }

    /**
     * Devuelve el personaje de esta ciudad que tenga el nombre ingresado o null si dicho personaje no se encuentra en
     * esta ciudad
     *
     * @param nombre nombre del personaje a buscar
     * @return el personaje o null si no está
     */
    public Personaje getPersonaje(String nombre) {
        for (Personaje personaje : personajes) {
            if (personaje.getNombre().equalsIgnoreCase(nombre)) {
                return personaje;
            }
        }
        return null;
    }

    /**
     * Agrega un personaje a la ciudad.
     *
     * @param personaje personaje que va a estar en esta ciudad
     */
    public void addPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    /**
     * Indica si el personaje con el nombre ingresado se encuentra en la ciudad.
     *
     * @param nombre nombre del personaje a buscar
     * @return true si el personaje se encuentra en esta ciudad
     */
    public boolean hasPersonaje(String nombre) {
        return getPersonaje(nombre) != null;
    }

    /**
     * Retorna una descripción extensa de esta ciudad. Con su nombre, direcciones de salida, objetos y personajes.
     *
     * @return un String con la información extensa de esta ciudad
     */
    public String informacion() {
        return "* Ciudad actual = " + nombre + "\n"
               + textoDirecciones() + "\n"
               + textoObjetos() + "\n"
               + textoPersonajes();
    }

    /**
     * Retorna un String con todas las direcciones posibles para salir de esta ciudad.
     *
     * @return las direcciones de las ciudades vecinas de esta ciudad
     */
    public String textoDirecciones() {
        StringBuilder textoSalidas = new StringBuilder("* Direcciones =");

        // Verificamos si hay o no salidas de esta ciudad
        if (vecinos.isEmpty()) {
            textoSalidas.append(" no se puede ir a ninguna parte");
            return textoSalidas.toString();
        }
        for (String key : vecinos.keySet()) {
            textoSalidas.append(" | ").append(key);
        }
        return textoSalidas.toString();
    }

    /**
     * Retorna un String con todos los objetos que tiene esta ciudad.
     *
     * @return los objetos en esta ciudad
     */
    public String textoObjetos() {
        StringBuilder textoObjetos = new StringBuilder("* Objetos =");

        // Verificamos si hay o no objetos en esta ciudad
        if (objetos.isEmpty()) {
            textoObjetos.append(" no hay nada aquí");
        } else {
            for (String objeto : objetos.keySet()) {
                textoObjetos.append(" | ").append(objeto).append(" (peso: ").append(objetos.get(objeto)).append("g)");
            }
        }
        return textoObjetos.toString();
    }

    /**
     * Retorna un String con todos los personajes presentes en esta ciudad.
     *
     * @return los personajes en esta ciudad
     */
    public String textoPersonajes() {
        StringBuilder textoPersonajes = new StringBuilder("* Personajes =");

        // Verificamos si hay o no personajes en esta ciudad
        if (personajes.isEmpty()) {
            textoPersonajes.append(" no hay nadie aquí");
            return textoPersonajes.toString();
        }
        for (Personaje personaje : personajes) {
            textoPersonajes.append(" | ").append(personaje.getNombre());
        }
        return textoPersonajes.toString();
    }
}
