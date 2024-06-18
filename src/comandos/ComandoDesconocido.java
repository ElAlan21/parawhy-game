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
import utilidades.Texto;

/**
 * Este comando es utilizado cuando el sistema no reconoce el comando pedido por el usuario. Emite un mensaje para
 * decirle al usuario sus errores.
 */
public class ComandoDesconocido extends ComandoAbstracto {
    public ComandoDesconocido() {
        super("Comando Desconocido");
    }

    /**
     * Imprime un mensaje de error.
     */
    public boolean ejecutar(Juego juego) {
        String comandoNoReconocido = getPalabras().get(0);
        if (comandoNoReconocido != null) {
            Texto.imprimir("El comando \"" + comandoNoReconocido + "\" no se reconoce.");
        } else {
            Texto.imprimir("Error: comando nulo.");
        }
        return true;
    }
}
