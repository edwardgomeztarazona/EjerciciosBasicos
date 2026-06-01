public class ColaImpresion {
    
    private Documento entrada;
    private Documento salida;
    private int tamanio;

    public ColaImpresion() {

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

    // Agrega un documento a la cola
    public void enqueue(Documento documento) {

        if (isEmpty()) {

            salida = documento;
            entrada = documento;

        } else {

            entrada.siguiente = documento;
            entrada = documento;
        }

        tamanio++;
    }

    // Procesa un documento
    public Documento dequeue() {

        if (isEmpty()) {

            System.out.println("No hay documentos en cola.");
            return null;
        }

        Documento documento = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return documento;
    }

    // Muestra la cola
    public void imprimir() {

        if (isEmpty()) {

            System.out.println("[ Cola vacía ]");
            return;
        }

        System.out.println("\nDOCUMENTOS EN COLA:");

        Documento actual = salida;

        while (actual != null) {

            System.out.println(
                "Archivo: " + actual.nombreArchivo +
                " | Usuario: " + actual.usuario +
                " | Páginas: " + actual.numeroPaginas +
                " | Color: " + actual.esColor
            );

            actual = actual.siguiente;
        }
    }

    // Calcula el total de páginas sin alterar la cola
    public int calcularPaginasTotales() {

        int totalPaginas = 0;

        Documento actual = salida;

        while (actual != null) {

            totalPaginas += actual.numeroPaginas;

            actual = actual.siguiente;
        }

        return totalPaginas;
    }
}