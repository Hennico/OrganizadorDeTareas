package organizadordetareas

class Tarea extends Dependiente{
    	String titulo
    	String descripcion
	Objetivo objetivo
   	int prioridad
	EstadoTarea estado

	
    	static constraints = {
		//objetivo nullable: true
    	}
	
	static def hasMany = [
		'tareasAnteriores': RelacionUsuarioTarea
	]
	
	public Tarea() {
		estado = EstadoTarea.PENDIENTE
	}

	private boolean ComprobarSiPuedoCambiarEstado(EstadoTarea estadoNuevo) {
		boolean flag = estado.permiteCambioA(estadoNuevo)
		if (estadoNuevo == EstadoTarea.EN_EJECUCION){
			tareasAnteriores.each{if(!(it.tareaDependida.estado==EstadoTarea.CANCELADA ||it.tareaDependida.estado==EstadoTarea.FINALIZADA)){flag = false}}
		}
		if (!flag){
			throw new CambioDeEstadoInvalidException()
		}
		return flag
	}	


	public void ComprobarYCambiarEstado(EstadoTarea estadoNuevo) {
		if (this.ComprobarSiPuedoCambiarEstado(estadoNuevo)){
		estado = estadoNuevo
		}
	}


	public AvisarAlObjetivo() {
		objetivo.NewTareaAnterior(this,DependenciaTipo.alta)
	}



	public CrearYSubTarea(String titulo, String descripcion, int prioridad) {
		Tarea subTarea = Tarea.newInstance(titulo, descripcion, objetivo, prioridad)
		subTarea.save flush:true
		tareasAnteriores.add (new NexoEntreTareas(this,subTarea,DependenciaTipo.alta))
	}	

	public Tarea (String titulo, String descripcion, Objetivo objetivo, int prioridad) {
		estado = EstadoTarea.PENDIENTE
		this.titulo = titulo
		this.descripcion = descripcion
		this.objetivo = objetivo
		this.prioridad = prioridad
	}
}

