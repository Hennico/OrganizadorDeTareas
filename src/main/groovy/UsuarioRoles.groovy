package organizadordetareas

public abstract class UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaPausada estadoNuevo) {
		usuarioTarea.EstadoTarea.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo.ToString();
	}
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaFinalizada estadoNuevo) {
		usuarioTarea.EstadoTarea.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo.ToString();
	}
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea , EstadoTareaEnEjecucion estadoNuevo) {
		usuarioTarea.EstadoTarea.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo.ToString();;
	}
	
	public abstract void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea , EstadoTareaCancelada estadoNuevo);
}

public class UsuarioRolAdministrador extends UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaCancelada estadoNuevo) {
		if (!usuarioTarea.EstadoTarea.EsEstado(estadoNuevo)) {
			usuarioTarea.tarea.CambiarEstado(estadoNuevo);
			usuarioTarea.estado = estadoNuevo.ToString();
		}
		else
			throw new Exception("La tarea ya esta cancelada");
	}
}

public class UsuarioRolOperario extends UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaCancelada estadoNuevo) {
		throw new Exception("Un operario no puede cancelar una tarea");
	}
}