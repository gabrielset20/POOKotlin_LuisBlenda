package model

// Classe Genero
open class Generos(private var nome: String) {
    // Método getNome
    fun getNome(): String {
        return nome
    }

    // Método setNome
    fun setNome(novoNome: String) {
        nome = novoNome
    }
}

// Classe Presunto
class Presunto(nome: String) : Generos(nome)

// Classe Leite
class Leite(nome: String) : Generos(nome)

// Classe Achocolatado
class Achocolatado(nome: String) : Generos(nome)
