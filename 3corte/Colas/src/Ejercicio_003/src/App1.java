/*3. Impresora Compartida (Red de Oficina)

En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que fueron recibidos.

- **La Clase Documento (Nodo):** Debe contener `nombreArchivo` (String), `usuario` (String), `numeroPaginas` (int) y `esColor` (boolean).
- **El Problema:** Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.
- **Reto:** Implementa un método `calcularPaginasTotales()` que recorra la cola y retorne la suma de `numeroPaginas` de todos los documentos en espera, sin alterar la cola. */

import java.util.Scanner;

public class App1 {
    public static void main(String[] args) throws Exception {
        
        ColaImpresion cola = new ColaImpresion();

        Scanner scanner = new Scanner(System.in);

        // Documentos iniciales
        cola.enqueue(new Documento("PlanoCasa.pdf", "Juan", 10, true));
        cola.enqueue(new Documento("Contrato.docx", "Maria", 5, false));
        cola.enqueue(new Documento("Diseño3D.png", "Carlos", 12, true));
        cola.enqueue(new Documento("Informe.pdf", "Ana", 7, false));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE IMPRESIÓN ---");
            System.out.println("1. Ver documentos en cola");
            System.out.println("2. Agregar documento");
            System.out.println("3. Imprimir documento");
            System.out.println("4. Calcular páginas totales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    cola.imprimir();

                    break;

                case 2:

                    System.out.print("Nombre del archivo: ");
                    String archivo = scanner.nextLine();

                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();

                    System.out.print("Número de páginas: ");
                    int paginas = scanner.nextInt();

                    System.out.print("¿Es a color? (true/false): ");
                    boolean color = scanner.nextBoolean();

                    cola.enqueue(new Documento(archivo, usuario, paginas, color));

                    System.out.println("Documento agregado correctamente.");

                    break;

                case 3:

                    Documento impreso = cola.dequeue();

                    if (impreso != null) {

                        System.out.println("\nImprimiendo documento:");
                        System.out.println("Archivo: " + impreso.nombreArchivo);
                        System.out.println("Usuario: " + impreso.usuario);
                        System.out.println("Páginas: " + impreso.numeroPaginas);
                        System.out.println("Color: " + impreso.esColor);
                    }

                    break;

                case 4:

                    int total = cola.calcularPaginasTotales();

                    System.out.println("\nTotal de páginas pendientes: " + total);

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