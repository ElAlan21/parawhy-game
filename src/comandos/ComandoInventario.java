package comandos;

import juego.Juego;
import utilidades.Texto;

import java.util.HashMap;
import java.util.Set;

/**
 * Comando que muestra el inventario actual del jugador.
 */
public class ComandoInventario extends ComandoAbstracto {

    /**
     * Constructor del Comando. Recibe una descripción que explica lo que el comando hace y/o da un ejemplo de cómo
     * utilizarlo.
     *
     * @param descripcion Descripción de este comando.
     */
    public ComandoInventario(String descripcion) {
        super(descripcion);
    }

    /**
     * Muestra el inventario actual del jugador, incluyendo los objetos y su peso, así como el espacio disponible en el inventario.
     *
     * @param juego El juego en el que se está ejecutando.
     * @return true, porque el juego debe continuar.
     */
    @Override
    public boolean ejecutar(Juego juego) {
        if (juego.getObjetos().isEmpty()) {
            Texto.imprimir("No tienes nada en tu inventario.");
        } else {
            Texto.imprimir("Tienes las siguientes cosas en tu inventario:");
            imprimirObjetos(juego.getObjetos()); // Imprimimos todos los objetos
        }
        Texto.imprimir("Espacio disponible: " + juego.getEspacioDisponible() + "g");
        return true;
    }

    /**
     * Método privado para imprimir los objetos del inventario junto con su peso.
     *
     * @param objetos El mapa de objetos en el inventario.
     */
    private void imprimirObjetos(HashMap<String, Integer> objetos) {
        Set<String> nombres = objetos.keySet();
        for (String nombre : nombres) {
            Texto.imprimir("- " + nombre + " (peso: " + objetos.get(nombre) + "g)");
        }
    }
}
