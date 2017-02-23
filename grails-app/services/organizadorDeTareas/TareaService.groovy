package organizadordetareas

import grails.transaction.Transactional

@Transactional

class TareaService{

    def cambiarAEnEjecucion(Tarea tarea) {
	tarea.ComprobarYCambiarEstado(EstadoTarea.EN_EJECUCION)
	tarea.save flush:true
	}

    def cambiarACancelada(Tarea tarea) {
	tarea.ComprobarYCambiarEstado(EstadoTarea.CANCELADA)
	tarea.tareasAnteriores.each{this.cambiarTareaACancelada(it.tareaDependida)}
	tarea.save flush:true
	}

    def cambiarAFinalizar(Tarea tarea) {
	tarea.ComprobarYCambiarEstado(EstadoTarea.FINALIZADA)
	tarea.save flush:true
	}

    def cambiarAPauzar(Tarea tarea) {
	tarea.ComprobarYCambiarEstado(EstadoTarea.PAUSADA)
	tarea.save flush:true
	}


    def SubTarea(Tarea tarea, String titulo, String descripcion, int prioridad) {
	if (tarea.estado == EstadoTarea.PENDIENTE){
		tarea.CrearYSubTarea(titulo, descripcion,prioridad)
		}
	tarea.save flush:true
	}




    def serviceMethod() {

    }
}
