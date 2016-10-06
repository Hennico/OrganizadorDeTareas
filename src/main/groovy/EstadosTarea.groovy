package organizadordetareas

public enum EstadoTarea {
	PENDIENTE,
	EN_EJECUCION,
	PAUSADA,
	CANCELADA,
	FINALIZADA
	
	private def maquinaEstados = [
		(EstadoTarea.PENDIENTE):[EstadoTarea.EN_EJECUCION, EstadoTarea.CANCELADA],
		(EstadoTarea.EN_EJECUCION):[EstadoTarea.PAUSADA,EstadoTarea.CANCELADA,EstadoTarea.FINALIZADA],
		(EstadoTarea.PAUSADA):[EstadoTarea.EN_EJECUCION,PAUSADA,EstadoTarea.CANCELADA],
		(EstadoTarea.CANCELADA):[],
		(EstadoTarea.FINALIZADA):[],
	]
	
	boolean permiteCambioA(EstadoTarea siguienteEstado) {
       	siguienteEstado in maquinaEstados[this]
	}
}
