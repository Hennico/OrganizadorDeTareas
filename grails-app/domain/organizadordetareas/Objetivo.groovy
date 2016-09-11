package organizadordetareas

class Objetivo {
    String titulo
    String descripcion
    Set<RelacionUsuarioTarea> tareasAnteriores
    String estado //Por ahora lo dejo asi
	
    int prioridad
	// cuando corrigamos los nombres de las variables. Tambien corregir los de la View.

	public Objetivo() {
		estado = EstadoTarea.PENDIENTE;
	}

    static constraints = {
    }
	
    EstadoTarea getEstadoTarea() {
        EstadoTarea.GenerateEstadoTarea(estado);
    }
	
	String toString() {
		titulo
	}
}
