/*Ejercicio 10 — Copiando configuración
Una app tiene un objeto int[] configuracion = {1920, 1080, 60} (resolución y FPS).

Crea una copia real del arreglo (no una referencia) usando un nuevo arreglo y copiando elemento por elemento.
Modifica la copia y demuestra que el original no cambia.
Comenta la diferencia con la asignación directa.
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] configuracion = {1920, 1080, 60};
        int[] copia = new int[configuracion.length];

        for (int i = 0; i < configuracion.length; i++) {
            copia[i] = configuracion[i];
        }

        copia[0] = 1280;

        System.out.println("Original: " + configuracion[0]);
        System.out.println("Copia: " + copia[0]);
    }
}