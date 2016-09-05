package organizadordetareas

class Tarea {
    String titulo
    String descripcion
    Set<RelacionUsuarioTarea> tareasAnteriores
    EstadoTarea estado
    int prioridad
    

    static constraints = {
    }
}
