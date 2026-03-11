/*
 Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante en su posición
correcta.
El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) de
cada uno.
 A medida que el usuario ingresa un número, o una vez llenado el arreglo, el algoritmo debe
simular el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando el
arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30] ). Esto permite al estudiante ver cómo los elementos se
desplazan para abrir espacio al nuevo valor.
 */

import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de libros: ");
        int n = sc.nextInt();

        int[] libros = new int[n];

        // Ingresar ISBN
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el ISBN del libro " + (i + 1) + ": ");
            libros[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int actual = libros[i];
            int j = i - 1;

            while (j >= 0 && libros[j] > actual) {
                libros[j + 1] = libros[j];
                j--;
            }

            libros[j + 1] = actual;

            // Mostrar arreglo en cada paso
            for (int k = 0; k < n; k++) {
                System.out.print(libros[k] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

