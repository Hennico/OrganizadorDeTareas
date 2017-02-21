package organizadordetareas

enum DependenciaTipo {
    baja, alta
}

class NexoEntreTareas {
    Dependiente tareaOrigen
    Tarea tareaDependida
    DependenciaTipo tipoDependencia

    static constraints = {
    }

public NexoEntreTareas(Dependiente tareaOrigen, Tarea tareaDependida, DependenciaTipo tipoDependencia){
	this.tareaOrigen = tareaOrigen
	this.tareaDependida = tareaDependida
	this.tipoDependencia = tipoDependencia
    }

}
