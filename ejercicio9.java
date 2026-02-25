/*Ejercicio 9 — Notas de un curso
Un profesor tiene las notas de 4 estudiantes en un arreglo. El coordinador recibe una referencia al mismo arreglo para revisarlas.

El coordinador corrige la nota del estudiante 2 (índice 1) de 2.5 a 3.0.
Muestra que el arreglo del profesor también refleja el cambio.
Añade comentarios explicando el concepto de referencia en memoria.
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        double[] notasProfesor = {3.5, 2.5, 4.0, 3.8};
        double[] notasCoordinador = notasProfesor;

        notasCoordinador[1] = 3.0;

        for (double n : notasProfesor) {
            System.out.print(n + " ");
        }

        // Mismo arreglo en memoria → ambos reflejan el cambio
    }
}