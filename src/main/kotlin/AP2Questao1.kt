class AP2Questao1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens()

            // Exibição
            println("cod\t\tnome\t\tgenero\t\tmarca\t\tpreco\t\tvalidade\tvalido?")
            for (item in itensNoEstoque) {
                val produto = item.produto
                val dataValidade = item.dataValidade
                val valido = item.valido()
                println("${produto.codigo}\t\t${produto.nome}\t\t${produto.genero.getNome()}\t\t${produto.marca.nome}\t\t${produto.preco}\t\t${dataValidade.getNome()}\t\t$valido")
            }

            // Exibir o total de itens no estoque
            val totalDeItens = supermercado.getEstoque().qtdItens()
            println("Total de Itens no Estoque: $totalDeItens")
        }
    }
}

fun main() {
    AP2Questao1.main(emptyArray())
}
