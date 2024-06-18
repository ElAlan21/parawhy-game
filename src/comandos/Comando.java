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

import java.util.*;

/**
 * Esta interface representa el comando emitido por el usuario.
 */
public interface Comando {

    /**
     * Ejecuta el comando sobre un juego dado. Este método modifica al juego (generalmente).
     *
     * @param juego el juego en el que se está ejecutando
     * @return true si el juego debe continuar, false si no
     */
    boolean ejecutar(Juego juego);

    /**
     * Devuelve un String que representa la descripción del comando.
     *
     * @return descripción de este comando
     */
    String getDescripcion();

    /**
     * Le dice al comando cuáles son las palabras del comando. Por ejemplo, una lista con "ir" y "norte" La primera
     * palabra siempre es el comando mismo.
     *
     * @param palabras las palabras utilizadas en el comando
     */
    void setPalabras(List<String> palabras);

    /**
     * Retorna las palabras utilizadas en el comando. Por ejemplo, una lista con "ir" y "norte".
     *
     * @return lista de palabras para el comando
     */
    List<String> getPalabras();

    /**
     * Devuelve una copia del comando.
     *
     * @return una copia de este comando
     */
    Comando copiar();

}
