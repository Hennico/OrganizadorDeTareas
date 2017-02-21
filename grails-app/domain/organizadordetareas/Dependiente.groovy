package organizadordetareas

abstract class Dependiente {
	
    	Set<NexoEntreTareas> tareasAnteriores

    	static constraints = {
    	}

   	public NewTareaAnterior(Tarea nuevaTarea, dependencia) {
		tareasAnteriores.add (new NexoEntreTareas(this,nuevaTarea,dependencia))	
	}
}
