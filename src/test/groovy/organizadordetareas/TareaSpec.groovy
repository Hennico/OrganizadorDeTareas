package organizadordetareas

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tarea)
class TareaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
    void "test inicio en pendiente"() {
	when:
	Tarea A = new Tarea()
        then:
        A.estado == EstadoTarea.PENDIENTE 
    }
	
}
