package organizadordetareas

public enum EstadoTarea {
	PENDIENTE,
	EN_EJECUCION,
	PAUSADA,
	CANCELADA,
	FINALIZADA
	
	static private def maquinaEstados = [
		(PENDIENTE):[EN_EJECUCION, CANCELADA],
		(EN_EJECUCION):[PAUSADA,CANCELADA,FINALIZADA],
		(PAUSADA):[EN_EJECUCION,PAUSADA,CANCELADA],
		(CANCELADA):[],
		(FINALIZADA):[],
	]
	
	private def arreglo = [EN_EJECUCION,CANCELADA]
	
	boolean permiteCambioA(EstadoTarea siguienteEstado) { 
		siguienteEstado in (maquinaEstados[this]) 
	}
}
