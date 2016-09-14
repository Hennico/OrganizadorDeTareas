package organizadordetareas

abstract class Accion {
	
	Accion tareaSiguiente //Si no deberia tenerla. Pero hase mas practico armar el arbol, por ahora. 
    	Set<TareaDependencia> tareasAnteriores

    	static constraints = {
    	}

	public Actualizar() { //esto se podria cambiar a que pida la tareaSiguiente.
		tareaSiguiente.NewTareaAnterior(This)
	}

   	public NewTareaAnterior(Tarea NuevaTarea, TareaDependencia estado) {
		tareasAnteriores.add (new TareaDependencia(This,NuevaTarea,estado))
	}
}
