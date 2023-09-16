package model

data class Item(
    val codigo: Int,
    val nome: String,
    val marca: String,
    val valido: Boolean
)

class AP2Questao7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val estoque = listOf(
                Item(1, "Produto A", "MarcaX", true),
                Item(2, "Produto B", "MarcaY", true),
                Item(3, "Produto C", "MarcaX", true),
                Item(4, "Produto D", "MarcaZ", true),
                Item(5, "Produto E", "MarcaX", false)
            )

            println("Digite o nome da marca para buscar produtos:")
            val marcaDesejada = readLine() ?: ""

            val produtosEncontrados = estoque.filter { it.valido && it.marca.equals(marcaDesejada, ignoreCase = true) }

            if (produtosEncontrados.isNotEmpty()) {
                println("Itens da marca '$marcaDesejada' encontrados:")
                for (produto in produtosEncontrados) {
                    println("Código: ${produto.codigo}, Nome: ${produto.nome}")
                }
                println("Quantidade de itens encontrados: ${produtosEncontrados.size}")
            } else {
                println("Nenhum item da marca '$marcaDesejada' encontrado.")
            }
        }
    }
}


