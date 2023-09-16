import kotlin.random.Random
import carrinho.Carrinho
import model .*
class AP2Questao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val carrinho = Carrinho()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens().toMutableList()

            // Inicializar contadores
            var totalItensNoEstoque = itensNoEstoque.size
            var totalItensNoCarrinho = 0
            var totalPrecoNoCarrinho = 0.0

            // Percorrer a lista de itens do estoque e selecionar os ímpares para o carrinho
            val iterator = itensNoEstoque.iterator()
            while (iterator.hasNext()) {
                val item = iterator.next()
                if (supermercado.getCodigoProdutoAtual() % 2 != 0) { //
                    carrinho.adicionaItem(item, supermercado.getEstoque())
                    iterator.remove()
                    totalItensNoCarrinho++
                    totalPrecoNoCarrinho += item.produto.preco
                }
            }

            // Mostrar os itens do carrinho, sua quantidade e preço total
            println("Itens no carrinho:")
            for (item in carrinho.getItens()) {
                val produto = item.produto
                val quantidade = carrinho.getQuantidade(item)
                println("${produto.nome}, Quantidade: $quantidade")
            }
            println("Total de itens no carrinho: $totalItensNoCarrinho")
            println("Total a pagar no carrinho: R$$totalPrecoNoCarrinho")

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
    AP2Questao5.main(emptyArray())
}
