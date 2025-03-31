package biblioteca.sistema

import biblioteca.modelos.Libro
import biblioteca.modelos.Usuario

class Biblioteca(val nombre: String) {
    private val catalogo = mutableListOf<Libro>()
    private val usuarios = mutableListOf<Usuario>()

    init {
        println("""
            |=== BIBLIOTECA '$nombre' INICIALIZADA ===
            |Sistema de gestión bibliotecaria
            |-------------------------------
        """.trimMargin())
    }

    fun agregarLibro(libro: Libro) {
        catalogo.add(libro)
        println("Libro agregado: '${libro.titulo}'")
    }

    fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        println("Usuario registrado: ${usuario.nombre} (${usuario.tipo})")
    }

    fun buscarPorTitulo(titulo: String): Libro? {
        return catalogo.find { it.titulo.contains(titulo, ignoreCase = true) }
    }

    fun mostrarCatalogo() {
        println("\n=== CATÁLOGO DE LIBROS ===")
        catalogo.forEach { it.mostrarDetalles() }
    }

    fun mostrarUsuarios() {
        println("\n=== USUARIOS REGISTRADOS ===")
        usuarios.forEach { println("- ${it.nombre} (${it.tipo})") }
    }
}