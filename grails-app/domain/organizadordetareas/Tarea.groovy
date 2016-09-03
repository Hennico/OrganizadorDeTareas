package organizadordetareas

class Tarea {
    String titulo
    String descripcion
    Set<TareaRelacion> tareasAnteriores
    EstadoTarea estado
    int prioridad
    

    static constraints = {
    }
}
