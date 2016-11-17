package organizadordetareas

import grails.transaction.Transactional

@Transactional

class TareaService{

    def cambiarAEnEjecucion(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.EN_EJECUCION)){
		boolean flag = true
		tarea.tareasAnteriores.each{if(!(it.tareaDependida.estado==EstadoTarea.CANCELADA ||it.tareaDependida.estado==EstadoTarea.FINALIZADA)){flag = false}}
		if (flag){
			tarea.CambiarEstado(EstadoTarea.EN_EJECUCION)
			}
		}
	tarea.save flush:true
	}

    def cambiarACancelada(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.CANCELADA)){
		tarea.CambiarEstado(EstadoTarea.CANCELADA)
		}
	tarea.tareasAnteriores.each{this.cambiarTareaACancelada(it.tareaDependida)}
	tarea.save flush:true
	}

    def cambiarAFinalizar(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.FINALIZADA)){
		tarea.CambiarEstado(EstadoTarea.FINALIZADA)
		}
	tarea.save flush:true
	}

    def cambiarAPauzar(Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.PAUSADA)){
		tarea.CambiarEstado(EstadoTarea.PAUSADA)
		}
	tarea.save flush:true
	}


    def AgregarHijo(Tarea tarea, String titulo, String descripcion, int prioridad) {
	if (tarea.estado == EstadoTarea.PENDIENTE){
		tarea.AgregarHijo(titulo, descripcion,prioridad)
		}
	tarea.save flush:true
	}




    def serviceMethod() {

    }
}
