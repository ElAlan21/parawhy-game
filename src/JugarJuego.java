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

import juego.Juego;
// Project encoding: ISO-8859-9

/**
 * La única función de esta clase es contener el main().
 */
public class JugarJuego {

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
