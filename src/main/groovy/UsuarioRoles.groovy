package organizadordetareas

public abstract class UsuarioRol {
	private def estadosQuePuedoUsar = [PENDIENTE,EN_EJECUCION,PAUSADA,FINALIZADA]

	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTarea estadoNuevo) {
		if (usuarioTarea.EstadoTarea.permiteCambioA(estadoNuevo) && estadoNuevo in estadosQuePuedoUsar){
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo
		}
	}
}

public class UsuarioRolAdministrador extends UsuarioRol {
	private def estadosEsepecialesQuePuedoUsar = [CANCELADA]

	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTarea estadoNuevo) {
		super.CambiarEstadoTarea(usuarioTarea, estadoNuevo)

		if (usuarioTarea.EstadoTarea.permiteCambioA(estadoNuevo) && (estadoNuevo== CANCELADA)) {
			usuarioTarea.tarea.CambiarEstado(estadoNuevo);
			usuarioTarea.estado = estadoNuevo
		}
	}
}

public class UsuarioRolOperario extends UsuarioRol {

}
