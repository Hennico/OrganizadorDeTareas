package organizadordetareas

class Tarea extends Dependiente{
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

	public AvisarAlObjetivo() {
		objetivo.NewTareaAnterior(this,DependenciaTipo.alta)
	}



	public CrearYAgregarHijo(String titulo, String descripcion, int prioridad) {
		Tarea tareaHija = Tarea.newInstance(titulo, descripcion, objetivo, prioridad)
		tareaHija.save flush:true
		tareasAnteriores.add (new TareaDependencia(this,tareaHija,DependenciaTipo.alta))
	}	

	public Tarea (String titulo, String descripcion, Objetivo objetivo, int prioridad) {
		estado = EstadoTarea.PENDIENTE
		this.titulo = titulo
		this.descripcion = descripcion
		this.objetivo = objetivo
		this.prioridad = prioridad
	}
}

