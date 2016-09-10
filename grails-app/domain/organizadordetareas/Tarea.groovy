package organizadordetareas

class Tarea {
    String titulo
    String descripcion
    Set<RelacionUsuarioTarea> tareasAnteriores
    EstadoTarea estado
    int prioridad
    
    static constraints = {
    }
	
	static def hasMany = [
		'tareasAnteriores': RelacionUsuarioTarea
	]
	
	public Tarea() {
		estado = new EstadoTareaPendiente();
	}
	
	public EstadoTarea GetEstado() { estado }
	
	public void CambiarEstado(EstadoTareaCancelada estadoNuevo) {
		usuarios.each { usuario -> usuario.estado = estadoNuevo }
	}
	public void CambiarEstado(EstadoTareaEnEjecucion estadoNuevo) {
		estado = estadoNuevo;
	}
	public void CambiarEstado(EstadoTareaFinalizada estadoNuevo) {
		if (!usuarios.any { usuario -> !usuario.estado.EsEstado(estadoNuevo) })
			estado = estadoNuevo;
	}
	public void CambiarEstado(EstadoTareaPausada estadoNuevo) {
		if (!usuarios.any { usuario -> !usuario.estado.EsEstado(estadoNuevo) })
			estado = estadoNuevo;
	}
}

