package organizadordetareas

class Objetivo extends Accion{
    	String titulo
    	String descripcion
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

   	public NewTareaAnterior(Tarea NuevaTarea, TareaDependencia estado) {
		tareasAnteriores.add (new TareaDependencia(This,NuevaTarea,estado))
	}

}
