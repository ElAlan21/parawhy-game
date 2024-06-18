/*
 * Universidad Nacional de Itap�a.
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
import comandos.FabricaDeComandos;
import utilidades.Texto;

import java.io.*;

/**
 * Esta clase es parte de Parawhy. Parawhy es un simple juego de aventuras basado en texto. "Parser" es una palabra
 * t�cnica que se refiere a la parte del programa (por ejemplo, un compilador) que descompone texto y lo traduce a una
 * representaci�n m�s manejable. Este Parser lee lo que ingresa el usuario e intenta interpretarlo como un comando del
 * juego. Cada vez que es llamado, lee una l�nea de la terminal y lo intenta interpretar como un comando de dos
 * palabras. Retorna el comando como un objeto de tipo Comando. El Parser tiene un conjunto de fabricaDeComandos
 * conocidos. Revisa lo que ingresa el usuario con base en esos fabricaDeComandos conocidos, y si el comando no es
 * conocido, devuelve un objeto de tipo comando que es marcado como comando desconocido.
 */
public class Parser {
    private final FabricaDeComandos fabricaDeComandos; //  Dado un par de palabras, crea el comando respectivo

    /**
     * Constructor del Parser, inicializa la f�brica de comandos.
     */
    public Parser() {
        fabricaDeComandos = new FabricaDeComandos();
    }

    /**
     * Le pide al usuario que ingrese algo y espera hasta que el usuario lo haga una vez ingresada la l�nea, se
     * interpreta y se retorna un comando con base en lo interpretado.
     *
     * @return un comando
     */
    public Comando getComando() {
        String lineaIngresada; // Contendr� la l�nea entera
        String palabra1 = "";
        String palabra2 = null;
        String palabra3 = null;

        Texto.imprimirSinSalto("> "); // print prompt
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            lineaIngresada = reader.readLine();
            // Partir la l�nea en pedazos con String.split()
            String[] palabrasArray = lineaIngresada.split("\\s+");
            if (palabrasArray.length > 0) {
                palabra1 = palabrasArray[0]; // Obtener la primera palabra
            }
            if (palabrasArray.length > 1) {
                palabra2 = palabrasArray[1]; // Obtener la segunda palabra
            }
            if (palabrasArray.length > 2) {
                palabra3 = palabrasArray[2]; // Obtener la segunda palabra
            }
            // Dar las palabras a la f�brica para que este cree los comandos respectivos
            return fabricaDeComandos.crearComando(palabra1, palabra2, palabra3);
        } catch (IOException exc) {
            Texto.imprimir("Error en el Parser durante la lectura: " + exc.getMessage());
        }
        // Si el comando no es v�lido o hubo alguna falla, retornar el comando "desconocido"
        return fabricaDeComandos.crearComandoDesconocido();
    }
}
