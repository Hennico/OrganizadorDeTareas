package organizadordetareas

enum DependenciaTipo {
    baja, alta
}

class TareaDependencia {
    Tarea tareaOrigen
    Tarea tareaDependida
    DependenciaTipo tipoDependencia

    static constraints = {
    }
}
