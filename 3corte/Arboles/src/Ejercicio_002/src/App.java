/*2. Catálogo Digital (Biblioteca Universitaria)

La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol. El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar y listar toda la colección ordenada por ISBN.

- **La Clase Libro (Nodo):** Debe contener `isbn` (long, clave del BST), `titulo` (String), `autor` (String) y `anioPublicacion` (int).
- **El Problema:** Al final del semestre, el bibliotecario necesita imprimir el inventario completo ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar si un ISBN específico ya existe en el catálogo antes de registrar una donación.
- **Reto:** Implementa el método `imprimirCatalogo()` usando el recorrido **InOrden** para listar todos los libros en orden ascendente de ISBN (imprime `isbn - titulo - autor`). Además, implementa `existeISBN(long isbn)` que retorne `true` si el libro ya está registrado y `false` en caso contrario. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArbolLibros catalogo = new ArbolLibros();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        catalogo.insertar(9781234567890L, "Java Basico", "Carlos Perez", 2022);
        catalogo.insertar(9781234567000L, "Estructuras de Datos", "Ana Gomez", 2021);
        catalogo.insertar(9781234568000L, "Bases de Datos", "Luis Torres", 2020);
        catalogo.insertar(9781234569000L, "Redes de Computadores", "Maria Diaz", 2023);
        catalogo.insertar(9781234567500L, "Programacion Orientada a Objetos", "Pedro Ruiz", 2022);

        int opcion;

        do {

            System.out.println("\n=== CATÁLOGO DIGITAL ===");
            System.out.println("1. Mostrar catálogo ordenado");
            System.out.println("2. Registrar libro");
            System.out.println("3. Verificar ISBN");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    catalogo.imprimirCatalogo();
                    break;

                case 2:

                    System.out.print("ISBN: ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();

                    if (catalogo.existeISBN(isbn)) {

                        System.out.println("Ese ISBN ya está registrado.");

                    } else {

                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        System.out.print("Año de publicación: ");
                        int anio = scanner.nextInt();
                        scanner.nextLine();

                        catalogo.insertar(isbn, titulo, autor, anio);

                        System.out.println("Libro registrado correctamente.");
                    }

                    break;

                case 3:

                    System.out.print("Ingrese ISBN a buscar: ");
                    long isbnBuscar = scanner.nextLong();
                    scanner.nextLine();

                    if (catalogo.existeISBN(isbnBuscar))
                        System.out.println("El ISBN ya existe en el catálogo.");
                    else
                        System.out.println("El ISBN no está registrado.");

                    break;

                case 4:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}