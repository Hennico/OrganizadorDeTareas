package organizadordetareas

class RelacionUsuarioTarea {
	Tarea tarea
	Usuario usuario
	String estado
	//UsuarioRol rol
	
	EstadoTarea GetEstadoTarea() {
		EstadoTarea.GenerateEstadoTarea(estado);
	}
}