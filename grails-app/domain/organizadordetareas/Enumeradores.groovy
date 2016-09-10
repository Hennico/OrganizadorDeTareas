package organizadordetareas

class RelacionUsuarioTarea {
  Tarea tarea
  EstadoTarea estado
  Usuario usuario
  UsuarioRol rol
}

public abstract class UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaPausada estadoNuevo) {
		usuarioTarea.estado.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo;
	}
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaFinalizada estadoNuevo) {
		usuarioTarea.estado.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo;
	}
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea , EstadoTareaEnEjecucion estadoNuevo) {
		usuarioTarea.estado.ValidarCambio(estadoNuevo);
		usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		usuarioTarea.estado = estadoNuevo;
	}
	
	public abstract void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea , EstadoTareaCancelada estadoNuevo);
}

public class UsuarioRolAdministrador extends UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaCancelada estadoNuevo) {
		if (!usuarioTarea.estado.EsEstado(estadoNuevo))
			usuarioTarea.tarea.CambiarEstado(estadoNuevo);
		else
			throw new Exception("La tarea ya esta cancelada");
	}
}

public class UsuarioRolOperario extends UsuarioRol {
	public void CambiarEstadoTarea(RelacionUsuarioTarea usuarioTarea, EstadoTareaCancelada estadoNuevo) {
		throw new Exception("Un operario no puede cancelar una tarea");
	}
}

public abstract class EstadoTarea {
	protected abstract int valorIgualdad();
	public boolean EsEstado(EstadoTarea otroEstado) {
		this.valorIgualdad() == otroEstado.valorIgualdad();
	}
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) {}
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("No se puede finalizar una tarea que no este en ejecucion") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) {}
}

public class EstadoTareaPausada extends EstadoTarea {
	protected int valorIgualdad() { 1 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("La tarea ya se encuentra pausada") }
}
public class EstadoTareaPendiente extends EstadoTarea {
	protected int valorIgualdad() { 2 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede Pausar una tarea pendiente") }
}
public class EstadoTareaCancelada extends EstadoTarea {
	protected int valorIgualdad() { 3 }

public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
}
public class EstadoTareaFinalizada extends EstadoTarea {
	protected int valorIgualdad() { 4 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Finalizada") }
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("La tarea ya se encuentra Finalizada") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Finalizada") }
}
public class EstadoTareaEnEjecucion extends EstadoTarea {
	protected int valorIgualdad() { 5 }
	
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) {}
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("La tarea ya se encuentra en Ejecucion") }
}
