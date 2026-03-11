/*
Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más
eficiente que el método de burbuja o inserción simple
 Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para
notar el efecto).
Implementa el algoritmo usando el salto (gap) inicial de $N/2$. El estudiante debe explicar en
comentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementos
que están muy lejos de su posición final.
 Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de
reducción de saltos.
 */

import java.util.Scanner;

public class ShellSortPaquetes {

    public static void shellSort(int arr[]) {
        int n = arr.length;

        // Se inicia con un salto (gap) de N/2 y se va reduciendo
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // Comparación entre elementos separados por el gap
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de paquetes: ");
        int n = sc.nextInt();

        int[] pesos = new int[n];

        // Ingreso de pesos
        for (int i = 0; i < n; i++) {
            System.out.print("Peso del paquete " + (i + 1) + ": ");
            pesos[i] = sc.nextInt();
        }

        // Mostrar arreglo original
        System.out.println("\nPesos originales:");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i] + " ");
        }

        /*
        Shell Sort es más rápido que inserción simple porque compara
        elementos que están lejos entre sí usando "gaps". Esto permite
        mover rápidamente elementos grandes o pequeños hacia posiciones
        cercanas a su lugar final, reduciendo la cantidad de movimientos
        cuando el gap llega a 1.
        */

        shellSort(pesos);

        // Mostrar arreglo ordenado
        System.out.println("\n\nPesos ordenados:");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i] + " ");
        }

        sc.close();
    }
}