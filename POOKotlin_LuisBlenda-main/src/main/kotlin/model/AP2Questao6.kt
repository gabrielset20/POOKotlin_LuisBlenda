package model

import java.util.*

data class Item(
    val codigo: Int,
    val nome: String,
    val valido: Boolean
)

class AP2Questao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val estoque = mutableListOf(
                Item(1, "Produto A", true),
                Item(2, "Produto B", true),
                Item(3, "Produto C", false),
                Item(4, "Produto D", true),
                Item(5, "Produto E", true)
            )

            val carrinho = mutableListOf<Item>()

            val random = Random()
            val quantidadeItensNoCarrinho = random.nextInt(estoque.size)

            var i = 0
            while (i < quantidadeItensNoCarrinho) {
                val itemIndex = random.nextInt(estoque.size)
                val itemSelecionado = estoque[itemIndex]
                if (itemSelecionado.valido) {
                    carrinho.add(itemSelecionado)
                    estoque.removeAt(itemIndex)
                    i++
                }
            }

            println("Itens no Carrinho:")
            for (item in carrinho) {
                println("Código: ${item.codigo}, Nome: ${item.nome}")
            }

            val quantidadeTotalCarrinho = carrinho.size
            println("Quantidade de Itens no Carrinho: $quantidadeTotalCarrinho")

            println("\nItens restantes no Estoque:")
            for (item in estoque) {
                println("Código: ${item.codigo}, Nome: ${item.nome}")
            }

            val quantidadeTotalEstoque = estoque.size
            println("Total de Itens no Estoque: $quantidadeTotalEstoque")
        }
    }
}
