package model

abstract class Genero(val nome: String) {
    abstract fun get(): String
    abstract fun set(value: String)
}

class Leite(nome: String) : Genero(nome) {
    override fun get(): String {
        return nome
    }

    override fun set(value: String) {
    }
}

class Presunto(nome: String) : Genero(nome) {
    override fun get(): String {
        return nome
    }

    override fun set(value: String) {
    }
}

class Achocolatado(nome: String) : Genero(nome) {
    override fun get(): String {
        return nome
    }

    override fun set(value: String) {
    }
}
