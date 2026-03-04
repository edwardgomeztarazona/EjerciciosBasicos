Control de Acceso (Gimnasio)
Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada.

public class ControlAcceso {
    public static void main(String[] args) {

        int[] codigos = {100, 200, 300, 400, 500, 600};
        int codigoIngresado = 400;

        int inicio = 0;
        int fin = codigos.length - 1;
        boolean autorizado = false;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (codigos[medio] == codigoIngresado) {
                autorizado = true;
                break;
            } else if (codigoIngresado < codigos[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (autorizado) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
        }
    }
}