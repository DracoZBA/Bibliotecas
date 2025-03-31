package biblioteca

import biblioteca.modelos.Libro
import biblioteca.modelos.Usuario
import biblioteca.sistema.Biblioteca

fun main() {
    //Crear biblioteca
    val biblioteca = Biblioteca("Central")

    //Agregar libros
    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", 432)
    val libro2 = Libro.crearLibroInfantil("El principito", "Antoine de Saint-Exupéry")

    biblioteca.agregarLibro(libro1)
    biblioteca.agregarLibro(libro2)

    //Registrar usuarios
    val usuario1 = Usuario("001", "María", Usuario.TipoUsuario.ADULTO)
    val usuario2 = Usuario("002", "Pedro", Usuario.TipoUsuario.INFANTIL)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    //Operaciones de préstamo
    usuario1.prestarLibro(libro1)
    usuario2.prestarLibro(libro2)

    //Mostrar estado
    biblioteca.mostrarCatalogo()
    biblioteca.mostrarUsuarios()

    usuario1.mostrarLibrosPrestados()
    usuario2.mostrarLibrosPrestados()

    //Devolución
    usuario1.devolverLibro(libro1)
    biblioteca.mostrarCatalogo()
}