/*Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada./* */


import java.util.Scanner;

public class ControlAccesoGimnasio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista de códigos de socios que pagaron (ORDENADA de menor a mayor)
        int[] codigosPagados = {1010, 1025, 1050, 1100, 1200, 1300, 1500};

        System.out.print("Ingrese su código de socio: ");
        int codigoIngresado = scanner.nextInt();

        // Variables para la búsqueda binaria
        int inicio = 0;
        int fin = codigosPagados.length - 1;
        boolean encontrado = false;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (codigosPagados[medio] == codigoIngresado) {
                encontrado = true;
                break;
            } 
            else if (codigoIngresado < codigosPagados[medio]) {
                fin = medio - 1;  // Buscar en la mitad izquierda
            } 
            else {
                inicio = medio + 1; // Buscar en la mitad derecha
            }
        }

        // Resultado final
        if (encontrado) {
            System.out.println("Acceso permitido. Bienvenido al gimnasio 💪");
        } else {
            System.out.println("Acceso denegado. Mensualidad pendiente.");
        }

        scanner.close();
    }
}