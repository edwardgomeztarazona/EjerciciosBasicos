/*
 Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para
un caso específico.
 El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS
métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
 Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
 Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos
hizo Inserción. El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.
 */
import java.util.Scanner;

public class Ordenamiento {
    // Algoritmo por Selección: busca el mínimo en el resto y lo intercambia
    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambio
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // Algoritmo por Inserción: inserta cada elemento en su posición correcta
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Método auxiliar para imprimir el arreglo
    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Ingresa los elementos:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original:");
        imprimir(arr);

        // Prueba Selección
        int[] arrSel = arr.clone();
        seleccion(arrSel);
        System.out.println("Por Selección:");
        imprimir(arrSel);  // [web:7][page:0]

        // Prueba Inserción
        int[] arrIns = arr.clone();
        insercion(arrIns);
        System.out.println("Por Inserción:");
        imprimir(arrIns);  // [web:8][page:1]

        sc.close();
    }
}
