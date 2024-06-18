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

import juego.Juego;

/**
 * Este comando termina el juego.
 */
public class ComandoSalir extends ComandoAbstracto {

    public ComandoSalir(String descripcion) {
        super(descripcion);
    }

    /**
     * Hace que el juego termine. No se guarda ningún progreso.
     */
    public boolean ejecutar(Juego juego) {
        return false;
    }
}
