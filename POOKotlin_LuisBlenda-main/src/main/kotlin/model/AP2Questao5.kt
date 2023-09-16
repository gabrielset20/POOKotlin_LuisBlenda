package model

data class Item(
    val codigo: Int,
    val nome: String,
    val preco: Double
)

class AP2Questao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val estoque = mutableListOf(
                Item(1, "Produto A", 10.0),
                Item(2, "Produto B", 15.0),
                Item(3, "Produto C", 20.0),
                Item(4, "Produto D", 25.0),
                Item(5, "Produto E", 30.0)
            )

            val carrinho = mutableListOf<Item>()

            var i = 0
            while (i < estoque.size) {
                val item = estoque[i]
                if (item.codigo % 2 != 0) {
                    carrinho.add(item)
                    estoque.removeAt(i)
                } else {
                    i++
                }
            }

            println("Itens no Carrinho:")
            for (item in carrinho) {
                println("${item.nome} - Preço: R$${item.preco}")
            }

            val totalCarrinho = carrinho.sumByDouble { it.preco }
            println("Total a pagar no Carrinho: R$$totalCarrinho")

            println("\nItens restantes no Estoque:")
            for (item in estoque) {
                println("${item.nome} - Preço: R$${item.preco}")
            }

            val totalEstoque = estoque.size
            println("Total de Itens no Estoque: $totalEstoque")
        }
    }
}
