package organizadordetareas

public abstract class EstadoTarea {
	static final String PAUSADA = "pausada";
	static final String PENDIENTE = "pendiente";
	static final String CANCELADA = "cancelada";
	static final String FINALIZADA = "finalizada";
	static final String EN_EJECUCION = "en ejecucion";
	
	static EstadoTarea GenerateEstadoTarea(String estado) {
		switch (estado) {
			case EstadoTarea.PAUSADA: return new EstadoTareaPausada(); break;
            case EstadoTarea.PENDIENTE: return new EstadoTareaPendiente(); break;
            case EstadoTarea.CANCELADA: return new EstadoTareaCancelada(); break;
            case EstadoTarea.FINALIZADA: return new EstadoTareaFinalizada(); break;
            case EstadoTarea.EN_EJECUCION: return new EstadoTareaEnEjecucion(); break;
		}
		throw new Exception("Nombre no valido");
	}
	
	protected abstract int valorIgualdad();
	public boolean EsEstado(EstadoTarea otroEstado) {
		this.valorIgualdad() == otroEstado.valorIgualdad();
	}
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) {}
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("No se puede finalizar una tarea que no este en ejecucion") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) {}
}

public class EstadoTareaPausada extends EstadoTarea {
	String ToString() { PAUSADA }
	protected int valorIgualdad() { 1 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("La tarea ya se encuentra pausada") }
}
public class EstadoTareaPendiente extends EstadoTarea {
	String ToString() { PENDIENTE }
	protected int valorIgualdad() { 2 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede Pausar una tarea pendiente") }
}
public class EstadoTareaCancelada extends EstadoTarea {
	String ToString() { CANCELADA }
	protected int valorIgualdad() { 3 }

	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Cancelada") }
}
public class EstadoTareaFinalizada extends EstadoTarea {
	String ToString() { FINALIZADA }
	protected int valorIgualdad() { 4 }
	
	public void ValidarCambio(EstadoTareaPausada estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Finalizada") }
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) { throw new Exception("La tarea ya se encuentra Finalizada") }
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("No se puede cambiar el estado de una tarea Finalizada") }
}
public class EstadoTareaEnEjecucion extends EstadoTarea {
	String ToString() { EN_EJECUCION }
	protected int valorIgualdad() { 5 }
	
	public void ValidarCambio(EstadoTareaFinalizada estadoNuevo) {}
	public void ValidarCambio(EstadoTareaEnEjecucion estadoNuevo) { throw new Exception("La tarea ya se encuentra en Ejecucion") }
}