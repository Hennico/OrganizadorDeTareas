package organizadordetareas

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TareaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tarea.list(params), model:[tareaCount: Tarea.count()]
    }

    def show(Tarea tarea) {
        respond tarea
    }

    def create() {
        respond new Tarea(params)
    }
	
    	def crear() {
		Tarea tarea = new Tarea(params)
		tarea.AvisarAlObjetivo();
		tarea.save flush:true
		render(view: "show", model: [tarea: tarea])
	}

	def cambiarAEjecucion(int id) {
		Tarea tarea = Tarea.get(id)
		tarea.ComprobarYCambiarEstado(EstadoTarea.EN_EJECUCION);
		tarea.save flush:true
		render(view: "show", model: [tarea: tarea])
	}

	def agregarPadre(int id) {
		Tarea tarea = Tarea.get(id)
		tarea.AvisarAlObjetivo();
		tarea.save flush:true
		render(view: "show", model: [tarea: tarea])
	}

	def agregarHija(int id) {
		Tarea tarea = Tarea.get(id)
		render(view: "CrearHija", model: [tarea: tarea])
	}


	def CrearYAgregarHijo(int id) {
		Tarea tarea = Tarea.get(id)
		tarea.CrearYAgregarHijo(params.titulo, params.descripcion, params.prioridad.toInteger());
		tarea.save flush:true
		render(view: "show", model: [tarea: tarea])
	}


    @Transactional
    def save(Tarea tarea) {
        if (tarea == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tarea.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tarea.errors, view:'create'
            return
        }

        tarea.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
                redirect tarea
            }
            '*' { respond tarea, [status: CREATED] }
        }
    }

    def edit(Tarea tarea) {
        respond tarea
    }

    @Transactional
    def update(Tarea tarea) {
        if (tarea == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tarea.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tarea.errors, view:'edit'
            return
        }

        tarea.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
                redirect tarea
            }
            '*'{ respond tarea, [status: OK] }
        }
    }

    @Transactional
    def delete(Tarea tarea) {

        if (tarea == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tarea.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tarea.label', default: 'Tarea'), tarea.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }



    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tarea.label', default: 'Tarea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
