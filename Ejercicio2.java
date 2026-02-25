/*Ejercicio 2 — Calculadora de una tienda
Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

Precio unitario de un producto (double)
Cantidad comprada (int)
Descuento aplicado en porcentaje (double)
Total a pagar después del descuento
Declara las variables, realiza el cálculo y muestra el resultado por consola.*/

public class Ejercicio2 {
    public static void main(String[] args) {
        double precioUnitario = 2500.0;
        int cantidad = 4;
        double descuento = 10.0;

        double subtotal = precioUnitario * cantidad;
        double total = subtotal - (subtotal * descuento / 100);

        System.out.println("Total a pagar: " + total);
    }
}