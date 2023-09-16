import model .*
class AP2Questao7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Entrada do usuário: Nome da marca
            print("Digite o nome da marca: ")
            val marcaNome = readLine() ?: ""

            // Busca por itens de produtos válidos da marca fornecida
            val itensDaMarca = supermercado.getEstoque().getItens()

            if (itensDaMarca.isEmpty()) {
                println("Nenhum item válido da marca $marcaNome encontrado.")
            } else {
                println("Itens válidos da marca $marcaNome:")
                for (item in itensDaMarca) {
                    val produto = item.produto
                    val quantidade = supermercado.getEstoque().getItens()
                    println("${produto.nome}, Quantidade: $quantidade")
                }
            }
        }
    }
}

fun main() {
    AP2Questao7.main(emptyArray())
}
