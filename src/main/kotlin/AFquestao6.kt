import model .*
class AFQuestao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinhoA = supermercado.getCarrinhoA()
            val carrinhoB = supermercado.getCarrinhoB()

            // Preencher carrinhoA com itens válidos do estoque
            estoque.getItens().forEach { item ->
                if (item.valido()) {
                    carrinhoA.adicionaItem(item, estoque)
                }
            }

            // Preencher carrinhoB com itens inválidos do estoque
            estoque.getItens().forEach { item ->
                if (!item.valido()) {
                    carrinhoB.adicionaItem(item, estoque)
                }
            }

            // Mostrar o estoque, carrinhoA e carrinhoB
            println("Estoque:")
            estoque.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras} - Valido: ${item.valido()}")
            }

            println("\nCarrinhoA:")
            carrinhoA.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            println("\nCarrinhoB:")
            carrinhoB.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }
        }
    }
}

fun main() {
    AFQuestao6.main(emptyArray())
}
