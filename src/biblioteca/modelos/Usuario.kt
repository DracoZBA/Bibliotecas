package biblioteca.modelos

class Usuario(
    val id: String,
    val nombre: String,
    val tipo: TipoUsuario
) {
    private val librosPrestados = mutableListOf<Libro>()

    enum class TipoUsuario {
        INFANTIL, ADULTO, INVESTIGADOR
    }

    fun prestarLibro(libro: Libro) {
        when {
            librosPrestados.size >= maxLibros() ->
                println("$nombre ha alcanzado el límite de préstamos")
            libro.estadoActual() == "Prestado" ->
                println("'${libro.titulo}' no está disponible")
            else -> {
                libro.prestar()
                librosPrestados.add(libro)
            }
        }
    }

    fun devolverLibro(libro: Libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver()
            librosPrestados.remove(libro)
        } else {
            println("$nombre no tiene prestado '${libro.titulo}'")
        }
    }

    private fun maxLibros(): Int = when(tipo) {
        TipoUsuario.INVESTIGADOR -> 5
        TipoUsuario.ADULTO -> 3
        TipoUsuario.INFANTIL -> 2
    }

    fun mostrarLibrosPrestados() {
        println("\nLibros prestados a $nombre:")
        librosPrestados.forEach { println("- ${it.titulo}") }
    }
}