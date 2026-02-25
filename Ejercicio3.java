/*Ejercicio 3 — Sensor de temperatura
Un sensor industrial registra temperaturas. El sistema recibe:

Temperatura actual en Celsius (double)
Nombre del sensor (String)
Número de lectura (int)
Si la temperatura supera el límite de 80°C, una variable boolean llamada enAlarma debe ser true.
Imprime el estado del sensor con todos sus datos. */

public class Ejercicio3 {
    public static void main(String[] args) {
        double temperatura = 85.0;
        String sensor = "Sensor A1";
        int lectura = 15;
        boolean enAlarma = temperatura > 80;

        System.out.println("Sensor: " + sensor);
        System.out.println("Lectura: " + lectura);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("En alarma: " + enAlarma);
    }
}