/*
 El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el sistema se
ordene alfabéticamente de la A a la Z.
 El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenas
de texto).
 Se debe usar el método de Inserción adaptado para String.
  El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2) . Es
vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
 La lista de asistencia impresa en orden alfabético perfecto.
 */
import java.util.Scanner;

public class InsertionSortNombres {

    public static void insertionSort(String[] nombres) {

        for (int i = 1; i < nombres.length; i++) {
            String clave = nombres[i];
            int j = i - 1;

            // compareToIgnoreCase compara sin importar mayúsculas o minúsculas
            // Si el resultado > 0 significa que el primer nombre es "mayor"
            // alfabéticamente que el segundo y debe moverse.
            while (j >= 0 && nombres[j].compareToIgnoreCase(clave) > 0) {
                nombres[j + 1] = nombres[j];
                j--;
            }

            nombres[j + 1] = clave;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos alumnos hay en la clase?: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del alumno " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }

        // Mostrar lista original
        System.out.println("\nLista original:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        insertionSort(nombres);

        // Mostrar lista ordenada
        System.out.println("\nLista ordenada alfabéticamente:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        sc.close();
    }
}