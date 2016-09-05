package organizadordetareas

class Tarea {
    String titulo
    String descripcion
    Set<RealacionUsuarioTarea> tareasAnteriores
    EstadoTarea estado
    int prioridad
    

    static constraints = {
    }
}
