package organizadordetareas

class Tarea extends Accion{
    	String titulo
    	String descripcion
   	Set<RelacionUsuarioTarea> tareasAnteriores
	Objetivo objetivo
   	int prioridad
	String estado
	
    	static constraints = {
		//objetivo nullable: true
    	}
	
	static def hasMany = [
		'tareasAnteriores': RelacionUsuarioTarea
	]
	
	public Tarea() {
		estado = EstadoTarea.PENDIENTE
	}

	public void CambiarEstado(EstadoTareaCancelada estadoNuevo) {
		usuarios.each { usuario -> usuario.estado = estadoNuevo }
        estado = estadoNuevo.ToString();
	}
	public void CambiarEstado(EstadoTareaEnEjecucion estadoNuevo) {
		estado = estadoNuevo.ToString();
	}
	public void CambiarEstado(EstadoTareaFinalizada estadoNuevo) {
		if (!usuarios.any { usuario -> !usuario.estado.EsEstado(estadoNuevo) })
			estado = estadoNuevo.ToString();
	}
	public void CambiarEstado(EstadoTareaPausada estadoNuevo) {
		if (!usuarios.any { usuario -> !usuario.estado.EsEstado(estadoNuevo) })
			estado = estadoNuevo.ToString();
	}
	
	public EstadoTarea GetEstadoTarea() {
		EstadoTarea.GenerateEstadoTarea(estado);
	}

	public sum() {
		prioridad=prioridad+1;
	}
}

