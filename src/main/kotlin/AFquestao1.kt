class AFQuestao1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens()

            // Solicitar ao usuário que entre com o nome do gênero
            println("Digite o nome do gênero para buscar itens:")
            val nomeGenero = readLine()

            if (nomeGenero != null) {
                // Inicializar a contagem de itens encontrados
                var totalItensEncontrados = 0

                // Exibir cabeçalho
                println("cod\t\t\tnome\t\t\tmarca\t\t\tquantidade\t\tvalidade\t\tvalido?")

                // Percorrer os itens do estoque
                for (item in itensNoEstoque) {
                    val genero = item.produto.genero

                    // Verificar se o gênero corresponde ao informado pelo usuário
                    if (genero.getNome().equals(nomeGenero, ignoreCase = true)) {
                        val produto = item.produto
                        val dataValidade = item.dataValidade
                        val valido = if (item.valido()) "Sim" else "Não"

                        // Exibir os detalhes do item encontrado
                        println("${produto.codigo}\t\t${produto.nome}\t\t${produto.marca.nome}\t\t1\t\t${dataValidade.getNome()}\t\t$valido")

                        // Incrementar a contagem de itens encontrados
                        totalItensEncontrados++
                    }
                }

                // Exibir o total de itens encontrados
                println("Total de itens do gênero '$nomeGenero' encontrados: $totalItensEncontrados")
            } else {
                println("Nome de gênero inválido.")
            }
        }
    }
}

fun main() {
    AFQuestao1.main(emptyArray())
}
