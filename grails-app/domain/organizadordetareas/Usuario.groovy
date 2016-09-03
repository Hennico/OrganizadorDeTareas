package organizadordetareas

class Usuario {
    Set<EstadoTarea> tareasAsignadas

    static constraints = {
    }

    void AsignarTarea(Tarea nuevaTarea, UsuarioRol rol) {
        if (!tareasAsignadas.any({ tareaActual -> tareaActual.tarea == nuevaTarea }))
            tareasAsignadas.add(new EstadoTarea([
                tarea: nuevaTarea,
                estado: Estado.pendiente,
                usuarioRol: rol,
                usuario: this
            ]))
    }
}
