import model .*

class AP2Questao2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens()

            // Criar um mapa para agrupar os itens por gênero
            val itensAgrupadosPorGenero = mutableMapOf<Genero, MutableList<ItemProduto>>()

            // Agrupar os itens pelo gênero
            for (item in itensNoEstoque) {
                val genero = item.produto.genero
                itensAgrupadosPorGenero[genero]?.add(item)
            }

            // Exibir os itens agrupados por gênero e o total de itens por gênero em formato de tabela
            println("cod\t\t\tnome\t\t\tgenero\t\t\tmarca\t\t\tpreco\t\tvalidade\t\tvalido?")
            for ((genero, itens) in itensAgrupadosPorGenero) {
                println("------------------------------------------------------------")
                println("Gênero: ${genero.nome}")
                println("Total de Itens: ${itens.size}")
                println("------------------------------------------------------------")
                for (item in itens) {
                    val produto = item.produto
                    val dataValidade = item.dataValidade
                    val valido = if (item.valido()) "Sim" else "Não"
                    println("${produto.codigo}\t\t${produto.nome}\t\t${genero.nome}\t\t${produto.marca.nome}\t\t${produto.preco}\t\t${dataValidade.getNome()}\t\t$valido")
                }
            }
        }
    }
}

fun main() {
    AP2Questao2.main(emptyArray())
}
