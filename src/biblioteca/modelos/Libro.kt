package biblioteca.modelos

interface EstadoLibro {
    fun prestar()
    fun devolver()
    fun estadoActual(): String
}

abstract class Material(
    open val titulo: String,
    open val autor: String,
    open val añoPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    override val titulo: String,
    override val autor: String,
    override val añoPublicacion: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, añoPublicacion), EstadoLibro {

    private var prestado: Boolean = false

    override fun prestar() {
        if (!prestado) {
            prestado = true
            println("'$titulo' ha sido prestado")
        } else {
            println("'$titulo' ya está prestado")
        }
    }

    override fun devolver() {
        if (prestado) {
            prestado = false
            println("'$titulo' ha sido devuelto")
        } else {
            println("'$titulo' no estaba prestado")
        }
    }

    override fun estadoActual(): String = if (prestado) "Prestado" else "Disponible"

    override fun mostrarDetalles() {
        println("""
            |Título: $titulo
            |Autor: $autor
            |Año: $añoPublicacion
            |Género: $genero
            |Páginas: $paginas
            |Estado: ${estadoActual()}
            |-----------------------------
        """.trimMargin())
    }

    companion object {
        fun crearLibroInfantil(titulo: String, autor: String) =
            Libro(titulo, autor, 2023, "Infantil", 32)
    }
}