package organizadordetareas

class Usuario {
    Set<RelacionUsuarioTarea> tareasAsignadas

    static constraints = {
    }

    void AsignarTarea(Tarea nuevaTarea, UsuarioRol rol) {
        if (!tareasAsignadas.any({ tareaActual -> tareaActual.tarea == nuevaTarea }))
            tareasAsignadas.add(new RelacionUsuarioTarea([
                tarea: nuevaTarea,
                estado: Estado.pendiente,
                usuarioRol: rol,
                usuario: this
            ]))
    }
}
