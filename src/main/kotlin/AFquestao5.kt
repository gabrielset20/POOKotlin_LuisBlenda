import model.*
import carrinho.Carrinho
class AFQuestao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinho = Carrinho()

            // Mostrar o estoque e o carrinho vazios
            println("Estoque inicial:")
            estoque.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            println("\nCarrinho inicial:")
            carrinho.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            // Preencher o carrinho com dez itens do estoque aleatoriamente
            for (i in 1..10) {
                val itemAleatorio = estoque.getItens().randomOrNull()
                if (itemAleatorio != null) {
                    carrinho.adicionaItem(itemAleatorio, estoque)
                }
            }

            // Mostrar o estoque e o carrinho após o preenchimento
            println("\nEstoque após o preenchimento do carrinho:")
            estoque.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            println("\nCarrinho após o preenchimento:")
            carrinho.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            // Colocar todos os itens do carrinho de volta no estoque
            carrinho.getItens().forEach { item ->
                estoque.entraItem(item)
            }

            // Mostrar o estoque e o carrinho após colocar os itens de volta
            println("\nEstoque após colocar os itens de volta:")
            estoque.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }

            println("\nCarrinho após colocar os itens de volta:")
            carrinho.getItens().forEach { item ->
                println("${item.produto.nome} - Código: ${item.codigoDeBarras}")
            }
        }
    }
}

fun main() {
    AFQuestao5.main(emptyArray())
}
