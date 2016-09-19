package organizadordetareas

enum DependenciaTipo {
    baja, alta
}

class TareaDependencia {
    Dependiente tareaOrigen
    Tarea tareaDependida
    DependenciaTipo tipoDependencia

    static constraints = {
    }

public TareaDependencia(Dependiente tareaOrigen, Tarea tareaDependida, DependenciaTipo tipoDependencia){
	this.tareaOrigen = tareaOrigen
	this.tareaDependida = tareaDependida
	this.tipoDependencia = tipoDependencia
    }

}
