/*2. Urgencias Hospitalarias (Triaje)

En la sala de urgencias de un hospital, los pacientes que llegan son registrados y colocados en una fila de atención. Dado el volumen de pacientes, el médico de guardia atiende en estricto orden de llegada. Al momento de llamar a un paciente, el sistema debe mostrar su información completa.

- **La Clase Paciente (Nodo):** Debe contener `cedula` (String), `nombreCompleto` (String), `edad` (int) y `sintomaPrincipal` (String).
- **El Problema:** Al finalizar el turno, el hospital necesita un reporte del total de pacientes atendidos y la lista completa en orden de atención.
- **Reto:** Implementa un método `atenderTodos()` que extraiga (`dequeue`) a cada paciente uno a uno, imprima su información al momento de ser atendido e imprima al final el total de pacientes procesados. */

import java.util.Scanner;

public class Appp {
    public static void main(String[] args) throws Exception {
        ColaPacientes cola = new ColaPacientes();

        Scanner scanner = new Scanner(System.in);

        // Pacientes iniciales
        cola.enqueue(new Paciente("1001", "Juan Perez", 25, "Dolor de cabeza"));
        cola.enqueue(new Paciente("1002", "Maria Gomez", 40, "Fiebre"));
        cola.enqueue(new Paciente("1003", "Carlos Ruiz", 31, "Dolor abdominal"));
        cola.enqueue(new Paciente("1004", "Ana Torres", 19, "Mareo"));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE URGENCIAS HOSPITALARIAS ---");
            System.out.println("1. Ver pacientes en espera");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Atender un paciente");
            System.out.println("4. Atender todos los pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    cola.imprimir();

                    break;

                case 2:

                    System.out.print("Cedula: ");
                    String cedula = scanner.nextLine();

                    System.out.print("Nombre Completo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Sintoma Principal: ");
                    String sintoma = scanner.nextLine();

                    cola.enqueue(new Paciente(cedula, nombre, edad, sintoma));

                    System.out.println("Paciente registrado correctamente.");

                    break;

                case 3:

                    Paciente atendido = cola.dequeue();

                    if (atendido != null) {

                        System.out.println("\nPaciente atendido:");
                        System.out.println("Cedula: " + atendido.cedula);
                        System.out.println("Nombre: " + atendido.nombreCompleto);
                        System.out.println("Edad: " + atendido.edad);
                        System.out.println("Sintoma: " + atendido.sintomaPrincipal);
                    }

                    break;

                case 4:

                    cola.atenderTodos();

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