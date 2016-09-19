package organizadordetareas

abstract class Dependiente {
	
    	Set<TareaDependencia> tareasAnteriores

    	static constraints = {
    	}

   	public NewTareaAnterior(Tarea nuevaTarea, dependencia) {
		tareasAnteriores.add (new TareaDependencia(this,nuevaTarea,dependencia))	
	}
}
