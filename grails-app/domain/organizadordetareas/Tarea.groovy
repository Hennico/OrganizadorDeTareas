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

	public void CambiarEstado(EstadoTarea estadoNuevo) {
		estado = estadoNuevo
	}

	public boolean ComprobarSiPuedoCambiarEstado(EstadoTarea estadoNuevo) {
		return estado.permiteCambioA(estadoNuevo)
	}	


	public void ComprobarYCambiarEstado(EstadoTarea estadoNuevo) {
		if (estado.permiteCambioA(estadoNuevo)){
		estado = estadoNuevo
		}
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

