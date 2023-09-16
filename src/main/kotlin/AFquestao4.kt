class AFQuestao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()

            // Calcular o lucro atual com a venda de todos os itens do estoque
            val lucroAtual = estoque.getItens().sumByDouble { item ->
                if (item.valido()) {
                    item.produto.preco
                } else {
                    0.0
                }
            }

            // Mostrar o estoque atual e o lucro
            println("Estoque atual com o lucro: R$$lucroAtual")
            println("Total de itens no estoque: ${estoque.qtdItens()}")

            // Retirar todos os itens vencidos do estoque e calcular o prejuízo
            val itensVencidos = estoque.getItens().filter { !it.valido() }
            val prejuizo = itensVencidos.sumByDouble { item ->
                item.produto.preco
            }

            // Remover os itens vencidos do estoque
            estoque.getItens()
            estoque.removeAllItensVencidos()

            // Mostrar o estoque sem os itens vencidos e o prejuízo
            println("\nEstoque sem os itens vencidos com o prejuízo: R$$prejuizo")
            println("Total de itens no estoque (sem itens vencidos): ${estoque.qtdItens()}")

            // Calcular o lucro real considerando o prejuízo
            val lucroReal = lucroAtual - prejuizo
            println("\nLucro real considerando o prejuízo: R$$lucroReal")
        }
    }
}

fun main() {
    AFQuestao4.main(emptyArray())
}
