package organizadordetareas

enum EstadoTarea {
    pendiente, enEjecucion, enPausa, finalizada, cancelada
}

abstract class UsuarioRol {
    
}

class RealacionUsuarioTarea {
  Tarea tarea
  EstadoTarea estado
  Usuario usuario
  UsuarioRol rol
}
