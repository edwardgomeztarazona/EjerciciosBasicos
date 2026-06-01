public class ArbolRepuestos {
    
    private Repuesto raiz;

    public ArbolRepuestos() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Repuesto insertar(Repuesto nodo, int codigoRef,
                              String descripcion,
                              String marca,
                              int stock) {

        if (nodo == null)
            return new Repuesto(codigoRef,
                    descripcion, marca, stock);

        if (codigoRef < nodo.codigoRef)
            nodo.izquierdo = insertar(nodo.izquierdo,
                    codigoRef, descripcion,
                    marca, stock);

        else if (codigoRef > nodo.codigoRef)
            nodo.derecho = insertar(nodo.derecho,
                    codigoRef, descripcion,
                    marca, stock);

        return nodo;
    }

    public void insertar(int codigoRef,
                         String descripcion,
                         String marca,
                         int stock) {

        raiz = insertar(raiz, codigoRef,
                descripcion, marca, stock);
    }

    private void preOrden(Repuesto nodo) {

        if (nodo != null) {

            System.out.println(nodo);

            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void backupPreOrden() {

        if (isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        System.out.println("=== BACKUP PREORDEN ===");
        preOrden(raiz);
    }

    private int contarHojas(Repuesto nodo) {

        if (nodo == null)
            return 0;

        if (nodo.izquierdo == null &&
            nodo.derecho == null)
            return 1;

        return contarHojas(nodo.izquierdo)
                + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    public void reporteRepuestosUnicos() {

        System.out.println(
            "Repuestos sin variantes relacionadas: "
            + contarHojas()
        );
    }
}