/*4. Torneo de Ajedrez (Sistema de Rankings ELO)

Una plataforma de ajedrez en línea gestiona el ranking ELO de sus jugadores en un BST. A medida que los jugadores completan partidas, su ELO se actualiza y se reinsertan en el árbol. El director del torneo necesita obtener la lista de jugadores que clasifican a la siguiente ronda, es decir, todos aquellos cuyo ELO se encuentre dentro de un rango específico.

- **La Clase Jugador (Nodo):** Debe contener `elo` (int, clave del BST), `nombreUsuario` (String), `pais` (String) y `partidasJugadas` (int).
- **El Problema:** Para la ronda de clasificación, el director fija un rango mínimo y máximo de ELO (por ejemplo, entre 1800 y 2200). Todos los jugadores en ese rango deben ser listados de menor a mayor ELO para armar los emparejamientos.
- **Reto:** Implementa el método `listarEnRango(int eloMin, int eloMax)` que recorra el árbol e imprima los datos de todos los jugadores cuyo `elo` esté dentro del rango `[eloMin, eloMax]` en orden ascendente. Usa la propiedad del BST para podar: si el nodo actual es menor que `eloMin`, solo explora el subárbol derecho; si es mayor que `eloMax`, solo explora el izquierdo. */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ArbolJugadores arbol = new ArbolJugadores();
        Scanner scanner = new Scanner(System.in);

        arbol.insertar(1500, "DragonMaster", "Colombia", 120);
        arbol.insertar(2100, "KingChess", "España", 340);
        arbol.insertar(1800, "MateEnDos", "Argentina", 200);
        arbol.insertar(2400, "GrandMasterX", "Brasil", 600);
        arbol.insertar(1900, "ChessPro", "México", 250);
        arbol.insertar(1700, "CaballoLoco", "Perú", 100);

        int opcion;

        do {

            System.out.println("\n--- TORNEO DE AJEDREZ ---");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Listar jugadores por rango ELO");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ELO: ");
                    int elo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();

                    System.out.print("País: ");
                    String pais = scanner.nextLine();

                    System.out.print("Partidas jugadas: ");
                    int partidas = scanner.nextInt();

                    arbol.insertar(elo, usuario,
                            pais, partidas);

                    System.out.println("Jugador registrado.");
                    break;

                case 2:

                    System.out.print("ELO mínimo: ");
                    int min = scanner.nextInt();

                    System.out.print("ELO máximo: ");
                    int max = scanner.nextInt();

                    arbol.listarEnRango(min, max);
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}