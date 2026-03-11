import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] listaNegra = {50, 120, 450, 800, 999}; // Ordenada
        int[] intentos = new int[8];

        // Pedir los 8 IDs
        System.out.println("Ingrese 8 IDs:");
        for (int i = 0; i < 8; i++) {
            intentos[i] = sc.nextInt();
        }

        // Buscar el ID más alto (Búsqueda Lineal)
        int mayor = intentos[0];
        for (int i = 1; i < 8; i++) {
            if (intentos[i] > mayor) {
                mayor = intentos[i];
            }
        }

        System.out.println("ID más alto: " + mayor);

        // Buscar en lista negra (Búsqueda Binaria)
        int inicio = 0, fin = listaNegra.length - 1;
        boolean esta = false;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (listaNegra[medio] == mayor) {
                esta = true;
                break;
            } else if (mayor < listaNegra[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (esta) {
            System.out.println(-->"Ya está en la lista negra.");
        } else {
            System.out.println(-->"Nuevo atacante detectado, procediendo a bloquear.");
        }

        sc.close();
    }
}