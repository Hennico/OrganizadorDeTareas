package organizadordetareas

import grails.transaction.Transactional

@Transactional
class SimpleService {

    def cambiarTareaACancelada(int id, Tarea tarea) {
	if (tarea.ComprobarSiPuedoCambiarEstado(EstadoTarea.CANCELADA)){
		tarea.CambiarEstado(EstadoTarea.CANCELADA)
		}
	tarea.save flush:true
	}



    def serviceMethod() {

    }
}
