import model .*

class AFQuestao2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens()

            // Solicitar ao usuário que entre com a data de validade
            println("Digite a data de validade (DD/MM/AAAA):")
            val dataString = readLine()

            if (dataString != null) {
                try {
                    // Converter a entrada do usuário em um objeto Data
                    val dataFornecida = Data.fromString(dataString)

                    // Inicializar a lista de itens expirados
                    val itensExpirados = mutableListOf<ItemProduto>()

                    // Percorrer os itens do estoque
                    for (item in itensNoEstoque) {
                        val dataValidade = item.dataValidade

                        // Verificar se a data de validade é posterior à data fornecida
                        if (!dataValidade.antes(dataFornecida)) {
                            itensExpirados.add(item)
                        }
                    }

                    // Exibir cabeçalho
                    println("cod\t\t\tnome\t\t\tmarca\t\t\tquantidade\t\tvalidade\t\tvalido?")

                    // Exibir os itens expirados
                    for (item in itensExpirados) {
                        val produto = item.produto
                        val dataValidade = item.dataValidade
                        val valido = if (item.valido()) "Sim" else "Não"

                        // Exibir os detalhes do item expirado
                        println("${produto.codigo}\t\t${produto.nome}\t\t${produto.marca.nome}\t\t1\t\t${dataValidade.getNome()}\t\t$valido")
                    }

                    // Exibir o total de itens expirados
                    println("Total de itens expirados: ${itensExpirados.size}")
                } catch (e: Exception) {
                    println("Data de validade inválida. Use o formato DD/MM/AAAA.")
                }
            } else {
                println("Data de validade inválida.")
            }
        }
    }
}

fun main() {
    AFQuestao2.main(emptyArray())
}
