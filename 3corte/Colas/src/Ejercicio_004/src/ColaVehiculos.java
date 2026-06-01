public class ColaVehiculos {
    
    private Vehiculo entrada;
    private Vehiculo salida;
    private int tamanio;

    public ColaVehiculos() {

        this.entrada = null;
        this.salida = null;
        this.tamanio = 0;
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return salida == null;
    }

    // Retorna el tamaño
    public int size() {
        return tamanio;
    }

    // Agrega un vehículo
    public void enqueue(Vehiculo vehiculo) {

        if (isEmpty()) {

            salida = vehiculo;
            entrada = vehiculo;

        } else {

            entrada.siguiente = vehiculo;
            entrada = vehiculo;
        }

        tamanio++;
    }

    // Atiende un vehículo
    public Vehiculo dequeue() {

        if (isEmpty()) {

            System.out.println("No hay vehículos en la cola.");
            return null;
        }

        Vehiculo vehiculo = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return vehiculo;
    }

    // Imprime la cola
    public void imprimir() {

        if (isEmpty()) {

            System.out.println("[ Cola vacía ]");
            return;
        }

        System.out.println("\nVEHÍCULOS EN ESPERA:");

        Vehiculo actual = salida;

        while (actual != null) {

            System.out.println(
                "Placa: " + actual.placa +
                " | Tipo: " + actual.tipoVehiculo +
                " | Tarifa: $" + actual.tarifa +
                " | Exento: " + actual.esExento
            );

            actual = actual.siguiente;
        }
    }

    // Reto
    public void cerrarTurno() {

        double totalRecaudado = 0;

        if (isEmpty()) {

            System.out.println("No hay vehículos en la cola.");
            return;
        }

        System.out.println("\n--- CERRANDO TURNO ---");

        while (!isEmpty()) {

            Vehiculo vehiculo = dequeue();

            System.out.println(
                "Procesando vehículo: " +
                vehiculo.placa +
                " - " +
                vehiculo.tipoVehiculo
            );

            if (!vehiculo.esExento) {
                totalRecaudado += vehiculo.tarifa;
            }
        }

        System.out.println("\nTotal recaudado: $" + totalRecaudado);
    }
}