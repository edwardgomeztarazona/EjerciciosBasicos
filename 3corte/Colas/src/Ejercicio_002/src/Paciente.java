import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        PilaEstaciones ruta = new PilaEstaciones();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        ruta.push(new Estacion("Entrada Principal", 0, 20.9));
        ruta.push(new Estacion("Galería Norte", 50, 19.5));
        ruta.push(new Estacion("Pozo Central", 120, 17.8));
        ruta.push(new Estacion("Cámara Profunda", 200, 16.4));

        int opcion;

        do {
            System.out.println("\n--- RUTA DE RESCATE (PILAS) ---");
            System.out.println("1. Ver estaciones colocadas");
            System.out.println("2. Registrar nueva estación (Push)");
            System.out.println("3. Retirar estación del tope (Pop)");
            System.out.println("4. Retroceder a superficie");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    ruta.imprimir();
                    break;

                case 2:
                    System.out.print("Nombre del punto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Profundidad: ");
                    int profundidad = scanner.nextInt();

                    System.out.print("Nivel de oxígeno (%): ");
                    double oxigeno = scanner.nextDouble();

                    ruta.push(new Estacion(nombre, profundidad, oxigeno));

                    System.out.println("Estación registrada correctamente.");
                    break;

                case 3:
                    Estacion retirada = ruta.pop();

                    if (retirada != null) {
                        System.out.println("Estación retirada: " + retirada);
                    } else {
                        System.out.println("No hay estaciones registradas.");
                    }
                    break;

                case 4:
                    ruta.retrocederASuperficie();
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