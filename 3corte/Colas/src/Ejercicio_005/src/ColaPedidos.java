public class ColaPedidos {
    
    private Pedido entrada;
    private Pedido salida;
    private int tamanio;

    public ColaPedidos() {

        this.entrada = null;
        this.salida = null;
        this.tamanio = 0;
    }

    
    public boolean isEmpty() {
        return salida == null;
    }

    
    public int size() {
        return tamanio;
    }

    
    public void enqueue(Pedido pedido) {

        if (isEmpty()) {

            salida = pedido;
            entrada = pedido;

        } else {

            entrada.siguiente = pedido;
            entrada = pedido;
        }

        tamanio++;
    }

    
    public Pedido dequeue() {

        if (isEmpty()) {

            System.out.println("No hay pedidos en cola.");
            return null;
        }

        Pedido pedido = salida;

        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return pedido;
    }

    
    public void imprimir() {

        if (isEmpty()) {

            System.out.println("[ Cola vacía ]");
            return;
        }

        System.out.println("\nPEDIDOS EN COLA:");

        Pedido actual = salida;

        while (actual != null) {

            System.out.println(
                "Pedido: " + actual.numeroPedido +
                " | Cliente: " + actual.cliente +
                " | Total: $" + actual.totalPagar +
                " | Cancelado: " + actual.cancelado
            );

            actual = actual.siguiente;
        }
    }

    // Reto
    public void procesarPedidos() {

        int despachados = 0;
        int cancelados = 0;

        if (isEmpty()) {

            System.out.println("No hay pedidos para procesar.");
            return;
        }

        System.out.println("\n--- PROCESANDO PEDIDOS ---");

        while (!isEmpty()) {

            Pedido pedido = dequeue();

            if (pedido.cancelado) {

                System.out.println(
                    "Pedido " +
                    pedido.numeroPedido +
                    " cancelado. No será despachado."
                );

                cancelados++;

            } else {

                System.out.println("\nPedido despachado:");
                System.out.println("Número: " + pedido.numeroPedido);
                System.out.println("Cliente: " + pedido.cliente);
                System.out.println("Total a pagar: $" + pedido.totalPagar);

                despachados++;
            }
        }

        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Total despachados: " + despachados);
        System.out.println("Total cancelados: " + cancelados);
    }
}
