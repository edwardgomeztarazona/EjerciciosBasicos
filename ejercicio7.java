/*Un almacén tiene un arreglo con el stock de 5 productos. El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

Crea el arreglo stockAlmacen con valores iniciales.
Asigna stockReportes = stockAlmacen.
Simula una venta reduciendo el stock de un producto desde stockReportes.
Muestra que stockAlmacen también cambió y explica en comentarios por qué. */

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] stockAlmacen = {10, 20, 30, 40, 50};
        int[] stockReportes = stockAlmacen;

        stockReportes[2] -= 5;

        for (int s : stockAlmacen) {
            System.out.print(s + " ");
        }

        // Cambia también porque ambos apuntan al mismo arreglo en memoria
    }
}