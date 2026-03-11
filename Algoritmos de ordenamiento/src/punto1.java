/*Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénes
ganaron las medallas
El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debe
pedir el tiempo en segundos (con decimales) de cada corredor.
 El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo al
inicio.
 El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar un
mensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar)*/



import java.util.Scanner;

public class Carrera100m {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos corredores participaron? ");
        int n = sc.nextInt();

        double[] tiempos = new double[n];

        // Ingresar tiempos
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el tiempo del corredor " + (i + 1) + " en segundos: ");
            tiempos[i] = sc.nextDouble();
        }

        // Ordenamiento por Selección (de menor a mayor)
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (tiempos[j] < tiempos[min]) {
                    min = j;
                }
            }

            double temp = tiempos[i];
            tiempos[i] = tiempos[min];
            tiempos[min] = temp;
        }

        // Mostrar arreglo ordenado
        System.out.println("\nTiempos ordenados (del más rápido al más lento):");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "° lugar: " + tiempos[i] + " s");
        }

        // Medallas
        if (n >= 3) {
            System.out.println("\nMedallas:");
            System.out.println("🥇 Oro: " + tiempos[0] + " s");
            System.out.println("🥈 Plata: " + tiempos[1] + " s");
            System.out.println("🥉 Bronce: " + tiempos[2] + " s");
        }

        sc.close();
    }
}