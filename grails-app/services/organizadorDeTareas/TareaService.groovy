package organizadordetareas

import grails.transaction.Transactional

@Transactional

class TareaService{

    def cambiarTareaAEnEjecucion(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.EN_EJECUCION)){
		boolean flag = true
		tarea.tareasAnteriores.each{if(!(it.tareaDependida.estado==EstadoTarea.CANCELADA ||it.tareaDependida.estado==EstadoTarea.FINALIZADA)){flag = false}}
		if (flag){
			tarea.CambiarEstado(EstadoTarea.EN_EJECUCION)
			}
		}
	tarea.save flush:true
	}

    def cambiarTareaACancelada(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.CANCELADA)){
		tarea.CambiarEstado(EstadoTarea.CANCELADA)
		}
	tarea.tareasAnteriores.each{this.cambiarTareaACancelada(it.tareaDependida)}
	tarea.save flush:true
	}

    def cambiarTareaAFinalizar(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.FINALIZADA)){
		tarea.CambiarEstado(EstadoTarea.FINALIZADA)
		}
	tarea.save flush:true
	}

    def cambiarTareaAPauzar(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.PAUSADA)){
		tarea.CambiarEstado(EstadoTarea.PAUSADA)
		}
	tarea.save flush:true
	}


    def crearYAgregarHijo(Tarea tarea, String titulo, String descripcion, int prioridad) {
	if (tarea.estado == EstadoTarea.PENDIENTE){
		tarea.CrearYAgregarHijo(titulo, descripcion,prioridad)
		}
	tarea.save flush:true
	}




    def serviceMethod() {

    }
}
