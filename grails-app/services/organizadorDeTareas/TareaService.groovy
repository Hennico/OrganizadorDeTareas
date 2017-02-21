package organizadordetareas

import grails.transaction.Transactional

@Transactional

class TareaService{

    def cambiarAEnEjecucion(Tarea tarea) {
	try {
		tarea.ComprobarYCambiarEstado(EstadoTarea.EN_EJECUCION)
	}
	catch (Exception ex) {
		
	}
	tarea.save flush:true
	}

    def cambiarACancelada(Tarea tarea) {
	try {
	tarea.ComprobarYCambiarEstado(EstadoTarea.CANCELADA)
	}
	catch (Exception ex) {
		
	}
	tarea.tareasAnteriores.each{this.cambiarTareaACancelada(it.tareaDependida)}
	tarea.save flush:true
	}

    def cambiarAFinalizar(Tarea tarea) {
	try {
	tarea.ComprobarYCambiarEstado(EstadoTarea.FINALIZADA)
	}
	catch (Exception ex) {
		
	}
	tarea.save flush:true
	}

    def cambiarAPauzar(Tarea tarea) {
	try {
	tarea.ComprobarYCambiarEstado(EstadoTarea.PAUSADA)
	}
	catch (Exception ex) {
		
	}
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
