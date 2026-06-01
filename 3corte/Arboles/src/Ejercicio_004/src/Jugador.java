import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArbolEmpleados arbol = new ArbolEmpleados();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(1001, "Juan Perez", "Gerente", 5000);
        arbol.insertar(800, "Ana Gomez", "Analista", 3000);
        arbol.insertar(1500, "Carlos Ruiz", "Supervisor", 4000);
        arbol.insertar(600, "Maria Torres", "Auxiliar", 2500);
        arbol.insertar(1700, "Pedro Diaz", "Coordinador", 4500);

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE NÓMINA ---");
            System.out.println("1. Buscar empleado con menor cédula");
            System.out.println("2. Buscar empleado con mayor cédula");
            System.out.println("3. Reporte de eficiencia");
            System.out.println("4. Insertar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    arbol.buscarMinimo();
                    break;

                case 2:
                    arbol.buscarMaximo();
                    break;

                case 3:
                    arbol.reporteEficiencia();
                    break;

                case 4:

                    System.out.print("Cédula: ");
                    long cedula = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();

                    arbol.insertar(cedula, nombre, cargo, salario);

                    System.out.println("Empleado registrado.");
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}