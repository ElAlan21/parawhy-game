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

import juego.Juego;
import utilidades.Texto;


/**
 * Este comando muestra imprime ayuda al usuario. Esto incluye todos los comandos disponibles.
 */
public class ComandoAyuda extends ComandoAbstracto {
    private static final String AYUDA = "Estás en Paraguay, hay varias ciudades para recorrer. Puedes" +
                                        "\nescribir cualquiera de los siguientes comandos: ";

    /**
     * Constructor del Comando. Recibe una descripción, que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion descripción de este comando
     */
    public ComandoAyuda(String descripcion) {
        super(descripcion);
    }

    /**
     * Imprime a la pantalla una pequeña información y, además, todos los comandos disponibles con un pequeño ejemplo de
     * su uso.
     *
     * @param juego el juego en el que se está ejecutando
     * @return true, porque el juego debe continuar
     */
    public boolean ejecutar(Juego juego) {
        Texto.imprimir(AYUDA);
        // Imprimir todos los comandos
        FabricaDeComandos fabrica = new FabricaDeComandos();
        HashMap<String, Comando> comandosConocidos = fabrica.getComandosConocidos();
        for (Map.Entry<String, Comando> entrada : comandosConocidos.entrySet()) {
            String nombre = entrada.getKey();
            String descripcionComando = entrada.getValue().getDescripcion();
            Texto.imprimir("- " + nombre + " => " + descripcionComando);
        }
        return true;
    }

}
