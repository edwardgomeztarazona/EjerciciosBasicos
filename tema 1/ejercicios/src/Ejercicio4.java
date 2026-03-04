/*Ejercicio 4 — Placa de un vehículo
El RUNT almacena datos básicos de vehículos. Modela la información de un carro con:

Placa (String)
Año de fabricación (int)
Cilindraje en cc (int)
Precio de compra (double)
Inicial del color (char)
Si tiene SOAT vigente (boolean)
Muestra todos los datos en consola. */

public class Ejercicio4 {
    public static void main(String[] args) {
        String placa = "ABC123";
        int anio = 2022;
        int cilindraje = 1600;
        double precioCompra = 45000000;
        char inicialColor = 'R';
        boolean soatVigente = true;

        System.out.println("Placa: " + placa);
        System.out.println("Año: " + anio);
        System.out.println("Cilindraje: " + cilindraje);
        System.out.println("Precio: " + precioCompra);
        System.out.println("Color: " + inicialColor);
        System.out.println("SOAT vigente: " + soatVigente);
    }
}