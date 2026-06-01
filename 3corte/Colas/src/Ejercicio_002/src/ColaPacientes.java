public class ColaPacientes {
    private Paciente entrada;
    private Paciente salida;
    private int tamanio;

    public ColaPacientes() {
        this.entrada = null;
        this.salida = null;
        this.tamanio = 0;
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return salida == null;
    }

    // Retorna el tamaño de la cola
    public int size() {
        return tamanio;
    }

    // Inserta un paciente
    public void enqueue(Paciente paciente) {

        if (isEmpty()) {
            salida = paciente;
            entrada = paciente;
        } else {
            entrada.siguiente = paciente;
            entrada = paciente;
        }

        tamanio++;
    }

    // Atiende y elimina un paciente
    public Paciente dequeue() {

        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return null;
        }

        Paciente paciente = salida;
        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return paciente;
    }

    // Imprime la cola
    public void imprimir() {

        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }

        System.out.println("\nPACIENTES EN ESPERA:");

        Paciente actual = salida;

        while (actual != null) {

            System.out.println(
                "Cedula: " + actual.cedula +
                " | Nombre: " + actual.nombreCompleto +
                " | Edad: " + actual.edad +
                " | Sintoma: " + actual.sintomaPrincipal
            );

            actual = actual.siguiente;
        }
    }

    // Atiende todos los pacientes
    public void atenderTodos() {

        int atendidos = 0;

        if (isEmpty()) {
            System.out.println("No hay pacientes para atender.");
            return;
        }

        System.out.println("\n--- ATENDIENDO PACIENTES ---");

        while (!isEmpty()) {

            Paciente paciente = dequeue();

            System.out.println(
                "\nPaciente atendido:" +
                "\nCedula: " + paciente.cedula +
                "\nNombre: " + paciente.nombreCompleto +
                "\nEdad: " + paciente.edad +
                "\nSintoma Principal: " + paciente.sintomaPrincipal
            );

            atendidos++;
        }

        System.out.println("\nTotal de pacientes atendidos: " + atendidos);
    }
}
