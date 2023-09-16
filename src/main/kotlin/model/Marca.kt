package model

class Marca {
    var nome: String = ""
        set(value) {
            field = value
        }
        get() {
            return field
        }
    constructor(nome: String) {
        this.nome = nome
    }
}
