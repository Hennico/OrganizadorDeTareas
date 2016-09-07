package organizadordetareas

class Objetivo {
    String titulo
    String descripcion
    Set<RealacionUsuarioTarea> tareasAnteriores
    EstadoTarea estado //Por ahora lo dejo asi
    int prioridad
	// cuando corrigamos los nombres de las variables. Tambien corregir los de la View.

	public Objetivo() {
		estado = new EstadoTareaPendiente();
	}

    static constraints = {
    }
}
