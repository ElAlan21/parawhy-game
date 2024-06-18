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
 * Esta clase implementa lo básico de la interfaz Comando. Es la base para todos los comandos.
 */
public abstract class ComandoAbstracto implements Comando, Cloneable {

    private List<String> palabras;
    private final String descripcion;

    /**
     * Constructor del Comando. Recibe una descripción, que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion descripción de este comando
     */
    public ComandoAbstracto(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setPalabras(List<String> palabras) {
        if (palabras == null || palabras.isEmpty()) {
            throw new IllegalArgumentException("La lista no debe ser nula ni estar vacía.");
        }
        this.palabras = Collections.unmodifiableList(palabras);
    }

    @Override
    public List<String> getPalabras() {
        if (this.palabras == null || this.palabras.isEmpty()) {
            throw new IllegalStateException("Palabras no inicializadas correctamente.");
        }
        return this.palabras;
    }

    @Override
    public Comando copiar() {
        try {
            return (Comando) clone();
        } catch (CloneNotSupportedException ex) {
            // Tontería del API de Java
            throw new IllegalStateException("No se puede clonar", ex);
        }
    }

}
