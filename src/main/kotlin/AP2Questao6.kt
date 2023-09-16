import kotlin.random.Random
import carrinho.Carrinho

class AP2Questao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val carrinho = Carrinho()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens().toMutableList()

            // Inicializar contadores
            var totalItensNoEstoque = itensNoEstoque.size

            // Definir o número máximo de itens a serem adicionados ao carrinho (aleatoriamente)
            val maxItensNoCarrinho = Random.nextInt(1, 11) // Número aleatório entre 1 e 10

            // Percorrer a lista de itens do estoque e selecionar aleatoriamente alguns itens válidos
            for (i in 1..maxItensNoCarrinho) {
                val itemIndex = Random.nextInt(itensNoEstoque.size)
                val item = itensNoEstoque[itemIndex]
                if (item.valido()) {
                    carrinho.adicionaItem(item, supermercado.getEstoque())
                    // Remover o item da lista de estoque
                    itensNoEstoque.removeAt(itemIndex)
                }
            }

            // Mostrar os itens do carrinho e sua quantidade
            println("Itens no carrinho:")
            for (item in carrinho.getItens()) {
                val produto = item.produto
                val quantidade = carrinho.getQuantidade(item)
                println("${produto.nome}, Quantidade: $quantidade")
            }

            // Mostrar os itens restantes no estoque e o total de itens no estoque
            println("\nItens restantes no estoque:")
            totalItensNoEstoque = itensNoEstoque.size
            for (item in itensNoEstoque) {
                val produto = item.produto
                println("${produto.nome}, Código: ${item.codigoDeBarras}")
            }
            println("\nTotal de itens no estoque: $totalItensNoEstoque")
        }
    }
}

fun main() {
    AP2Questao6.main(emptyArray())
}
