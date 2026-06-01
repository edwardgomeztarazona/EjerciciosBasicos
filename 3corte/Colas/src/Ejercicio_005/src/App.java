/*5. Fábrica de Pedidos (E-commerce)
Una tienda en línea recibe pedidos de manera continua. Cada pedido ingresa a una cola central de procesamiento. El sistema de bodega toma los pedidos en orden de llegada para preparar el envío. Si un pedido ya fue cancelado por el cliente, debe ser descartado automáticamente al momento de ser procesado.

La Clase Pedido (Nodo): Debe contener numeroPedido (String), cliente (String), totalPagar (double) y cancelado (boolean).
El Problema: La bodega necesita procesar solo los pedidos vigentes. Los cancelados deben ser eliminados sin ser despachados, pero registrados en un conteo.
Reto: Implementa un método procesarPedidos() que recorra y vacíe la cola. Para cada pedido: si cancelado = true, lo descarta e incrementa un contador de cancelados; si cancelado = false, lo "despacha" imprimiendo sus datos. Al finalizar, muestra el total despachado y el total cancelado. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ColaPedidos cola = new ColaPedidos();

        Scanner scanner = new Scanner(System.in);

        // Pedidos iniciales
        cola.enqueue(new Pedido("P001", "Juan Perez", 120000, false));
        cola.enqueue(new Pedido("P002", "Maria Gomez", 85000, true));
        cola.enqueue(new Pedido("P003", "Carlos Ruiz", 45000, false));
        cola.enqueue(new Pedido("P004", "Ana Torres", 99000, true));
        cola.enqueue(new Pedido("P005", "Luis Fernandez", 150000, false));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE PEDIDOS E-COMMERCE ---");
            System.out.println("1. Ver pedidos en cola");
            System.out.println("2. Registrar pedido");
            System.out.println("3. Procesar un pedido");
            System.out.println("4. Procesar todos los pedidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    cola.imprimir();

                    break;

                case 2:

                    System.out.print("Número de Pedido: ");
                    String numero = scanner.nextLine();

                    System.out.print("Cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Total a Pagar: ");
                    double total = scanner.nextDouble();

                    System.out.print("¿Está cancelado? (true/false): ");
                    boolean cancelado = scanner.nextBoolean();

                    cola.enqueue(
                        new Pedido(
                            numero,
                            cliente,
                            total,
                            cancelado
                        )
                    );

                    System.out.println("Pedido registrado correctamente.");

                    break;

                case 3:

                    Pedido pedido = cola.dequeue();

                    if (pedido != null) {

                        System.out.println("\nPedido procesado:");
                        System.out.println("Número: " + pedido.numeroPedido);
                        System.out.println("Cliente: " + pedido.cliente);
                        System.out.println("Total: $" + pedido.totalPagar);
                        System.out.println("Cancelado: " + pedido.cancelado);
                    }

                    break;

                case 4:

                    cola.procesarPedidos();

                    break;

                case 5:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}