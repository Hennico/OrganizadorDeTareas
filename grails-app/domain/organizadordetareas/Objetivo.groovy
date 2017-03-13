package organizadordetareas

class Objetivo extends Dependiente{
    	String titulo
    	String descripcion
    	EstadoTarea estado //No creo que amerita une stado distinto.
	
    	int prioridad
		// cuando corrigamos los nombres de las variables. Tambien corregir los de la View.

	public Objetivo() {
		estado = EstadoTarea.PENDIENTE;
	}

    	static constraints = {
    	}
	
    	EstadoTarea getEstadoTarea() {
       		EstadoTarea.GenerateEstadoTarea(estado);
    	}
	
	String toString() {
		titulo
	}

	public ActualizarEstado(){
		boolean flag = true
		tareasAnteriores.each{if(!(it.tareaDependida.estado==EstadoTarea.CANCELADA ||it.tareaDependida.estado==EstadoTarea.FINALIZADA)){flag = false}}
		if (flag){
			estado = EstadoTarea.FINALIZADA
		}
	}


}
